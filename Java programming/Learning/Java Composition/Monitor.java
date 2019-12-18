public class Monitor {

    private String model;
    private String manufacturer;
    private int size;
    private Resolution nativeResolution; // This is composition
    // The Resolution class is part of the monitor. A Monitor isn't a resolution
    // but a Monitor has a resolution, which is the nativeResolution.
    // The Resolution is a component of a Monitor

    public Monitor(String model, String manufacturer, int size, Resolution nativeResolution) {
        this.model = model;
        this.manufacturer = manufacturer;
        this.size = size;
        this.nativeResolution = nativeResolution;
    }

    public void drawPixelAt(int x, int y, String color){
        System.out.println("Drawing pixel at " + x + "," + y + " in color " + color);
    }

    public String getModel() {
        return model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public int getSize() {
        return size;
    }

    public Resolution getNativeResolution() {
        return nativeResolution;
    }
}
