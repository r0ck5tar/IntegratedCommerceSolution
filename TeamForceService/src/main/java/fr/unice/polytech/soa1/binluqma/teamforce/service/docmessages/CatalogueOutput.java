package fr.unice.polytech.soa1.binluqma.teamforce.service.docmessages;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by Hakim on 07/10/14.
 */
@XmlType
public class CatalogueOutput {

    public CatalogueOutput() {}

    public CatalogueOutput(String link) {
        this.link = link;
    }

    private String link;

    @XmlElement(name = "link", required = true)
    public String getLink() { return link; }
    public void setLink(String link) { this.link = link; }
}
