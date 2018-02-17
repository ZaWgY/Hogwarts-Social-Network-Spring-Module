package Hogwarts.Domain;

import javax.persistence.*;

@Entity
@Table(name = "PERSONAL_AREA")
public class PersonalArea {
    @Id
    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "is_healthy")
    private Boolean isHealthy;

    public PersonalArea(String name, String description, Boolean is_healthy){
        this.name = name;
        this.description = description;
        this.isHealthy = is_healthy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getHealthy() {
        return isHealthy;
    }

    public void setHealthy(Boolean healthy) {
        isHealthy = healthy;
    }
}
