package com.ayo.demo.service;

import org.apache.commons.math3.util.Precision;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

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
    public  void when_degreesInFahrenheitSpecified_expectConversionToCelsius() {
        assertEquals(Precision.round((55.2 - 32) / 1.8, 2), temperatureService.convertToMetric(55.2));
    }

    @Test
    public  void when_degreesInCelsiusSpecified_expectConversionToFahrenheit() {
        assertEquals(Precision.round((5.2 * 1.8) + 32, 2), temperatureService.convertToImperial(5.2));
    }
}
