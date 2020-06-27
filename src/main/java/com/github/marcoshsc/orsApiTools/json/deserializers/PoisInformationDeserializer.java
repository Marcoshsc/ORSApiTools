package com.github.marcoshsc.orsApiTools.json.deserializers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.github.marcoshsc.orsApiTools.pois.helperclasses.PoisResponseOptions;

import java.io.IOException;

public class PoisInformationDeserializer extends StdDeserializer<PoisResponseOptions> {

    public PoisInformationDeserializer() {
        this(null);
    }

    protected PoisInformationDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public PoisResponseOptions deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
            throws IOException {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        return new ObjectMapper().readValue(node.get("query").toString(), PoisResponseOptions.class);
    }
}
