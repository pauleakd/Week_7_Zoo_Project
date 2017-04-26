package example.codeclan.com.zooproject.Food;

import example.codeclan.com.zooproject.Drinkable;
import example.codeclan.com.zooproject.Edible;
import example.codeclan.com.zooproject.ZooManagement.Sellable;

/**
 * Created by user on 26/04/2017.
 */

public class Soda implements Drinkable, Sellable {

    private FoodType foodType;
    private int nutritionalValue;

    public Soda(){
        foodType = FoodType.HUMAN;
        nutritionalValue = 15;
    }
    public String getsEaten(){
        return "a soda";
    }

    public int getNutritionalValue(){
        return nutritionalValue;
    }

    public FoodType getFoodType(){
        return foodType;
    }
}
