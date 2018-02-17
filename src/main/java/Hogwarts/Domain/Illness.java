package Hogwarts.Domain;

import javax.persistence.*;

@Entity
@Table(name = "ILLNESSES")
public class Illness {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String illness;
    private String cause;
    @Column(name = "id_type")
    private Integer typeId;

    public Illness(String illness, String cause, Integer typeId) {
        this.illness = illness;
        this.cause = cause;
        this.typeId = typeId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIllness() {
        return illness;
    }

    public void setIllness(String illness) {
        this.illness = illness;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }
}
