package lu.hal.demo.service;

import io.vanillabp.spi.process.ProcessService;
import io.vanillabp.spi.service.WorkflowService;
import io.vanillabp.spi.service.WorkflowTask;
import lombok.extern.slf4j.Slf4j;
import lu.hal.demo.api.v1.HalDemoDto;
import lu.hal.demo.domain.HalDemoAggregate;
import lu.hal.demo.mapper.HalDemoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@WorkflowService(workflowAggregateClass = HalDemoAggregate.class)
@Slf4j
public class HalDemo {

    @Autowired
    private ProcessService<HalDemoAggregate> halDemoProcessService;

    @Autowired
    private HalDemoMapper halDemoMapper;

    @WorkflowTask(taskDefinition = "demoTask")
    public void demoTask() {
        System.out.println("demoTask");
    }

    public String startHalDemoWorkflow(HalDemoDto halDemoDto) throws Exception {
        HalDemoAggregate halDemoAggregate = halDemoMapper.mapToEntity(halDemoDto);
        halDemoAggregate.setId(UUID.randomUUID().toString());
        HalDemoAggregate hal = halDemoProcessService.startWorkflow(halDemoAggregate);
        return hal.getId();
    }

    @WorkflowTask(taskDefinition = "secondDemoTask")
    public void secondDemoTask() {
        System.out.println("secondDemoTask");
    }

}
