import java.util.ArrayList;

//public class Team {
//public class Team<T> {  // When we instantiate a class now. The "T" will be replaced automatically with the real type using when instantiating. SAME FOR BELOW
//public class Team<T extends Player> { // Further validation that only types Player types can be added. So manys will except any type that extends from Player of a subclass of Player
public class Team<T extends Player> implements Comparable<Team<T>>{ // used a public Java built in interface to compare only certain types which was passed in. if was no <T> it could compare differ teams in the table

    private String name;
    int played = 0; // Where are these available?
    int won = 0;
    int lost = 0;
    int tied = 0;

//    private ArrayList<Player> members = new ArrayList<>();
    private ArrayList<T> members = new ArrayList<>();


    public Team(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

//    public boolean addPlayer(Player player) {   // Allows us to pass a baseball, football, and soccer player due to extending abstract class
    public boolean addPlayer(T player) {
        if (members.contains(player)) {
//                System.out.println(((Player) player).getName() + " is already on the team");   // getName() is false until you create an instance in main or cast ((PLayer) player)
            // Because since T is generic compiler doesn't know if T actually has a getName() until it is created in main
            System.out.println(player.getName() + " is already on the team");   // Now knows Type T extends from Player so will have all it's methods.
            return false;
        } else {
            members.add(player);
//               System.out.println(((Player) player).getName() + " picked for team " + this.name);
            System.out.println(player.getName() + " picked for team " + this.name);
            return true;
        }
    }


    public int numPlayer() {
        return this.members.size();
    }

//    public void matchResult(Team opponent, int ourScore, int theirScore) {
    public void matchResult(Team<T> opponent, int ourScore, int theirScore) {   // Make this happen so you can only do match results of same sports.

        String message;
        if(ourScore > theirScore) {
            won ++;
            message = " Beat ";
        }
        else if(ourScore == theirScore) {
            tied ++;
            message = " Drew with ";
        }
        else {
            lost ++;
            message = " Lost to ";
        }
        played ++;

        if(opponent != null) {
            System.out.println(this.getName() + message + opponent.getName());      // VERY GOOD TO NOT USE PRINT LINE A LOT
            opponent.matchResult(null, theirScore, ourScore);  // So basically also updates the opponents team matchResults if they exist.
        }
                                                                                         // Think realistically you would check if they exist before adding a win, etc. logically anyways.
    }

    public int ranking() {
        return (won * 2) + tied;    // 2 points for a win, 1 for a tie.
    }

    @Override
    public int compareTo(Team<T> team) {
        if(this.ranking() > team.ranking()) {
            return -1;
        } else if(this.ranking() < team.ranking()) {
            return 1;
        }
        return 0;
    }
}
