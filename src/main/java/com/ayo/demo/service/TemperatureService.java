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
     * @param imperialValue a temperature in Imperial unit (Fahrenheit)
     * @return a Metric unit (Celsius) equivalent value rounded to two decimal places
     *
     */
    public ResponseEntity<Double> convertImperialToMetric(final Double imperialValue) {
        Double metricValue;
        HttpStatus status;

        if (imperialValue != null) {
            metricValue = this.convertToMetric(imperialValue);
            status = HttpStatus.OK;
        } else {
            metricValue = null;
            status = HttpStatus.BAD_REQUEST;
        }

        return new ResponseEntity<>(metricValue, status);

    }


    /**
     * This function is used to convert temperature from Metric (Celsius)
     * into Imperial (Fahrenheit)
     *
     * @param metricValue a temperature in Metric unit (Celsius)
     * @return an Imperial unit (Fahrenheit) equivalent value rounded to two decimal places
     *
     */
    public ResponseEntity<Double> convertMetricToImperial(final Double metricValue) {
        Double imperialValue;
        HttpStatus status;

        if (metricValue != null) {
            imperialValue = this.convertToImperial(metricValue);
            status = HttpStatus.OK;
        } else {
            imperialValue = null;
            status = HttpStatus.BAD_REQUEST;
        }

        return new ResponseEntity<>(imperialValue, status);
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
