package com.ayo.demo.service;

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
public class AreaServiceTest {

    @InjectMocks
    private AreaService areaService;

    @BeforeAll
    static void setup() {
        MockitoAnnotations.openMocks(AreaServiceTest.class);
    }

    @Test
    public void when_callingForAnAcreResponseEntity_expect_successfulConversionToImperialInResponseEntity() {
        ResponseEntity<Double> response = new ResponseEntity<>(136.40, HttpStatus.OK);
        assertEquals(response, areaService.convertHectareToAcre(55.2));
    }

    @Test
    public void when_callingForAnHectareResponseEntity_expect_successfulConversionToMetricInResponseEntity() {
        ResponseEntity<Double> response = new ResponseEntity<>(22.34, HttpStatus.OK);
        assertEquals(response, areaService.convertAcreToHectare(55.2));
    }

    @Test
    public void when_convertingHectareToAcre_expect_success() {
        // conversion is multiply by 2.47105
        assertEquals(areaService.convertToImperial(5.9), 14.58);
    }

    @Test
    public void when_convertingAcreToHectare_expect_success() {
        // conversion is divide by 2.47105
        assertEquals(areaService.convertToMetric(29.7), 12.02);
    }
}
