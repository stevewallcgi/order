package orderManagement;

import java.util.List;

public class LocationValidity {
	boolean valid;
	List<String> errors;
	
	public LocationValidity(boolean valid, List<String> errors) {
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
}
