package de.johannj.deta;

public class Deta {
    private String baseUrl;
    private String projectKey;
    private String projectId;



    public Deta(String projectKey) {
        this.projectKey = projectKey;
        this.projectId = projectKey.split("_")[0];
        this.baseUrl = "https://database.deta.sh/v1/";
    }



    public String getProjectKey() {
        return this.projectKey;
    }

    public String getBaseUrl() {
        return this.baseUrl;
    }

    public String getProjectId() {
        return this.projectId;
    }


}
