package com.github.marcoshsc.orsApiTools.json.deserializers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.github.marcoshsc.orsApiTools.directions.helperclasses.extrainfo.ExtraInfoValues;

import java.io.IOException;

public class ExtraInfoValuesDeserializer extends StdDeserializer<ExtraInfoValues> {

    public ExtraInfoValuesDeserializer() {
        this(null);
    }

    protected ExtraInfoValuesDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public ExtraInfoValues deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        return new ExtraInfoValues(node.get(0).asInt(), node.get(1).asInt(), node.get(2).asInt());
    }
}
