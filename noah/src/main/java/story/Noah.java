package story;

import java.util.concurrent.TimeUnit;

class Noah extends Human implements Passenger {
    public Noah() {
        super(Gender.MALE, 85);
        arche = new Ark();
    }

    public Noah(int meat_supply, int grass_supply) {
        super(Gender.MALE, 85);
        arche = new Ark(meat_supply, grass_supply);
    }

    private Ark arche;
    // colombe, tuer, pecher, repeupler, nourrir

    public void toEat(Supply food) throws NoMoreGrassException, NoMoreMeatException
    {
        int qte = this.eat() / 2;
        food.consume_grass(qte);
        food.consume_meat(qte);
    }

    public void feed_animals() throws NoMoreGrassException, NoMoreMeatException {
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

    public void fish() {
        System.out.println("\nNoah is fishing...");
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.format("Noah catch a fish! Adding it to the meat supply. We now have %d kg of good meat.\n\n", arche.getFood().add_meat(1));
    }

    public void crope()
    {
        System.out.println("\nNoah is croping the hay he grew..");
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.format("This was a nice harvest. We have %d of hay in supply !\n\n", arche.getFood().add_grass(5));
    }
}