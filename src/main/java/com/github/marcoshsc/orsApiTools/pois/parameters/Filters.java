package com.github.marcoshsc.orsApiTools.pois.parameters;

import com.github.marcoshsc.orsApiTools.general.enums.ORSEnum;
import com.github.marcoshsc.orsApiTools.interfaces.JSONBodyParameter;
import com.github.marcoshsc.orsApiTools.pois.enums.FeeEnum;
import com.github.marcoshsc.orsApiTools.pois.enums.SmokingEnum;
import com.github.marcoshsc.orsApiTools.pois.enums.WheelChairEnum;
import com.github.marcoshsc.orsApiTools.utils.UtilityFunctions;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;
import java.util.List;

/**
 * Filters in terms of osm_tags which should be applied to the query.
 * Set to null filters that won't be used.
 *
 * @author Marcos Henrique
 */
public class Filters implements JSONBodyParameter<JSONObject> {

    private static final String name = ORSEnum.FILTERS_BODY_PARAM.toString();
    /**
     * List of integers representing category group IDs to filter the response.
     */
    private List<Integer> categoryGroupIds;
    /**
     * List of integers representing category IDs to filter the response.
     */
    private List<Integer> categoryIds;
    /**
     * List of location names to be accepted as response.
     */
    private List<String> names;
    /**
     * List of integers representing wheelchair accessibility required in returned locations.
     */
    private List<WheelChairEnum> wheelchair;
    /**
     * List of integers representing smoking rules required in returned locations.
     */
    private List<SmokingEnum> smoking;
    /**
     * List of integers representing fee rules required in returned locations.
     * Fee refers to pay money to enter/use the place.
     */
    private List<FeeEnum> fee;

    public Filters(List<Integer> categoryGroupIds, List<Integer> categoryIds, List<String> names,
                   List<WheelChairEnum> wheelchair, List<SmokingEnum> smoking, List<FeeEnum> fee) {
        this.categoryGroupIds = categoryGroupIds;
        this.categoryIds = categoryIds;
        this.names = names;
        this.wheelchair = wheelchair;
        this.smoking = smoking;
        this.fee = fee;
    }

    /**
     *
     * @return the parameter name.
     */
    @Override
    public String getKey() {
        return name;
    }

    /**
     *
     * @return the final processed object referent to the parameter.
     */
    @Override
    public JSONObject getValue() throws JSONException {
        JSONObject obj = new JSONObject();
        if(categoryGroupIds != null)
            obj.put("category_group_ids", UtilityFunctions.getIntegerJSONArray(categoryGroupIds));
        if(categoryIds != null)
            obj.put("category_ids", UtilityFunctions.getIntegerJSONArray(categoryIds));
        if(names != null)
            obj.put("name", UtilityFunctions.getStringJSONArray(names));
        if(wheelchair != null)
            obj.put("wheelchair", UtilityFunctions.getStringJSONArray(wheelchair));
        if(smoking != null)
            obj.put("smoking", UtilityFunctions.getStringJSONArray(smoking));
        if(fee != null)
            obj.put("fee", UtilityFunctions.getStringJSONArray(fee));
        return obj;
    }

    public static void main(String[] args) throws JSONException {
        JSONObject obj = new JSONObject();
        Filters filters = new Filters(Arrays.asList(1, 2, 3), null, Arrays.asList("name1", "name2"),
                Arrays.asList(WheelChairEnum.YES, WheelChairEnum.DESIGNATED), Arrays.asList(SmokingEnum.ISOLATED),
                null);
        obj.put(filters.getKey(), filters.getValue());
        System.out.println(obj);
    }

}
