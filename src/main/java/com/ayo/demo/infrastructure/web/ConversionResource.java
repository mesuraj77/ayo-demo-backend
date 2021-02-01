package com.ayo.demo.infrastructure.web;

import com.ayo.demo.service.convertor.ConvertorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/convert")
public class ConversionResource {

    private final ConvertorService convertorService;

    @Autowired
    public ConversionResource(final ConvertorService convertorService) {
        this.convertorService = convertorService;
    }

    @RequestMapping(value = "/{measurement}/{toSystem}/{value}",
            method = RequestMethod.GET,
            produces = {
                    APPLICATION_JSON_VALUE,
            })
    public ResponseEntity<String> convert(@PathVariable final String measurement, @PathVariable final String toSystem, @PathVariable final Double value) {
        return convertorService.convert(measurement, toSystem, value);
    }

    @RequestMapping(value = "/measurements",
            method = RequestMethod.GET,
            produces = {
                    APPLICATION_JSON_VALUE,
            })
    public ResponseEntity<List<String>> getMeasurements() {
        return convertorService.getMeasurements();
    }

    @RequestMapping(value = "/si-units",
            method = RequestMethod.GET,
            produces = {
                    APPLICATION_JSON_VALUE,
            })
    public ResponseEntity<List<String>> getSiUnits() {
        return convertorService.getSiUnits();
    }
}
