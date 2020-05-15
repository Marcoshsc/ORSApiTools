package com.github.marcoshsc.orsApiTools.directions;

import com.github.marcoshsc.orsApiTools.directions.enums.*;
import com.github.marcoshsc.orsApiTools.directions.helperclasses.Maneuever;
import com.github.marcoshsc.orsApiTools.directions.helperclasses.RequestOptions;
import com.github.marcoshsc.orsApiTools.directions.helperclasses.Segment;
import com.github.marcoshsc.orsApiTools.directions.helperclasses.Step;
import com.github.marcoshsc.orsApiTools.directions.helperclasses.extrainfo.DirectionsExtraInfo;
import com.github.marcoshsc.orsApiTools.directions.helperclasses.extrainfo.ExtraInfoField;
import com.github.marcoshsc.orsApiTools.directions.helperclasses.extrainfo.ExtraInfoSummary;
import com.github.marcoshsc.orsApiTools.directions.helperclasses.extrainfo.ExtraInfoValues;
import com.github.marcoshsc.orsApiTools.general.interfaces.JSONProcessingStrategy;
import com.github.marcoshsc.orsApiTools.geocode.helperclasses.BoundingBox;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.locationtech.jts.geom.Coordinate;

import java.util.ArrayList;
import java.util.List;

/**
 * JSON processing strategy for Directions requests. Parses the JSON and return a java object response.
 *
 * @author Marcos Henrique
 */
public class DirectionsProcessingStrategy implements JSONProcessingStrategy<DirectionsResponse> {

    /**
     *
     * @param obj the JSON to be processed
     * @return the processed response.
     * @throws JSONException if JSON parsing errors were encountered.
     */
    @Override
    public DirectionsResponse processJSON(JSONObject obj) throws JSONException {
        JSONObject route = obj.getJSONArray("routes").getJSONObject(0);
        JSONObject info = obj.getJSONObject("info");
        JSONObject summary = route.getJSONObject("summary");
        double totalDistance = summary.getDouble("distance");
        double totalDuration = summary.getDouble("duration");
        Double ascent = getIfExists(summary, "ascent");
        Double descent = getIfExists(summary, "descent");
        Double avgSpeed = getIfExists(summary, "avgspeed");
        List<Coordinate> coordList = getGeometry(route);
        List<Segment> segmentList = getSegments(route);
        DirectionsExtraInfo extraInfo = getExtraInfo(route);
        BoundingBox boundingBox = getBoundingBox(route);
        RequestOptions options = getRequestOptions(info);
        return new DirectionsResponse(obj, totalDistance, totalDuration, ascent, descent, avgSpeed, coordList,
                segmentList, extraInfo, boundingBox, options);
    }

    private Double getIfExists(JSONObject obj, String key) throws JSONException {
        if(!obj.has(key))
            return null;
        return obj.getDouble(key);
    }

    private List<Coordinate> getGeometry(JSONObject obj) throws JSONException {
        if(!obj.has("geometry"))
            return new ArrayList<>();
        String geometryFormat = obj.getString("geometry_format");
        JSONArray coordinates = geometryFormat.equals(EnumDirectionsGeomType.GEOJSON.toString()) ?
                obj.getJSONObject("geometry").getJSONArray("coordinates") :
                obj.getJSONArray("geometry");
        return getCoordListFromJSONArray(coordinates);
    }

    private List<Coordinate> getCoordListFromJSONArray(JSONArray coordinates) throws JSONException {
        List<Coordinate> coordList = new ArrayList<>();
        for (int i = 0; i < coordinates.length(); i++) {
            JSONArray coordJSON = coordinates.getJSONArray(i);
            Coordinate coord;
            coord = coordJSON.length() == 2 ?
                    new Coordinate(coordJSON.getDouble(0), coordJSON.getDouble(1)) :
                    new Coordinate(coordJSON.getDouble(0), coordJSON.getDouble(1), coordJSON.getDouble(2));
            coordList.add(coord);
        }
        return coordList;
    }

    private List<Segment> getSegments(JSONObject obj)
            throws JSONException {
        if(!obj.has("segments"))
            return new ArrayList<>();
        JSONArray segmentsWayPoints = obj.getJSONArray("way_points");
        JSONArray segmentsArray = obj.getJSONArray("segments");
        List<Segment> segmentList = new ArrayList<>();
        for (int i = 0; i < segmentsArray.length(); i++) {
            JSONObject segmentJSON = segmentsArray.getJSONObject(i);
            double segmentDistance = segmentJSON.getDouble("distance");
            double segmentDuration = segmentJSON.getDouble("duration");
            Double ascent = getIfExists(segmentJSON, "ascent");
            Double descent = getIfExists(segmentJSON, "descent");
            Double avgSpeed = getIfExists(segmentJSON, "avgspeed");
            Double detourFactor = getIfExists(segmentJSON, "detourfactor");
            Double percentage = getIfExists(segmentJSON, "percentage");
            List<Step> stepList = getSteps(segmentJSON);
            int firstIndex = segmentsWayPoints.getInt(i), lastIndex = segmentsWayPoints.getInt(i + 1);
            Segment segment = new Segment(segmentDistance, segmentDuration, ascent, descent, avgSpeed, detourFactor,
                    percentage, stepList, firstIndex, lastIndex);
            segmentList.add(segment);
        }
        return segmentList;
    }

    private List<Step> getSteps(JSONObject segmentJSON)
            throws JSONException {
        JSONArray stepsArray = segmentJSON.getJSONArray("steps");
        List<Step> stepList = new ArrayList<>();
        for (int j = 0; j < stepsArray.length(); j++) {
            JSONObject stepJSON = stepsArray.getJSONObject(j);
            Step step = getStep(stepJSON);
            stepList.add(step);
        }
        return stepList;
    }

    private Step getStep(JSONObject stepJSON)
            throws JSONException {
        double stepDistance = stepJSON.getDouble("distance");
        double stepDuration = stepJSON.getDouble("duration");
        int type = stepJSON.getInt("type");
        String instruction = stepJSON.getString("instruction");
        String name = stepJSON.getString("name");
        Maneuever maneuever = getManeuever(stepJSON);
        JSONArray wayPoints = stepJSON.getJSONArray("way_points");
        int startIndex = wayPoints.getInt(0), endIndex = wayPoints.getInt(1);
        return new Step(stepDistance, stepDuration, type, instruction, name, maneuever, startIndex, endIndex);
    }

    private Maneuever getManeuever(JSONObject stepJSON) throws JSONException {
        if(!stepJSON.has("maneuver"))
            return null;
        JSONObject maneuverJSON = stepJSON.getJSONObject("maneuver");
        double bearingBefore = maneuverJSON.getDouble("bearing_before");
        double bearingAfter = maneuverJSON.getDouble("bearing_after");
        if(!maneuverJSON.has("location"))
            return new Maneuever(bearingBefore, bearingAfter, null);
        JSONArray bearingCoordsJSON = maneuverJSON.getJSONArray("location");
        Coordinate location = new Coordinate(bearingCoordsJSON.getDouble(0), bearingCoordsJSON.getDouble(1));
        return new Maneuever(bearingBefore, bearingAfter, location);
    }

    private DirectionsExtraInfo getExtraInfo(JSONObject obj) throws JSONException {
        if(!obj.has("extras"))
            return new DirectionsExtraInfo(null, null, null, null,null,
                    null,null,null, null, null);
        JSONObject extras = obj.getJSONObject("extras");
        ExtraInfoField steepness = getExtraInfoField(extras, ExtraInfoEnum.STEEPNESS);
        ExtraInfoField suitability = getExtraInfoField(extras, ExtraInfoEnum.SUITABILITY);
        ExtraInfoField surface = getExtraInfoField(extras, ExtraInfoEnum.SURFACE);
        ExtraInfoField wayCategory = getExtraInfoField(extras, ExtraInfoEnum.WAY_CATEGORY);
        ExtraInfoField wayType = getExtraInfoField(extras, ExtraInfoEnum.WAY_TYPE);
        ExtraInfoField tollWays = getExtraInfoField(extras, ExtraInfoEnum.TOLL_WAYS);
        ExtraInfoField trailDifficulty = getExtraInfoField(extras, ExtraInfoEnum.TRAIL_DIFFICULTY);
        ExtraInfoField roadAccessRestrictions = getExtraInfoField(extras, ExtraInfoEnum.ROAD_ACCESS_RESTRICTIONS);
        ExtraInfoField countryInfo = getExtraInfoField(extras, ExtraInfoEnum.COUNTRY_INFO);
        ExtraInfoField avgSpeed = getExtraInfoField(extras, ExtraInfoEnum.AVERAGE_SPEED);
        return new DirectionsExtraInfo(steepness, suitability, surface, wayCategory, wayType, tollWays, trailDifficulty,
                roadAccessRestrictions, avgSpeed, countryInfo);
    }

    private ExtraInfoField getExtraInfoField(JSONObject obj, ExtraInfoEnum key) throws JSONException {
        String keyValue = key == ExtraInfoEnum.WAY_TYPE ? "waytypes" : key.toString();
        if(!obj.has(keyValue))
            return null;
        JSONObject field = obj.getJSONObject(keyValue);
        List<ExtraInfoValues> valuesList = getExtraInfoValuesList(field);
        List<ExtraInfoSummary> summaryList = getExtraInfoSummaryList(field);
        return new ExtraInfoField(valuesList, summaryList);
    }

    private List<ExtraInfoValues> getExtraInfoValuesList(JSONObject obj) throws JSONException {
        JSONArray valuesJSONArray = obj.getJSONArray("values");
        List<ExtraInfoValues> valuesList = new ArrayList<>();
        for (int i = 0; i < valuesJSONArray.length(); i++) {
            JSONArray valueJSONArray = valuesJSONArray.getJSONArray(i);
            ExtraInfoValues values = getExtraInfoValues(valueJSONArray);
            valuesList.add(values);
        }
        return valuesList;
    }

    private ExtraInfoValues getExtraInfoValues(JSONArray array) throws JSONException {
        int start = array.getInt(0);
        int end = array.getInt(1);
        double value = array.getDouble(2);
        return new ExtraInfoValues(start, end, value);
    }

    private List<ExtraInfoSummary> getExtraInfoSummaryList(JSONObject obj) throws JSONException {
        JSONArray summaryJSONArray = obj.getJSONArray("summary");
        List<ExtraInfoSummary> summaryList = new ArrayList<>();
        for (int i = 0; i < summaryJSONArray.length(); i++) {
            JSONObject summaryJSON = summaryJSONArray.getJSONObject(i);
            ExtraInfoSummary summary = getExtraInfoSummary(summaryJSON);
            summaryList.add(summary);
        }
        return summaryList;
    }

    private ExtraInfoSummary getExtraInfoSummary(JSONObject obj) throws JSONException {
        double value = obj.getDouble("value");
        double distance = obj.getDouble("distance");
        double amount = obj.getDouble("amount");
        return new ExtraInfoSummary(value, distance, amount);
    }

    private BoundingBox getBoundingBox(JSONObject obj) throws JSONException {
        JSONArray bboxArray = obj.getJSONArray("bbox");
        return new BoundingBox(
                bboxArray.getDouble(1),
                bboxArray.getDouble(3),
                bboxArray.getDouble(0),
                bboxArray.getDouble(2)
        );
    }

    private RequestOptions getRequestOptions(JSONObject obj) throws JSONException {
        JSONObject query = obj.getJSONObject("query");
        String profileStr = query.getString("profile");
        EnumProfile profile = EnumProfile.getByStr(profileStr);
        String preferenceStr = query.getString("preference");
        PreferenceEnum preference = PreferenceEnum.getByStr(preferenceStr);
        List<Coordinate> coordinates = getCoordinates(query);
        String languageStr = query.getString("language");
        LanguageEnum language = LanguageEnum.getByStr(languageStr);
        String unitsStr = query.getString("units");
        UnitsEnum units = UnitsEnum.getByStr(unitsStr);
        boolean geometry = query.getBoolean("geometry");
        if(!geometry)
            return new RequestOptions(profile, preference, coordinates, language, units, false, null,
                    null, false, false);
        String geometryFormatStr = query.getString("geometry_format");
        EnumDirectionsGeomType geometryFormat = EnumDirectionsGeomType.getByStr(geometryFormatStr);
        boolean instructions = query.getBoolean("instructions");
        boolean elevation = query.getBoolean("elevation");
        if(!instructions)
            return new RequestOptions(profile, preference, coordinates, language, units, true, geometryFormat,
                    null, false, elevation);
        String instructionsFormatStr = query.getString("instructions_format");
        InstructionsFormatEnum instructionsFormat = InstructionsFormatEnum.getByStr(instructionsFormatStr);
        return new RequestOptions(profile, preference, coordinates, language, units, true, geometryFormat,
                instructionsFormat, true, elevation);
    }

    private List<Coordinate> getCoordinates(JSONObject query) throws JSONException {
        JSONArray coordsArray = query.getJSONArray("coordinates");
        return getCoordListFromJSONArray(coordsArray);
    }

}
