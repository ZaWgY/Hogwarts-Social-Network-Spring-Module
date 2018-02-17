package Hogwarts.Repository;

import Hogwarts.Domain.RoomPass;
import org.springframework.data.repository.CrudRepository;

public interface RoomPassRepository extends CrudRepository<RoomPass, Integer> {
}
