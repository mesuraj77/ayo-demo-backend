package com.ayo.demo.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.math3.util.Precision;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AreaService implements Convertor {

    /**
     * This function is used to convert area from Imperial (Acre)
     * into Metric (Hectare)
     *
     * @param acreValue an are in Imperial unit (Acre)
     * @return an Imperial unit (Hectare) equivalent value rounded to two decimal places
     *
     */
    public ResponseEntity<Double> convertAcreToHectare(final Double acreValue) {
        return null;
    }

    /**
     * This function is used to convert area from Metric (Hectare)
     * into Imperial (Acre)
     *
     * @param hectareValue an are in Metric unit (Hectare)
     * @return an Imperial unit (Acre) equivalent value rounded to two decimal places
     *
     */
    public ResponseEntity<Double> convertHectareToAcre(final Double hectareValue) {
        return null;
    }

    @Override
    public double convertToMetric(final double fromValue) {
        return Precision.round(fromValue / 2.471, 2);
    }

    @Override
    public double convertToImperial(final double fromValue) {
        return Precision.round(fromValue * 2.471, 2);
    }
}
