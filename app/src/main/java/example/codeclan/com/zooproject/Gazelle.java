package example.codeclan.com.zooproject;

/**
 * Created by user on 21/04/2017.
 */

public class Gazelle extends Animal implements Edible{

    public Gazelle(String name, String type, char gender, boolean mature, Biome preferredBiome, boolean solitary) {
        super(name, type, gender, mature, preferredBiome, solitary);
    }

    public String getsEaten(){
        return "";
    }

    public int getNutritionalValue(){
        return 1;
    }

}
