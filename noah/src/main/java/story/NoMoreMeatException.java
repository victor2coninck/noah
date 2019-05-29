package story;

public class NoMoreMeatException extends Exception
{
    // Exception trigger when the meat supply is at a critical level
    public NoMoreMeatException(String errorMessage)
    {
        super(errorMessage);                
        System.out.println("No more meat left !!!");
    }
}