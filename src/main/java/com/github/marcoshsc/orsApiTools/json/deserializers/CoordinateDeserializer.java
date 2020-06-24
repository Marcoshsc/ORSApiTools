package com.github.marcoshsc.orsApiTools.json.deserializers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import org.locationtech.jts.geom.Coordinate;

import java.io.IOException;

public class CoordinateDeserializer extends StdDeserializer<Coordinate> {

    public CoordinateDeserializer() {
        this(null);
    }

    protected CoordinateDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public Coordinate deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        return new Coordinate(node.get(0).asDouble(), node.get(1).asDouble());
    }
}
