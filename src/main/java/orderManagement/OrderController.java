package orderManagement;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.hateoas.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
//@Profile("hateoas")
@RequestMapping("/orders")
@ExposesResourceFor(Order.class)
public class OrderController {
	
	Map<Long, Order> orders = new HashMap<Long, Order>();
	
	@Autowired EntityLinks entityLinks;

    
    @RequestMapping(method=RequestMethod.GET, value="/{id}", produces="application/hal+json")
    public ResponseEntity<Resource<Order>> get(@PathVariable("id") long orderId) {   
    	Resource<Order> resource = createResource(new Order(orderId));
    			
		return new ResponseEntity<>(resource,  HttpStatus.OK);
    }
  
    
    @RequestMapping(method=RequestMethod.PUT, value="", produces="application/hal+json")
    public ResponseEntity<Resource<Order>> updateOrder(@RequestBody Order order ) {
    	return new ResponseEntity<>(createResource(order),  HttpStatus.OK);
    }
    
    @RequestMapping(method=RequestMethod.POST, value="/orderValidation", produces="application/hal+json")
    public ResponseEntity<Resource<OrderValidation>> orderValid(@RequestBody Order order) {		
    	
    	OrderValidation orderValidity = OrderValidator.validateOrder(order);
    	
    	Resource<OrderValidation> resource = new Resource<OrderValidation>(orderValidity);
    	resource.add(linkTo(methodOn(OrderController.class).orderValid(order)).withSelfRel());
    	
    	return new ResponseEntity<>(resource, HttpStatus.OK);
    }
    
    @RequestMapping(method=RequestMethod.GET, value="/orderValidation", produces="application/hal+json")
    public ResponseEntity<Resource<OrderValidation>> getOrderValid(@RequestBody Order order) {		
    	
    	OrderValidation orderValidity = OrderValidator.validateOrder(order);
    	
    	Resource<OrderValidation> resource = new Resource<OrderValidation>(orderValidity);
    	resource.add(linkTo(methodOn(OrderController.class).orderValid(order)).withSelfRel());
    	
    	return new ResponseEntity<>(resource, HttpStatus.OK);
    }


	@RequestMapping(method=RequestMethod.POST, value="/locationValidation", produces="application/hal+json")
    public ResponseEntity<Resource<LocationValidity>> locationValid(@RequestBody Order order) {	
        	
    	Resource<LocationValidity> resource = new Resource<LocationValidity>(LocationValidator.validLocation(order));
    	resource.add(linkTo(methodOn(OrderController.class).locationValid(order)).withSelfRel());
    	resource.add(linkTo(methodOn(OrderController.class).get(order.getId())).withRel("order"));
    	
    	return new ResponseEntity<>(resource, HttpStatus.OK);
    }
    
	private Resource<Order> createResource(Order order) {
		Resource<Order> resource = new Resource<Order>(order);

    	resource.add(linkTo(methodOn(OrderController.class).get(order.getId())).withSelfRel());
    	resource.add(linkTo(methodOn(OrderController.class).orderValid(order)).withRel("validOrder"));
    	resource.add(linkTo(methodOn(OrderController.class).locationValid(order)).withRel("validLocation"));
		return resource;
	}  
}
