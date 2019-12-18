public class Main {

    public static void main(String[] args) {
        // Encapsulation is the mechanism that allows you to restrict
        // access to certain components in the objects you're creating
//
//        Player player = new Player();
//        player.name="Danny";
//        player.health = 20;
//        player.weapon = "Sword";
//
//        int damage = 10;
//        player.loseHealth(damage);
//        System.out.println("Remaining health: " + player.healthRemaining());
//
//        damage = 11;
//        player.health=200;
//        player.loseHealth(damage);
//        System.out.println("Remaining health: " + player.healthRemaining());
//

        EnhancedPlayer player = new EnhancedPlayer("Danny", 200,"Sword");
        System.out.println("Initial health: " + player.getHealth());





    }
}
