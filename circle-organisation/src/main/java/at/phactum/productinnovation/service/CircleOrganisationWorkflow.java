package at.phactum.productinnovation.service;

import java.util.UUID;


import at.phactum.api.v1.CircleOrganisationDto;
import at.phactum.productinnovation.domain.CircleOrganisationAggregate;
import at.phactum.productinnovation.mapper.CircleOrganisationMapper;
import io.vanillabp.spi.process.ProcessService;
import io.vanillabp.spi.service.WorkflowService;
import io.vanillabp.spi.service.WorkflowTask;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@WorkflowService(workflowAggregateClass = CircleOrganisationAggregate.class)
@Slf4j
public class CircleOrganisationWorkflow {

    @Autowired
    private ProcessService<CircleOrganisationAggregate> circleOrganisationProcessService;

    @WorkflowTask
    public void firstCircle(CircleOrganisationAggregate circleOrganisationAggregate) {
        log.info("firstCircle {}", circleOrganisationAggregate.getId());
    }

    @SneakyThrows
    public String startCircleOrganisationWorkflow(CircleOrganisationDto circleOrganisationDto) {
        final CircleOrganisationMapper mapper = Mappers.getMapper(CircleOrganisationMapper.class);
        CircleOrganisationAggregate circleOrganisationAggregate = mapper.mapToEntity(circleOrganisationDto);
        circleOrganisationAggregate.setId(UUID.randomUUID().toString());
        CircleOrganisationAggregate saved = circleOrganisationProcessService.startWorkflow(circleOrganisationAggregate);
        return saved.getId();
    }

}
