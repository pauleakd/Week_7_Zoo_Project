package example.codeclan.com.zooproject;

import com.google.gson.Gson;

import org.junit.Before;
import org.junit.Test;

import example.codeclan.com.zooproject.Animals.AnimalFactory;
import example.codeclan.com.zooproject.Animals.Gazelle;
import example.codeclan.com.zooproject.Animals.Lion;
import example.codeclan.com.zooproject.Food.FoodType;
import example.codeclan.com.zooproject.Food.Grass;
import example.codeclan.com.zooproject.ZooManagement.Enclosure;
import example.codeclan.com.zooproject.ZooManagement.ZooAnimals;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

/**
 * Created by user on 21/04/2017.
 */

public class GazelleTest {
    Gazelle gazelle;
    Lion lion;
    Grass grass;
    Enclosure enclosure;

    @Before
    public void before(){
        lion = (Lion) AnimalFactory.CreateAnimal(ZooAnimals.LION, "Leo", 'M', true, 500 );
        gazelle = (Gazelle) AnimalFactory.CreateAnimal(ZooAnimals.GAZELLE, "Garry", 'M', true, 500 );
        grass = new Grass();
        enclosure = new Enclosure("African Plains", 100, Biome.SAVANNAH);
    }

    @Test
    public void getName(){
        String result = gazelle.getName();
        assertEquals("Garry",  result);
    }

    @Test
    public void hasBelly(){
        int result = gazelle.getBelly().size();
        assertEquals(0, result);
    }

    @Test
    public void canJsonify() {
        Gson gson = new Gson();
        String gazzelleString = gson.toJson(gazelle);
        assertNotNull(gazzelleString);
        Gazelle fromJson = gson.fromJson(gazzelleString, Gazelle.class);
        assertNotNull(fromJson);
    }

    @Test
    public void bellyCount(){
        int result = gazelle.bellyCount();
        assertEquals(0,result);
    }

    @Test
    public void gazelleCanEatGrass(){
        gazelle.eat(grass);
        assertEquals(1, gazelle.bellyCount());
    }

    @Test
    public void gazelleCannotEatLion(){
        gazelle.eat(lion);
        assertEquals(0, gazelle.bellyCount());
    }

    @Test
    public void gazelleSleepAndEatTest(){
        gazelle.sleep();
        gazelle.eat(grass);
        int result = gazelle.getHunger();
        assertEquals(65, result);
    }

    @Test
    public void gazelleWontEatLionWhenVeryHungry(){
        enclosure.addAnimal(gazelle);
        enclosure.addAnimal(lion);
        gazelle.addToHunger(-90);
        int result = gazelle.bellyCount();
        assertEquals(0,result);
        int count = enclosure.getAnimalCount();
        assertEquals(2,count);
    }
}
