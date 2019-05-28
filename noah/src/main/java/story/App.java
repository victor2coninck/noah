package story;

public final class App {
    private App() {
    }

    public static void main(String[] args) {

        Carnivorous lion = new Carnivorous("LION", Gender.MALE, 150);
        Carnivorous lionne = new Carnivorous("LION", Gender.FEMALE, 125);

        Herbivorous boucM = new Herbivorous("BOUC", Gender.MALE, 70);
        Herbivorous boucF = new Herbivorous("BOUC", Gender.FEMALE, 60);

        Carnivorous loup = new Carnivorous("LOUP", Gender.MALE, 100);
        Carnivorous louve = new Carnivorous("LOUP", Gender.FEMALE, 80);

        Carnivorous varrantM = new Carnivorous("VARRANT", Gender.MALE, 10);
        Carnivorous varrantF = new Carnivorous("VARRANT", Gender.FEMALE, 10);

        Noah noah = new Noah(1000, 100);

        noah.board(lion, lionne);
        noah.board(boucM, boucF);
        noah.board(loup, louve);
        noah.board(varrantM, varrantF);

        int i = 0;
        boolean end = false;
        while (!end){
            try {
                System.out.format("\n~~~~~~~~~~>DAY #%d: MEAT:%dkg | GRASS:%dkg | BREEDING:%dp\n", i,
                                                noah.getArche().getFood().getMeat_supply(),
                                                noah.getArche().getFood().getGrass_supply(),
                                                noah.getBreeding().size());
                noah.morningRoutine();
                noah.feed_animals();
            } catch (NoMoreMeatException e) {
                if (!noah.fish())
                    noah.createMeat();
            } catch (NoMoreGrassException e) {
                noah.crope();
            }
            i++;
            noah.sleep();
            if (noah.getArche().getFood().status() && noah.getBreeding().isEmpty())
            {
                System.out.println("\n\n\nNOAH YOU FAILED ! KGRZGKZZG *God thunder*\n");
                end = true;
            }
        }
    }
}