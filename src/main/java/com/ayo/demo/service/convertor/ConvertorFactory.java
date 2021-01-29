package com.ayo.demo.service.convertor;

import com.ayo.demo.service.AreaService;
import com.ayo.demo.service.TemperatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static java.lang.String.format;

@Component
public class ConvertorFactory {

    private final TemperatureService temperatureService;
    private final AreaService areaService;

    @Autowired
    public ConvertorFactory(final TemperatureService temperatureService,
                            final AreaService areaService) {
        this.temperatureService = temperatureService;
        this.areaService = areaService;
    }

    public Convertor getConvertor(final ConversionType type) {
        if (ConversionType.TEMPERATURE.equals(type)) {
            return temperatureService;
        } else if (ConversionType.AREA.equals(type)) {
            return areaService;
        } else {
            throw new RuntimeException(format("Could not identify implementation for the conversion type [%s]",
                    type.name()));
        }
    }
}
