package com.github.marcoshsc.orsApiTools.pois.helperclasses;

/**
 * Represents a category, composed by an ID, the category name and the category group name.
 * The ID is a osm ID, so you can search on the docs to see what each code mean.
 *
 * @author Marcos Henrique
 */
public class PoisCategory {

    /**
     * OSM integer identifier of the category
     */
    private String id;
    /**
     * Category name
     */
    private String name;
    /**
     * Category group name.
     */
    private String group;

    public PoisCategory(String id, String name, String group) {
        this.id = id;
        this.name = name;
        this.group = group;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGroup() {
        return group;
    }

    @Override
    public String toString() {
        return "PoisCategory{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", group='" + group + '\'' +
                "}\n";
    }
}
