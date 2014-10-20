package fr.unice.polytech.soa1.binluqma.teamforce.service;

import fr.unice.polytech.soa1.binluqma.teamforce.business.Address;
import fr.unice.polytech.soa1.binluqma.teamforce.business.Customer;
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
 * Created by Hakim on 19/10/14.
 */
@Path("/teamforce/asdf/")
public class CustomerServiceImpl implements CustomerService {
    @EJB private Customers customers;
    @EJB private Addresses addresses;
    @EJB private Catalogues catalogues;
    @EJB private Orders orders;
    @Context
    private UriInfo uri;

    @Override
    public Response viewCustomer(int id) {
        Customer c = customers.findById(id);
        CustomerInfo customerInfo = new CustomerInfo(c.getId(), c.getFirstName(), c.getLastName(), c.getEmail(), c.getPhone());

        List<Integer> orderIDs = orders.getOrdersByCustomerId(id);
        ListOfOrders listOfOrders = new ListOfOrders();

        if(orderIDs != null) {
            for(int i: orderIDs) {
                listOfOrders.getOrders().add(uri.getBaseUri().toString() + "teamforce/public/customers" + id + "/orders/" + i);
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
}
