package fr.unice.polytech.soa1.binluqma.teamforce.business.mockdata;

import fr.unice.polytech.soa1.binluqma.teamforce.business.Address;
import fr.unice.polytech.soa1.binluqma.teamforce.business.Order;
import fr.unice.polytech.soa1.binluqma.teamforce.business.OrderStatus;

import javax.ejb.Singleton;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.*;

/**
 * Created by Hakim on 06/10/14.
 */
@Singleton(name = "Orders-DB-Mock")
public class Orders {
    //map of customer IDs to Order IDs
    private Map<Integer, List<Integer>> customersToOrders;
    private Map<Integer, Order> orders;
    private Random random = new Random();
    private Address address;

    public Orders() { init(); }

    private void init() {
        customersToOrders = new HashMap<>();
        orders = new HashMap<>();

        URL ordersCSV = Catalogues.class.getResource("/orders.csv");
        System.out.println(ordersCSV.getFile());

        try {
            int randomCustomer = 1;
            BufferedReader br = new BufferedReader(new FileReader(ordersCSV.getFile().replace("%20", " ")));
            String line = br.readLine();
            while((line = br.readLine()) != null) {
                String[] entry = line.split("\\|");
                int orderId = Integer.parseInt(entry[0].trim());
                String product = entry[1].trim();
                int quantity = Integer.parseInt(entry[2].trim());

                if(orders.containsKey(orderId)) {
                    orders.get(orderId).getProductQuantities().put(product, quantity);
                }

                else{
                    Order order = new Order();
                    order.setStatus(OrderStatus.values()[random.nextInt(OrderStatus.values().length)]);
                    orders.put(orderId, order);

                    if(customersToOrders.containsKey(randomCustomer)) {
                        customersToOrders.get(randomCustomer).add(orderId);
                    }
                    else {
                         ArrayList<Integer> orderIds = new ArrayList<>();
                         orderIds.add(orderId);
                         customersToOrders.put(randomCustomer, orderIds);
                         randomCustomer++;
                    }
                }
            }
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Integer> getOrdersByCustomerId(int id) {
        return customersToOrders.get(id);
    }

    public Order getOrderById(int id) {
        return orders.get(id);
    }

    public Map<Integer, List<Integer>> getCustomersToOrders() {
        return customersToOrders;
    }

    public Map<Integer, Order> getOrders() {
        return orders;
    }
}
