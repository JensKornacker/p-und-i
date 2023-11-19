package lu.hal.demo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.mapstruct.Builder;

@Entity
@Table(name = "hal_demo")
public class HalDemoAggregate {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "type")
    private String type;

    /********
     * Due to a known bug in mapstruct we use manually written Getters and Setters:
     ******** */


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
