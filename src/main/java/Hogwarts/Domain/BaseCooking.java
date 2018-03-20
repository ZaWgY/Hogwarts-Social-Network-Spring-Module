package Hogwarts.Domain;


import org.hibernate.annotations.GeneratorType;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BaseCooking{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String dishName;
    private String personLogin;

    public BaseCooking(String dishName, String personLogin) {
        this.dishName = dishName;
        this.personLogin = personLogin;
    }
    public BaseCooking(){}

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public String getPersonLogin() {
        return personLogin;
    }

    public void setPersonLogin(String personLogin) {
        this.personLogin = personLogin;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
