package fr.unice.polytech.soa1.binluqma.teamforce.service;

import fr.unice.polytech.soa1.binluqma.teamforce.service.docmessages.CatalogueInput;
import fr.unice.polytech.soa1.binluqma.teamforce.service.docmessages.CatalogueOutput;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlElement;

/**
 * Created by Hakim on 05/10/14.
 */
@WebService(targetNamespace = "http://informatique.polytech.unice.fr/soa1/binluqma/teamforce-management")
public interface ManagementService {

    @WebMethod(operationName = "createcatalogue")
    @WebResult(name = "newcatalogue")
    public CatalogueOutput createCatalogue(@WebParam(name = "catalogue") CatalogueInput input);
}

