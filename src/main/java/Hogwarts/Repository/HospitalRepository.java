package Hogwarts.Repository;

import Hogwarts.Domain.Hospital;
import org.springframework.data.repository.CrudRepository;

public interface HospitalRepository extends CrudRepository<Hospital, Integer> {
}
