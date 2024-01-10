package at.phactum.productinnovation.api;




import at.phactum.api.v1.CircleApi;
import at.phactum.api.v1.CircleOrganisationDto;
import at.phactum.productinnovation.service.CircleOrganisationWorkflow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CircleOrganisationController implements CircleApi {

    @Autowired
    private CircleOrganisationWorkflow circleOrganisationWorkflowService;

    @Override
    public ResponseEntity<String> requestCircleOrganisation(final CircleOrganisationDto circleOrganisationDto) {
        return ResponseEntity.ok(circleOrganisationWorkflowService.startCircleOrganisationWorkflow(circleOrganisationDto));
    }
}
