public class Main {

    public static void main(String[] args) {
//        Player player = new Player();
//        player.name = "Boyd";   // Problem: Player -> line 3
//        player.health = 20;     // If this is forgotten health starts at 0 automatically. constructors ensure they are not missed as you must pass in all parameters to make it work.
//        player.weapon = "Sword";
////        Can also forget to initialise them and when the class is then called for the first time. There won't be any health.
////        Also they can manually access them without validation like Max health in Player class. Will be bypassed because you can access it at this level.
////        This is what encapsulation is. STOPS UNAUTHORISED ACCESS
//
//        int damage = 10;
//        player.loseHealth(damage);
//        System.out.println("Remaining health = " + player.healthRemaining());
//
//        damage = 11;
//        player.health = 200; // Not good because we can change the rules and change health here where you only want it in the class method in Player. Takes control out of player class
////        Adding a constructor stops this because you need to update it through the class then i think.
//        player.loseHealth(damage);
//        System.out.println("Remaining health = " + player.healthRemaining());

        EnhancedPlayer player = new EnhancedPlayer("Boyd", 501, "Sword");
        System.out.println("Initial health is " + player.getHealth());  // Now if EnhancePlayer class health name was changed. it would not break where as before it would.
//        Can also not changed health. Only way to reduce the health is use the losehealth();

        player.gainHealth(100);
    }
}
