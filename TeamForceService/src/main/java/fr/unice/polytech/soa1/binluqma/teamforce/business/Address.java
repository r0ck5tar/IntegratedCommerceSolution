package fr.unice.polytech.soa1.binluqma.teamforce.business;

/**
 * Created by Hakim on 06/10/14.
 */
public class Address {
    private String line1;
    private String line2;
    private String zip;
    private String city;
    private String type;
    private int ownerId;

    public Address(String line1, String line2, String zip, String city, String type, int ownerId) {
        this.line1 = line1;
        this.line2 = line2;
        this.zip = zip;
        this.city = city;
        this.type = type;
        this.ownerId = ownerId;
    }

    public String getLine1() { return line1; }

    public String getLine2() { return line2; }

    public String getZip() { return zip; }

    public String getCity() { return city; }

    public String getType() { return type; }

    public int getOwnerId() { return ownerId; }
}
