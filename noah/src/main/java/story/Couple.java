package story;

import java.util.Optional;

class Couple implements Passenger
{
    public Couple(Animal male, Animal female)
    {
        if (male.sex.equals(female.sex) || !male.specie.equals(female.specie))
        {
            throw new IllegalArgumentException("One tries to create a non-compatible couple");
        }

        this.male = male;
        this.female = female;
        this.baby = Optional.empty();
    }

    private Animal male;
    private Animal female;
    private Optional<Animal> baby;

    public void toEat(Supply food) throws NoMoreGrassException, NoMoreMeatException
    {
        if (male instanceof Carnivorous)
        {
            int qte = (int)(0.3 * male.getWeight());
            food.consume_meat(qte);
        }
        else
        {
            int qte = (int)(0.5 * male.getWeight());
            food.consume_grass(qte);
        }
        male.eat();
        female.eat();
    }

    public void nightlife()
    {
        if ((!baby.isPresent()) && (male.getStamina() + female.getStamina() >= 250))
        {
            baby = male.breed(female);
        }
        male.setStamina(10);
        female.setStamina(10);
    }

    /**
     * @return Animal return the male
     */
    public Animal getMale() {
        return male;
    }

    /**
     * @return Animal return the female
     */
    public Animal getFemale() {
        return female;
    }

    /**
     * @return Optional<Animal> return the baby
     */
    public Optional<Animal> getBaby() {
        return baby;
    }

    public void setBaby(Optional<Animal> value)
    {
        baby = value;
    }

}