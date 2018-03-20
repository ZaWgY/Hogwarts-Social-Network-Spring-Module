package Hogwarts.Repository;

import Hogwarts.Domain.Dish;
import org.springframework.data.repository.CrudRepository;

public interface DishRepository extends CrudRepository<Dish, Integer> {
    Dish getById(Integer id);
    Dish getByName(String name);
}
