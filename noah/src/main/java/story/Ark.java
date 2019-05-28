package story;

import java.util.ArrayList;

class Ark
{
    private ArrayList<Couple> animals;
    private Supply food;

    public Ark()
    {
        animals = new ArrayList<>();
        food = new Supply();
    }

    public Ark(int meat_qte, int grass_qte)
    {
        animals = new ArrayList<>();
        food = new Supply(meat_qte, grass_qte);
    }

    public void navigate()
    {
        System.out.println("~~~...We all live in the ark...~~~");
    }

    public void closeLights()
    {
        for (Couple c : animals)
        {
            c.nightlife();
        }
    }

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