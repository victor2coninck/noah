package story;

import java.util.Optional;

class Human extends Animal
{
    /*
    *   Human Class Constructor, inherit from Animal
    */
    public Human(Gender sex, int weight)
    {
        super("human", sex, weight);
    }


    /*
    *   A Human is praying before meals, wich gave him 100 stamina (useless in this version)
    *   He also is Omnivorous
    */
    @Override
    protected void eat()
    {
        System.out.println("'God bless this meal, Amen.'");
        stamina += 100;
    }

    /*
    *   A Human can copulate with another Human
    *   Note : Noah is the only Human in this version
    */
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