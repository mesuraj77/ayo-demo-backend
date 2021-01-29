package com.ayo.demo.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.math3.util.Precision;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TemperatureService implements Convertor {

    /**
     * This function is used to convert temperature from Imperial (Fahrenheit)
     * into Metric (Celsius)
     *
     * @param fahrenheitValue a temperature in Imperial unit (Fahrenheit)
     * @return a Metric unit (Celsius) equivalent value rounded to two decimal places
     *
     */
    public ResponseEntity<Double> convertFahrenheitToCelsius(final Double fahrenheitValue) {
        Double celsiusValue;
        HttpStatus status;

        if (fahrenheitValue != null) {
            celsiusValue = this.convertToMetric(fahrenheitValue);
            status = HttpStatus.OK;
        } else {
            celsiusValue = null;
            status = HttpStatus.BAD_REQUEST;
        }

        return new ResponseEntity<>(celsiusValue, status);

    }


    /**
     * This function is used to convert temperature from Metric (Celsius)
     * into Imperial (Fahrenheit)
     *
     * @param celsiusValue a temperature in Metric unit (Celsius)
     * @return an Imperial unit (Fahrenheit) equivalent value rounded to two decimal places
     *
     */
    public ResponseEntity<Double> convertCelsiusToFahrenheit(final Double celsiusValue) {
        Double fahrenheitValue;
        HttpStatus status;

        if (celsiusValue != null) {
            fahrenheitValue = this.convertToImperial(celsiusValue);
            status = HttpStatus.OK;
        } else {
            fahrenheitValue = null;
            status = HttpStatus.BAD_REQUEST;
        }

        return new ResponseEntity<>(fahrenheitValue, status);
    }

    @Override
    public double convertToMetric(final double fromValue) {
        return Precision.round((fromValue - 32) / 1.8, 2);
    }

    @Override
    public double convertToImperial(final double fromValue) {
        return Precision.round((fromValue * 1.8) + 32, 2);
    }
}
