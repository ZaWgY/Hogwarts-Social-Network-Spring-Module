package Hogwarts.Service;

import Hogwarts.Domain.People;

import java.util.List;

public interface PeopleService {
    void remove(int id);
    List<People> listAll();
    People find(int id);
    void save(People people);
}
