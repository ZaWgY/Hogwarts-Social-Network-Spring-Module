package Hogwarts.Repository;

import Hogwarts.Domain.News;
import org.springframework.data.repository.CrudRepository;

public interface NewsRepository extends CrudRepository<News, Integer> {
    void deleteByName(String name);
}
