package lux.hal.demo.api;

import lux.hal.demo.api.v1.HalDemoApi;
import lux.hal.demo.api.v1.HalDemoDto;
import lux.hal.demo.service.HalDemoWorkflow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HalDemoController implements HalDemoApi {

    @Autowired
    private HalDemoWorkflow halDemoWorkflowService;

    @Override
    public ResponseEntity<String> requestHalDemo(HalDemoDto halDemoDto) {
        try {
            String halDemoWorkflowId = halDemoWorkflowService.startHalDemoWorkflow(halDemoDto);
            return ResponseEntity.ok(halDemoWorkflowId);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
