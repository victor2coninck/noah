package story;

import java.util.Optional;

class Herbivorous extends Animal
{
    /*
    *   Herbivorous Class Constructor, inherit from Animal Class
    */
    public Herbivorous(String specie, Gender sex, int weight)
    {
        super(specie, sex, weight);
    }

    /*
    *   Herbivorous are eating MEAT and their consumtion ratio is 1/2 of their weight
    */
    @Override
    protected void eat()
    {
        System.out.format("%s %s is eating veggies!\n", sex.toString(), specie);
        stamina += (int) (0.5 * weight);
    }

    /*
    *   Herbivorous descendence is herbivorous
    */
    @Override
    protected Optional<Animal> breed(Animal partner)
    {       
        if (partner.specie == this.specie)
        {
            System.out.println("...love is in motion...");
            Herbivorous bb = new Herbivorous(this.specie, Gender.getRandomGender(), this.weight);
            return Optional.of(bb);
        }
        System.out.println("Ungodly action attempted...");
        return Optional.empty();
    }
}