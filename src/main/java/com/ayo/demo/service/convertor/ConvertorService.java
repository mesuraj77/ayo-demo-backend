package com.ayo.demo.service.convertor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ConvertorService {

    private final ConvertorFactory convertorFactory;

    public ConvertorService(final ConvertorFactory convertorFactory) {
        this.convertorFactory = convertorFactory;
    }

    public ResponseEntity<Double> convert(final ConversionType type, final UnitType toUnit, final Double inputValue) {
        Double convertedValue;
        HttpStatus status;

        if (inputValue != null) {

            Convertor convertor = convertorFactory.getConvertor(type);

            switch (toUnit) {
                case METRIC:
                    convertedValue = convertor.convertToMetric(inputValue);
                    break;
                case IMPERIAL:
                    convertedValue = convertor.convertToImperial(inputValue);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown Unit Type, the accepted inputs are "
                            + UnitType.METRIC.name() + " and " + UnitType.IMPERIAL.name());
            }

            status = HttpStatus.OK;

        } else {
            convertedValue = null;
            status = HttpStatus.BAD_REQUEST;
        }

        return new ResponseEntity<>(convertedValue, status);
    }
}
