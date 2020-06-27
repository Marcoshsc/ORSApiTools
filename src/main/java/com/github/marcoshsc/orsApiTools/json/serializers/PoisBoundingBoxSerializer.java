package com.github.marcoshsc.orsApiTools.json.serializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.github.marcoshsc.orsApiTools.geocode.helperclasses.BoundingBox;

import java.io.IOException;

public class PoisBoundingBoxSerializer extends StdSerializer<BoundingBox> {

    public PoisBoundingBoxSerializer() {
        this(null);
    }

    protected PoisBoundingBoxSerializer(Class<BoundingBox> t) {
        super(t);
    }

    @Override
    public void serialize(BoundingBox boundingBox, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartArray();

        jsonGenerator.writeStartArray();
        jsonGenerator.writeNumber(boundingBox.getMinLongitude());
        jsonGenerator.writeNumber(boundingBox.getMinLatitude());
        jsonGenerator.writeEndArray();

        jsonGenerator.writeStartArray();
        jsonGenerator.writeNumber(boundingBox.getMaxLongitude());
        jsonGenerator.writeNumber(boundingBox.getMaxLatitude());
        jsonGenerator.writeEndArray();

        jsonGenerator.writeEndArray();
    }
}
