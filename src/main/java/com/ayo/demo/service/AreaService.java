package com.ayo.demo.service;

import com.ayo.demo.service.convertor.Convertor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.math3.util.Precision;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AreaService implements Convertor {

    /**
     * This function is used to convert area from Imperial (Acre) into Metric (Hectare)
     *
     * @param acreValue an are in Imperial unit (Acre)
     * @return an Imperial unit (Hectare) equivalent value rounded to two decimal places
     *
     */
    @Override
    public double convertToMetric(final double acreValue) {
        return Precision.round(acreValue / 2.471, 2);
    }

    /**
     * This function is used to convert area from Metric (Hectare) into Imperial (Acre)
     *
     * @param hectareValue an are in Metric unit (Hectare)
     * @return an Imperial unit (Acre) equivalent value rounded to two decimal places
     *
     */
    @Override
    public double convertToImperial(final double hectareValue) {
        return Precision.round(hectareValue * 2.471, 2);
    }
}
