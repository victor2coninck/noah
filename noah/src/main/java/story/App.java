package story;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public final class App {
    private App() {
    }

    public static void main(String[] args) throws FileNotFoundException 
    {
        Scanner sc = new Scanner(new File(args[0]));
        sc.useDelimiter("\n");
        int meat = Integer.parseInt(sc.next());
        int herb = Integer.parseInt(sc.next());
        Noah noah = new Noah(meat, herb);
        while (sc.hasNext())
        {
            String line = sc.next();
            Scanner mini_sc = new Scanner(line);
            Animal eva = null;
            Animal adam = null;
            mini_sc.useDelimiter(":");
            String token = mini_sc.next();
            if (token.equals("h"))
            {
                String specie = mini_sc.next();
                int weight = Integer.parseInt(mini_sc.next());
                adam = new Herbivorous(specie, Gender.MALE, weight);
                eva = new Herbivorous(specie, Gender.FEMALE, (int) (weight * 0.8));
            }
            if (token.equals("c"))
            {
                String specie = mini_sc.next();
                int weight = Integer.parseInt(mini_sc.next());
                adam = new Carnivorous(specie, Gender.MALE, weight);
                eva = new Carnivorous(specie, Gender.FEMALE, (int) (weight * 0.8)); 
            }
            noah.board(adam, eva);
            mini_sc.close();
        }
        sc.close();
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
                System.out.println("\n\n\nNOAH YOU FAILED ! NO FOOD LEFT grrrr KGRZGKZZG *God thunder*\n");
                end = true;
            }
        }
    }
}        /*Carnivorous lion = new Carnivorous("LION", Gender.MALE, 150);
Carnivorous lionne = new Carnivorous("LION", Gender.FEMALE, 125);

Herbivorous boucM = new Herbivorous("BOUC", Gender.MALE, 70);
Herbivorous boucF = new Herbivorous("BOUC", Gender.FEMALE, 60);

Carnivorous loup = new Carnivorous("LOUP", Gender.MALE, 100);
Carnivorous louve = new Carnivorous("LOUP", Gender.FEMALE, 80);

Carnivorous varrantM = new Carnivorous("VARRANT", Gender.MALE, 10);
Carnivorous varrantF = new Carnivorous("VARRANT", Gender.FEMALE, 10);

Noah noah = new Noah(1000, 1000);

noah.board(lion, lionne);
noah.board(boucM, boucF);
noah.board(loup, louve);
noah.board(varrantM, varrantF);
*/
