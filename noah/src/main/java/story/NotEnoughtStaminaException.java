package story;

public class NotEnoughtStaminaException extends Exception
{
    // Exception trigger when Noah stamina is at a critical level : Not Used in this version
    public NotEnoughtStaminaException()
    {
        super();                
        System.out.println("Not enought energie to do this action, eat something!!!");
    }
}