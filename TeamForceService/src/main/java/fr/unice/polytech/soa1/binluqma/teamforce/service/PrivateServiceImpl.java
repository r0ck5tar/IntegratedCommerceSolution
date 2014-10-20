package fr.unice.polytech.soa1.binluqma.teamforce.service;

import fr.unice.polytech.soa1.binluqma.teamforce.business.Customer;
import fr.unice.polytech.soa1.binluqma.teamforce.business.Product;
import fr.unice.polytech.soa1.binluqma.teamforce.business.mockdata.Catalogues;
import fr.unice.polytech.soa1.binluqma.teamforce.business.mockdata.Customers;

import javax.ejb.EJB;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.util.Random;

/**
 * Created by Hakim on 07/10/14.
 */
@Path("/teamforce/private")
public class PrivateServiceImpl implements PrivateService {
    private Random random = new Random();
    @EJB private Customers customers;
    @EJB private Catalogues catalogues;

    @Override
    public Response viewOrders() {
        return null;
    }

    @Override
    public Response findOrderById() {
        return null;
    }

    @Override
    public Response viewCustomers() {
        return null;
    }

    @Override
    public Response findCustomerById(int id) {
        return null;
    }

    @Override
    public Response findCustomerByName(String firstName, String lastName) {
        return null;
    }

    @Override
    public Response updateCustomer(int id) {
        return null;
    }

    @Override
    public Response updateOrder(int orderId) {
        return null;
    }

    @Override
    public Response deleteCustomer(int id) {
        return null;
    }

    @Override
    public Response deleteOrder(int orderId) {
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
