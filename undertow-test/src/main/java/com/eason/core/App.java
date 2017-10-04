package com.eason.core;

import io.undertow.Undertow;
import io.undertow.server.HttpHandler;
import io.undertow.server.HttpServerExchange;
import io.undertow.util.Headers;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Undertow server = Undertow.builder().addHttpListener(8080, "localhost")
                .setHandler(new HttpHandler() {
                    public void handleRequest(final HttpServerExchange httpServerExchange) throws Exception {
                        httpServerExchange.getResponseHeaders().put(Headers.CONTENT_TYPE, "text/plain");
                        httpServerExchange.getResponseSender().send("hello world");
                    }

                }).build();
        server.start();
        System.out.println( "Hello World!" );
    }
}
