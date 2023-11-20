package lux.hal.demo.mapper;

import lux.hal.demo.api.v1.HalDemoDto;
import lux.hal.demo.domain.HalDemoAggregate;
import org.mapstruct.Mapper;

@Mapper
public interface HalDemoMapper {

    HalDemoAggregate mapToEntity(HalDemoDto halDemoDto);

}
