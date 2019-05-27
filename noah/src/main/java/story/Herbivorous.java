package story;

import java.util.Optional;

class Herbivorous extends Animal
{
    public Herbivorous(String specie, Gender sex, int weight)
    {
        super(specie, sex, weight);
    }

    @Override
    protected int eat()
    {
        System.out.format("%s %s is eating veggies!\n", sex.toString(), specie);
        return (int) (0.5 * weight);
    }

    @Override
    protected Optional<Animal> breed(Animal partner)
    {       
        if (partner.specie == this.specie)
        {
            System.out.println("...love is in motion...");
            Herbivorous bb = new Herbivorous(this.specie, Gender.getRandomGender(), this.weight);
            return Optional.of(bb);
        }
        return Optional.empty();
    }
}