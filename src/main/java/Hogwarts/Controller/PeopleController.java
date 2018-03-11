package Hogwarts.Controller;

import Hogwarts.Domain.People;
import Hogwarts.Service.NotificationService;
import Hogwarts.Service.PeopleService;
import Hogwarts.ServiceImpl.PeopleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class PeopleController {
    private PeopleService peopleService;
    private NotificationService notificationService;

    @Autowired
    public void setPeopleService(PeopleService peopleService, NotificationService notificationService){
        this.peopleService = peopleService;
        this.notificationService = notificationService;
    }

    @RequestMapping(value = "/allPeople",method = RequestMethod.GET)
    public List<People> getAllPeople(){
        return peopleService.listAll();
    }

    @RequestMapping(value = "/addHuman", method = RequestMethod.GET)
    public void addTestHuman(){
        peopleService.save(new People("Naruto","Uzumaki","login","password",1,"Kartofel@mail.ru","Gryffindor"));
    }
    @RequestMapping(value = "/registerPerson", method = RequestMethod.POST)
    public ResponseEntity registerUser(@RequestBody People people){
        System.out.println("Регистрация юзера " + people.getLogin());
        if (peopleService.checkAvailable(people.getLogin())){
            try{
                System.out.println("Отправка сообщения на почту - " + people.getEmail());
                notificationService.sendRegistrationNotification(people);
            }catch(Exception e){
                System.out.println("Почта не валидна");
                return ResponseEntity.ok(HttpStatus.BAD_REQUEST);
            }
            peopleService.save(people);
            return ResponseEntity.ok(HttpStatus.OK);
        }
        return ResponseEntity.ok(HttpStatus.CONFLICT);
    }
    @RequestMapping(value = "/authUser", method = RequestMethod.POST)
    public ResponseEntity authUser(@RequestBody People people){
        System.out.println("Авторизаця юзера " + people.getLogin());
        int result = peopleService.checkUser(people);
        if (result == 0){
            return ResponseEntity.ok(HttpStatus.NOT_FOUND);
        }
        if (result == 1){
            return ResponseEntity.ok(HttpStatus.EXPECTATION_FAILED);
        }
        if (result == 2){
            return ResponseEntity.ok(HttpStatus.FOUND);
        }
        return  ResponseEntity.ok(HttpStatus.BAD_REQUEST);
    }
}
