package com.ayo.demo.infrastructure.web;

import org.apache.commons.math3.util.Precision;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ConversionResourceTest {

    private final TestRestTemplate testRestTemplate = new TestRestTemplate();
    private final HttpHeaders httpHeaders = new HttpHeaders();

    @LocalServerPort
    private int port;


    @Test
    public void givenACelsiusValueToConvert_whenExecuted_thenResponseContainsValueAndCorrectCode() throws IOException {
        double value = 55.2;
        HttpEntity<String> entity = new HttpEntity<>(null, httpHeaders);
        ResponseEntity<Double> responseEntity = testRestTemplate.exchange(createUrlWithPort("/temperature/fahrenheit/" + value + "/to/celsius"),
                HttpMethod.GET,
                entity,
                Double.class);

        assertNotNull(responseEntity);
        assertEquals(responseEntity.getStatusCodeValue(), HttpStatus.OK.value());
        assertNotNull(responseEntity.getBody());
        assertEquals(responseEntity.getBody(), Precision.round((value - 32) / 1.8, 2));
    }

    @Test
    public void givenAFahrenheitValueToConvert_whenExecuted_thenResponseContainsValueAndCorrectCode() throws IOException {
        double value = 55.2;
        HttpEntity<String> entity = new HttpEntity<>(null, httpHeaders);
        ResponseEntity<Double> responseEntity = testRestTemplate.exchange(createUrlWithPort("/temperature/celsius/" + value + "/to/fahrenheit"),
                HttpMethod.GET,
                entity,
                Double.class);

        assertNotNull(responseEntity);
        assertEquals(responseEntity.getStatusCodeValue(), HttpStatus.OK.value());
        assertNotNull(responseEntity.getBody());
        assertEquals(responseEntity.getBody(), Precision.round((value * 1.8) + 32, 2));
    }

    private String createUrlWithPort(final String uri) {
        return "http://localhost:" + port + "/convert" + uri;
    }
}
