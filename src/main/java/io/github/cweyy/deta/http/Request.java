package io.github.cweyy.deta.http;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.github.cweyy.deta.Deta;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.*;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class Request {


    private Deta deta;


    public Request(Deta deta){
        this.deta = deta;
    }
    public JsonObject httpPut(String endpoint, JsonObject payload) throws IOException {
        String url = this.deta.getBaseUrl() + endpoint;
        String requestBody = new Gson().toJson(payload);
        HttpPut request = new HttpPut(url);
        request.addHeader("X-Api-Key", this.deta.getProjectKey());
        request.addHeader("Content-Type", "application/json");
        request.setEntity(new StringEntity(requestBody));
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        CloseableHttpResponse response = null;
        response = httpClient.execute(request);
        HttpEntity entity = response.getEntity();
        String responseString = null;
        responseString = EntityUtils.toString(entity);
        return new JsonParser().parse(responseString).getAsJsonObject();
    }

    public JsonObject httpPost(String endpoint, JsonObject payload) throws IOException {
        String url = this.deta.getBaseUrl() + endpoint;
        String requestBody = new Gson().toJson(payload);
        HttpPost request = new HttpPost(url);
        request.addHeader("X-Api-Key", this.deta.getProjectKey());
        request.addHeader("Content-Type", "application/json");
        request.setEntity(new StringEntity(requestBody));
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        CloseableHttpResponse response = null;
        response = httpClient.execute(request);
        HttpEntity entity = response.getEntity();
        String responseString = null;
        responseString = EntityUtils.toString(entity);
        return new JsonParser().parse(responseString).getAsJsonObject();
    }

    public JsonObject httpPatch(String endpoint, JsonObject payload) throws IOException {
        String url = this.deta.getBaseUrl() + endpoint;
        String requestBody = new Gson().toJson(payload);
        HttpPatch request = new HttpPatch(url);
        request.addHeader("X-Api-Key", this.deta.getProjectKey());
        request.addHeader("Content-Type", "application/json");
        request.setEntity(new StringEntity(requestBody));
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        CloseableHttpResponse response = null;
        response = httpClient.execute(request);
        HttpEntity entity = response.getEntity();
        String responseString = null;
        responseString = EntityUtils.toString(entity);
        return new JsonParser().parse(responseString).getAsJsonObject();
    }

    public JsonObject httpGet(String endpoint) throws IOException {
        String url = this.deta.getBaseUrl() + endpoint;
        HttpGet request = new HttpGet(url);
        request.addHeader("X-Api-Key", this.deta.getProjectKey());
        request.addHeader("Content-Type", "application/json");
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        CloseableHttpResponse response = null;
        response = httpClient.execute(request);
        HttpEntity entity = response.getEntity();
        String responseString = null;
        responseString = EntityUtils.toString(entity);
        return new JsonParser().parse(responseString).getAsJsonObject();
    }

    public JsonObject httpDelete(String endpoint) throws IOException {
        String url = this.deta.getBaseUrl() + endpoint;
        HttpDelete request = new HttpDelete(url);
        request.addHeader("X-Api-Key", this.deta.getProjectKey());
        request.addHeader("Content-Type", "application/json");
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        CloseableHttpResponse response = null;
        response = httpClient.execute(request);
        HttpEntity entity = response.getEntity();
        String responseString = null;
        responseString = EntityUtils.toString(entity);
        return new JsonParser().parse(responseString).getAsJsonObject();
    }


}
