package story;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Random;
import java.util.concurrent.TimeUnit;

class Noah extends Human implements Passenger {

    private Ark arche;
    private LinkedList<Couple> breeding;

    public Noah() {
        super(Gender.MALE, 85);
        arche = new Ark();
        breeding = new LinkedList<>();
    }

    public Noah(int meat_supply, int grass_supply) {
        super(Gender.MALE, 85);
        arche = new Ark(meat_supply, grass_supply);
        breeding = new LinkedList<>();
    }

    public void toEat(Supply food) throws NoMoreGrassException, NoMoreMeatException
    {
        int qte = (int)(this.weight * 0.2) / 2;
        food.consume_grass(qte);
        food.consume_meat(qte);
        eat();
    }

    public void createMeat()
    {
        Couple x = null;
        try {
            x = breeding.pop();
        } catch (NoSuchElementException e)
        {
            System.out.println("Cannot breed meat either...");
            return;
        }
        Animal xx = x.getBaby().get();
        x.setBaby(Optional.empty());
        arche.getFood().add_meat(xx.getWeight());
    }

    public void feed_animals() throws NoMoreGrassException, NoMoreMeatException{
        for (Couple c : arche.getAnimals()) {
            c.toEat(arche.getFood());
        }
    }

    public void board(Couple couple) {
        arche.getAnimals().add(couple);
        System.out.println("New couple boarded!");
    }

    public void board(Animal male, Animal female) {
        arche.getAnimals().add(new Couple(male, female));
        System.out.println("New couple boarded!");
    }

    public boolean fish() {
        System.out.println("Noah is fishing...");
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Random random = new Random();
        if (random.nextInt() % 2 == 0) 
        {
            System.out.println("No fish those days...");
            return false;
        }
        System.out.format("Noah catch a fish! Adding it to the meat supply. We now have %d kg of good meat.\n", arche.getFood().add_meat(1));
        return true;
    }

    public void crope()
    {
        System.out.println("Noah is croping the hay he grew..");
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.format("This was a nice harvest. We have %d of hay in supply !\n", arche.getFood().add_grass(5));
    }

    /**
     * @return Ark return the arche
     */
    public Ark getArche() {
        return arche;
    }

    public LinkedList<Couple> getBreeding()
    {
        return breeding;
    }

    public void morningRoutine() throws NoMoreGrassException, NoMoreMeatException
    {
        toEat(this.arche.getFood());
        for (Couple c : arche.getAnimals())
        {
            if (c.getBaby().isPresent())
            {
                System.out.format("Noah is amazed by this cute %s baby ! *.*\n", c.getMale().getSpecie());
                if (!breeding.contains(c))
                    breeding.add(c);
            }
        }
    }

    public void sleep()
    {
        arche.closeLights();
        System.out.println("Sun is going down...");
    }
}