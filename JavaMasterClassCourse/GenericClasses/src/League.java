import java.util.ArrayList;
import java.util.Collections;

public class League<T extends Team<?>> {   // So Team or any subclass type is allowed
    public String name;
    private ArrayList<T> league = new ArrayList<>();

    public League(String name) {
        this.name = name;
    }

    public boolean add(T team) {
        if(league.contains(team)) {
            System.out.println(team.getName() + " is already in the table");
            return false;
        } else {
            league.add(team);
            return true;
        }
    }

    public void showLeagueTable() {
        Collections.sort(league);   // Works as since we extend from team. It use the compareTo function in their.
        for(T t : league) {
            System.out.println(t.getName() + ": " + t.ranking());
        }
    }

}
