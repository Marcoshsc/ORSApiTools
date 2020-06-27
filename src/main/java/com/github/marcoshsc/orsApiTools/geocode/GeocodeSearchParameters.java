package com.github.marcoshsc.orsApiTools.geocode;

import com.github.marcoshsc.orsApiTools.general.parameters.ApiKey;
import com.github.marcoshsc.orsApiTools.geocode.parameters.*;
import com.github.marcoshsc.orsApiTools.interfaces.ParameterList;
import com.github.marcoshsc.orsApiTools.interfaces.QueryParameter;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Set of parameters from geocode/search endpoint. Each parameter's description is inside it's class definition.
 *
 * @author Marcos Henrique in 28-04-2020
 */
@Getter
@Setter
@ToString
public class GeocodeSearchParameters implements ParameterList {

    /**
     * Api key to be used.
     */
    private ApiKey apiKey;
    /**
     * Name of location, street address or postal code.
     */
    private Text text;
    /**
     * Longitude of the focus.point.
     */
    private FocusPointLongitude focusPointLongitude;
    /**
     * Latitude of the focus.point.
     */
    private FocusPointLatitude focusPointLatitude;
    /**
     * Bottom border of rectangular boundary to narrow results.
     */
    private BoundaryRectMinimumLatitude boundaryRectMinimumLatitude;
    /**
     * Top border of rectangular boundary to narrow results.
     */
    private BoundaryRectMaximumLatitude boundaryRectMaximumLatitude;
    /**
     * Right border of rectangular boundary to narrow results.
     */
    private BoundaryRectMaximumLongitude boundaryRectMaximumLongitude;
    /**
     * Left border of rectangular boundary to narrow results.
     */
    private BoundaryRectMinimumLongitude boundaryRectMinimumLongitude;
    /**
     * Center Latitude of circular boundary to narrow results.
     */
    private BoundaryCircleLatitude boundaryCircleLatitude;
    /**
     * Center Longitude of circular boundary to narrow results.
     */
    private BoundaryCircleLongitude boundaryCircleLongitude;
    /**
     * Radius of circular boundary around the center coordinate in kilometers.
     */
    private BoundaryCircleRadius boundaryCircleRadius;
    /**
     * Restrict results to administrative boundary using a Pelias global id gid.
     */
    private BoundaryGID boundaryGID;
    /**
     * Restrict results to single country.
     */
    private BoundaryCountry boundaryCountry;
    /**
     * Restrict your search to specific sources.
     */
    private Sources sources;
    /**
     * Restrict search to layers (place type).
     */
    private Layers layers;
    /**
     * Set the number of returned results.
     */
    private Size size;

    /**
     *
     * @return a list of all not-null fields on the object.
     */
    @Override
    public List<QueryParameter<?>> getUsedParameters() {
        List<QueryParameter<?>> parameters = new ArrayList<>();
        try {
            for(Field f : this.getClass().getDeclaredFields()) {
                Object o;
                o = f.get(this);
                if(o != null)
                    parameters.add((QueryParameter<?>)o);
            }
        } catch (IllegalArgumentException | IllegalAccessException e) {
            System.out.println(e.getMessage());
            System.out.println("Something wrong happened with the parameters");
        }
        return parameters;
    }

}
