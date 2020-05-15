package com.github.marcoshsc.orsApiTools.geocode;

import com.github.marcoshsc.orsApiTools.general.parameters.ApiKey;
import com.github.marcoshsc.orsApiTools.geocode.parameters.*;
import com.github.marcoshsc.orsApiTools.interfaces.ParameterList;
import com.github.marcoshsc.orsApiTools.interfaces.QueryParameter;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Set of parameters from geocode/search endpoint. Each parameter's description is inside it's class definition.
 *
 * @author Marcos Henrique in 28-04-2020
 */
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

    public ApiKey getApiKey() {
        return apiKey;
    }

    public void setApiKey(ApiKey apiKey) {
        this.apiKey = apiKey;
    }

    public Text getText() {
        return text;
    }

    public void setText(Text text) {
        this.text = text;
    }

    public FocusPointLongitude getFocusPointLongitude() {
        return focusPointLongitude;
    }

    public void setFocusPointLongitude(FocusPointLongitude focusPointLongitude) {
        this.focusPointLongitude = focusPointLongitude;
    }

    public FocusPointLatitude getFocusPointLatitude() {
        return focusPointLatitude;
    }

    public void setFocusPointLatitude(FocusPointLatitude focusPointLatitude) {
        this.focusPointLatitude = focusPointLatitude;
    }

    public BoundaryRectMinimumLatitude getBoundaryRectMinimumLatitude() {
        return boundaryRectMinimumLatitude;
    }

    public void setBoundaryRectMinimumLatitude(BoundaryRectMinimumLatitude boundaryRectMinimumLatitude) {
        this.boundaryRectMinimumLatitude = boundaryRectMinimumLatitude;
    }

    public BoundaryRectMaximumLatitude getBoundaryRectMaximumLatitude() {
        return boundaryRectMaximumLatitude;
    }

    public void setBoundaryRectMaximumLatitude(BoundaryRectMaximumLatitude boundaryRectMaximumLatitude) {
        this.boundaryRectMaximumLatitude = boundaryRectMaximumLatitude;
    }

    public BoundaryRectMaximumLongitude getBoundaryRectMaximumLongitude() {
        return boundaryRectMaximumLongitude;
    }

    public void setBoundaryRectMaximumLongitude(BoundaryRectMaximumLongitude boundaryRectMaximumLongitude) {
        this.boundaryRectMaximumLongitude = boundaryRectMaximumLongitude;
    }

    public BoundaryRectMinimumLongitude getBoundaryRectMinimumLongitude() {
        return boundaryRectMinimumLongitude;
    }

    public void setBoundaryRectMinimumLongitude(BoundaryRectMinimumLongitude boundaryRectMinimumLongitude) {
        this.boundaryRectMinimumLongitude = boundaryRectMinimumLongitude;
    }

    public BoundaryCircleLatitude getBoundaryCircleLatitude() {
        return boundaryCircleLatitude;
    }

    public void setBoundaryCircleLatitude(BoundaryCircleLatitude boundaryCircleLatitude) {
        this.boundaryCircleLatitude = boundaryCircleLatitude;
    }

    public BoundaryCircleLongitude getBoundaryCircleLongitude() {
        return boundaryCircleLongitude;
    }

    public void setBoundaryCircleLongitude(BoundaryCircleLongitude boundaryCircleLongitude) {
        this.boundaryCircleLongitude = boundaryCircleLongitude;
    }

    public BoundaryCircleRadius getBoundaryCircleRadius() {
        return boundaryCircleRadius;
    }

    public void setBoundaryCircleRadius(BoundaryCircleRadius boundaryCircleRadius) {
        this.boundaryCircleRadius = boundaryCircleRadius;
    }

    public BoundaryGID getBoundaryGID() {
        return boundaryGID;
    }

    public void setBoundaryGID(BoundaryGID boundaryGID) {
        this.boundaryGID = boundaryGID;
    }

    public BoundaryCountry getBoundaryCountry() {
        return boundaryCountry;
    }

    public void setBoundaryCountry(BoundaryCountry boundaryCountry) {
        this.boundaryCountry = boundaryCountry;
    }

    public Sources getSources() {
        return sources;
    }

    public void setSources(Sources sources) {
        this.sources = sources;
    }

    public Layers getLayers() {
        return layers;
    }

    public void setLayers(Layers layers) {
        this.layers = layers;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }
}
