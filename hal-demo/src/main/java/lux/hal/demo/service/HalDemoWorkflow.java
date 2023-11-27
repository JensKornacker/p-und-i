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

    @WorkflowTask
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

    @WorkflowTask
    public void secondDemoTask() {
        log.info("second Demo Task");
    }

    @WorkflowTask
    public void sendEvent(HalDemoAggregate halDemoAggregate) {
        log.info(halDemoAggregate.getId());
        log.info(halDemoAggregate.getDemoType());
        halDemoProcessService.correlateMessage(halDemoAggregate, "receive_demo", halDemoAggregate.getDemoType());
    }

}
