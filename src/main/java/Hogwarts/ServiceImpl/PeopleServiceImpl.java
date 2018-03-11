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

    @Override
    public boolean checkAvailable(String username) {
        List<People> list = new ArrayList<>();
        peopleRepository.findAll().forEach(list::add);
        for (People p: list) {
            if (p.getLogin() == null || p.getLogin().isEmpty()){
                continue;
            }
            if ( p.getLogin().equals(username)){

                return false;
            }
        }
        return true;
    }

    @Override
    public int checkUser(People people) {
        int returnValue = 0;
        List<People> list = new ArrayList<>();
        peopleRepository.findAll().forEach(list::add);
        for (People p :list) {
            if (p.getLogin() == null || p.getLogin().isEmpty()){
                continue;
            }
            if (p.getEmail() == null || p.getEmail().isEmpty()){
                continue;
            }
            if (p.getLogin().equals(people.getLogin()) || p.getEmail().equals(people.getLogin())){
                returnValue = 1;
                if(p.getPassword().equals(people.getPassword())){
                    returnValue = 2;
                }
            }
        }
        return returnValue;
    }

    @Override
    public List<People> listOfAdmins() {
        List<People> returnedList = new ArrayList<>();
        List<People> list = new ArrayList<>();
        peopleRepository.findAll().forEach(list::add);
        for (People p:list) {
            if(p.getStatusId() == 1){
                returnedList.add(p);
            }
        }
        return returnedList;
    }
}
