package com.github.marcoshsc.orsApiTools.json.deserializers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.github.marcoshsc.orsApiTools.directions.DirectionsResponse;
import com.github.marcoshsc.orsApiTools.directions.helperclasses.RequestOptions;

import java.io.IOException;

public class DirectionsResponseDeserializer extends StdDeserializer<DirectionsResponse> {

    public DirectionsResponseDeserializer() {
        this(null);
    }

    protected DirectionsResponseDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public DirectionsResponse deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        DirectionsResponse response = new ObjectMapper().readValue(node.get("routes").get(0).toString(), DirectionsResponse.class);
        ObjectMapper mapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.addDeserializer(RequestOptions.class, new DirectionsRequestOptionsDeserializer());
        mapper.registerModule(module);
        RequestOptions options = mapper.readValue(node.get("info").toString(), RequestOptions.class);
        response.setOptions(options);
        return response;
    }
}
