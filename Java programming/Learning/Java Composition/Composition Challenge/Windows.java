public class Windows {
    private int numberOfWindows;
    private Size size;

    public Windows(int numberOfWindows, Size size) {
        this.numberOfWindows = numberOfWindows;
        this.size = size;
    }

    public int getNumberOfWindows() {
        return numberOfWindows;
    }

    public Size getSize() {
        return size;
    }

    public String toString(){
        return "Number of windows: " + numberOfWindows + " Window size: " + size + "\n";
    }
}
