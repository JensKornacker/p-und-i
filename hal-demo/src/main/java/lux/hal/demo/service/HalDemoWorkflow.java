package lux.hal.demo.service;

import java.util.UUID;

import io.vanillabp.spi.process.ProcessService;
import io.vanillabp.spi.service.BpmnProcess;
import io.vanillabp.spi.service.WorkflowService;
import io.vanillabp.spi.service.WorkflowTask;
import lombok.extern.slf4j.Slf4j;
import lux.hal.demo.api.v1.HalDemoDto;
import lux.hal.demo.domain.HalDemoAggregate;
import lux.hal.demo.mapper.HalDemoMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@WorkflowService(workflowAggregateClass = HalDemoAggregate.class)
@Slf4j
public class HalDemoWorkflow {

    @Autowired
    private ProcessService<HalDemoAggregate> halDemoProcessService;

    @WorkflowTask(taskDefinition = "demoTask")
    public void demoTask() {
        log.info("demoTask");
    }

    public String startHalDemoWorkflow(HalDemoDto halDemoDto) throws Exception {
        final HalDemoMapper mapper = Mappers.getMapper(HalDemoMapper.class);
        HalDemoAggregate halDemoAggregate = mapper.mapToEntity(halDemoDto);
        halDemoAggregate.setId(UUID.randomUUID().toString());
        HalDemoAggregate hal = halDemoProcessService.startWorkflow(halDemoAggregate);
        return hal.getId();
    }

    @WorkflowTask(taskDefinition = "secondDemoTask")
    public void secondDemoTask() {
        log.info("second Demo Task");
    }

}
