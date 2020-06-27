package com.github.marcoshsc.orsApiTools.json.deserializers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.github.marcoshsc.orsApiTools.geocode.helperclasses.BoundingBox;

import java.io.IOException;

public class GeneralBoundingBoxDeserializer extends StdDeserializer<BoundingBox> {

    public GeneralBoundingBoxDeserializer() {
        this(null);
    }

    protected GeneralBoundingBoxDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public BoundingBox deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
            throws IOException {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        if(node.isEmpty()) return null;
        return new BoundingBox(
                node.get(1).asDouble(),
                node.get(3).asDouble(),
                node.get(0).asDouble(),
                node.get(2).asDouble()
        );
    }
}
