package Hogwarts.Domain;

import javax.persistence.*;

@Entity
@Table(name = "ILLNESS_TYPE")
public class IllnessType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String type;

    public IllnessType(String type) {
        this.type = type;
    }

    public IllnessType() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
