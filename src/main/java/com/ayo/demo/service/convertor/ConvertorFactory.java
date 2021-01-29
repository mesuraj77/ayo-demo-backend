package com.ayo.demo.service.convertor;

import com.ayo.demo.service.AreaService;
import com.ayo.demo.service.LengthService;
import com.ayo.demo.service.TemperatureService;
import com.ayo.demo.service.VolumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static java.lang.String.format;

@Component
public class ConvertorFactory {

    private final TemperatureService temperatureService;
    private final AreaService areaService;
    private final LengthService lengthService;
    private final VolumeService volumeService;

    @Autowired
    public ConvertorFactory(final TemperatureService temperatureService,
                            final AreaService areaService,
                            final LengthService lengthService,
                            final VolumeService volumeService) {
        this.temperatureService = temperatureService;
        this.areaService = areaService;
        this.lengthService = lengthService;
        this.volumeService = volumeService;
    }

    /**
     * This method works as a factory which would (based on the conversion type required) return the appropriate
     * implementation of <code>Convertor.java</code>
     *
     * @param type the type of Convertor required, bound by the <code>ConversionType</code> enumerator
     * @return the appropriate Convertor implementation
     *
     * @throws RuntimeException which can occur if a type is being used without an appropriate Convertor being implemented
     */
    public Convertor getConvertor(final ConversionType type) {
        if (ConversionType.TEMPERATURE.equals(type)) {
            return temperatureService;
        } else if (ConversionType.AREA.equals(type)) {
            return areaService;
        } else if (ConversionType.LENGTH.equals(type)) {
            return lengthService;
        } else if (ConversionType.VOLUME.equals(type)) {
            return volumeService;
        } else {
            throw new RuntimeException(format("Could not identify implementation for the conversion type [%s]",
                    type.name()));
        }
    }
}
