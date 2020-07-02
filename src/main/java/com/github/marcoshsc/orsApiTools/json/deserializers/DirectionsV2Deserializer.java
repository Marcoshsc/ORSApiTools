package com.github.marcoshsc.orsApiTools.json.deserializers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.github.marcoshsc.orsApiTools.directions.helperclasses.RequestOptions;
import com.github.marcoshsc.orsApiTools.directions.v2.DirectionsV2Response;
import com.github.marcoshsc.orsApiTools.utils.UtilityFunctions;
import org.locationtech.jts.geom.Coordinate;

import java.io.IOException;
import java.util.List;

public class DirectionsV2Deserializer extends StdDeserializer<DirectionsV2Response> {

    private boolean elevation;

    public DirectionsV2Deserializer(boolean elevation) {
        this(null);
        this.elevation = elevation;
    }

    protected DirectionsV2Deserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public DirectionsV2Response deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
            throws IOException, JsonProcessingException {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        JsonNode route = node.get("routes").get(0);
        ObjectMapper mapper = new ObjectMapper();
        DirectionsV2Response response = mapper.readValue(route.toString(), DirectionsV2Response.class);
        List<Coordinate> geometry = UtilityFunctions.decodeGeometry(route.get("geometry").asText(), elevation);
        response.setGeometry(geometry);
        RequestOptions options = mapper.readValue(node.get("metadata").get("query").toString(), RequestOptions.class);
        response.setOptions(options);
        return response;
    }
}
