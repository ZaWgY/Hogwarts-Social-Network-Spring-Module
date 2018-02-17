package Hogwarts.Domain;

import javax.persistence.*;

@Entity
@Table(name = "DELIVERY")
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer numberOfServing;

    public Delivery(Integer numberOfServing) {
        this.numberOfServing = numberOfServing;
    }

    public Delivery() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumberOfServing() {
        return numberOfServing;
    }

    public void setNumberOfServing(Integer numberOfServing) {
        this.numberOfServing = numberOfServing;
    }
}
