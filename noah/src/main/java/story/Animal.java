package story;

import java.util.Optional;

public abstract class Animal
{
    protected Gender sex;
    protected String specie;
    protected int weight;
    protected int stamina;

    public Animal(String specie, Gender sex, int weight)
    {
        this.specie = specie;
        this.sex = sex;
        this.weight = weight;
        this.stamina = 0;        
        System.out.format("A new %s %s is born !!!!!!\n", sex.toString(), specie);
    }

    //return how much it ate.
    protected abstract void eat();
    protected abstract Optional<Animal> breed(Animal partner);

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