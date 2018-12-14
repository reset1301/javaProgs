package rrr.highschool;

import org.springframework.context.annotation.Profile;
import rrr.Food;
import rrr.FoodProviderService;

import java.util.ArrayList;
import java.util.List;

@Profile(value = "highschool")
public class FoodProviderServiceImpl implements FoodProviderService {
    @Override
    public List<Food> providerLunchSet() {
        List<Food> foods = new ArrayList<>();
        foods.add(new Food("Coca-cola"));
        foods.add(new Food("Hamburger"));
        foods.add(new Food("French-fries"));

        return foods;
    }
}
