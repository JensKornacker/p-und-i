package lux.hal.demo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "hal_demo")
public class HalDemoAggregate {

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
