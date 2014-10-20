package fr.unice.polytech.soa1.binluqma.teamforce.service;

import fr.unice.polytech.soa1.binluqma.teamforce.business.Catalogue;
import fr.unice.polytech.soa1.binluqma.teamforce.business.Product;
import fr.unice.polytech.soa1.binluqma.teamforce.business.mockdata.Catalogues;
import fr.unice.polytech.soa1.binluqma.teamforce.service.docmessages.*;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;

/**
 * Created by Hakim on 07/10/14.
 */
@Stateless(name = "management")
@WebService(targetNamespace = "http://informatique.polytech.unice.fr/soa1/binluqma/teamforce-management",
        portName = "ManagementPort",
        serviceName = "ManagementService",
        endpointInterface = "fr.unice.polytech.soa1.binluqma.teamforce.service.ManagementService")
public class ManagementServiceImpl implements ManagementService {
    @EJB private Catalogues catalogues;

    @Override
    public CatalogueOutput createCatalogue(CatalogueInput input) {
        String name = input.getName();
        Catalogue catalogue = new Catalogue(name);
        Product product = null;
        for (RecommendedProductInfo p: input.getProducts()) {
            if (!catalogues.getAllProducts().containsKey(p.getId())) {
                product = new Product(p.getId(), p.getPrice());
                catalogues.getAllProducts().put(p.getId(), product);
            }
            else {
                product = catalogues.getAllProducts().get(p.getId());
            }

            //catalogue.getProducts().add(product);
        }
        catalogues.getCatalogues().put(name, catalogue);

        return new CatalogueOutput("http://localhost:8080/teamforce/public/catalogues/" + name);
    }
}
