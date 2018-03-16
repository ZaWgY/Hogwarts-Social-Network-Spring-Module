package Hogwarts.Controller;

import Hogwarts.Domain.Cooking;
import Hogwarts.Domain.Dish;
import Hogwarts.Domain.People;
import Hogwarts.Service.CookingService;
import Hogwarts.Service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class DishController {
    private DishService dishService;
    private CookingService cookingService;

    @Autowired
    public DishController(DishService dishService, CookingService cookingService) {
        this.dishService = dishService;
        this.cookingService = cookingService;
    }

    @RequestMapping(value = "/getAllFood", method = RequestMethod.GET)
    public List<Dish> getAllDishes(){
        return dishService.listOfAll();
    }

    @RequestMapping(value = "/createFoodOrder", method = RequestMethod.POST)
    public void createOrder(@RequestBody Dish dish, @RequestBody People people){
        Cooking cooking = new Cooking(people.getId(),dish.getId(),false);
        cookingService.save(cooking);
    }

    @RequestMapping(value = "/getCooking", method = RequestMethod.GET)
    public List<Cooking> getAllCooking(){
        return cookingService.getAll();
    }

    @RequestMapping(value = "/setCookingReady", method = RequestMethod.POST)
    public void setCookingReady(@RequestBody Boolean flag, @RequestBody Cooking cooking){
        cookingService.setReady(flag,cooking);
        //Оповестить пользователя о готовности его заказа
    }

    @RequestMapping(value = "/createNewDish", method = RequestMethod.POST)
    public ResponseEntity createNewDish(@RequestBody Dish dish){
        if (dishService.isAvaliable(dish)){
            dishService.save(dish);
            return ResponseEntity.ok(HttpStatus.OK);
        }else{
            return ResponseEntity.ok(HttpStatus.EXPECTATION_FAILED);
        }

    }

    @RequestMapping(value = "/addBasicDishes", method = RequestMethod.GET)
    public void addBasicDeishes(){
        dishService.save(new Dish("Овсянка", "Наверное съебно, но это не точно.","10 минут"));
        dishService.save(new Dish("Шоколадная лягушка", "Она прыгает и шоколадная.","20 минут"));
        dishService.save(new Dish("Тыквенный сок", "Блевотный и оранжевый.","5 минут"));
        dishService.save(new Dish("Сливочное пиво", "Пиво со сливками.","10 минут"));
        dishService.save(new Dish("Каменные кексы", "Они твёрдые.","2 года"));
    }

}
