package com.github.marcoshsc.orsApiTools.pois.helperclasses;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.github.marcoshsc.orsApiTools.pois.PoisResponse;

import java.io.IOException;

public class PoisResponseConverter extends StdDeserializer<PoisResponse> {

    public PoisResponseConverter() {
        this(null);
    }

    protected PoisResponseConverter(Class<?> vc) {
        super(vc);
    }

    @Override
    public PoisResponse deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        JsonNode jsonNode = p.getCodec().readTree(p);
        ObjectMapper mapper = new ObjectMapper();
        JsonNode obj = jsonNode.get(0);
        return mapper.readValue(obj.toString(), PoisResponse.class);
    }
}
