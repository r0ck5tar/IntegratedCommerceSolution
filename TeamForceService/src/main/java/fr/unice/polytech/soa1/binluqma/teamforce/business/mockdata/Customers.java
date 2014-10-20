package fr.unice.polytech.soa1.binluqma.teamforce.business.mockdata;

import fr.unice.polytech.soa1.binluqma.teamforce.business.Customer;

import javax.ejb.Singleton;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Hakim on 06/10/14.
 */
@Singleton(name = "Customers-DB-Mock")
public class Customers {
    private Map<Integer, Customer> customersById;
    private Map<String, Customer> customersByFullName;

    public Customers() { init(); }

    private void init() {
        customersById = new HashMap<>();
        customersByFullName = new HashMap<>();

        URL customersCSV = Catalogues.class.getResource("/customers.csv");
        System.out.println(customersCSV.getFile());

        try {
            BufferedReader br = new BufferedReader(new FileReader(customersCSV.getFile().replace("%20", " ")));
            String line = br.readLine();
            while((line = br.readLine()) != null) {
                String[] entry = line.split("\\|");
                int id = Integer.parseInt(entry[0].trim());
                String firstName = entry[1].trim();
                String lastName = entry[2].trim();
                String fullName = firstName + " " + lastName;
                String email = entry[3].trim();
                String phone = entry[4].trim();

                Customer customer = new Customer(id, firstName, lastName, email, phone);
                customersById.put(id, customer);
                customersByFullName.put(fullName, customer);
            }
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Customer findById(int id) {
        return customersById.get(id);
    }

    public Customer findByFullName(String fullName) {
        return customersByFullName.get(fullName);
    }

    public Collection<Customer> getAllCustomers() {
        return customersById.values();
    }
}
