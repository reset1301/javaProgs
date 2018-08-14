package com.roma.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

public class ClientSync {
    public static final String BASE_URI = "http://localhost:8080/myapp/";

    Client client;
    WebTarget target;

    public static void main(String[] args) {
        ClientSync clientSync = new ClientSync();
        clientSync.client = ClientBuilder.newClient();
        clientSync.target = clientSync.client.target(BASE_URI);
        String responseMsg = clientSync.target.path("/sync/check/1").request().get(String.class);
        System.out.println(responseMsg);
    }
}
