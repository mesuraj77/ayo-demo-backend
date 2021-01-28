package com.ayo.demo.infrastructure.web;

import com.ayo.demo.service.LengthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/length")
public class LengthResource {

    private final LengthService lengthService;

    @Autowired
    public LengthResource(final LengthService lengthService) {
        this.lengthService = lengthService;
    }

    @RequestMapping(value = "/convert/{value}/metric",
            method = RequestMethod.POST,
            produces = {
                    APPLICATION_JSON_VALUE,
            })
    public Double convertValueToMetric(@PathVariable final Double value) {
        return lengthService.convertToMetric(value);
    }

    @RequestMapping(value = "/convert/{value}/imperial",
            method = RequestMethod.POST,
            produces = {
                    APPLICATION_JSON_VALUE,
            })
    public Double convertValueToImperial(@PathVariable final Double value) {
        return lengthService.convertToImperial(value);
    }
}
