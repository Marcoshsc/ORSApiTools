package com.github.marcoshsc.orsApiTools.json.deserializers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.locationtech.jts.geom.Coordinate;

import java.io.IOException;
import java.util.List;

public class DirectionsGeometryDeserializer extends StdDeserializer<List<Coordinate>> {

    public DirectionsGeometryDeserializer() {
        this(null);
    }

    protected DirectionsGeometryDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public List<Coordinate> deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        ObjectMapper mapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.addDeserializer(List.class, new CoordinateListDeserializer());
        mapper.registerModule(module);
        TypeReference<List<Coordinate>> typeReference = new TypeReference<List<Coordinate>>() {};
        return node.has("type") ?
                mapper.readValue(node.get("coordinates").toString(), typeReference) :
                mapper.readValue(node.toString(), typeReference);
    }
}
