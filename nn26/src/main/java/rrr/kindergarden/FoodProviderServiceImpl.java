package rrr.kindergarden;


import org.springframework.context.annotation.Profile;
import rrr.Food;
import rrr.FoodProviderService;

import java.util.ArrayList;
import java.util.List;

@Profile(value = "kindergarden")
public class FoodProviderServiceImpl implements FoodProviderService {
    @Override
    public List<Food> providerLunchSet() {
        List<Food> foods = new ArrayList<>();
        foods.add(new Food("Milk"));
        foods.add(new Food("Cake"));

        return foods;
    }
}
