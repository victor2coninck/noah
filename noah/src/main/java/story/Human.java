package story;

import java.util.Optional;

class Human extends Animal
{
    public Human(Gender sex, int weight)
    {
        super("human", sex, weight);
    }

    @Override
    protected void eat()
    {
        System.out.println("Eating a good meal");
        stamina += 100;
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