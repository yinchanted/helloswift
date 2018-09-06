package com.swift.apiplayground.apitest;

import org.junit.Assert;
import org.junit.Test;

import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;

public class HelloSwiftTest {

    private static String BASE_URI = "http://localhost:8090/helloswift";
    private Client client = ClientBuilder.newClient();

    @Test
    public void getSwiftMessage() {
        WebTarget webTarget = client.target(BASE_URI).path("/");
        Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
        String response = invocationBuilder.get(String.class);
        Assert.assertNotNull(response);
        client.close();
    }
}
