package story;

import java.util.Optional;

class Human extends Animal
{
    public Human(Gender sex, int weight)
    {
        super("human", sex, weight);
    }

    @Override
    protected int eat()
    {
        System.out.println("Eating a ²good meal");
        return (int) 0.05*weight;
    }

    @Override
    protected Optional<Animal> breed(Animal partner)
    {
        if (partner.specie == this.specie)
        {
            System.out.println("...love is in motion...");
            Human bb = new Human(Gender.getRandomGender(), this.weight);
            return Optional.of(bb);
        }
        return Optional.empty();
    }
}