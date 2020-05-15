package com.github.marcoshsc.orsApiTools.geocode.parameters;

import com.github.marcoshsc.orsApiTools.general.enums.ORSEnum;
import com.github.marcoshsc.orsApiTools.geocode.enums.GeocodeSources;
import com.github.marcoshsc.orsApiTools.interfaces.QueryParameter;
import com.github.marcoshsc.orsApiTools.utils.UtilityFunctions;

import java.util.List;

/**
 * Restrict your search to specific sources. Searches all sources by default.
 * You can either use the normal or short name. Sources are described at
 * br.sbrp.project.orsApiTools.geocode.enums.GeocodeSources.
 *
 * @author Marcos Henrique in 27-04-2020
 */
public class Sources implements QueryParameter<List<GeocodeSources>> {

    private final String name = ORSEnum.SOURCES_GEOCODE_PARAM.toString();
    private List<GeocodeSources> value;

    public Sources(List<GeocodeSources> value) {
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
    public List<GeocodeSources> getTypedValue() {
        return value;
    }
}
