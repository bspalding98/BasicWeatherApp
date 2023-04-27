public class EnhancedPlayer {
    private String name;
    private int hitPoints = 100;   // Essentially when an instance is created this is default value. So if validation on line 8 fails. health will = 100 now instead of 0.
    private String weapon;

    public EnhancedPlayer(String name, int health, String weapon) { // Guaranteeing now that all these fields are initialised.
        this.name = name;
        if((health > 0) && (health <= 100)) {
            this.hitPoints = health;
        }
        this.weapon = weapon;
    }

    public void loseHealth(int damage) {
        this.hitPoints -= damage;
        if(this.hitPoints <= 0) {
            System.out.println("Player knocked out");
            // Reduce number of lives remaining for the player
        }
    }

    public void gainHealth(int rate) {
        this.hitPoints += rate;
        System.out.println("hitPoints increase to " + getHealth());
    }

    public int getHealth() {
        return hitPoints;
    }
}
