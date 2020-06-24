package com.github.marcoshsc.orsApiTools.json.serializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.util.List;

public class IntegerListSerializer extends StdSerializer<List<Integer>> {

    public IntegerListSerializer() {
        this(null);
    }

    protected IntegerListSerializer(Class<List<Integer>> t) {
        super(t);
    }

    @Override
    public void serialize(List<Integer> integers, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartArray();
        for (Integer i : integers) {
            jsonGenerator.writeNumber(i);
        }
        jsonGenerator.writeEndArray();
    }
}
