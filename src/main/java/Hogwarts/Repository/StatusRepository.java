package Hogwarts.Repository;

import Hogwarts.Domain.Status;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StatusRepository extends CrudRepository<Status, Integer> {
}
