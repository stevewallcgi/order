package orderManagement;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
	
	Map<Long, Order> orders = new HashMap<Long, Order>();
    
    @RequestMapping(method=RequestMethod.GET, value="/orders/{id}")
    public Order getOrder(@PathVariable("id") int orderId) {
        return new Order(orderId);
    }    
    
    @RequestMapping(method=RequestMethod.PUT, value="/orders")
    public Order updateOrder(@RequestBody Order order ) {
    	order.setLocation(new Location(order.getId()));
        return order;
    }
    
    @RequestMapping("/orders/{id}/valid")
    public OrderValidity orderValid(@PathVariable("id") int orderId) {
    	Order order = new Order(orderId);
    	return OrderValidator.validateOrder(order);
    }
    
    @RequestMapping("/orders/{id}/location/valid")
    public LocationValidity locationValid(@PathVariable("id") long orderId) {
    	Order order = new Order(orderId);
    	return LocationValidator.validLocation(order.getLocation());
    }
}
