package story;

public class NotEnoughtStaminaException extends Exception
{
    public NotEnoughtStaminaException()
    {
        super();                
        System.out.println("Not enought energie to do this action, eat something!!!");
    }
}