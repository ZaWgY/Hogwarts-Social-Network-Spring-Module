package Hogwarts.Controller;

import Hogwarts.Domain.Status;
import Hogwarts.Service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StatusController {
    private StatusService statusService;

    @Autowired
    public void setStatusService(StatusService statusService) {
        this.statusService = statusService;
    }

    @RequestMapping(value = "/getAllStatus",method = RequestMethod.GET)
    public List<Status> getAllStatus(){
        return statusService.findAll();
    }

    @RequestMapping(value = "/setBasicStatus",method = RequestMethod.GET)
    public void setStatuses(){
        statusService.save(new Status("Student"));
        statusService.save(new Status("Teacher"));
        statusService.save(new Status("Moder"));
        statusService.save(new Status("Admin"));
        statusService.save(new Status("Undecided"));
    }



}
