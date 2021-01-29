package com.ayo.demo.infrastructure.web;

import com.ayo.demo.service.convertor.ConversionType;
import com.ayo.demo.service.convertor.ConvertorService;
import com.ayo.demo.service.convertor.UnitType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/convert")
public class ConversionResource {

    private final ConvertorService convertorService;

    @Autowired
    public ConversionResource(final ConvertorService convertorService) {
        this.convertorService = convertorService;
    }

    @RequestMapping(value = "/temperature/to-metric/{value}",
            method = RequestMethod.GET,
            produces = {
                    APPLICATION_JSON_VALUE,
            })
    public ResponseEntity<Double> convertFahrenheitToCelsius(@PathVariable final Double value) {
        return convertorService.convert(ConversionType.TEMPERATURE, UnitType.METRIC, value);
    }

    @RequestMapping(value = "/temperature/to-imperial/{value}",
            method = RequestMethod.GET,
            produces = {
                    APPLICATION_JSON_VALUE,
            })
    public ResponseEntity<Double> convertCelsiusToFahrenheit(@PathVariable final Double value) {
        return convertorService.convert(ConversionType.TEMPERATURE, UnitType.IMPERIAL, value);
    }

    @RequestMapping(value = "/area/to-metric/{value}",
            method = RequestMethod.GET,
            produces = {
                    APPLICATION_JSON_VALUE,
            })
    public ResponseEntity<Double> convertAcreToHectare(@PathVariable final Double value) {
        return convertorService.convert(ConversionType.AREA, UnitType.METRIC, value);
    }

    @RequestMapping(value = "/area/to-imperial/{value}",
            method = RequestMethod.GET,
            produces = {
                    APPLICATION_JSON_VALUE,
            })
    public ResponseEntity<Double> convertHectareToAcre(@PathVariable final Double value) {
        return convertorService.convert(ConversionType.AREA, UnitType.IMPERIAL, value);
    }
}
