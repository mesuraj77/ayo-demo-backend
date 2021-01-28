package com.ayo.demo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class WeightService implements Convertor {
    @Override
    public double convertToMetric(final double fromValue) {
        return 0;
    }

    @Override
    public double convertToImperial(final double fromValue) {
        return 0;
    }
}
