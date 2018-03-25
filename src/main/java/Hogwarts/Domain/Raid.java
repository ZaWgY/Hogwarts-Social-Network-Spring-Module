package Hogwarts.Domain;

import javax.persistence.*;

@Entity
@Table(name = "RAID")
public class Raid {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "expired_fatidue")
    private Integer expiredFatigue;
    @Column(name = "min_expired_health")
    private Integer minExpiredHealth;
    @Column(name = "max_expired_health")
    private Integer maxExpiredHealth;
    @Column(name = "illness_probability")
    private Integer illnessProbability;
    private Integer numberOfRequiredStudents;
    private Integer numberOfCurrentStudents;
    private Boolean isActive;

    public Raid(String name, String description, Integer expiredFatigue, Integer minExpiredHealth, Integer maxExpiredHealth) {
        this.name = name;
        this.description = description;
        this.expiredFatigue = expiredFatigue;
        this.minExpiredHealth = minExpiredHealth;
        this.maxExpiredHealth = maxExpiredHealth;
        this.isActive = true;
    }

    public Raid(String name, String description, Integer expiredFatigue, Integer minExpiredHealth, Integer maxExpiredHealth, Integer numberOfRequiredStudents) {
        this.name = name;
        this.description = description;
        this.expiredFatigue = expiredFatigue;
        this.minExpiredHealth = minExpiredHealth;
        this.maxExpiredHealth = maxExpiredHealth;
        this.numberOfRequiredStudents = numberOfRequiredStudents;
        this.isActive = true;
    }

    public Raid() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getExpiredFatigue() {
        return expiredFatigue;
    }

    public void setExpiredFatigue(Integer expiredFatigue) {
        this.expiredFatigue = expiredFatigue;
    }

    public Integer getMinExpiredHealth() {
        return minExpiredHealth;
    }

    public void setMinExpiredHealth(Integer minExpiredHealth) {
        this.minExpiredHealth = minExpiredHealth;
    }

    public Integer getMaxExpiredHealth() {
        return maxExpiredHealth;
    }

    public void setMaxExpiredHealth(Integer maxExpiredHealth) {
        this.maxExpiredHealth = maxExpiredHealth;
    }

    public Integer getIllnessProbability() {
        return illnessProbability;
    }

    public void setIllnessProbability(Integer illnessProbability) {
        this.illnessProbability = illnessProbability;
    }

    public Integer getNumberOfRequiredStudents() {
        return numberOfRequiredStudents;
    }

    public void setNumberOfRequiredStudents(Integer numberOfRequiredStudents) {
        this.numberOfRequiredStudents = numberOfRequiredStudents;
    }

    public Integer getNumberOfCurrentStudents() {
        return numberOfCurrentStudents;
    }

    public void setNumberOfCurrentStudents(Integer numberOfCurrentStudents) {
        this.numberOfCurrentStudents = numberOfCurrentStudents;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }
}
