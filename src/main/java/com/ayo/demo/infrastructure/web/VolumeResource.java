package com.ayo.demo.infrastructure.web;

import com.ayo.demo.service.VolumeService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/volume")
public class VolumeResource {

    private final VolumeService volumeService;

    public VolumeResource(final VolumeService volumeService) {
        this.volumeService = volumeService;
    }

    @RequestMapping(value = "/convert/{value}/metric",
            method = RequestMethod.POST,
            produces = {
                    APPLICATION_JSON_VALUE,
            })
    public Double convertValueToMetric(@PathVariable final Double value) {
        return volumeService.convertToMetric(value);
    }

    @RequestMapping(value = "/convert/{value}/imperial",
            method = RequestMethod.POST,
            produces = {
                    APPLICATION_JSON_VALUE,
            })
    public Double convertValueToImperial(@PathVariable final Double value) {
        return volumeService.convertToImperial(value);
    }
}
