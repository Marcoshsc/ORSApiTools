package com.github.marcoshsc.orsApiTools.json.deserializers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.github.marcoshsc.orsApiTools.directions.helperclasses.StepWayPoints;

import java.io.IOException;

public class StepWayPointsDeserializer extends StdDeserializer<StepWayPoints> {

    public StepWayPointsDeserializer() {
        this(null);
    }

    protected StepWayPointsDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public StepWayPoints deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        return new StepWayPoints(node.get(0).asInt(), node.get(1).asInt());
    }
}
