package at.phactum.productinnovation.mapper;


import at.phactum.api.v1.CircleOrganisationDto;
import at.phactum.productinnovation.domain.CircleOrganisationAggregate;
import org.mapstruct.Mapper;

@Mapper
public interface CircleOrganisationMapper {

    CircleOrganisationAggregate mapToEntity(CircleOrganisationDto circleOrganisationDto);

}
