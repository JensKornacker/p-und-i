package at.phactum.productinnovation.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "simple_task")
public class CircleOrganisationAggregate {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "type")
    private String demoType;

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

    public String getDemoType() {
        return demoType;
    }

    public void setDemoType(final String demoType) {
        this.demoType = demoType;
    }
}
