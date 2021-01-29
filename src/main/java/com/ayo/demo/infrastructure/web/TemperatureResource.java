package com.ayo.demo.infrastructure.web;

import com.ayo.demo.service.TemperatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/temperature")
public class TemperatureResource {

    private final TemperatureService temperatureService;

    @Autowired
    public TemperatureResource(final TemperatureService temperatureService) {
        this.temperatureService = temperatureService;
    }

    @RequestMapping(value = "/convert/{value}/metric",
            method = RequestMethod.GET,
            produces = {
                    APPLICATION_JSON_VALUE,
            })
    public ResponseEntity<Double> convertValueToMetric(@PathVariable final Double value) {
        return temperatureService.convertImperialToMetric(value);
    }

    @RequestMapping(value = "/convert/{value}/imperial",
            method = RequestMethod.GET,
            produces = {
                    APPLICATION_JSON_VALUE,
            })
    public ResponseEntity<Double> convertValueToImperial(@PathVariable final Double value) {
        return temperatureService.convertMetricToImperial(value);
    }
}
