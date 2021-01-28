package com.ayo.demo.infrastructure.web;

import com.ayo.demo.service.WeightService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/weight")
public class WeightResource {

    private final WeightService weightService;

    public WeightResource(final WeightService weightService) {
        this.weightService = weightService;
    }

    @RequestMapping(value = "/convert/{value}/metric",
            method = RequestMethod.POST,
            produces = {
                    APPLICATION_JSON_VALUE,
            })
    public Double convertValueToMetric(@PathVariable final Double value) {
        return weightService.convertToMetric(value);
    }

    @RequestMapping(value = "/convert/{value}/imperial",
            method = RequestMethod.POST,
            produces = {
                    APPLICATION_JSON_VALUE,
            })
    public Double convertValueToImperial(@PathVariable final Double value) {
        return weightService.convertToImperial(value);
    }
}
