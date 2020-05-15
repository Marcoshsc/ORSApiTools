package com.github.marcoshsc.orsApiTools.pois;

import com.github.marcoshsc.orsApiTools.general.interfaces.JSONProcessingStrategy;
import com.github.marcoshsc.orsApiTools.geocode.helperclasses.BoundingBox;
import com.github.marcoshsc.orsApiTools.pois.enums.FiltersEnum;
import com.github.marcoshsc.orsApiTools.pois.enums.PoisRequestEnum;
import com.github.marcoshsc.orsApiTools.pois.helperclasses.Properties;
import com.github.marcoshsc.orsApiTools.pois.helperclasses.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.locationtech.jts.geom.Coordinate;

import java.util.*;

/**
 * POIS strategy for processing JSON and returning a response.
 *
 * @author Marcos Henrique
 */
public class PoisProcessingStrategy implements JSONProcessingStrategy<PoisResponse> {

    /**
     * Makes the JSON processing and return the response.
     * @param obj the JSON to be processed.
     * @return a java object corresponding to the JSON received.
     * @throws JSONException if some JSON parsing error was encountered.
     */
    @Override
    public PoisResponse processJSON(JSONObject obj) throws JSONException {
        BoundingBox boundingBox = getBoundingBox(obj);
        List<PoisLocation> features = getFeatures(obj);
        PoisResponseOptions options = getOptions(obj);
        return new PoisResponse(obj, boundingBox, features, options);
    }

    private BoundingBox getBoundingBox(JSONObject obj) throws JSONException {
        JSONArray bbox = obj.getJSONArray("bbox");
        return bbox.length() == 0 ? null :
                new BoundingBox(
                        bbox.getDouble(1),
                        bbox.getDouble(3),
                        bbox.getDouble(0),
                        bbox.getDouble(2)
                );
    }

    private List<PoisLocation> getFeatures(JSONObject obj) throws JSONException {
        JSONArray featuresArray = obj.getJSONArray("features");
        List<PoisLocation> features = new ArrayList<>();
        for (int i = 0; i < featuresArray.length(); i++) {
            PoisLocation feature = getFeature(featuresArray.getJSONObject(i));
            features.add(feature);
        }
        return features;
    }

    private PoisLocation getFeature(JSONObject obj) throws JSONException {
        Coordinate coordinate = getCoordinate(obj.getJSONObject("geometry").getJSONArray("coordinates"));
        Properties properties = getProperties(obj.getJSONObject("properties"));
        return new PoisLocation(coordinate, properties);
    }

    private Coordinate getCoordinate(JSONArray array) throws JSONException {
        return new Coordinate(array.getDouble(0), array.getDouble(1));
    }

    private Properties getProperties(JSONObject obj) throws JSONException {
        String osmId = obj.get("osm_id").toString();
        int osmType = obj.getInt("osm_type");
        double distance = obj.getDouble("distance");
        List<PoisCategory> categories = getCategories(obj.getJSONObject("category_ids"));
        OSMTags tags = getTags(obj.getJSONObject("osm_tags"));
        return new Properties(osmId, osmType, distance, categories, tags);
    }

    private List<PoisCategory> getCategories(JSONObject obj) throws JSONException {
        List<PoisCategory> categories = new ArrayList<>();
        Iterator<?> iterator = obj.keys();
        while(iterator.hasNext()) {
            String key = iterator.next().toString();
            PoisCategory category = getCategory(obj.getJSONObject(key), key);
            categories.add(category);
        }
        return categories;
    }

    private PoisCategory getCategory(JSONObject obj, String id) throws JSONException {
        String categoryName = obj.getString("category_name");
        String categoryGroup = obj.getString("category_group");
        return new PoisCategory(id, categoryName, categoryGroup);
    }

    private OSMTags getTags(JSONObject obj) throws JSONException {
        String name = getStringIfExists(obj, "name");
        String address = getStringIfExists(obj, "address");
        String webSite = getStringIfExists(obj, "website");
        String openingHours = getStringIfExists(obj, "opening_hours");
        String wheelchair = getStringIfExists(obj, "wheelchair");
        String distance = getStringIfExists(obj, "distance");
        String fee = getStringIfExists(obj, "fee");
        String smoking = getStringIfExists(obj, "smoking");
        String phone = getStringIfExists(obj, "phone");
        return new OSMTags(obj, name, address, webSite, openingHours, wheelchair, distance, fee, smoking, phone);
    }

    private String getStringIfExists(JSONObject obj, String key) throws JSONException {
        if(obj.has(key))
            return obj.getString(key);
        return null;
    }

    private PoisResponseOptions getOptions(JSONObject obj) throws JSONException {
        JSONObject query = obj.getJSONObject("information").getJSONObject("query");
        JSONObject geometry = query.getJSONObject("geometry");
        PoisRequestEnum request = PoisRequestEnum.getByStr(query.getString("request"));
        Map<FiltersEnum, List<String>> filters = getFilters(query);
        BoundingBox boundingBox = getOptionsBoundingBox(geometry);
        Coordinate coordinate = geometry.has("geojson") ?
                getCoordinate(geometry.getJSONObject("geojson").getJSONArray("coordinates")) : null;
        int buffer = geometry.has("buffer") ? geometry.getInt("buffer") : 0;
        return new PoisResponseOptions(request, filters, boundingBox, coordinate, buffer);
    }

    private Map<FiltersEnum, List<String>> getFilters(JSONObject query) throws JSONException {
        if(!query.has("filters"))
            return null;
        JSONObject filtersJSON = query.getJSONObject("filters");
        Map<FiltersEnum, List<String>> filters = new HashMap<>();
        for(FiltersEnum filter : FiltersEnum.values()) {
            List<String> valueList = getFilterValuesByKey(filtersJSON, filter.toString());
            if(valueList != null)
                filters.put(filter, valueList);
        }
        return filters;
    }

    private List<String> getFilterValuesByKey(JSONObject obj, String key) throws JSONException {
        if(!obj.has(key))
            return null;
        List<String> valueList = new ArrayList<>();
        JSONArray array = obj.getJSONArray(key);
        for (int i = 0; i < array.length(); i++) {
            valueList.add(array.get(i).toString());
        }
        return valueList;
    }

    private BoundingBox getOptionsBoundingBox(JSONObject geometry) throws JSONException {
        if(!geometry.has("bbox"))
            return null;
        JSONArray bboxArray = geometry.getJSONArray("bbox");
        JSONArray firstSector = bboxArray.getJSONArray(0), secondSector = bboxArray.getJSONArray(1);
        return new BoundingBox(firstSector.getDouble(1), secondSector.getDouble(1),
                                firstSector.getDouble(0), secondSector.getDouble(0));
    }

}
