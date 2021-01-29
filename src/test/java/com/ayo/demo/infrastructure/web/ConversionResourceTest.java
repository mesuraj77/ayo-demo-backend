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
        assertEquals(HttpStatus.OK.value(), responseEntity.getStatusCodeValue());
        assertNotNull(responseEntity.getBody());
        assertEquals(celsiusValue, responseEntity.getBody());
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
        assertEquals(HttpStatus.OK.value(), responseEntity.getStatusCodeValue());
        assertNotNull(responseEntity.getBody());
        assertEquals(fahrenheitValue, responseEntity.getBody());
    }


    @Test
    public void givenAnAcreValueToConvert_whenExecuted_thenResponseContainsValueAndCorrectCode() throws IOException {
        double acreValue = 55.2;
        double hectareValue = 22.34;
        HttpEntity<String> entity = new HttpEntity<>(null, httpHeaders);
        ResponseEntity<Double> responseEntity = testRestTemplate.exchange(createUrlWithPort("/area/to-metric/" + acreValue),
                HttpMethod.GET,
                entity,
                Double.class);

        assertNotNull(responseEntity);
        assertEquals(HttpStatus.OK.value(), responseEntity.getStatusCodeValue());
        assertNotNull(responseEntity.getBody());
        assertEquals(hectareValue, responseEntity.getBody());
    }

    @Test
    public void givenAHectareValueToConvert_whenExecuted_thenResponseContainsValueAndCorrectCode() throws IOException {
        double hectareValue = 55.2;
        double acreValue = 136.40;
        HttpEntity<String> entity = new HttpEntity<>(null, httpHeaders);
        ResponseEntity<Double> responseEntity = testRestTemplate.exchange(createUrlWithPort("/area/to-imperial/" + hectareValue),
                HttpMethod.GET,
                entity,
                Double.class);

        assertNotNull(responseEntity);
        assertEquals(HttpStatus.OK.value(), responseEntity.getStatusCodeValue());
        assertNotNull(responseEntity.getBody());
        assertEquals(acreValue, responseEntity.getBody());
    }

    @Test
    public void givenAMileValueToConvert_whenExecuted_thenResponseContainsValueAndCorrectCode() throws IOException {
        double mileValue = 55.2;
        double kilometerValue = 88.82;
        HttpEntity<String> entity = new HttpEntity<>(null, httpHeaders);
        ResponseEntity<Double> responseEntity = testRestTemplate.exchange(createUrlWithPort("/length/to-metric/" + mileValue),
                HttpMethod.GET,
                entity,
                Double.class);

        assertNotNull(responseEntity);
        assertEquals(HttpStatus.OK.value(), responseEntity.getStatusCodeValue());
        assertNotNull(responseEntity.getBody());
        assertEquals(kilometerValue, responseEntity.getBody());
    }

    @Test
    public void givenKilometerValueToConvert_whenExecuted_thenResponseContainsValueAndCorrectCode() throws IOException {
        double mileValue = 61.78;
        double kilometerValue = 99.40;
        HttpEntity<String> entity = new HttpEntity<>(null, httpHeaders);
        ResponseEntity<Double> responseEntity = testRestTemplate.exchange(createUrlWithPort("/length/to-imperial/" + kilometerValue),
                HttpMethod.GET,
                entity,
                Double.class);

        assertNotNull(responseEntity);
        assertEquals(HttpStatus.OK.value(), responseEntity.getStatusCodeValue());
        assertNotNull(responseEntity.getBody());
        assertEquals(mileValue, responseEntity.getBody());
    }

    private String createUrlWithPort(final String uri) {
        return "http://localhost:" + port + "/convert" + uri;
    }
}
