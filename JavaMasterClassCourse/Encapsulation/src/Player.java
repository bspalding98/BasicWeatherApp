public class Player {

    public String fullName; // Changing this should not affect anything. but effects main because it is trying to access it directly.
//    So you need to change it in main as well if you do it here
    public int health;
    public String weapon;

    public void loseHealth(int damage) {
        this.health -= damage;
        if(this.health <= 0) {
            System.out.println("Player knocked out");
            // Reduce number of lives remaining for the player
        }
    }

    public int healthRemaining() {
        return this.health;
    }
}
