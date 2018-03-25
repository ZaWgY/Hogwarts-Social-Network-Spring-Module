package Hogwarts.Repository;

import Hogwarts.Domain.RaidRespond;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RaidRespondRepository extends CrudRepository<RaidRespond,Integer> {
    List<RaidRespond> findByUserName(String userName);
}
