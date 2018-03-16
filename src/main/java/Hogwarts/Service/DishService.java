package Hogwarts.Service;


import Hogwarts.Domain.Dish;

import java.util.List;

public interface DishService {
    List<Dish> listOfAll();
    void changeDescription(String description, Integer id);
    void save(Dish dish);
    boolean isAvaliable(Dish dish);
}
