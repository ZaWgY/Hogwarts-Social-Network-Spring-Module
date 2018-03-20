package Hogwarts.Domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cooking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer number;
    private Integer personId;
    private Integer dishId;
    private Boolean ready;
    private Boolean given;
    private static Integer numberCounter=0;

    public Cooking(){}

    public Cooking(Integer personId, Integer dishId, Boolean ready, Integer number) {
        this.personId = personId;
        this.dishId = dishId;
        this.ready = ready;
        this.number = number;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public Integer getDishId() {
        return dishId;
    }

    public void setDishId(Integer dishId) {
        this.dishId = dishId;
    }

    public Boolean getReady() {
        return ready;
    }

    public void setReady(Boolean ready) {
        this.ready = ready;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
    private void generateNumber(){
        this.number = numberCounter+1;
    }

    public Boolean getGiven() {
        return given;
    }

    public void setGiven(Boolean given) {
        this.given = given;
    }
}
