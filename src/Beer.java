public class Beer {
    private String beerName;
    private String brewery;
    private String beerType;
    private double alcohol;
    private double price;
    private double litresPrBottle;
    private int count;

    public Beer(String name, String beerType, double alcohol) {
        this.beerName = name;
        this.beerType = beerType;
        this.alcohol = alcohol;
    }

    public Beer(String CSVLine) {
        fromCSVString(CSVLine);
    }

    public String getBeerName() {
        return beerName;
    }

    public String getBeerType() {
        return beerType;
    }

    public double getAlcohol() {
        return alcohol;
    }

    @Override
    public String toString() {
        return beerName + " (" + beerType + ") " + alcohol + "%";
    }

    public String toCSVString() {
        return beerName + ";" + beerType + ";" + alcohol;
    }

    public void fromCSVString(String csvstring) {
        // TODO: parse/scan csvstring into attributes
    }
}
