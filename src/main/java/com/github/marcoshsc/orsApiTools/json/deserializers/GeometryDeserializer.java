package com.github.marcoshsc.orsApiTools.json.deserializers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import org.wololo.geojson.GeoJSONFactory;
import org.wololo.geojson.Geometry;
import org.wololo.jts2geojson.GeoJSONReader;
import org.wololo.jts2geojson.GeoJSONWriter;

import java.io.IOException;

public class GeometryDeserializer extends StdDeserializer<Geometry> {

    public GeometryDeserializer() {
        this(null);
    }

    protected GeometryDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public Geometry deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
            throws IOException, JsonProcessingException {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        return new GeoJSONWriter().write(new GeoJSONReader().read(GeoJSONFactory.create(node.toString())));
    }
}
