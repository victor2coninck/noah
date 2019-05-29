package story;

import java.util.Random;

/* Gender enum provide a value for each Animal's gender, and also a method to randomly choose a gender */
public enum Gender
{
    MALE, FEMALE;

    public static Gender getRandomGender()
    {
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }
}