public class Player {
// Class without encapsulation
// If we change something in this class we need to change it in other classes
// that use components of this class. So for example if we change the name of the
// field "name" to "fullName", every usage of that field in the other class must be
// changed
    public String fullName;
    public int health;
    public String weapon;

    public void loseHealth(int damage){
        this.health=this.health-damage;
        if(this.health<=0){
            System.out.println("Player knocked out");
            // Reduce number of lives remaining
        }
    }

    public int healthRemaining(){
        return this.health;
    }


}
