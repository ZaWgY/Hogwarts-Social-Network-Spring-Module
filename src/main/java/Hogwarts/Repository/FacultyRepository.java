package Hogwarts.Repository;

import Hogwarts.Domain.Faculty;
import org.springframework.data.repository.CrudRepository;

public interface FacultyRepository extends CrudRepository<Faculty, String> {
}
