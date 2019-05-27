package story;

import java.util.Optional;

public abstract class Animal
{
    protected Gender sex;
    protected String specie;
    protected int weight;

    public Animal(String specie, Gender sex, int weight)
    {
        this.specie = specie;
        this.sex = sex;
        this.weight = weight;        
        System.out.format("A new %s %s is born !\n", sex.toString(), specie);
    }

    //return how much it ate.
    protected abstract int eat();
    protected abstract Optional<Animal> breed(Animal partner);

    public int getWeight()
    {
        return this.weight;
    }
}