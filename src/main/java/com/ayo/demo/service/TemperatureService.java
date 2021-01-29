package com.ayo.demo.service;

import com.ayo.demo.service.convertor.Convertor;
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
     * @param fahrenheitValue a temperature in Imperial unit (Fahrenheit)
     * @return a Metric unit (Celsius) equivalent value rounded to two decimal places
     *
     */
    @Override
    public double convertToMetric(final double fahrenheitValue) {
        return Precision.round((fahrenheitValue - 32) / 1.8, 2);
    }

    /**
     * This function is used to convert temperature from Metric (Celsius)
     * into Imperial (Fahrenheit)
     *
     * @param celsiusValue a temperature in Metric unit (Celsius)
     * @return an Imperial unit (Fahrenheit) equivalent value rounded to two decimal places
     *
     */
    @Override
    public double convertToImperial(final double celsiusValue) {
        return Precision.round((celsiusValue * 1.8) + 32, 2);
    }
}
