package Hogwarts.ServiceImpl;

import Hogwarts.Domain.Cooking;
import Hogwarts.Domain.Dish;
import Hogwarts.Repository.DishRepository;
import Hogwarts.Service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DishServiceImpl implements DishService {
    private DishRepository dishRepository;

    @Autowired
    public DishServiceImpl(DishRepository dishRepository) {
        this.dishRepository = dishRepository;
    }

    @Override
    public List<Dish> listOfAll() {
        List<Dish> list = new ArrayList<>();
        dishRepository.findAll().forEach(list::add);
        return list;
    }

    @Override
    public void changeDescription(String description, Integer id) {
        Dish currentDish = dishRepository.getById(id);
        currentDish.setDescription(description);
        dishRepository.save(currentDish);

    }

    @Override
    public void save(Dish dish) {
        dishRepository.save(dish);
    }

    @Override
    public boolean isAvaliable(Dish dish) {
        List<Dish> list = new ArrayList<>();
        dishRepository.findAll().forEach(list::add);
        for (Dish d:list) {
            if (d.getName() == null || d.getName().isEmpty()){
                continue;
            }
            if(dish.getName().equals(d.getName())){
                return false;
            }
        }
        return true;
    }
}
