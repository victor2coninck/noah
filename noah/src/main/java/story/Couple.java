package story;

import java.util.Optional;

class Couple implements Passenger
{
    /* Couple attributs */
    private Animal male;
    private Animal female;
    private Optional<Animal> baby;

    /*
    *   Couple Class Constructor, implements Passenger interface
    *   A couple must contains two Animal of different gender but same species
    */
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

    /*
    *   Each animal EAT and CONSUME supply from the Ark
    */
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

    /*
    *   When the stamina is full, a Couple can breed a baby during night
    */
    public void nightlife()
    {
        if ((!baby.isPresent()) && (male.getStamina() + female.getStamina() >= 250))
        {
            baby = male.breed(female);
        }
        male.setStamina(10);
        female.setStamina(10);
    }

    //getters and setters

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