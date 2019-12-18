public class House {

    public static void main(String[] args) {
        Lamp lamp = new Lamp(2,"black");
        Windows windows = new Windows(1, new Size(1,2));
        Walls walls = new Walls("Green", new Size(3,3));
        Carpets carpets = new Carpets(1,"Blue", new Size(1,1));

        Room myRoom = new Room("Bedroom",windows,walls,carpets,lamp);

        myRoom.getLamp().powerOn(); //A method accessed via getter
        myRoom.turnLightsOn(); //A method that hides the lamp object
        System.out.println(myRoom);

    }
}
