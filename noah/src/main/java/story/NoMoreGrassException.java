package story;

public class NoMoreGrassException extends Exception
{

    public NoMoreGrassException(String errorMessage)
    {
        super(errorMessage);
        System.out.println("No more grass for the veggies !!!");
    }
}