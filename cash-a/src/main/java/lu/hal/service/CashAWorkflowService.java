package lu.hal.service;

import io.vanillabp.spi.service.BpmnProcess;
import io.vanillabp.spi.service.TaskId;
import io.vanillabp.spi.service.WorkflowService;
import io.vanillabp.spi.service.WorkflowTask;
import lombok.extern.slf4j.Slf4j;
import lu.hal.domain.CashAAggregate;
import org.springframework.stereotype.Service;

@Service
@WorkflowService(workflowAggregateClass = CashAAggregate.class, bpmnProcess = @BpmnProcess(bpmnProcessId = "cash_a"))
@Slf4j
public class CashAWorkflowService {

    @WorkflowTask(taskDefinition = "cash_a_service")
    public void cashAServiceTask(final @TaskId String taskId) {
        // log.info(taskId);
    }

}
