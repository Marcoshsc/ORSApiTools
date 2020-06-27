package com.github.marcoshsc.orsApiTools.json.deserializers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.github.marcoshsc.orsApiTools.pois.helperclasses.PoisCategory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class PoisCategoryListDeserializer extends StdDeserializer<List<PoisCategory>> {

    public PoisCategoryListDeserializer() {
        this(null);
    }

    protected PoisCategoryListDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public List<PoisCategory> deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
            throws IOException {
        List<PoisCategory> categoryList = new ArrayList<>();
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        Iterator<Map.Entry<String, JsonNode>> fields = node.fields();
        while(fields.hasNext()) {
            Map.Entry<String, JsonNode> entry = fields.next();
            JsonNode entryNode = entry.getValue();
            String id = entry.getKey();
            String name = entryNode.get("category_name").asText();
            String group = entryNode.get("category_group").asText();
            categoryList.add(new PoisCategory(id, name, group));
        }
        return categoryList;
    }
}
