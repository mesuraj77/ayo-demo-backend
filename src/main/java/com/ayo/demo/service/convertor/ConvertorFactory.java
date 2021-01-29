package com.ayo.demo.service.convertor;

import com.ayo.demo.service.TemperatureService;
import org.springframework.stereotype.Component;

import static java.lang.String.format;

@Component
public class ConvertorFactory {

    private final TemperatureService temperatureService;

    public ConvertorFactory(final TemperatureService temperatureService) {
        this.temperatureService = temperatureService;
    }

    public Convertor getConvertor(final ConversionType type) {
        if (ConversionType.TEMPERATURE.equals(type)) {
            return temperatureService;
        } else {
            throw new RuntimeException(format("Could not identify implementation for the conversion type [%s]",
                    type.name()));
        }
    }
}
