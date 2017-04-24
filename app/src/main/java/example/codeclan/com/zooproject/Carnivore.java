package example.codeclan.com.zooproject;

/**
 * Created by user on 21/04/2017.
 */

public class Carnivore extends Animal {
    public Carnivore(String name, FoodType foodType, char gender, boolean mature,
                     Biome preferredBiome, boolean solitary, int nutrionalValue, int preferredSpace) {
        super(name, foodType, gender, mature, preferredBiome, solitary, nutrionalValue, preferredSpace);
    }

    public void eat(Edible edible){
        if(edible.getFoodType() == FoodType.MEAT){
            getBelly().add(edible);
            addToHunger(edible.getNutritionalValue());
            if(bellyCount() > 4){
                poop();
            }
            String event = getName() + " the " + getClass().getSimpleName().toString() + " ate " + edible.getsEaten();
            getAnimalLog().add(event);
        }

    }
}