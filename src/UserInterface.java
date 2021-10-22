import java.io.FileNotFoundException;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class UserInterface {
    private BeerBase application;

    public UserInterface(BeerBase application) {
        this.application = application;
    }

    public void start() {
        System.out.println("Welcome to BeerBase 2.01");


        Scanner input = new Scanner(System.in).useLocale(Locale.ENGLISH);
                                            // FIX så det ALTID er . i double!
        boolean running = true;
        while( running ) {
            System.out.println("""
                Make your selection:
                1) Create beer
                2) List all beers
                
                0) Exit application""");
            int selection = input.nextInt();
            input.nextLine();

            switch (selection) {
                case 0: exit();
                        running = false;
                        break;
                case 1: createBeer(input);
                        break;
                case 2: listBeers();
                        break;

            }
        }
    }

    private void exit() {
        try {
            application.exit();
            System.out.println("Filen er nu gemt - tak for i dag");
        } catch (FileNotFoundException e) {
            System.out.println("Der gik desværre noget galt under gemningen af filen");
            System.out.println("Alt dit arbejde er gået tabt");
        }
    }

    private void createBeer(Scanner scanner) {
        System.out.println("Let's create a beer - I need the name, the type and the alcohol percentage");

        System.out.print("Name: ");
        String beerName = scanner.nextLine();
        System.out.print("Type: ");
        String beerType = scanner.nextLine();
        System.out.print("Alcohol %");
        double alcohol = scanner.nextDouble();

        Beer beer = new Beer(beerName, beerType, alcohol);
        application.addBeer(beer);
    }

    private void listBeers() {
       List<Beer> beers = application.getListOfAllBeers();

       for(Beer beer : beers) {
           System.out.println(beer);
       }

    }
}
