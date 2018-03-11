package Hogwarts.Service;

import Hogwarts.Domain.Faculty;

import java.util.List;

public interface FacultyService {
    void save(Faculty faculty);
    void addPoints(Faculty faculty,Integer points);
    Integer getFacultyPoints(String name);
    List<Faculty> listAll();
}
