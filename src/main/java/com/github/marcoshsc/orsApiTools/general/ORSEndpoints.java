package com.github.marcoshsc.orsApiTools.general;

import com.github.marcoshsc.orsApiTools.directions.ORSDirectionsRequest;
import com.github.marcoshsc.orsApiTools.geocode.GeocodeSearchRequest;
import com.github.marcoshsc.orsApiTools.isochrones.IsochronesRequest;
import com.github.marcoshsc.orsApiTools.matrix.ORSMatrixRequest;
import com.github.marcoshsc.orsApiTools.optimization.OptimizationRequest;
import com.github.marcoshsc.orsApiTools.pois.PoisRequest;

/**
 * Aggregate all the possible requests, to ease the user utilization. Works as a factory. New endpoints should generate
 * more methods here, for returning them.
 *
 * @author Marcos Henrique
 */
public interface ORSEndpoints {

    static ORSMatrixRequest getMatrix(String apiKey) {
        return new ORSMatrixRequest(apiKey);
    }

    static ORSDirectionsRequest getDirections(String apiKey) {
        return new ORSDirectionsRequest(apiKey);
    }

    static GeocodeSearchRequest getGeocodeSearch(String apiKey) {
        return new GeocodeSearchRequest(apiKey);
    }

    static PoisRequest getPois(String apiKey) {
        return new PoisRequest(apiKey);
    }

    static OptimizationRequest getOptimization(String apiKey) {
        return new OptimizationRequest(apiKey);
    }

    static IsochronesRequest getIsochrones(String apiKey) { return new IsochronesRequest(apiKey); }

}
