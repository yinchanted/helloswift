package com.swift.apiplayground.apitest;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import org.junit.Test;
import java.io.IOException;
import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;

public class HelloSwiftTest {

    private static String BASE_URI = "http://localhost:8090/helloswift";
    private OkHttpClient client = new OkHttpClient();

    @Test
    public void getMessage() throws IOException
    {
        Request request = new Request.Builder().url(BASE_URI).build();
        Response response = client.newCall(request).execute();
        assertEquals(response.code(), 200);
        assertEquals(response.message(), "OK");
        assertThat(response.body().string(), containsString("Hello, you reached me at"));
    }
}
