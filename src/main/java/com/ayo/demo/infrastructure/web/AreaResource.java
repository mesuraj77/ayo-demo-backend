package com.ayo.demo.infrastructure.web;

import com.ayo.demo.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/area")
public class AreaResource {

    private final AreaService areaService;

    @Autowired
    public AreaResource(final AreaService areaService) {
        this.areaService = areaService;
    }

    @RequestMapping(value = "/convert/{value}/metric",
            method = RequestMethod.POST,
            produces = {
                    APPLICATION_JSON_VALUE,
            })
    public Double convertValueToMetric(@PathVariable final Double value) {
        return areaService.convertToMetric(value);
    }

    @RequestMapping(value = "/convert/{value}/imperial",
            method = RequestMethod.POST,
            produces = {
                    APPLICATION_JSON_VALUE,
            })
    public Double convertValueToImperial(@PathVariable final Double value) {
        return areaService.convertToImperial(value);
    }
}
