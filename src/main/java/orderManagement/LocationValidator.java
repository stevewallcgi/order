package orderManagement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LocationValidator {
	public static LocationValidity validLocation(Location location) {
		LocationValidity locationValidity;
		
        if ((location.getId() % 2) == 0) {
        	locationValidity =  new LocationValidity(true, null);
        } else {
        	List<String> errors = new ArrayList<String>(Arrays.asList("Error 1", "Error 2"));
        	locationValidity = new LocationValidity(false, errors);
        }
        
        return locationValidity;
	}

}
