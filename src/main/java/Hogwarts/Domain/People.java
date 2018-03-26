package Hogwarts.Domain;

import javax.persistence.*;

@Entity
@Table(name = "PEOPLE")
public class People {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String surname;
    private String login;
    @Column(name="p_password")
    private String password;
    private String email;
    private String facultyId;
    @Column(name="id_status")
    private Integer statusId;
    private Integer health = 100;
    private Integer fatigue = 0;
    private Integer points = 0;

    public People(String name, String surname, String login, String password,Integer statusId, String email, String facultyId, Integer health, Integer fatigue) {
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.password = password;
        this.email = email;
        this.facultyId = facultyId;
        this.statusId = statusId;
        this.health = health;
        this.fatigue = fatigue;
    }

    public People(String name, String surname, String login, String password, Integer statusId, String email, String facultyId) {
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.password = password;
        this.statusId = statusId;
        this.email = email;
        this.facultyId = facultyId;
    }

    public People() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id){
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    public Integer getHealth() {
        return health;
    }

    public void setHealth(Integer health) {
        this.health = health;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getFatigue() {
        return fatigue;
    }

    public void setFatigue(Integer fatigue) {
        this.fatigue = fatigue;
    }

    public String getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(String facultyId) {
        this.facultyId = facultyId;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }
    public void addPoints(Integer points){
        this.points += points;
    }
    public String getFacutyNameById(Integer id){
        if(id.equals(1)){
            return "Gryffindor";
        }
        if(id.equals(2)){
            return "Hufflepuff";
        }
        if(id.equals(3)){
            return "Ravenclaw";
        }
        if(id.equals(4)){
            return "Slytherin";
        }
        return null;
    }
}
