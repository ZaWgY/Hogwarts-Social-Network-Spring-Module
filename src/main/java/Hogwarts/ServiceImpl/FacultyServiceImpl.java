package Hogwarts.ServiceImpl;

import Hogwarts.Domain.Faculty;
import Hogwarts.Repository.FacultyRepository;
import Hogwarts.Service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FacultyServiceImpl implements FacultyService{

    private FacultyRepository facultyRepository;

    @Autowired
    public FacultyServiceImpl(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    @Override
    public void save(Faculty faculty) {
        facultyRepository.save(faculty);
    }

    @Override
    public void addPoints(Faculty faculty, Integer points) {

    }

    @Override
    public Integer getFacultyPoints(String name) {
        List<Faculty> list = new ArrayList<>();
        facultyRepository.findAll().forEach(list::add);
        for (Faculty f: list) {
            if (name.equals(f.getName())){
                return f.getPoints();
            }
        }
        return 0;
    }

    @Override
    public List<Faculty> listAll() {
        List<Faculty> list = new ArrayList<>();
        facultyRepository.findAll().forEach(list::add);
        return list;
    }
}
