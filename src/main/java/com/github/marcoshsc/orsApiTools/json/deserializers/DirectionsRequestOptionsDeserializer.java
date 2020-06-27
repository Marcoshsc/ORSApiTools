package com.github.marcoshsc.orsApiTools.json.deserializers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.github.marcoshsc.orsApiTools.directions.helperclasses.RequestOptions;

import java.io.IOException;

public class DirectionsRequestOptionsDeserializer extends StdDeserializer<RequestOptions> {

    public DirectionsRequestOptionsDeserializer() {
        this(null);
    }

    protected DirectionsRequestOptionsDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public RequestOptions deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
            throws IOException, JsonProcessingException {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        return new ObjectMapper().readValue(node.get("query").toString(), RequestOptions.class);
    }
}
