package at.phactum.productinnovation.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "circle_organisation")
public class CircleOrganisationAggregate {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "type")
    private String circleType;

    @Column(name = "name")
    private String circleName;

    /* *******
     * Due to a known bug in mapstruct in combination with Lombok annotations
     * we use manually written Getters and Setters
     ******** */

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public String getCircleType() {
        return circleType;
    }

    public void setCircleType(final String demoType) {
        this.circleType = demoType;
    }

    public String getCircleName() {
        return circleName;
    }

    public void setCircleName(final String circleName) {
        this.circleName = circleName;
    }
}
