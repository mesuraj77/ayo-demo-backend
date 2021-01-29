package com.ayo.demo.service;

import org.apache.commons.math3.util.Precision;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class TemperatureServiceTest {

    @InjectMocks
    private TemperatureService temperatureService;

    @BeforeAll
    static void setup() {
        MockitoAnnotations.openMocks(TemperatureServiceTest.class);
    }

    @Test
    public  void when_callingForAResponseEntity_expect_successfulConversionToCelsiusInResponseEntity() {
        ResponseEntity<Double> response = new ResponseEntity<>(Precision.round((55.2 - 32) / 1.8, 2), HttpStatus.OK);
        assertEquals(response, temperatureService.convertImperialToMetric(55.2));
    }

    @Test
    public  void when_callingConvertToMetricWithNullValue_expect_appropriateErrorStatusAndNoValueResponse() {
        ResponseEntity<Double> response = new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        assertEquals(response, temperatureService.convertImperialToMetric(null));
    }

    @Test
    public  void when_callingForAResponseEntity_expect_successfulConversionToFahrenheitInResponseEntity() {
        ResponseEntity<Double> response = new ResponseEntity<>(Precision.round((5.2 * 1.8) + 32, 2), HttpStatus.OK);
        assertEquals(response, temperatureService.convertMetricToImperial(5.2));
    }

    @Test
    public  void when_callingConvertToImperialWithNullValue_expect_appropriateErrorStatusAndNoValueResponse() {
        ResponseEntity<Double> response = new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        assertEquals(response, temperatureService.convertMetricToImperial(null));
    }

    @Test
    public  void when_degreesInFahrenheitSpecified_expectConversionToCelsius() {
        assertEquals(Precision.round((49.1 - 32) / 1.8, 2), temperatureService.convertToMetric(49.1));
    }

    @Test
    public  void when_degreesInCelsiusSpecified_expectConversionToFahrenheit() {
        assertEquals(Precision.round((22.5 * 1.8) + 32, 2), temperatureService.convertToImperial(22.5));
    }
}
