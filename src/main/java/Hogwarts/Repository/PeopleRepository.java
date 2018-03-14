package Hogwarts.Repository;

import Hogwarts.Domain.People;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PeopleRepository extends CrudRepository<People, Integer> {
    List<People> findAllByStatusId(Integer statusId);
    People findByLogin(String login);
//    @Modifying
//    @Query("update PEOPLE p set p.facultyId = ?1, p.statusId = ?2 where p.id = ?3")
//    void setUserInfoById(String facultyId, Integer statusId, Integer userId);
}
