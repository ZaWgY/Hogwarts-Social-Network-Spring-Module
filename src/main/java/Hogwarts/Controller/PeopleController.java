package Hogwarts.Controller;

import Hogwarts.Domain.People;
import Hogwarts.Service.PeopleService;
import Hogwarts.ServiceImpl.PeopleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PeopleController {
    private PeopleService peopleService;

    @Autowired
    public void setPeopleService(PeopleService peopleService){
        this.peopleService = peopleService;
    }

    @RequestMapping(value = "/allPeople",method = RequestMethod.GET)
    public List<People> getAllPeople(){
        return peopleService.listAll();
    }

    @RequestMapping(value = "/addHuman", method = RequestMethod.GET)
    public void addTestHuman(){
        peopleService.save(new People("Naruto","Uzumaki","login","password",1));
    }
}
