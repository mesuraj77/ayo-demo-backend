package com.ayo.demo.infrastructure.web;

import com.ayo.demo.service.AreaService;
import com.ayo.demo.service.TemperatureService;
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

    private final TemperatureService temperatureService;
    private final AreaService areaService;

    @Autowired
    public ConversionResource(final TemperatureService temperatureService,
                              final AreaService areaService) {
        this.temperatureService = temperatureService;
        this.areaService = areaService;
    }

    @RequestMapping(value = "/temperature/fahrenheit/{value}/to/celsius",
            method = RequestMethod.GET,
            produces = {
                    APPLICATION_JSON_VALUE,
            })
    public ResponseEntity<Double> convertFahrenheitToCelsius(@PathVariable final Double value) {
        return temperatureService.convertFahrenheitToCelsius(value);
    }

    @RequestMapping(value = "/temperature/celsius/{value}/to/fahrenheit",
            method = RequestMethod.GET,
            produces = {
                    APPLICATION_JSON_VALUE,
            })
    public ResponseEntity<Double> convertCelsiusToFahrenheit(@PathVariable final Double value) {
        return temperatureService.convertCelsiusToFahrenheit(value);
    }

    @RequestMapping(value = "/area/acre/{value}/to/hectare",
            method = RequestMethod.GET,
            produces = {
                    APPLICATION_JSON_VALUE,
            })
    public ResponseEntity<Double> convertAcreToHectare(@PathVariable final Double value) {
        return areaService.convertAcreToHectare(value);
    }

    @RequestMapping(value = "/area/hectare/{value}/to/acre",
            method = RequestMethod.GET,
            produces = {
                    APPLICATION_JSON_VALUE,
            })
    public ResponseEntity<Double> convertHectareToAcre(@PathVariable final Double value) {
        return areaService.convertHectareToAcre(value);
    }
}
