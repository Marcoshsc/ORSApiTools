package com.github.marcoshsc.orsApiTools.pois.helperclasses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * Represents a category, composed by an ID, the category name and the category group name.
 * The ID is a osm ID, so you can search on the docs to see what each code mean.
 *
 * @author Marcos Henrique
 */
@Getter
@ToString
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PoisCategory {

    /**
     * OSM integer identifier of the category
     */
    private final String id;

    /**
     * Category name
     */
    private final String name;

    /**
     * Category group name.
     */
    private final String group;

}
