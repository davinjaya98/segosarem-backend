package com.paparadaminteractive.artic.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.json.simple.JSONObject;

public class HttpRestHandler {

	private final Logger logger = Logger.getLogger(this.getClass());

	public String requestGet(String url, Map<String, String> header) {
		logger.info(url);
		//Request the client
		HttpClient client = httpClientBuilder();

		//Create the post object
		HttpGet get = new HttpGet(url);

		StringBuffer result = new StringBuffer();

		try {
			if (header != null) {
				for (Map.Entry<String, String> entrySet : header.entrySet()) {
					String key = entrySet.getKey();
					String value = entrySet.getValue();

					get.addHeader(key, value);
				}
			}
			//Execute the request and get the response
			HttpResponse response = client.execute(get);
			BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

			logger.info("Request status: " + response.getStatusLine().getStatusCode() + " " + response.getStatusLine().getReasonPhrase());
			String line = "";
			while ((line = rd.readLine()) != null) {
				result.append(line);
			}

			if (result.toString().isEmpty()) {
				result.append("{\"status\":\"" + response.getStatusLine().getStatusCode() + "\"}");
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return result.toString();
	}

	public String requestPost(String url, List<NameValuePair> parameter, Map<String, String> header) {
		logger.info(url);
		if (parameter != null) {
			String paramLog = "Parameters: ";
			for (NameValuePair pair : parameter) {
				paramLog += pair.getName() + "=" + pair.getValue() + " ";
			}
			logger.info(paramLog);
		}
		//Request the client
		HttpClient client = httpClientBuilder();

		//Create the post object
		HttpPost post = new HttpPost(url);

		StringBuffer result = new StringBuffer();

		try {

			if (header != null) {
				for (Map.Entry<String, String> entrySet : header.entrySet()) {
					String key = entrySet.getKey();
					String value = entrySet.getValue();

					post.addHeader(key, value);
				}
			}

			//Set the parameter to the post request
			post.setEntity(new UrlEncodedFormEntity(parameter));

			//Execute the request and get the response
			HttpResponse response = client.execute(post);
			BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

			logger.info("Request status: " + response.getStatusLine().getStatusCode() + " " + response.getStatusLine().getReasonPhrase());
			String line = "";
			while ((line = rd.readLine()) != null) {
				result.append(line);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return result.toString();

	}

	public String requestPostJSON(String url, JSONObject json, Map<String, String> header) {
		logger.info(url);
		if (json != null) {
			logger.info(json.toString());
		}
		//Request the client
		HttpClient client = httpClientBuilder();

		//Create the post object
		HttpPost post = new HttpPost(url);

		StringBuffer result = new StringBuffer();

		try {

			if (header != null) {
				for (Map.Entry<String, String> entrySet : header.entrySet()) {
					String key = entrySet.getKey();
					String value = entrySet.getValue();

					post.addHeader(key, value);
				}
			}

			//Set the parameter to the post request
			StringEntity parameter = new StringEntity(json.toString(), ContentType.APPLICATION_JSON);
			post.setEntity(parameter);

			//Execute the request and get the response
			HttpResponse response = client.execute(post);
			BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

			logger.info("Request status: " + response.getStatusLine().getStatusCode() + " " + response.getStatusLine().getReasonPhrase());
			String line = "";
			while ((line = rd.readLine()) != null) {
				result.append(line);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return result.toString();

	}

	public String requestPut(String url, JSONObject json, Map<String, String> header) {
		logger.info(url);
		if (json != null) {
			logger.info(json.toString());
		}
		//Request the client
		HttpClient client = httpClientBuilder();

		//Create the put object
		HttpPut put = new HttpPut(url);

		StringBuffer result = new StringBuffer();

		try {
			if (header != null) {
				for (Map.Entry<String, String> entrySet : header.entrySet()) {
					String key = entrySet.getKey();
					String value = entrySet.getValue();

					put.addHeader(key, value);
				}
			}

			if (json != null) {
				//Set the parameter to the put request
				StringEntity parameter = new StringEntity(json.toString(), ContentType.APPLICATION_JSON);
				put.setEntity(parameter);
			}

			//Execute the request and get the response
			HttpResponse response = client.execute(put);
			BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

			logger.info("Request status: " + response.getStatusLine().getStatusCode() + " " + response.getStatusLine().getReasonPhrase());
			String line = "";
			while ((line = rd.readLine()) != null) {
				result.append(line);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return result.toString();

	}

	protected HttpClient httpClientBuilder() {
		//Create the client
		HttpClient client = new DefaultHttpClient();

		return client;
	}
}