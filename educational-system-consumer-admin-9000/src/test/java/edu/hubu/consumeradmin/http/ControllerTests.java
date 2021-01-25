package edu.hubu.consumeradmin.http;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * @author moonlan
 * date 2021/1/25 下午4:18
 */
@SuppressWarnings(value = "unused")
@SpringBootTest
public class ControllerTests {
    
    private static final String uriPrefix = "http://localhost:9000";

    @Test
    public void testTest() throws IOException, InterruptedException {
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(uriPrefix + "/test"))
                .POST(HttpRequest.BodyPublishers.ofString("")).build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(httpRequest, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
    }

}
