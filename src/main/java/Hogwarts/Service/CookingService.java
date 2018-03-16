package Hogwarts.Service;


import Hogwarts.Domain.Cooking;

import java.util.List;

public interface CookingService {
    List<Cooking> getAll();
    List<Cooking> getCookingByName(Integer id);
    void setReady(Boolean flag, Cooking id);
    void save(Cooking cooking);
}
