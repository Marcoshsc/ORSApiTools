package com.github.marcoshsc.orsApiTools.pois;

import com.github.marcoshsc.orsApiTools.interfaces.JSONBodyParameter;
import com.github.marcoshsc.orsApiTools.interfaces.JSONRequestBody;
import com.github.marcoshsc.orsApiTools.pois.parameters.*;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Field;

/**
 * Group of the parameters to the POIS endpoint on the ORS API.
 *
 * @author Marcos Henrique
 */
public class PoisParameters implements JSONRequestBody {

    /**
     * Type of the request.
     */
    private PoisParameterRequest request;
    /**
     * The geometry object which is a geojson or a bounding box object, optionally buffered.
     */
    private PoisGeometry geometry;
    /**
     * Filters in terms of osm_tags which should be applied to the query.
     */
    private Filters filters;
    /**
     * The limit of objects to be returned in the response.
     */
    private Limit limit;
    /**
     * Either you can sort by category or the distance to the geometry object provided in the request.
     * (Currently only distance sorting is allowed).
     */
    private SortBy sortBy;

    /**
     * Searches for not null values and return a JSON to be used in the body of the response.
     * @return the resulting JSON object.
     * @throws JSONException if some JSON parsing error happened.
     */
    @Override
    public JSONObject getBody() throws JSONException {
        JSONObject obj = new JSONObject();
        try {
            for(Field f : this.getClass().getDeclaredFields()) {
                Object o;
                o = f.get(this);
                if(o != null) {
                    JSONBodyParameter<?> parameter = (JSONBodyParameter<?>)o;
                    obj.put(parameter.getKey(), parameter.getValue());
                }
            }
        } catch (IllegalArgumentException | IllegalAccessException e) {
            System.out.println(e.getMessage());
            System.out.println("Something wrong happened with the parameters");
        }
        return obj;
    }

    /**
     *
     * @return request parameter
     */
    public PoisParameterRequest getRequest() {
        return request;
    }

    /**
     *
     * @param request the parameter to be set
     */
    public void setRequest(PoisParameterRequest request) {
        this.request = request;
    }

    /**
     *
     * @return geometry parameter
     */
    public PoisGeometry getGeometry() {
        return geometry;
    }

    /**
     *
     * @param geometry the parameter to be set
     */
    public void setGeometry(PoisGeometry geometry) {
        this.geometry = geometry;
    }

    /**
     *
     * @return filters parameter
     */
    public Filters getFilters() {
        return filters;
    }

    /**
     *
     * @param filters the parameter to be set
     */
    public void setFilters(Filters filters) {
        this.filters = filters;
    }

    /**
     *
     * @return limits parameter
     */
    public Limit getLimit() {
        return limit;
    }

    /**
     *
     * @param limit the parameter to be set
     */
    public void setLimit(Limit limit) {
        this.limit = limit;
    }

    /**
     *
     * @return sortby parameter
     */
    public SortBy getSortBy() {
        return sortBy;
    }

    /**
     *
     * @param sortBy the parameter to be set
     */
    public void setSortBy(SortBy sortBy) {
        this.sortBy = sortBy;
    }
}
