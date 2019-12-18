
public class Room {
    private String roomName;
    private Windows windows;
    private Walls walls;
    private Carpets carpets;
    private Lamp lamp;

    public Room(String roomName, Windows windows, Walls walls, Carpets carpets, Lamp lamp) {
        this.roomName=roomName;
        this.windows = windows;
        this.walls = walls;
        this.carpets = carpets;
        this.lamp = lamp;
    }

    public void turnLightsOn(){
        lamp.powerOn();
    }

    public Lamp getLamp() {
        return lamp;
    }

    public Windows getWindows() {
        return windows;
    }

    public Walls getWalls() {
        return walls;
    }

    public Carpets getCarpets() {
        return carpets;
    }

    public String toString(){
        return roomName + "\n" + windows + walls + carpets + lamp;
    }
}
