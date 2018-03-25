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
        raidService.save(new Raid("Охота на дракона","Поход на дракона в горы драконов",20,30,40,15));
        raidService.save(new Raid("Поимка тролля","Необходимо поймать сбежавшего тролля",20,30,40,15));
        raidService.save(new Raid("Игра в квиддич","Турнир по квиддичу",20,30,40,15));
        raidService.save(new Raid("Задание по зельеварению","Необходимо сварить зелье невидомости",20,30,40,15));
    }
    @RequestMapping(value = "/saveRaidRespond", method = RequestMethod.POST)
    public void addRaidRespond(@RequestBody RaidRespond raidRespond){
        this.raidService.addRaidRespond(new RaidRespond(raidRespond.getUserName(),raidRespond.getRaidName()));
    }
    @RequestMapping(value = "/getAllRaidsByName", method = RequestMethod.POST)
    public List<RaidRespond> getAllRaidsByName(@RequestBody String login){
        return raidService.getRaidsByLogin(login);
    }
    @RequestMapping(value = "/addNewRaid", method = RequestMethod.POST)
    public Boolean addNewRaid(@RequestBody Raid raid){
        if (raidService.checkAvailiable(raid.getName())){
            raidService.save(new Raid(raid.getName(),raid.getDescription(),raid.getExpiredFatigue(),raid.getMinExpiredHealth(),raid.getMaxExpiredHealth(),raid.getNumberOfRequiredStudents()));
            System.out.println("Рейд добавлен");
            return true;
        }
        return false;
    }

}
