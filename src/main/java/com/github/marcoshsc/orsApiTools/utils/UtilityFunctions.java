package com.github.marcoshsc.orsApiTools.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.marcoshsc.orsApiTools.general.exceptions.RequestException;
import com.github.marcoshsc.orsApiTools.utils.interfaces.StatusCodeHandlerStrategy;
import org.apache.http.*;
import org.apache.http.client.HttpClient;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.locationtech.jts.geom.Coordinate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public interface UtilityFunctions {

    static HttpResponse postHttpRequest(String URL, String json, Map<String, String> headers) throws IOException {
        HttpRequestRetryHandler retryHandler = getHttpRequestRetryHandler();
        CloseableHttpClient httpClient = HttpClients.custom()
                .setRetryHandler(retryHandler)
                .addInterceptorLast((HttpResponseInterceptor) (response, context) -> {
                    int status = response.getStatusLine().getStatusCode();
                    if (status > 200) {
                        try {
                            handleOSMStatusCode(response);
                        } catch (RequestException exception) {
                            throw new IOException(exception.getMessage());
                        }
                        throw new IOException("Status code " + status + " Found.");
                    }
                })
                .build();
        HttpPost httpPost = new HttpPost(URL);
        for (String key : headers.keySet())
            httpPost.setHeader(key, headers.get(key));
        httpPost.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));
        return httpClient.execute(httpPost);
    }

    static HttpRequestRetryHandler getHttpRequestRetryHandler() {
        return (e, retryTimes, httpContext) -> {
                try {
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
                return retryTimes < 10;
            };
    }

    static void handleOSMStatusCode(HttpResponse response) throws RequestException {
        int statusCode = response.getStatusLine().getStatusCode();
        try {
            if (statusCode >= 400) {
                if(statusCode == 503) throw new RequestException("ERROR 503: The server is currently unavailable " +
                        "due to overload or maintenance.");
                ObjectMapper mapper = new ObjectMapper();
                JsonNode node = mapper.readValue(EntityUtils.toString(response.getEntity()), JsonNode.class);
                if (node.has("error")) {
                    JsonNode errorNode = node.get("error");
                    if(errorNode.has("message")) {
                        String message = String.format("%s Error code: %d.", errorNode.get("message").asText(),
                                errorNode.get("code").asInt());
                        throw new RequestException(message);
                    }
                    throw new RequestException(errorNode.asText());
                }
                throw new RequestException("Response returned status code " + statusCode + ".");
            }
        } catch(IOException exc) {
            throw new RequestException("Error with the request. Log: " + exc.getMessage());
        }
    }

    static JSONArray getJSONArrayFromCoordinateList(List<Coordinate> coordinateList) {
        JSONArray jsonArray = new JSONArray();
        for (Coordinate coordinate : coordinateList)
            jsonArray.put(getCoordinateJSONArray(coordinate));
        return jsonArray;
    }

    static boolean isOutInterval(int value, int start, int end) {
        return value < start || value > end;
    }

    static JSONArray getIntegerJSONArray(List<Integer> list) {
        JSONArray array = new JSONArray();
        for(int s : list)
            array.put(s);
        return array;
    }

    static JSONArray getCoordinateJSONArray(Coordinate coordinate) throws JSONException {
        JSONArray array = new JSONArray();
        array.put(coordinate.getX());
        array.put(coordinate.getY());
        return array;
    }

    static String groupAllByComma(List<?> values) {
        StringBuilder sb = new StringBuilder();
        int i;
        for (i = 0; i < values.size() - 1; i++) {
            sb.append(values.get(i).toString());
            sb.append(",");
        }
        sb.append(values.get(i).toString());
        return sb.toString();
    }

    static String groupByPipe(List<?> list) {
        StringBuilder sb = new StringBuilder();
        int i;
        for(i = 0; i < list.size() - 1; i++) {
            sb.append(list.get(i).toString());
            sb.append("|");
        }
        sb.append(list.get(i).toString());
        return sb.toString();
    }

    static String groupCoordinateListORSStyle(List<Coordinate> list) {
        StringBuilder sb = new StringBuilder();
        int i;
        for (i = 0; i < list.size() - 1; i++) {
            sb.append(list.get(i).getX());
            sb.append(",");
            sb.append(list.get(i).getY());
            sb.append("|");

        }
        sb.append(list.get(i).getX());
        sb.append(",");
        sb.append(list.get(i).getY());
        return sb.toString();
    }

    static List<Integer> getIntegerList(int start, int end) {
        List<Integer> list = new ArrayList<>();
        for (int i = start; i < end; i++) {
            list.add(i);
        }
        return list;
    }

    static JSONObject makeHTTPRequest(String URL, Map<String, String> headers, StatusCodeHandlerStrategy handler)
            throws RequestException {
        try {
            HttpRequestRetryHandler retryHandler = getHttpRequestRetryHandler();
            CloseableHttpClient httpClient = HttpClients.custom()
                .setRetryHandler(retryHandler)
                .addInterceptorLast((HttpResponseInterceptor) (response, context) -> {
                    int status = response.getStatusLine().getStatusCode();
                    if (status > 200) {
                        try {
                            handleOSMStatusCode(response);
                        } catch (RequestException exception) {
                            throw new IOException(exception.getMessage());
                        }
                        throw new IOException("Status code " + status + " Found.");
                    }
                })
                .build();
            HttpGet v_Request = new HttpGet(URL);
            for(String key : headers.keySet()) {
                v_Request.addHeader(key, headers.get(key));
            }
            return handleRequest(handler, httpClient.execute(v_Request));
        } catch(IOException | JSONException exc) {
            throw new RequestException(exc.getMessage());
        }
    }

    static JSONObject handleRequest (HttpResponse response, Integer statusCode) throws JSONException, IOException {
        BufferedReader m_Rd = new BufferedReader(
                new InputStreamReader(response.getEntity().getContent()));
        StringBuilder m_Result = new StringBuilder();
        String m_Line = "";
        while ((m_Line = m_Rd.readLine()) != null) {
            m_Result.append(m_Line);
        }
        if(statusCode == null)
            return new JSONObject(m_Result.toString());
        JSONObject obj = new JSONObject(m_Result.toString());
        obj.put("statusCodeToHandle", statusCode.intValue());
        return obj;
    }

    static JSONObject handleRequest(StatusCodeHandlerStrategy handler, HttpResponse response)
            throws IOException, RequestException, JSONException {
        int statusCode = response.getStatusLine().getStatusCode();
        if(handler == null) {
            UtilityFunctions.handleOSMStatusCode(response);
            if (statusCode >= 400)
                throw new RequestException(String.format("Response returned status code %d. ", statusCode));
        }
        else
            handler.verifyStatusCode(statusCode);
        return handleRequest(response, null);
    }

    static List<Coordinate> decodeGeometry(String encodedGeometry, boolean inclElevation) {
        List<Coordinate> geometry = new ArrayList<>();
        int len = encodedGeometry.length();
        int index = 0;
        int lat = 0;
        int lng = 0;
        int ele = 0;

        while (index < len) {
            int result = 1;
            int shift = 0;
            int b;
            do {
                b = encodedGeometry.charAt(index++) - 63 - 1;
                result += b << shift;
                shift += 5;
            } while (b >= 0x1f);
            lat += (result & 1) != 0 ? ~(result >> 1) : (result >> 1);

            result = 1;
            shift = 0;
            do {
                b = encodedGeometry.charAt(index++) - 63 - 1;
                result += b << shift;
                shift += 5;
            } while (b >= 0x1f);
            lng += (result & 1) != 0 ? ~(result >> 1) : (result >> 1);


            if(inclElevation) {
                result = 1;
                shift = 0;
                do {
                    b = encodedGeometry.charAt(index++) - 63 - 1;
                    result += b << shift;
                    shift += 5;
                } while (b >= 0x1f);
                ele += (result & 1) != 0 ? ~(result >> 1) : (result >> 1);
            }

            Coordinate coordinate = new Coordinate();
            try {
                coordinate.setY((lat / 1E5));
                coordinate.setX((lng / 1E5));
                if(inclElevation){
                    coordinate.setZ(((float) (ele / 100)));
                }
                geometry.add(coordinate);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return geometry;
    }

}
