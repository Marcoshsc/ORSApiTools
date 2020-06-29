package com.github.marcoshsc.orsApiTools.json.serializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.util.List;

public class RangeSerializer extends StdSerializer<List<Double>> {

    public RangeSerializer() {
        this(null);
    }

    protected RangeSerializer(Class<List<Double>> t) {
        super(t);
    }

    @Override
    public void serialize(List<Double> range, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartArray();
        for (Double i : range)
            jsonGenerator.writeNumber(i);
        jsonGenerator.writeEndArray();
    }
}
