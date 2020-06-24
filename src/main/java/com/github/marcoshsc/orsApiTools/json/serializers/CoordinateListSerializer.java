package com.github.marcoshsc.orsApiTools.json.serializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.github.marcoshsc.orsApiTools.isochrones.parameters.Locations;
import org.locationtech.jts.geom.Coordinate;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class CoordinateListSerializer extends StdSerializer<List<Coordinate>> {

    public CoordinateListSerializer() {
        this(null);
    }

    protected CoordinateListSerializer(Class<List<Coordinate>> t) {
        super(t);
    }

    @Override
    public void serialize(List<Coordinate> coordinateList, JsonGenerator jsonGenerator,
                          SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartArray();
        for (Coordinate coordinate : coordinateList) {
            jsonGenerator.writeStartArray();
            jsonGenerator.writeNumber(coordinate.x);
            jsonGenerator.writeNumber(coordinate.y);
            jsonGenerator.writeEndArray();
        }
        jsonGenerator.writeEndArray();
    }

    public static void main(String[] args) throws JsonProcessingException {
        List<Coordinate> coordinates = Arrays.asList(
                new Coordinate(1, 2),
                new Coordinate(2, 3),
                new Coordinate(6, 3)
        );
        Locations locations = new Locations(coordinates);
        System.out.println(new ObjectMapper().writeValueAsString(locations));
    }
}
