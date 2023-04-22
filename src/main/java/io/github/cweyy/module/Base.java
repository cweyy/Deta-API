package io.github.cweyy.module;

import com.google.gson.*;
import io.github.cweyy.Deta;
import io.github.cweyy.http.Request;

import java.io.IOException;

public class Base {

    private Deta deta;
    private String baseName;

    private Request request;

    public Base(Deta deta, String baseName) {
        this.deta = deta;
        this.baseName = baseName;
        this.request = new Request(deta);
    }

    public Deta getDeta() {
        return deta;
    }

    public JsonObject put(JsonObject data) {
        String endpoint = this.deta.getProjectId() + "/" + this.baseName + "/items";
        JsonObject payload = new JsonObject();
        JsonArray items = new JsonArray();
        items.add(data);
        payload.add("items", items);

        try {
            return request.httpPut(endpoint, payload).get("processed").getAsJsonObject().get("items").getAsJsonArray().get(0).getAsJsonObject();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public JsonObject update(JsonObject updates, String key) {
        String endpoint = this.deta.getProjectId() + "/" + this.baseName + "/items/" + key;

        try {
            return request.httpPatch(endpoint, updates);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public JsonObject query(JsonArray query, Integer limit, String lastKey) {
        String endpoint = this.deta.getProjectId() + "/" + this.baseName + "/query";

        JsonObject payload = new JsonObject();
        payload.add("query", query);
        if(limit != null){
            payload.addProperty("limit", limit);
        }
        if(lastKey != null){
            payload.addProperty("last", lastKey);
        }
        try {
            return request.httpPost(endpoint, payload);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public JsonObject query(JsonArray query) {
        return query(query, null, null);
    }

    public JsonObject query(JsonArray query, String lastKey) {
        return query(query, null, lastKey);
    }

    public JsonObject query(JsonArray query, Integer limit) {
        return query(query, limit, null);
    }


    public JsonArray putMany(JsonArray data) {
        String endpoint = this.deta.getProjectId() + "/" + this.baseName + "/items";
        JsonObject payload = new JsonObject();
        payload.add("items", data);

        try {
            return request.httpPut(endpoint, payload).get("processed").getAsJsonObject().get("items").getAsJsonArray();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public JsonObject get(String key) {
        String endpoint = this.deta.getProjectId() + "/" + this.baseName + "/items/" + key;

        try {
            return request.httpGet(endpoint);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public JsonObject delete(String key) {
        String endpoint = this.deta.getProjectId() + "/" + this.baseName + "/items/" + key;

        try {
            return request.httpDelete(endpoint);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public JsonObject insert(JsonObject data) {
        String endpoint = this.deta.getProjectId() + "/" + this.baseName + "/items";
        JsonObject payload = new JsonObject();
        payload.add("item", data);

        try {
            return request.httpPost(endpoint, payload);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
