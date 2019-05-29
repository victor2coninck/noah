package story;

import java.util.Optional;

public abstract class Animal
{
    /* Animal attributs */
    protected Gender sex;
    protected String specie;
    protected int weight;
    protected int stamina;

    /*
    * Animal Class Constructor
    */
    public Animal(String specie, Gender sex, int weight)
    {
        this.specie = specie;
        this.sex = sex;
        this.weight = weight;
        this.stamina = 50;        
        System.out.format("A new %s %s is born !!!!!!\n", sex.toString(), specie);
    }

    /*
    *   eat()  : an Animal can eat and gain some stamina
    *   breed(): an Animal can reproduce itself with another Animal having the same specie and an opposed gender
    */
    protected abstract void eat();
    protected abstract Optional<Animal> breed(Animal partner);

    /*
    * Usefull getters
    */
    public int getWeight()
    {
        return this.weight;
    }

    public int getStamina()
    {
        return this.stamina;
    }

    public void setStamina(int value)
    {
        this.stamina = value;
    }

    public String getSpecie()
    {
        return this.specie;
    }
}