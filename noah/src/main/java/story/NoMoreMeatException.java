package story;

public class NoMoreMeatException extends Exception
{
    public NoMoreMeatException(String errorMessage)
    {
        super(errorMessage);                
        System.out.println("No more meat left !!!");
    }
}