package lu.hal.demo.config;

import io.vanillabp.springboot.modules.WorkflowModuleIdAwareProperties;
import io.vanillabp.springboot.modules.WorkflowModuleProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = HalDemoConfig.WORKFLOW_MODULE_ID)
public class HalDemoConfig implements WorkflowModuleIdAwareProperties {
    public static final String WORKFLOW_MODULE_ID = "hal-demo";

    @Bean
    public static WorkflowModuleProperties cashAWorkflowModuleProperties() {
        return new WorkflowModuleProperties(HalDemoConfig.class, WORKFLOW_MODULE_ID);
    }

    @Override
    public String getWorkflowModuleId() {
        return WORKFLOW_MODULE_ID;
    }
}
