package com.ayo.demo.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.math3.util.Precision;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TemperatureService implements Convertor {

    /**
     * This function is used to convert temperature from Imperial (Fahrenheit)
     * into Metric (Celsius)
     *
     * @param fromValue a temperature in Imperial unit (Fahrenheit)
     * @return a Metric unit (Celsius) equivalent value rounded to two decimal places
     *
     */
    @Override
    public double convertToMetric(final double fromValue) {
        return Precision.round((fromValue - 32) / 1.8, 2);

    }


    /**
     * This function is used to convert temperature from Metric (Celsius)
     * into Imperial (Fahrenheit)
     *
     * @param fromValue a temperature in Metric unit (Celsius)
     * @return an Imperial unit (Fahrenheit) equivalent value rounded to two decimal places
     *
     */
    @Override
    public double convertToImperial(final double fromValue) {
        return Precision.round((fromValue * 1.8) + 32, 2);
    }
}
