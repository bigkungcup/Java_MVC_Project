package sit.int202.toabin_quiz3;

import sit.int202.toabin_quiz3.entities.Drink;
import sit.int202.toabin_quiz3.repositories.DrinkRepository;

import java.util.List;

public class TestQuiz3 {
    public static void main(String[] args) {
        DrinkRepository drinkRepo = new DrinkRepository() ;
        List<Drink> drinks = drinkRepo.findAll() ;
        for(Drink drink : drinks){
            System.out.println(drink);
        }
    }
}

