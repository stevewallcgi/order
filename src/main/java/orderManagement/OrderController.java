package orderManagement;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    
    @RequestMapping(method=RequestMethod.GET, value="/orders/{id}")
    public Order getOrder(@PathVariable("id") int orderId) {
        return new Order(orderId);
    }    
    
    @RequestMapping(method=RequestMethod.PUT, value="/orders")
    public Order updateOrder(@RequestBody Order order ) {
        return new Order(order.getId());
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
