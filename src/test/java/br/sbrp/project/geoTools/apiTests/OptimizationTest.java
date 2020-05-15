package br.sbrp.project.geoTools.apiTests;

import com.github.marcoshsc.orsApiTools.directions.enums.EnumProfile;
import com.github.marcoshsc.orsApiTools.general.ORSEndpoints;
import com.github.marcoshsc.orsApiTools.general.exceptions.RequestException;
import com.github.marcoshsc.orsApiTools.optimization.OptimizationRequest;
import com.github.marcoshsc.orsApiTools.optimization.helperclasses.*;
import com.github.marcoshsc.orsApiTools.optimization.parameters.Jobs;
import com.github.marcoshsc.orsApiTools.optimization.parameters.Shipments;
import com.github.marcoshsc.orsApiTools.optimization.parameters.Vehicles;
import org.junit.Test;
import org.locationtech.jts.geom.Coordinate;
import util.ApiKeyGetter;

import java.io.IOException;
import java.util.Arrays;

public class OptimizationTest {

    @Test
    public void simpleTest() throws RequestException, IOException {
        OptimizationRequest req = ORSEndpoints.getOptimization(ApiKeyGetter.getApiKey());
        req.getParameters().setVehicles(new Vehicles(Arrays.asList(
                new Vehicle(
                        1,
                        EnumProfile.DRIVING_HGV,
                        new Coordinate(2.35044,
                                48.71764),
                        null,
                        new Coordinate(2.35044,
                                48.71764),
                        null,
                        Arrays.asList(4),
                        Arrays.asList(1, 14),
                        new TimeWindow(28800, 43200),
                        Arrays.asList(
                                new Break(1, Arrays.asList(new TimeWindow(32400, 34200)), 0)
                        )
                ),
                new Vehicle(
                        2,
                        EnumProfile.DRIVING_HGV,
                        new Coordinate(2.35044,
                                48.71764),
                        null,
                        new Coordinate(2.35044,
                                48.71764),
                        null,
                        Arrays.asList(4),
                        Arrays.asList(2,14),
                        new TimeWindow(28800, 43200),
                        Arrays.asList(new Break(2, Arrays.asList(new TimeWindow(34200, 36000)), 300))
                )
        )));
        req.getParameters().setJobs(new Jobs(Arrays.asList(
                new Job(
                        1,
                        new Coordinate(1.98935,
                                48.701),
                        null,
                        300,
                        Arrays.asList(1),
                        null,
                        Arrays.asList(1),
                        null,
                        Arrays.asList(new TimeWindow(32400, 36000))
                ),
                new Job(
                        2,
                        new Coordinate(2.03655,
                                48.61128),
                        null,
                        300,
                        null,
                        Arrays.asList(1),
                        Arrays.asList(1),
                        null,
                        null
                ),
                new Job(
                        5,
                        new Coordinate(2.28325,
                                48.5958),
                        null,
                        300,
                        Arrays.asList(1),
                        null,
                        Arrays.asList(14),
                        null,
                        null
                ),
                new Job(
                        6,
                        new Coordinate(2.89357,
                                48.90736),
                        null,
                        300,
                        Arrays.asList(1),
                        null,
                        Arrays.asList(14),
                        null,
                        null
                )
        )));
        req.getParameters().setShipments(new Shipments(Arrays.asList(
                new Shipment(
                        new ShipmentStep(
                                4,
                                new Coordinate(2.41808,
                                        49.22619),
                                null,
                                300,
                                null
                        ),
                        new ShipmentStep(
                                3,
                                new Coordinate(2.39719,
                                        49.07611),
                                null,
                                300,
                                null
                        ),
                        Arrays.asList(1),
                        Arrays.asList(2),
                        null
                )
        )));
        System.out.println(req.makeRequest());
    }
}
