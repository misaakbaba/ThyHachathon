package com.example.melkor.app;

public class ApiUtils {

    private ApiUtils() {}

    public static final String BASE_URL = "http://46.101.135.184/";

    public static CrewPostInterface getAPIService() {

        return ApiClient.getClient(BASE_URL).create(CrewPostInterface.class);
    }
}
