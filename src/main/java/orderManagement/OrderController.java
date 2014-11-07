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

    
    @RequestMapping(method=RequestMethod.GET, value="/{id}", produces="application/json")
    public ResponseEntity<Resource<Order>> get(@PathVariable("id") long orderId) {   
    	Resource<Order> resource = createResource(new Order(orderId));
    			
		return new ResponseEntity<>(resource,  HttpStatus.OK);
    }
  
    
    @RequestMapping(method=RequestMethod.PUT, value="", produces="application/json")
    public ResponseEntity<Resource<Order>> updateOrder(@RequestBody Order order ) {
    	order.setLocation(new Location(order.getId()));
    	return new ResponseEntity<>(createResource(order),  HttpStatus.OK);
    }
    
    @RequestMapping(method=RequestMethod.GET, value="/{id}/valid", produces="application/json")
    public ResponseEntity<Resource<OrderValidity>> orderValid(@PathVariable("id") long orderId) {
    	Order order = new Order(orderId);		
    	
    	Resource<OrderValidity> resource = new Resource<OrderValidity>(OrderValidator.validateOrder(order));
    	resource.add(linkTo(methodOn(OrderController.class).orderValid(order.getId())).withSelfRel());
    	resource.add(linkTo(methodOn(OrderController.class).get(order.getId())).withRel("order"));
    	
    	return new ResponseEntity<>(resource, HttpStatus.OK);
    }


	@RequestMapping(method=RequestMethod.GET, value="/{id}/location/valid", produces="application/json")
    public ResponseEntity<Resource<LocationValidity>> locationValid(@PathVariable("id") long orderId) {
    	Order order = new Order(orderId);
    	
    	Resource<LocationValidity> resource = new Resource<LocationValidity>(LocationValidator.validLocation(order.getLocation()));
    	resource.add(linkTo(methodOn(OrderController.class).locationValid(order.getId())).withSelfRel());
    	resource.add(linkTo(methodOn(OrderController.class).get(order.getId())).withRel("order"));
    	
    	return new ResponseEntity<>(resource, HttpStatus.OK);
    }
    
	private Resource<Order> createResource(Order order) {
		Resource<Order> resource = new Resource<Order>(order);

    	resource.add(linkTo(methodOn(OrderController.class).get(order.getId())).withSelfRel());
    	resource.add(linkTo(methodOn(OrderController.class).orderValid(order.getId())).withRel("validOrder"));
    	resource.add(linkTo(methodOn(OrderController.class).locationValid(order.getId())).withRel("validLocation"));
		return resource;
	}  
}
