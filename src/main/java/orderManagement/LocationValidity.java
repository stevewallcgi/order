package orderManagement;

import java.util.List;

public class LocationValidity {
	boolean valid;
	List<String> errors;
	Location location;
	
	public LocationValidity(Location location, boolean valid, List<String> errors) {
		setLocation(location);
		setValid(valid);
		setErrors(errors);
	}
	
	public boolean isValid() {
		return valid;
	}
	public void setValid(boolean valid) {
		this.valid = valid;
	}
	public List<String> getErrors() {
		return errors;
	}
	public void setErrors(List<String> errors) {
		this.errors = errors;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}
}
