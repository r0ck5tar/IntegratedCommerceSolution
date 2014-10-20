package fr.unice.polytech.soa1.binluqma.teamforce.service;

import fr.unice.polytech.soa1.binluqma.teamforce.business.*;
import fr.unice.polytech.soa1.binluqma.teamforce.business.mockdata.Addresses;
import fr.unice.polytech.soa1.binluqma.teamforce.business.mockdata.Catalogues;
import fr.unice.polytech.soa1.binluqma.teamforce.business.mockdata.Customers;
import fr.unice.polytech.soa1.binluqma.teamforce.business.mockdata.Orders;

import javax.ejb.EJB;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.List;

/**
 * Created by Hakim on 05/10/14.
 */
@Path("/teamforce/")
public class OrderServiceImpl implements OrderService {
    @EJB private Customers customers;
    @EJB private Addresses addresses;
    @EJB private Catalogues catalogues;
    @EJB private Orders orders;
    @Context private UriInfo uri;

    @Override
    public Response catalogues() {
        ListOfCatalogues result = new ListOfCatalogues();

        for (String c: catalogues.getCatalogues().keySet()) {
            result.getCatalogues().add(uri.getAbsolutePath().toString() + "/" + c);
        }
        return Response.ok(result).build();
    }

    @Override
    public Response viewCatalogue(String edition) {
        ListOfProducts result = new ListOfProducts();

        for (Category c: catalogues.getCatalogues().get(edition).getCategories()) {
            for(Product p: c.getProducts()) {
                ProductInfo productInfo = new ProductInfo(p.getId(), p.getPrice());
                productInfo.setLink(uri.getBaseUri().toString() + "teamforce/public/products/" + p.getId());
                result.getProducts().add(productInfo);
            }
        }
        return Response.ok(result).build();
    }

    @Override
    public Response products() {
        ListOfProducts result = new ListOfProducts();

        for(Product p: catalogues.getAllProducts().values()) {
            ProductInfo productInfo = new ProductInfo(p.getId(), p.getPrice());
            productInfo.setLink(uri.getBaseUri().toString() + "teamforce/public/products/" + p.getId());
            result.getProducts().add(productInfo);
        }

        return Response.ok(result).build();
    }

    @Override
    public Response viewProduct(String id) {
        Product product = catalogues.getAllProducts().get(id);
        ProductInfo productInfo = new ProductInfo(product.getId(), product.getPrice());
        return Response.ok(productInfo).build();
    }



    @Override
    public Response viewCustomerOrders(int id) {
        List<Integer> orderIds = orders.getOrdersByCustomerId(id);

        if(orderIds == null) {
            return Response.status(404).build();
        }

        FullListOfOrders result = new FullListOfOrders();
        for(int i: orderIds) {
            Order order = orders.getOrderById(i);
            OrderInfo orderInfo = new OrderInfo(i);
            orderInfo.setStatus(order.getStatus());
            for(String p: order.getProductQuantities().keySet()) {
                Product product = catalogues.getAllProducts().get(p);
                int quantity = order.getProductQuantities().get(p);
                ProductQuantity productQuantity = new ProductQuantity(product.getId(), quantity, product.getPrice()*quantity);
                orderInfo.getProductQuantities().add(productQuantity);
                if(order.getDeliveryAddress() != null) {
                    Address address = order.getDeliveryAddress();
                    AddressInfo deliveryAddressInfo = new AddressInfo(address.getLine1(), address.getLine2(), address.getZip(), address.getCity(), address.getType());
                    orderInfo.setDeliveryAddress(deliveryAddressInfo);
                }
            }
            result.getOrders().add(orderInfo);
        }
        return Response.ok(result).build();
    }

    @Override
    public Response viewCustomerOrder(int id, int orderId) {
        return null;
    }

    @Override
    public Response viewOrder(int orderId) {
        return null;
    }

    @Override
    public Response createOrder() {
        return null;
    }

    @Override
    public Response updateOrder(int id, int orderId) {
        return null;
    }

    @Override
    public Response deleteOrder(int id, int orderId) {
        return null;
    }
}
