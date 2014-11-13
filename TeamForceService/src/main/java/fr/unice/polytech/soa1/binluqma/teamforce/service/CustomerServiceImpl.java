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
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Hakim on 19/10/14.
 */
@Path("/teamforce/")
public class CustomerServiceImpl implements CustomerService {
    @EJB private Customers customers;
    @EJB private Addresses addresses;
    @EJB private Catalogues catalogues;
    @EJB private Orders orders;
    @Context private UriInfo uri;
    private Random random = new Random();

    @Override
    public Response viewCustomer(int id) {
        Customer c = customers.findById(id);
        CustomerInfo customerInfo = new CustomerInfo(c.getId(), c.getFirstName(), c.getLastName(), c.getEmail(), c.getPhone());

        List<Integer> orderIDs = orders.getOrdersByCustomerId(id);
        ListOfOrders listOfOrders = new ListOfOrders();

        if(orderIDs != null) {
            for(int i: orderIDs) {
                listOfOrders.getOrders().add(uri.getBaseUri().toString() + "teamforce/customers" + id + "/orders/" + i);
            }
        }

        customerInfo.setOrders(listOfOrders);

        if(addresses.getAddressesByCustomerId(id) != null) {
            for(Address a: addresses.getAddressesByCustomerId(id)) {
                AddressInfo addressInfo = new AddressInfo(a.getLine1(), a.getLine2(), a.getZip(), a.getCity(), a.getType());
                customerInfo.getAddresses().add(addressInfo);
            }
        }

        return Response.ok(customerInfo).build();
    }

    @Override
    public Response viewCustomers() {
        return null;
    }

    @Override
    public Response createCustomer() {
        return null;
    }

    @Override
    public Response updateCustomer() {
        return null;
    }

    @Override
    public Response deleteCustomer(int id) {
        return null;
    }

    @Override
    public Response findCustomerByName(String firstName, String lastName) {
        return null;
    }

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

        for (Category c: catalogues.getCatalogues().get(edition).getCategories().values()) {
            for(Product p: c.getProducts()) {
                ProductInfo productInfo = new ProductInfo(p.getId(), p.getPrice());
                productInfo.setLink(uri.getBaseUri().toString() + "teamforce/products/" + p.getId());
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
            productInfo.setLink(uri.getBaseUri().toString() + "teamforce/products/" + p.getId());
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
    public Response createOrder(Integer id, OrderInput input) {
        /*
        Order order = new Order();
        order.setOrderId(orders.getOrders().size()+1);
        order.setStatus(OrderStatus.ORDERED);

        if(addresses.getAddressesByCustomerId(id) != null) {
            Address deliveryAddress = addresses.getAddressesByCustomerId(id).get(0);
            order.setDeliveryAddress(deliveryAddress);
        }

        for (ProductOrder p: input.getProductOrders()) {
            Product product = catalogues.getAllProducts().get(p.getId());

            if(product != null) {
                order.getProductQuantities().put(p.getId(), p.getQuantity());
            }
        }

        orders.getOrders().put(order.getOrderId(), order);
        if (orders.getCustomersToOrders().containsKey(id)) {
            orders.getCustomersToOrders().get(id).add(order.getOrderId());
        }
        else {
            List<Integer> orderList = new ArrayList<>();
            orderList.add(order.getOrderId());
            orders.getCustomersToOrders().put(id, orderList);
        }
        */
        OrderOutput result = new OrderOutput();
        /*
        int totalProducts = catalogues.getAllProducts().size();
        for (int i = 0; i <3;  i++) {
            RecommendedProductInfo productInfo = new RecommendedProductInfo();
            String recommendedProductName = (String) catalogues.getAllProducts().keySet().toArray()[random.nextInt(totalProducts)];
            Product product = catalogues.getAllProducts().get(recommendedProductName) ;
            productInfo.setId(product.getId());
            productInfo.setPrice(product.getPrice());
            result.getRecommendedProducts().add(productInfo);
        }
        */
        result.setOrderStatus(OrderStatus.ORDERED);
        return Response.ok(result).build();
    }

    @Override
    public Response viewCustomerOrder(int id, int orderId) {
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

    @Override
    public Response viewOrder(int orderId) {
        return null;
    }

    @Override
    public Response getAllProductSuggestions() {
        ListOfSuggestedProducts result = new ListOfSuggestedProducts();

        for (Customer c: customers.getAllCustomers()) {
            SuggestedProducts suggestions = new SuggestedProducts();
            suggestions.setCustomerId(c.getId());
            suggestions.setCustomerName(c.getFirstName()+ " " + c.getLastName());

            for (int i=0; i < 5; i++) {
                int totalProducts = catalogues.getAllProducts().size();
                Product randomProduct = (Product) catalogues.getAllProducts().values().toArray()[random.nextInt(totalProducts)];
                ProductInfo productInfo = new ProductInfo(randomProduct.getId(), randomProduct.getPrice());
                suggestions.getProducts().add(productInfo);
            }
            result.getSuggestedProducts().add(suggestions);
        }

        return Response.ok(result).build();
    }

    @Override
    public Response getProductSuggestionsForCustomer(int id) {
        return null;
    }
}
