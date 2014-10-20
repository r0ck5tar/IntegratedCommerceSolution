package fr.unice.polytech.soa1.binluqma.teamforce.business.mockdata;

import fr.unice.polytech.soa1.binluqma.teamforce.business.Address;

import javax.ejb.Singleton;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Hakim on 06/10/14.
 */
@Singleton(name = "Address-DB-Mock")
public class Addresses {
    private Map<Integer, List<Address>> addresses;

    public Addresses() { init(); }

    private void init() {
        addresses = new HashMap<>();

        URL addressesCSV = Catalogues.class.getResource("/addresses.csv");
        System.out.println(addressesCSV.getFile());

        try {
            BufferedReader br = new BufferedReader(new FileReader(addressesCSV.getFile().replace("%20", " ")));
            String line = br.readLine();
            while((line = br.readLine()) != null) {
                String[] entry = line.split("\\|");
                String line1 = entry[0].trim();
                String line2 = entry[1].trim();
                String zip = entry[2].trim();
                String city = entry[3].trim();
                String type = entry[4].trim();
                int owner = Integer.parseInt(entry[5].trim());

                if(addresses.containsKey(owner)) {
                    addresses.get(owner).add(new Address(line1, line2, zip, city, type, owner));
                }

                else{
                    List<Address> addressList = new ArrayList<>();
                    addressList.add(new Address(line1, line2, zip, city, type, owner));
                    addresses.put(owner, addressList);
                }


            }
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Address> getAddressesByCustomerId(int i) {
        return addresses.get(i);
    }
}
