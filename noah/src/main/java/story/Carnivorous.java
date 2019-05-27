package story;

import java.util.Optional;

class Carnivorous extends Animal
{
    public Carnivorous(String specie, Gender sex, int weight)
    {
        super(specie, sex, weight);
    }

    @Override
    protected int eat()
    {
        System.out.format("%s %s is eating GoOd mEaT!\n", sex.toString(), specie);
        return (int) (0.4 * weight);
    }

    @Override
    protected Optional<Animal> breed(Animal partner)
    {
        if (partner.specie == this.specie)
        {
            System.out.println("...love is in motion...");
            Carnivorous bb = new Carnivorous(this.specie, Gender.getRandomGender(), this.weight);
            return Optional.of(bb);
        }
        return Optional.empty();
    }
}