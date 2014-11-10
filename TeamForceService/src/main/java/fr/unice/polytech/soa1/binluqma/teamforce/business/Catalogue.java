package fr.unice.polytech.soa1.binluqma.teamforce.business;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Hakim on 06/10/14.
 */
public class Catalogue {
    private String name;
    private Map<String, Category> categories = new HashMap<>();

    public Catalogue(String name) { this.name = name; }

    public Map<String, Category> getCategories() { return categories; }
}
