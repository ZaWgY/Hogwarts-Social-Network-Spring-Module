package Hogwarts.ServiceImpl;


import Hogwarts.Domain.People;
import Hogwarts.Repository.PeopleRepository;
import Hogwarts.Service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PeopleServiceImpl implements PeopleService {
    private PeopleRepository peopleRepository;

    @Autowired
    public PeopleServiceImpl(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    @Override
    public void remove(int id) {

    }

    @Override
    public List<People> listAll() {
        List<People> list = new ArrayList<>();
        peopleRepository.findAll().forEach(list::add);
        return list;

    }

    @Override
    public People find(int id) {
        return null;
    }

    @Override
    public void save(People people) {
        peopleRepository.save(people);
    }
}
