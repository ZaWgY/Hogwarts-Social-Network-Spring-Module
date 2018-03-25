package Hogwarts.ServiceImpl;

import Hogwarts.Domain.Faculty;
import Hogwarts.Domain.News;
import Hogwarts.Repository.NewsRepository;
import Hogwarts.Service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Вадим on 25.03.2018.
 */
@Service
public class NewsServiceImpl implements NewsService {
    private NewsRepository newsRepository;

    @Autowired
    public NewsServiceImpl(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    @Override
    public List<News> findAll() {
        List<News> list = new ArrayList<>();
        newsRepository.findAll().forEach(list::add);
        return list;
    }

    @Override
    public void deleteAll() {
        newsRepository.deleteAll();
    }

    @Override
    public void deleteByName(String name) {
        newsRepository.deleteByName(name);
    }

    @Override
    public void addNews(News news) {
        newsRepository.save(news);
    }

    @Override
    public boolean checkNews(String name) {
        List<News> list = findAll();
        for (News n:list) {
            if(n.getName().equals(name)){
                return false;
            }
        }
        return true;
    }
}
