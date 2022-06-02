package com.chylee.demo.filter;

import org.springframework.http.client.SimpleClientHttpRequestFactory;

import java.io.IOException;
import java.net.HttpURLConnection;

public class NoRedirectSimpleClientHttpRequestFactory extends SimpleClientHttpRequestFactory {
    protected void prepareConnection(HttpURLConnection connection, String httpMethod) throws IOException {
        super.prepareConnection(connection, httpMethod);
        connection.setInstanceFollowRedirects(false);
    }
}
