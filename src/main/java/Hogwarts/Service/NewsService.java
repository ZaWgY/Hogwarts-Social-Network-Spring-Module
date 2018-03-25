package Hogwarts.Service;

import Hogwarts.Domain.News;

import java.util.List;

public interface NewsService {
    List<News> findAll();
    void deleteAll();
    void deleteByName(String name);
    void addNews(News news);
    boolean checkNews(String name);
}
