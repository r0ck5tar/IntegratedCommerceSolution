package facadeWH;

public class ItemsDatabase {
	
	public boolean isInStock(String itemId) {
		return true;
	}
	
	public Dimensions getDimensions(String itemId) {
		return new Dimensions(1, 2, 3);
	}
}
