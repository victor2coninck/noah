package story;

import java.util.ArrayList;

class Ark
{
    /* Ark attributes */
    private ArrayList<Couple> animals;
    private Supply food;

    /*
    *   Ark Class Constructor without parameters
    */
    public Ark()
    {
        animals = new ArrayList<>();
        food = new Supply();
    }

    /*
    *   Ark Class Constructor with parameters to init the Supply
    */
    public Ark(int meat_qte, int grass_qte)
    {
        animals = new ArrayList<>();
        food = new Supply(meat_qte, grass_qte);
    }

    /*
    *   Useless in this version.
    */
    public void navigate()
    {
        System.out.println("~~~...We all live in the ark...~~~");
    }

    /*
    *   closing the light make the animals thinks it's the night on the Ark
    */
    public void closeLights()
    {
        for (Couple c : animals)
        {
            c.nightlife();
        }
    }

    // Usefull getters
    /**
     * @return ArrayList<Couple> return the animals
     */
    public ArrayList<Couple> getAnimals() {
        return animals;
    }

    /**
     * @return Supply return the food
     */
    public Supply getFood() {
        return food;
    }

}