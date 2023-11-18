package lu.hal.config;

import io.vanillabp.springboot.modules.WorkflowModuleIdAwareProperties;
import io.vanillabp.springboot.modules.WorkflowModuleProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = CashAConfig.WORKFLOW_MODULE_ID)
public class CashAConfig implements WorkflowModuleIdAwareProperties {
    public static final String WORKFLOW_MODULE_ID = "cash-a";

    @Bean
    public static WorkflowModuleProperties cashAWorkflowModuleProperties() {
        return new WorkflowModuleProperties(CashAConfig.class, WORKFLOW_MODULE_ID);
    }

    @Override
    public String getWorkflowModuleId() {
        return WORKFLOW_MODULE_ID;
    }
}
