package com.github.marcoshsc.orsApiTools.geocode.parameters;

import com.github.marcoshsc.orsApiTools.general.enums.ORSEnum;
import com.github.marcoshsc.orsApiTools.general.superclasses.StringParameter;

/**
 * Restrict results to administrative boundary using a Pelias global id gid.
 * gids for records can be found using either the Who’s on First Spelunker,
 * a tool for searching Who’s on First data, or from the responses of other Pelias queries.
 *
 * @author Marcos Henrique in 27-04-2020
 */
public class BoundaryGID extends StringParameter {

    private final String name = ORSEnum.BOUNDARY_GEOGRAPHIC_ID.toString();

    public BoundaryGID(String value) {
        super(value);
    }

    @Override
    public String getName() {
        return name;
    }
}
