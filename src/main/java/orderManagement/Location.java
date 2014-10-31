package orderManagement;

public class Location {
	LocationValidity valid;

	public Location(LocationValidity locationValidity) {
		setValid(locationValidity);
	}

	public LocationValidity getValid() {
		return valid;
	}

	public void setValid(LocationValidity valid) {
		this.valid = valid;
	}
}
