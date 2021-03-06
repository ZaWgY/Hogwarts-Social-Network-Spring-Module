package Hogwarts.ServiceImpl;

import Hogwarts.Domain.Cooking;
import Hogwarts.Repository.CookingRepository;
import Hogwarts.Service.CookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CookingServiceImpl implements CookingService{
    private CookingRepository cookingRepository;

    @Autowired
    public CookingServiceImpl(CookingRepository cookingRepository) {
        this.cookingRepository = cookingRepository;
    }

    @Override
    public List<Cooking> getAll() {
        List<Cooking> list = new ArrayList<>();
        cookingRepository.findAll().forEach(list::add);
        return list;
    }

    @Override
    public List<Cooking> getCookingByName(String login) {
        return cookingRepository.findByPersonLogin(login);
    }

    @Override
    public void setReady(Boolean flag, Cooking cooking){
        Cooking currentCooking = cookingRepository.getById(cooking.getId());
        currentCooking.setReady(flag);
        cookingRepository.save(currentCooking);
    }

    @Override
    public void save(Cooking cooking) {
        cookingRepository.save(cooking);
    }

    @Override
    public Integer getLatestNumber() {
        Integer returnedValue=0;
        List<Cooking> list =  getAll();
        for (Cooking c:list) {
            if(c.getNumber() > returnedValue){
            returnedValue=c.getNumber();
            }
        }
        return returnedValue;
    }

    @Override
    public void deleteAll() {
        cookingRepository.deleteAll();
    }

}
