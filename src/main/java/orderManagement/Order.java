package orderManagement;




public class Order{
	
    private long id;
    private OrderStatus status = OrderStatus.OPEN;
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

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = OrderStatus.valueOf(status);
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}
	
	public static Order valueOf(String value) {
		return new Order(Long.valueOf(value));
	}
}
