package Hogwarts.Repository;

import Hogwarts.Domain.Cooking;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface CookingRepository extends CrudRepository<Cooking,Integer> {
    Cooking getById(Integer id);
    List<Cooking> findAllByPersonId(Integer id);

}
