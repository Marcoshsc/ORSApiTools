# ORSApiTools
Java library that provides implementation of Open Route Service endpoints.

## Updates

Newer version 2.0 now includes Isochrones and Matrix V2 endpoint support, and a complete refactor was made in the code, in order to use jackson
as the JSON parser library.

Version 1.1 fixed bugs in the matrix endpoint.

## Information

Library created by Marcos Henrique (Marcoshsc)<br>
Currently on version 2.2.0

## Description
This library provides implementations of the following endpoints:
- Directions
- Matrix
- Isochrones
- Geocode Search
- Optimization
- Pois

There is also a feature that allows a matrix request to be made with any number of
coordinates, which is not supported natively by the Open Route Service API.

New endpoints are gonna be implemented in later versions of the library.
If you wanna contribute and implement one yourself, feel free to open an
issue and discuss what and how you gonna do it.

More information about the endpoints can be found at
https://openrouteservice.org/dev/#/api-docs/

## Contributing
Pull requests are welcome. For major changes, please open an issue first to
discuss what you would like to change.
If you want to build a new endpoint implementation, also open an issue to
discuss what is going to be done.

## Importing
Add the following dependency to your pom.xml (Latest version):

    <!-- https://mvnrepository.com/artifact/com.github.marcoshsc/orsApiTools -->
    <dependency>
        <groupId>com.github.marcoshsc</groupId>
        <artifactId>orsApiTools</artifactId>
        <version>2.2.0</version>
    </dependency>

    
After that, everything is working. Enjoy!
    
## Usage examples

You can either pass an api key as the parameter or set a "ors.key" file in the 
project with the api key inside of it, and use ApiKeyGetter to get the value.
You will find some sample usages as listed below. See javadocs for better understanding.
    
### Directions

    DirectionsV2Request req = ORSEndpoints.getDirectionsV2(ApiKeyGetter.getApiKey());
    req.getParameters().setProfile(new Profile(EnumProfile.DRIVING_CAR));
    req.getParameters().setCoordinates(new Coordinates(Arrays.asList(
            new Coordinate(-43.5876127,-19.6845878),
            new Coordinate(-43.5840602,-19.6416472)
    )));
    req.getParameters().setAttributes(new Attributes(Arrays.asList(AttributesEnum.values())));
    req.getParameters().setElevation(new Elevation(true));
    req.getParameters().setManeuvers(new Maneuvers(true));
    req.getParameters().setInstructionsFormat(new InstructionsFormat(InstructionsFormatEnum.HTML));
    req.getParameters().setExtraInfo(new ExtraInfo(Collections.singletonList(ExtraInfoEnum.SURFACE)));

    DirectionsV2Response res = req.makeRequest();
    
### Matrix

    MatrixV2Request req = ORSEndpoints.getMatrixV2(ApiKeyGetter.getApiKey());
    req.getParameters().setProfile(new Profile(EnumProfile.FOOT_WALKING));
    req.getParameters().setLocations(new Locations(Arrays.asList(
            new Coordinate(-47.050871,-17.841496),
            new Coordinate(-47.044044,-17.636455),
            new Coordinate(-47.100653,-17.795555),
            new Coordinate(-47.030208,-17.81385),
            new Coordinate(-47.214168,-17.733528)
    )));
    req.getParameters().setMetrics(new Metrics(Collections.singletonList(EnumMetrics.DISTANCE)));
    req.getParameters().setResolveLocations(new ResolveLocations(true));
    MatrixV2Response res = req.makeRequest();
    
### Isochrones

    IsochronesRequest req = ORSEndpoints.getIsochrones(ApiKeyGetter.getApiKey());
    IsochronesParameters parameters = req.getParameters();
    parameters.setProfile(new Profile(EnumProfile.DRIVING_HGV));
    parameters.setLocations(new Locations(Arrays.asList(new Coordinate(8.681495,
            49.41461), new Coordinate(8.686507,49.41943))));
    parameters.setRangeType(new RangeType(EnumRangeType.DISTANCE));
    parameters.setRange(new Range(Arrays.asList(100.2, 200.0)));
    parameters.setSmoothing(new Smoothing(13));
    IsochronesResponse response = req.makeRequest();
    
### Geocode Search

    String key = ApiKeyGetter.getApiKey();
    GeocodeSearchRequest request = ORSEndpoints.getGeocodeSearch(key);
    request.getParameters().setText(new Text("Avenida Getúlio Vargas, JM"));
    GeocodeSearchResponse response = request.makeRequest();
    
### Optimization

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
    OptimizationResponse res = req.makeRequest();
    
### Pois

    PoisRequest req = ORSEndpoints.getPois(ApiKeyGetter.getApiKey());
    req.getParameters().setRequest(new PoisParameterRequest(PoisRequestEnum.POIS));
    req.getParameters().setGeometry(new PoisGeometry(new BoundingBox(53.0756,
            53.0456,
            8.8034,
            8.7834
    ), new GeoJSON(new Coordinate(8.8034,
            53.0756)), 500));
    req.getParameters().setLimit(new Limit(12));
    req.getParameters().setSortBy(new SortBy(SortByEnum.DISTANCE));
    PoisResponse res = req.makeRequest();
