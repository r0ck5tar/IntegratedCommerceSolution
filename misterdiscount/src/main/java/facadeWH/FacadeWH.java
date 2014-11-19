package facadeWH;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService(name="WarehouseFacade",
targetNamespace = "http://informatique.polytech.unice.fr/soa1/integration/warehouseFacade",
portName = "warehouseFacadePort", serviceName = "warehouseFacadeService")
public interface FacadeWH {
		@WebMethod(operationName = "getItemDetails")
	    @WebResult(name = "itemDetail")
	    public ItemDetails getItemDetails(@WebParam(name="itemId") String itemId);
		
		@WebMethod(operationName = "isItemInStock")
	    @WebResult(name = "isInStock")
		public boolean isItemInStock(@WebParam(name="itemId") String itemId);
}
