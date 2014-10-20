package fr.unice.polytech.soa1.binluqma.teamforce.business;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hakim on 06/10/14.
 */
public class Catalogue {
    private String name;
    private List<Category> categories = new ArrayList<>();

    public Catalogue(String name) { this.name = name; }

    public List<Category> getCategories() { return categories; }
}
