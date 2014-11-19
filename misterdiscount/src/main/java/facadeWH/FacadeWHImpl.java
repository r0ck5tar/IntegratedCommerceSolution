package facadeWH;

import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;

public class FacadeWHImpl implements FacadeWH{
	@EJB ItemsDatabase itemsDB;

	@Override
	@WebMethod(operationName = "getItemDetails")
	@WebResult(name = "itemDetail")
	public ItemDetails getItemDetails(@WebParam(name = "itemId") String itemId) {
		ItemDetails result = new ItemDetails();
		if(itemsDB.isInStock(itemId)) {
			Dimensions dimensions = itemsDB.getDimensions(itemId);
			result.setHeight(dimensions.getHeight()	);
			result.setWidth(dimensions.getWidth());
			result.setDepth(dimensions.getDepth());		
		}
		
		//exception otherwise
		
		return result;
		
		
	}

	@Override
	@WebMethod(operationName = "isItemInStock")
	@WebResult(name = "isInStock")
	public boolean isItemInStock(@WebParam(name = "itemId") String itemId) {
		return true;
	}

}
