package story;

/*
*   A passenger eat the Ark's supply
*/
public interface Passenger
{
    public void toEat(Supply food) throws NoMoreGrassException, NoMoreMeatException;
}