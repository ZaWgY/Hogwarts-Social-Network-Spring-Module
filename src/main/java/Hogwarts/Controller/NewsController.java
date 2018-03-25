package Hogwarts.Controller;

import Hogwarts.Domain.News;
import Hogwarts.Service.NewsService;
import Hogwarts.ServiceImpl.NewsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class NewsController {
    private NewsService newsService;

    @Autowired
    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @RequestMapping(value = "/allNews", method = RequestMethod.GET)
    public List<News> getAllNews(){
        return newsService.findAll();
    }
    @RequestMapping(value = "/addBasicNews", method = RequestMethod.GET)
    public void addBasicNews(){
        newsService.addNews(new News("Описание","Имя"));
        newsService.addNews(new News("При таинственных обстаятельствах умер кот.","Умер кот"));
        newsService.addNews(new News("У студента было много долгов ,но он очень старался их закрыть и его не отчислили.","С двумя долгами не отчисляют?"));
        newsService.addNews(new News("Может быть,а может и нет...","Дурмстранг обогна хогвартс?"));
        newsService.addNews(new News("Описание","Имя"));
    }
    @RequestMapping(value = "/addNews", method = RequestMethod.POST)
    public Boolean addNews(@RequestBody News  news){
        if (newsService.checkNews(news.getName())){
            newsService.addNews(new News(news.getDescription(),news.getName()));
            return true;
        }else{
            return false;
        }

    }
}
