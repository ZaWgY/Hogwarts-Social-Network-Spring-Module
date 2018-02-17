package Hogwarts.Repository;

import Hogwarts.Domain.People;
import org.springframework.data.repository.CrudRepository;

public interface PeopleRepository extends CrudRepository<People, Integer> {
}
