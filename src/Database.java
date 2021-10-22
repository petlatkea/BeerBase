import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Database {

    private ArrayList<Beer> listen;

    public Database() {
        listen = new ArrayList<>();
        loadFromFile();
    }

    public void addBeer(Beer beer) {
        listen.add(beer);
    }

    public void saveToFile() throws FileNotFoundException {
        // Lav en ny fil
        File fil = new File("beers.csv");
        PrintStream ps = null;
        ps = new PrintStream(fil);

        // loop igennem listen af beers
        for(Beer beer : listen) {
            // skriv hver beer til filen
            ps.println(beer.toCSVString());
        }
    }

    private void loadFromFile() {
        // Åbn en fil
        // Læs hver linje i filen
        try {
            File fil = new File("beers.csv");
            Scanner reader = new Scanner(fil);

            while(reader.hasNext()) {
                String line = reader.nextLine();
                // Opret et Beer objekt for hver linje
                Beer beer = new Beer(line);
                listen.add(beer);
            }
        } catch (FileNotFoundException e) {
            // No file found - just ignore, and start with empty database!
            listen.clear();
        }
    }

    public List<Beer> getListOfAllBeers() {
        return listen;
    }
}
