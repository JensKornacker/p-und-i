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

//    public ResponseEntity<String> requestHalDemo(CircleOrganisationDto circleOrganisationDto) {
//        try {
//            String circleOrganisationWorkflowId = circleOrganisationWorkflowService.startHalDemoWorkflow(circleOrganisationDto);
//            return ResponseEntity.ok(circleOrganisationWorkflowId);
//        } catch (Exception e) {
//            throw new RuntimeException(e.getMessage());
//        }
//    }

    @Override
    public ResponseEntity<String> requestCircleOrganisation(final CircleOrganisationDto circleOrganisationDto) {
        return CircleApi.super.requestCircleOrganisation(circleOrganisationDto);
    }
}
