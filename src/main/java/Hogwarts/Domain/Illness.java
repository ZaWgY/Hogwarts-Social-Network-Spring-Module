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
}
