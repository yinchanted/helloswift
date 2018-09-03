package com.swift.apiplayground.api;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.Path;
import org.json.simple.JSONObject;

@Path("/")
public class HelloSwift {

    @GET
    @Produces("application/json")
    public Response getSwiftMessage() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        String msg = "Hello, you reached me at " + dateFormat.format(date);
        JSONObject json = new JSONObject();
        json.put("Message", msg);
        String jsonText = json.toString();
        return Response.ok(jsonText, MediaType.APPLICATION_JSON).build();
    }
}