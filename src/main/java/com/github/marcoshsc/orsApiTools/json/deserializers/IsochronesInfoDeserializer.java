package com.github.marcoshsc.orsApiTools.json.deserializers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.github.marcoshsc.orsApiTools.isochrones.helperclasses.Info;

import java.io.IOException;

public class IsochronesInfoDeserializer extends StdDeserializer<Info> {

    public IsochronesInfoDeserializer() {
        this(null);
    }

    protected IsochronesInfoDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public Info deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        return new ObjectMapper().readValue(node.get("query").toString(), Info.class);
    }
}
