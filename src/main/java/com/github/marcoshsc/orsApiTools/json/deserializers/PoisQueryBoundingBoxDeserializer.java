package com.github.marcoshsc.orsApiTools.json.deserializers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.github.marcoshsc.orsApiTools.geocode.helperclasses.BoundingBox;

import java.io.IOException;

public class PoisQueryBoundingBoxDeserializer extends StdDeserializer<BoundingBox> {

    public PoisQueryBoundingBoxDeserializer() {
        this(null);
    }

    protected PoisQueryBoundingBoxDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public BoundingBox deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
            throws IOException {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        JsonNode firstSet = node.get(0), secondSet = node.get(1);
        return new BoundingBox(
                firstSet.get(1).asDouble(),
                secondSet.get(1).asDouble(),
                firstSet.get(0).asDouble(),
                secondSet.get(0).asDouble()
        );
    }
}
