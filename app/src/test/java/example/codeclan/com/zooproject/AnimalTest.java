package example.codeclan.com.zooproject;

import org.junit.Before;
import org.junit.Test;

import example.codeclan.com.zooproject.Animals.AnimalFactory;
import example.codeclan.com.zooproject.Animals.Lion;
import example.codeclan.com.zooproject.Food.FoodType;
import example.codeclan.com.zooproject.ZooManagement.ZooAnimals;

import static junit.framework.Assert.assertEquals;

/**
 * Created by user on 20/04/2017.
 */

public class AnimalTest {
    Lion lion;

    @Before
    public void before(){
        lion = (Lion) AnimalFactory.CreateAnimal(ZooAnimals.LION, "Leo", 'M', true, 500 );
    }

    @Test
    public void getName(){
        String result = lion.getName();
        assertEquals("Leo", result);
    }

    @Test
    public void getType(){
        FoodType result = lion.getFoodType();
        assertEquals(FoodType.MEAT, result);
    }

    @Test
    public void getGender(){
        char result = lion.getGender();
        assertEquals('M', result);
    }

    @Test
    public void getMaturity(){
        boolean result = lion.getMaturity();
        assertEquals(true, result);
    }

    @Test
    public void getPreferredBiome(){
        Biome result = lion.getPreferredBiome();
        assertEquals(Biome.SAVANNAH, result);
    }

    @Test
    public void IsSolitary(){
        boolean result = lion.getSolitary();
        assertEquals(false, result);
    }

    @Test
    public void getHunger(){
        int result = lion.getHunger();
        assertEquals(100, result);
    }

    @Test
    public void getHappiness(){
        int result = lion.getHappiness();
        assertEquals(50, result);
    }
}
