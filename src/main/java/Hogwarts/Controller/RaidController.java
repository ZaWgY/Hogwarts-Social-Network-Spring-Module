package Hogwarts.Controller;

import Hogwarts.Domain.Raid;
import Hogwarts.Domain.RaidRespond;
import Hogwarts.Service.NotificationService;
import Hogwarts.Service.PeopleService;
import Hogwarts.Service.RaidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class RaidController {
    private RaidService raidService;
    private PeopleService peopleService;
    private NotificationService notificationService;

    @Autowired
    public RaidController(RaidService raidService, PeopleService peopleService, NotificationService notificationService) {
        this.raidService = raidService;
        this.peopleService = peopleService;
        this.notificationService = notificationService;
    }


    @RequestMapping(value = "/allRaids", method = RequestMethod.GET)
    public List<Raid> getAllRaids(){
        return raidService.findAll();
    }
    @RequestMapping(value = "/addBasicRaids", method = RequestMethod.GET)
    public void addBasicRaids(){
        raidService.save(new Raid("Охота на дракона","Поход на дракона в горы драконов",15,5));
        raidService.save(new Raid("Поимка тролля","Необходимо поймать сбежавшего тролля",15,5));
        raidService.save(new Raid("Игра в квиддич","Турнир по квиддичу",15,5));
        raidService.save(new Raid("Задание по зельеварению","Необходимо сварить зелье невидомости",15,5));
    }
    @RequestMapping(value = "/saveRaidRespond", method = RequestMethod.POST)
    public Boolean addRaidRespond(@RequestBody RaidRespond raidRespond){
        if (raidService.checkRaidRespond(raidRespond.getUserName(),raidRespond.getRaidName())){
            this.raidService.addRaidRespond(new RaidRespond(raidRespond.getUserName(),raidRespond.getRaidName()));

            return true;
        }
        return false;
    }
    @RequestMapping(value = "/getAllRaidsByName", method = RequestMethod.POST)
    public List<RaidRespond> getAllRaidsByName(@RequestBody String login){
        return raidService.getRaidsByLogin(login);
    }
    @RequestMapping(value = "/addNewRaid", method = RequestMethod.POST)
    public Boolean addNewRaid(@RequestBody Raid raid){
        if (raidService.checkAvailiable(raid.getName())){
            raidService.save(new Raid(raid.getName(),raid.getDescription(),raid.getNumberOfRequiredStudents(),raid.getPoints()));
            System.out.println("Рейд добавлен");
            return true;
        }
        return false;
    }
    @RequestMapping(value = "/getAllRaidResponse", method = RequestMethod.GET)
    public List<RaidRespond> getAllRaidResponse(){
        return this.raidService.getRaidResonds();
    }
    @RequestMapping(value = "/deleteAllRaidsResponds", method = RequestMethod.GET)
    public void deleteAllRaidsResponds(){
        raidService.deleteAll();
    }
    @RequestMapping(value = "/deleteAllRaids", method = RequestMethod.GET)
    public void deleteAllRaids(){
        raidService.deleteAllRaids();
    }

    @RequestMapping(value = "/setRaidUnactive", method = RequestMethod.POST)
    public void setRaidUnactive(@RequestBody String raidName){
        raidService.setRaidUnactive(raidName);
    }
    @RequestMapping(value = "/addPoints", method = RequestMethod.POST)
    public void addPoints(@RequestBody RaidRespond raidRespond){
        raidService.addPoints(raidRespond);
    }
}
