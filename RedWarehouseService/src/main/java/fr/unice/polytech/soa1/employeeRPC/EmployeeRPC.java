package fr.unice.polytech.soa1.employeeRPC;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import java.util.List;

/**
 * Created by user on 04/10/14.
 */
@WebService(targetNamespace = "http://informatique.polytech.unice.fr/soa1/employeeRPC/private")
public interface EmployeeRPC {

    @WebMethod(operationName = "get_task")
    @WebResult(name = "tasks")
    public String getTask(@WebParam(name = "id")String id) throws UnknownContentFault, UnknownTaskFault;

    @WebMethod(operationName = "place_product")
    @WebResult(name = "placement")
    public List<String> placeProduct(@WebParam(name = "product_ref")String productRef,
                                     @WebParam(name = "product_width")int width,
                                     @WebParam(name = "product_height")int height,
                                     @WebParam(name = "product_depth")int depth,
                                     @WebParam(name = "product_quantity")int quantity
                                     );

    @WebMethod(operationName = "get_product_location")
    @WebResult(name = "result_placement")
    public List<String> getProductLocation(@WebParam(name = "product_ref")String productRef) throws UnknownProductReference;


}
