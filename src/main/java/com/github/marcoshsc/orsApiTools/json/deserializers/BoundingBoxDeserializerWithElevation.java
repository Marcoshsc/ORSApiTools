package com.github.marcoshsc.orsApiTools.json.deserializers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.github.marcoshsc.orsApiTools.directions.v2.helperclasses.BoundingBoxWithElevation;

import java.io.IOException;

public class BoundingBoxDeserializerWithElevation extends StdDeserializer<BoundingBoxWithElevation> {

    public BoundingBoxDeserializerWithElevation() {
        this(null);
    }

    protected BoundingBoxDeserializerWithElevation(Class<?> vc) {
        super(vc);
    }

    @Override
    public BoundingBoxWithElevation deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
            throws IOException, JsonProcessingException {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        return node.size() == 6 ?
                new BoundingBoxWithElevation(node.get(0).asDouble(), node.get(1).asDouble(), node.get(2).asDouble(),
                        node.get(3).asDouble(), node.get(4).asDouble(), node.get(5).asDouble()) :
                new BoundingBoxWithElevation(node.get(0).asDouble(), node.get(1).asDouble(), null,
                        node.get(2).asDouble(), node.get(3).asDouble(), null);
    }

}
