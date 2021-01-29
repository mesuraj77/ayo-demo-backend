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
        double fahrenheitValue = 55.2;
        ResponseEntity<Double> response = new ResponseEntity<>(Precision.round((fahrenheitValue - 32) / 1.8, 2), HttpStatus.OK);
        assertEquals(response, temperatureService.convertFahrenheitToCelsius(fahrenheitValue));
    }

    @Test
    public  void when_callingConvertToMetricWithNullValue_expect_appropriateErrorStatusAndNoValueResponse() {
        ResponseEntity<Double> response = new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        assertEquals(response, temperatureService.convertFahrenheitToCelsius(null));
    }

    @Test
    public  void when_callingForAResponseEntity_expect_successfulConversionToFahrenheitInResponseEntity() {
        double celsiusValue = 5.2;
        ResponseEntity<Double> response = new ResponseEntity<>(Precision.round((celsiusValue * 1.8) + 32, 2), HttpStatus.OK);
        assertEquals(response, temperatureService.convertCelsiusToFahrenheit(celsiusValue));
    }

    @Test
    public  void when_callingConvertToImperialWithNullValue_expect_appropriateErrorStatusAndNoValueResponse() {
        ResponseEntity<Double> response = new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        assertEquals(response, temperatureService.convertCelsiusToFahrenheit(null));
    }

    @Test
    public  void when_degreesInFahrenheitSpecified_expectConversionToCelsius() {
        // conversion is (value - 32) / 1.8 then rounded up to two decimal places
        assertEquals(9.5, temperatureService.convertToMetric(49.1));
    }

    @Test
    public  void when_degreesInCelsiusSpecified_expectConversionToFahrenheit() {
        // conversion is (value x 1.8) + 32 then rounded up to two decimal places
        assertEquals(72.5, temperatureService.convertToImperial(22.5));
    }
}
