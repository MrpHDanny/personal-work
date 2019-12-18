public class Carpets {

    private int numberOfCarpets;
    private String carpetColor;
    private Size size;

    public Carpets(int numberOfCarpets, String carpetColor, Size size) {
        this.numberOfCarpets = numberOfCarpets;
        this.carpetColor = carpetColor;
        this.size = size;
    }

    public int getNumberOfCarpets() {
        return numberOfCarpets;
    }

    public String getCarpetColor() {
        return carpetColor;
    }

    public Size getSize() {
        return size;
    }

    public String toString(){
        return "Number of carpets: " + numberOfCarpets + " Carpet color: " + carpetColor + "Carpet size: " + size + "\n";
    }
}
