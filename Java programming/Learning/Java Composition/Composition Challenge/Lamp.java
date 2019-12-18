public class Lamp {
    private int heigth;
    private String color;

    public Lamp(int heigth, String color) {
        this.heigth = heigth;
        this.color = color;
    }

    public void powerOn(){
        System.out.println("Lamp turned on");
    }

    public int getHeigth() {
        return heigth;
    }

    public String getColor() {
        return color;
    }

    public String toString(){
        return "Lamp height: " + heigth + " Lamp color: " + color + "\n";
    }
}
