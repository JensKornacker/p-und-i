package at.phactum.productinnovation.config;

import io.vanillabp.springboot.modules.WorkflowModuleIdAwareProperties;
import io.vanillabp.springboot.modules.WorkflowModuleProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// @Configuration
// @ConfigurationProperties(prefix = CircleOrganisationConfig.WORKFLOW_MODULE_ID)
public class CircleOrganisationConfig implements WorkflowModuleIdAwareProperties {
    public static final String WORKFLOW_MODULE_ID = "circle-organisation";

    @Bean
    public static WorkflowModuleProperties cashAWorkflowModuleProperties() {
        return new WorkflowModuleProperties(CircleOrganisationConfig.class, WORKFLOW_MODULE_ID);
    }

    @Override
    public String getWorkflowModuleId() {
        return WORKFLOW_MODULE_ID;
    }
}
