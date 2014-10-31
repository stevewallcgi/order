package orderManagement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OrderValidator {
	public static OrderValidity validateOrder(Order order) {        
		OrderValidity orderValidity;
		
        if ((order.getId() % 2) == 0) {
        	orderValidity =  new OrderValidity(true, null);
        } else {
        	List<String> errors = new ArrayList<String>(Arrays.asList("Error 1", "Error 2"));
        	orderValidity = new OrderValidity(false, errors);
        }
        
        return orderValidity;
	}

}
