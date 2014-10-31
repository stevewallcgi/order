package orderManagement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Order {
	
    private long id;
    private boolean validOrder;
    private boolean validLocation;
    private OrderValidity valid;
    private Location location;

    public Order() {
    }
    
    public Order(long id) {
        this.id = id;
        
        if ((id % 2) == 0) {
        	setValid(new OrderValidity(true, null));
        	setLocation(new Location(new LocationValidity(true, null)));
        } else {
        	List<String> errors = new ArrayList<String>(Arrays.asList("Error 1", "Error 2"));
        	setValid(new OrderValidity(false, errors));
        	setLocation(new Location(new LocationValidity(false, errors)));
        }
    }
    
    public Order (long id, boolean validOrder, boolean validLocation) {
    	this.id = id;
    	
    	List<String> errors = new ArrayList<String>(Arrays.asList("Error 1", "Error 2"));	
    	
    	if (validOrder) {
        	setValid(new OrderValidity(true, null)); 
    	} else {
        	setValid(new OrderValidity(false, errors));    	
    	}
    	
    	if (validLocation) {
        	setLocation(new Location(new LocationValidity(true, null)));
    	} else {
        	setLocation(new Location(new LocationValidity(false, errors)));
    	}
    }

    public long getId() {
        return id;
    }
    
    public void setId(long id) {
    	this.id = id;
    }

	public OrderValidity getValid() {
		return valid;
	}

	public void setValid(OrderValidity valid) {
		this.valid = valid;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public boolean isValidOrder() {
		return validOrder;
	}

	public void setValidOrder(boolean validOrder) {
		this.validOrder = validOrder;
	}

	public boolean isValidLocation() {
		return validLocation;
	}

	public void setValidLocation(boolean validLocation) {
		this.validLocation = validLocation;
	}
}
