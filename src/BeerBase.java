import java.io.FileNotFoundException;
import java.util.List;

public class BeerBase {

    private Database db;
    private UserInterface ui;

    public BeerBase() {
        db = new Database();
        ui = new UserInterface(this);
    }

    public void addBeer(Beer beer) {
        db.addBeer(beer);
    }

    public void start() {
        ui.start();
    }

    public void exit() throws FileNotFoundException {
        db.saveToFile();
    }

    public static void main(String[] args) {
        BeerBase beerBase = new BeerBase();
        beerBase.start();
    }

    public List<Beer> getListOfAllBeers() {
        return db.getListOfAllBeers();
    }
}
