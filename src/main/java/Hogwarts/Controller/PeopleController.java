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
        peopleService.save(new People("Naruto","Uzumaki","login1","password",1,"legenda2121@mail.ru","Gryffindor"));
        peopleService.save(new People("Boruto","Uzumaki","login2","password",2,"legenda2121@mail.ru","Gryffindor"));
        peopleService.save(new People("Sakura","Uzumaki","login3","password",3,"legenda2121@mail.ru","Gryffindor"));
        peopleService.save(new People("Sasuke","Uzumaki","login4","password",4,"legenda2121@mail.ru","Gryffindor"));
        peopleService.save(new People("Kakash","Uzumaki","login5","password",5,"legenda2121@mail.ru","Gryffindor"));
        peopleService.save(new People("Kawaki","Uzumaki","login6","password",6,"legenda2121@mail.ru","Gryffindor"));
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
                e.printStackTrace();
                return ResponseEntity.ok(HttpStatus.BAD_REQUEST);
            }
            peopleService.save(new People(people.getName(),people.getSurname(),people.getLogin(),people.getPassword(),4,people.getEmail(),"undecided"));
//            notificationService.sendRegInfoNotification(new People(people.getName(),people.getSurname(),people.getLogin(),people.getPassword(),4,people.getEmail(),"undecided"),peopleService.listOfAdmins());
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
        if (result == 3){
            return ResponseEntity.ok(HttpStatus.FORBIDDEN);
        }
        return  ResponseEntity.ok(HttpStatus.BAD_REQUEST);
    }
    @RequestMapping(value = "/undecidedUsers", method = RequestMethod.GET)
    public List<People> getAllUndecidedUsers(){
        System.out.println("Запрос на получение всех неутверждённых пользователей");
        return peopleService.listOfUndecided();
    }
    @RequestMapping(value = "/adminList", method = RequestMethod.GET)
    public List<People> getAdminList(){
        System.out.println("Запрос на получение всех админов");
        return peopleService.listOfAdmins();
    }
    @RequestMapping(value = "/approveUser", method = RequestMethod.POST)
    public void approveUser(@RequestBody People people){
        System.out.println("Дарова");
        this.peopleService.approoveUser(people);
        notificationService.sendApproveInfo(people);
    }
    @RequestMapping(value = "/deleteAlPeople", method = RequestMethod.GET)
    public void deleteUsers(){
        peopleService.removeAll();
    }

    @RequestMapping(value = "/getStatusByLogin", method = RequestMethod.POST)
    public  Integer getStatusByLogin(@RequestBody String login){
        People people = peopleService.getPeopleByLogin(login);
        return people.getStatusId();
    }
    @RequestMapping(value = "/getPeopleByLogin", method = RequestMethod.POST)
    public People getPeopleByLogin(@RequestBody String login){
        return peopleService.getPeopleByLogin(login);
    }
}
