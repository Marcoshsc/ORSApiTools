package com.github.marcoshsc.orsApiTools.json.deserializers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import org.locationtech.jts.geom.Coordinate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CoordinateListDeserializer extends StdDeserializer<List<Coordinate>> {

    public CoordinateListDeserializer() {
        this(null);
    }

    protected CoordinateListDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public List<Coordinate> deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        List<Coordinate> coordinates = new ArrayList<>();
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        for (int i = 0; i < node.size(); i++) {
            JsonNode innerNode = node.get(i);
            if(innerNode.size() == 3)
                coordinates.add(new Coordinate(innerNode.get(0).asDouble(), innerNode.get(1).asDouble(),
                        innerNode.get(2).asDouble()));
            else
                coordinates.add(new Coordinate(innerNode.get(0).asDouble(), innerNode.get(1).asDouble()));
        }
        return coordinates;
    }
}
