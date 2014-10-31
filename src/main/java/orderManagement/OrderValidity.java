package orderManagement;

import java.util.List;

public class OrderValidity {
	boolean valid;
	List<String> errors;
	
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

	
	public OrderValidity(boolean validIn, List<String> errorsIn) {
		valid = validIn;
		errors = errorsIn;
	}

}
