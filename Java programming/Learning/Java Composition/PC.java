public class PC {
    private Case theCase;
    private Monitor monitor;
    private Motherboard motherboard;

// This class demonstrates composition
// The PC has a case, monitor and a motherboard
// If we use standard Java inheritance we are limited to extending one class only
// This way, however, we are using three other java classes in one class.

    public PC(Case theCase, Monitor monitor, Motherboard motherboard) {
        this.theCase = theCase;
        this.monitor = monitor;
        this.motherboard = motherboard;

    }

    public void powerUp(){
        theCase.pressPowerButton(); // references the case object
        drawLogo();
    }

    private void drawLogo(){
        // fancy graphics
        monitor.drawPixelAt(1200,50,"Yellow"); // references the monitor object and its method

    }
//    private Case getTheCase() {
//        return theCase;
//    }
//
//    private Monitor getMonitor() {
//        return monitor;
//    }
//
//    private Motherboard getMotherboard() {
//        return motherboard;
//    }
// We don't need those getters if don't plan on using methods in these objects
// in the main class
}
