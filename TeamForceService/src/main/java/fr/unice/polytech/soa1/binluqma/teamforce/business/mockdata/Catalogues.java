package fr.unice.polytech.soa1.binluqma.teamforce.business.mockdata;

import fr.unice.polytech.soa1.binluqma.teamforce.business.Catalogue;
import fr.unice.polytech.soa1.binluqma.teamforce.business.Product;

import javax.ejb.Singleton;
import java.io.*;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by Hakim on 05/10/14.
 */
@Singleton(name = "Catalogues-DB-Mock")
public class Catalogues {
    private Map<String, Catalogue> catalogues;
    private Map<String, Product> allProducts;
    private Random random = new Random();

    public Catalogues() { init(); }

    private void init() {
        catalogues = new HashMap<String, Catalogue>();
        allProducts = new HashMap<>();

        URL cataloguesCSV = Catalogues.class.getResource("/catalogues.csv");
        System.out.println(cataloguesCSV.getFile());

        try {
            BufferedReader br = new BufferedReader(new FileReader(cataloguesCSV.getFile().replace("%20", " ")));
            String line = br.readLine();
            while((line = br.readLine()) != null) {
                String[] entry = line.split("\\|");
                String catalogue = entry[1].trim();
                String product = entry[0].trim();

                allProducts.put(product, new Product(product, random.nextInt(20) + 1 + random.nextFloat()));

                if(catalogues.containsKey(catalogue)) {
                    //catalogues.get(catalogue).getProducts().add(allProducts.get(product));
                }

                else{
                    Catalogue c = new Catalogue(catalogue);
                    //c.getProducts().add(allProducts.get(product));
                    catalogues.put(catalogue, c);
                }


            }
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Map<String, Catalogue> getCatalogues() { return catalogues; }

    public Map<String, Product> getAllProducts() { return allProducts; }
}
