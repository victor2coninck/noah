package story;

public interface Passenger
{
    public void toEat(Supply food) throws NoMoreGrassException, NoMoreMeatException;
}