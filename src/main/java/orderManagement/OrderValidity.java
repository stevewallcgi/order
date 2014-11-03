package orderManagement;

import java.util.List;

public class OrderValidity {
	boolean valid;
	List<String> errors;
	Order order;

	public OrderValidity(Order order, boolean valid, List<String> errors) {
		this.order = order;
		this.valid = valid;
		this.errors = errors;
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

	
	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

}
