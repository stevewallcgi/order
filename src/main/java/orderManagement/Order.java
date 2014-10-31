package orderManagement;


public class Order {
	
    private long id;
    private Location location;

    public Order() {
    }
    
    public Order(long id) {
        this.id = id;
        location = new Location(id);
    }


    public long getId() {
        return id;
    }
    
    public void setId(long id) {
    	this.id = id;
    }

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}
}
