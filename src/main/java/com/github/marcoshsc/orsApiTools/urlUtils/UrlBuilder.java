package com.github.marcoshsc.orsApiTools.urlUtils;

import com.github.marcoshsc.orsApiTools.interfaces.ParameterList;
import com.github.marcoshsc.orsApiTools.interfaces.QueryParameter;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class UrlBuilder {
	
	private String url;
	
	private String baseUrl;
	
	private final Map<String, String> queryParams = new HashMap<>();
	
	private final ArrayList<String> pathParams = new ArrayList<>();
	
	public UrlBuilder() {}
	
	public UrlBuilder(String baseUrl) {
		this.baseUrl = baseUrl;
	}
	
	public String build() throws UnsupportedEncodingException {
		if(baseUrl == null)
			return null;
		StringBuilder sb = new StringBuilder(baseUrl);
		for(String param: pathParams) {
			sb.append("/");
			sb.append(param);
		}
		boolean alreadyHasQueryParams = false;
		if(!queryParams.isEmpty())
			sb.append("?");
		for(Map.Entry<String, String> entry : queryParams.entrySet()) {
			if(!alreadyHasQueryParams)
				alreadyHasQueryParams = true;
			else
				sb.append("&");
			sb.append(entry.getKey());
			sb.append("=");
			sb.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
		}
		url = sb.toString();
		return url;
	}
	
	public void addQueryParam(String param, String value) {
		if(param == null || value == null) 
			return;
		queryParams.put(param, value);
	}
	
	public void addQueryParam(QueryParameter<?> parameter) {
		if(parameter == null)
			return;
		queryParams.put(parameter.getName(), parameter.getValue());
	}
	
	public void addQueryParam(Enum<?> param, Enum<?> value) {
		if(param == null || value == null) 
			return;
		queryParams.put(param.toString(), value.toString());
	}
	
	public void addQueryParam(Enum<?> param, String value) {
		if(param == null || value == null) 
			return;
		queryParams.put(param.toString(), value);
	}
	
	public void addQueryParam(ParameterList parameters) {
		if(parameters == null)
			return;
		for(QueryParameter<?> qp: parameters.getUsedParameters()) {
			addQueryParam(qp);
		}
	}
	
	public void addPathParam(String param) {
		if(param == null)
			return;
		pathParams.add(param);
	}
	
	public void addPathParam(Enum<?> param) {
		if(param == null)
			return;
		pathParams.add(param.toString());
	}
	
	public void addBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}
	
	public void addBaseUrl(Enum<?> baseUrl) {
		this.baseUrl = baseUrl.toString();
	}
	
	public String getUrl() {
		return url;
	}
	
}
