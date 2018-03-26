package Hogwarts.Domain;

import javax.persistence.*;

@Entity
@Table(name = "FACULTY")
public class Faculty {
    @Id
    private String name;
    private Integer points;

    public Faculty(String name, Integer points) {
        this.name = name;
        this.points = points;
    }

    public Faculty() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

}
