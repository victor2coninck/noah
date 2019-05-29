package story;

public class NoMoreGrassException extends Exception
{
    // Exception trigger when the grass supply is at a critical level
    public NoMoreGrassException(String errorMessage)
    {
        super(errorMessage);
        System.out.println("No more grass for the veggies !!!");
    }
}