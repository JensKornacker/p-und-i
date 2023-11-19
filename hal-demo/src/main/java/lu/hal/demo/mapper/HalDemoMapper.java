package lu.hal.demo.mapper;

import lu.hal.demo.api.v1.HalDemoDto;
import lu.hal.demo.domain.HalDemoAggregate;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface HalDemoMapper {

    @Mapping(target = "type", source = "demoType")
    HalDemoAggregate mapToEntity(HalDemoDto halDemoDto);

}
