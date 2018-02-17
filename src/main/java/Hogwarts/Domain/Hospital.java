package Hogwarts.Domain;

import javax.persistence.*;

@Entity
@Table(name = "HOSPITAL")
public class Hospital {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "id_person")
    private Integer personId;
    @Column(name = "id_illness")
    private Integer illnessId;
    private String comments;

    public Hospital(Integer personId, Integer illnessId, String comments) {
        this.personId = personId;
        this.illnessId = illnessId;
        this.comments = comments;
    }

    public Hospital() {
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

    public Integer getIllnessId() {
        return illnessId;
    }

    public void setIllnessId(Integer illnessId) {
        this.illnessId = illnessId;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
