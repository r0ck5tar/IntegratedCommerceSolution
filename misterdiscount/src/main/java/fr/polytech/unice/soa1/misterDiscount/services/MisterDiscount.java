package fr.polytech.unice.soa1.misterDiscount.services;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import fr.polytech.unice.soa1.misterDiscount.business.Order;
import fr.polytech.unice.soa1.misterDiscount.business.Receipt;



@WebService(name="MisterDiscount",
            targetNamespace = "http://informatique.polytech.unice.fr/soa1/integration/misterDiscount",
            portName = "MisterDiscountPort", serviceName = "MisterDiscountService")
public interface MisterDiscount {

    @WebMethod(operationName = "takingOrder")
    @WebResult(name = "receiptObject")
    public Receipt takingOrder(@WebParam(name="OrderMinimal") Order order);

}