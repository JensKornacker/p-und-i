package at.phactum.productinnovation.service;

import java.util.UUID;


import at.phactum.api.v1.CircleOrganisationDto;
import at.phactum.productinnovation.domain.CircleOrganisationAggregate;
import at.phactum.productinnovation.mapper.CircleOrganisationMapper;
import io.vanillabp.spi.process.ProcessService;
import io.vanillabp.spi.service.WorkflowService;
import io.vanillabp.spi.service.WorkflowTask;
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
    public void demoTask() {
        log.info("demoTask");
    }

    public String startHalDemoWorkflow(CircleOrganisationDto halDemoDto) throws Exception {
        final CircleOrganisationMapper mapper = Mappers.getMapper(CircleOrganisationMapper.class);
        CircleOrganisationAggregate circleOrganisationAggregate = mapper.mapToEntity(halDemoDto);
        circleOrganisationAggregate.setId(UUID.randomUUID().toString());
        CircleOrganisationAggregate hal = circleOrganisationProcessService.startWorkflow(circleOrganisationAggregate);
        return hal.getId();
    }

    @WorkflowTask
    public void secondDemoTask() {
        log.info("second Demo Task");
    }

    @WorkflowTask
    public void sendEvent(CircleOrganisationAggregate circleOrganisationAggregate) {
        log.info(circleOrganisationAggregate.getId());
        log.info(circleOrganisationAggregate.getDemoType());
        circleOrganisationProcessService.correlateMessage(circleOrganisationAggregate, "receive_demo", circleOrganisationAggregate.getDemoType());
    }

}
