package com.ayo.demo.infrastructure.web;

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
        double fahrenheitValue = 55.2;
        double celsiusValue = 12.89;
        HttpEntity<String> entity = new HttpEntity<>(null, httpHeaders);
        ResponseEntity<Double> responseEntity = testRestTemplate.exchange(createUrlWithPort("/temperature/to-metric/" + fahrenheitValue),
                HttpMethod.GET,
                entity,
                Double.class);

        assertNotNull(responseEntity);
        assertEquals(responseEntity.getStatusCodeValue(), HttpStatus.OK.value());
        assertNotNull(responseEntity.getBody());
        assertEquals(responseEntity.getBody(), celsiusValue);
    }

    @Test
    public void givenAFahrenheitValueToConvert_whenExecuted_thenResponseContainsValueAndCorrectCode() throws IOException {
        double celsiusValue = 55.2;
        double fahrenheitValue = 131.36;
        HttpEntity<String> entity = new HttpEntity<>(null, httpHeaders);
        ResponseEntity<Double> responseEntity = testRestTemplate.exchange(createUrlWithPort("/temperature/to-imperial/" + celsiusValue),
                HttpMethod.GET,
                entity,
                Double.class);

        assertNotNull(responseEntity);
        assertEquals(responseEntity.getStatusCodeValue(), HttpStatus.OK.value());
        assertNotNull(responseEntity.getBody());
        assertEquals(responseEntity.getBody(), fahrenheitValue);
    }

    private String createUrlWithPort(final String uri) {
        return "http://localhost:" + port + "/convert" + uri;
    }
}
