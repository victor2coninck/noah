package story;

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
    }

    private Animal male;
    private Animal female;

    public void toEat(Supply food) throws NoMoreGrassException, NoMoreMeatException
    {
        int qte = male.eat();
        qte += female.eat();
        if (male instanceof Carnivorous)
        {
            food.consume_meat(qte);
        }
        else
            food.consume_grass(qte);
    }
}