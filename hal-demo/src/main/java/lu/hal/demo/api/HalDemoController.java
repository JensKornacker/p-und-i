package lu.hal.demo.api;

import lombok.extern.slf4j.Slf4j;
import lu.hal.demo.api.v1.HalDemoApi;
import lu.hal.demo.api.v1.HalDemoDto;
import lu.hal.demo.service.HalDemo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HalDemoController implements HalDemoApi {

    @Autowired
    private HalDemo halDemoService;

    @Override
    public ResponseEntity<String> requestHalDemo(HalDemoDto halDemoDto) {
        try {
            String halDemoWorkflowId = halDemoService.startHalDemoWorkflow(halDemoDto);
            return ResponseEntity.ok(halDemoWorkflowId);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
