package Hogwarts.Controller;

import Hogwarts.Domain.Faculty;
import Hogwarts.Service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class FacultyController {
    private FacultyService facultyService;

    @Autowired
    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @RequestMapping(value = "/allFaculties",method = RequestMethod.GET)
    public List<Faculty> getAllFaculties(){
        return  facultyService.listAll();
    }

    @RequestMapping(value = "/basicFaculties", method = RequestMethod.GET)
    public void setBasicFaculties(){
        facultyService.save(new Faculty("Gryffindor",0));
        facultyService.save(new Faculty("Hufflepuff",0));
        facultyService.save(new Faculty("Ravenclaw",0));
        facultyService.save(new Faculty("Slytherin",0));
    }
    @RequestMapping(value = "/getGryfPoints", method = RequestMethod.GET)
    public Integer getGryfPoints(){
        return facultyService.getFacultyPoints("Gryffindor");
    }
    @RequestMapping(value = "/getHuffPoints", method = RequestMethod.GET)
    public Integer getHuffPoints(){
        return facultyService.getFacultyPoints("Hufflepuff");
    }
    @RequestMapping(value = "/getRavenPoints", method = RequestMethod.GET)
    public Integer getRavenPoints(){
        return facultyService.getFacultyPoints("Ravenclaw");
    }
    @RequestMapping(value = "/getSlythPoints", method = RequestMethod.GET)
    public Integer getSlithPoints(){
        return facultyService.getFacultyPoints("Slytherin");
    }
}
