package com.github.marcoshsc.orsApiTools.json.serializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.github.marcoshsc.orsApiTools.optimization.helperclasses.TimeWindow;

import java.io.IOException;

public class TimeWindowSerializer extends StdSerializer<TimeWindow> {

    public TimeWindowSerializer() {
        this(null);
    }

    protected TimeWindowSerializer(Class<TimeWindow> t) {
        super(t);
    }

    @Override
    public void serialize(TimeWindow timeWindow, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
            throws IOException {
        jsonGenerator.writeStartArray();
        jsonGenerator.writeNumber(timeWindow.getStart());
        jsonGenerator.writeNumber(timeWindow.getEnd());
        jsonGenerator.writeEndArray();
    }

}
