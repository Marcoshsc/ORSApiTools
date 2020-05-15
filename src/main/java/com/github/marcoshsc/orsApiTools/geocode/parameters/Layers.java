package com.github.marcoshsc.orsApiTools.geocode.parameters;

import com.github.marcoshsc.orsApiTools.general.enums.ORSEnum;
import com.github.marcoshsc.orsApiTools.geocode.enums.GeocodeLayers;
import com.github.marcoshsc.orsApiTools.interfaces.QueryParameter;
import com.github.marcoshsc.orsApiTools.utils.UtilityFunctions;

import java.util.List;

/**
 * Restrict search to layers (place type). By default all layers are searched.
 *
 * @author Marcos Henrique in 27-04-2020
 */
public class Layers implements QueryParameter<List<GeocodeLayers>> {

    private final String name = ORSEnum.LAYERS_PARAM.toString();
    private List<GeocodeLayers> value;

    public Layers(List<GeocodeLayers> value) {
        this.value = value;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getValue() {
        return UtilityFunctions.groupAllByComma(value);
    }

    @Override
    public List<GeocodeLayers> getTypedValue() {
        return value;
    }
}
