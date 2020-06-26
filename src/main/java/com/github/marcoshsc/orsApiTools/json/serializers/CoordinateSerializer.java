package com.github.marcoshsc.orsApiTools.json.serializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import org.locationtech.jts.geom.Coordinate;

import java.io.IOException;

public class CoordinateSerializer extends StdSerializer<Coordinate> {

    public CoordinateSerializer() {
        this(null);
    }

    protected CoordinateSerializer(Class<Coordinate> t) {
        super(t);
    }

    @Override
    public void serialize(Coordinate coordinate, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
            throws IOException {
        jsonGenerator.writeStartArray();
        jsonGenerator.writeNumber(coordinate.x);
        jsonGenerator.writeNumber(coordinate.y);
        jsonGenerator.writeEndArray();
    }
}
