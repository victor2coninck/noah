package story;

public final class App {
    private App() {
    }

    public static void main(String[] args) {

        Carnivorous lion = new Carnivorous("lion", Gender.MALE, 150);
        Carnivorous lionne = new Carnivorous("lion", Gender.FEMALE, 125);

        Herbivorous boucM = new Herbivorous("bouc", Gender.MALE, 70);
        Herbivorous boucF = new Herbivorous("bouc", Gender.FEMALE, 60);

        Carnivorous loup = new Carnivorous("loup", Gender.MALE, 100);
        Carnivorous louve = new Carnivorous("loup", Gender.FEMALE, 80);

        Noah noah = new Noah(0, 0);
        noah.board(lion, lionne);
        noah.board(boucM, boucF);
        noah.board(loup, louve);

        try {
            noah.feed_animals();
        } catch (NoMoreMeatException e) {
            noah.fish();
        } catch (NoMoreGrassException e) {
            noah.crope();
        }

        loup.breed(louve);
        loup.breed(lion);
    }
}
