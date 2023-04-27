// WHY generics
// The earlier the bug is spotted. The easier and cheaper it is to fix. -> best less resources and man power to fix the error
// Generics help stop this by trying to get the little things done at the start. Because things can compile fine but still break at production

// CAN ALSO pass interfaces in where Player class was for Team type
// Multiple bounds same as class extends and interface. Only one class, and then multiple interfaces but extend class first.

public class Main {

    public static void main(String[] args) {
        FootballPlayer joe = new FootballPlayer("Joe");
        BaseballPlayer pat = new BaseballPlayer("Pat");
        SoccerPlayer beckham = new SoccerPlayer("Beckham");

//        Team adelaideCrows = new Team("Adelaide Crows");
        Team<FootballPlayer> adelaideCrows = new Team<>("Adelaide Crows");  // Fix the Team generic setup and now ensures FootballPlayer only is added to this team.
        adelaideCrows.addPlayer(joe);
//        adelaideCrows.addPlayer(pat);
//        adelaideCrows.addPlayer(beckham);

        System.out.println(adelaideCrows.numPlayer());

        // CODE ABOVE
        // Has a bug. There is no error but you can add different sport players from different sports to the same team...
        // Could make 3 differ team classes. However a lot of duplicated code and you want to reduce that if possible
        // Could extend the team, but then you need to implement functionality to make it unique to be useful that way.

        // we instead modify Team to be a generic class.
        // Everything commented out in Team was the old code and the code below was the changed code to make it generic. Or if more code added and not change. '*' above it.


        Team<BaseballPlayer> baseballTeam = new Team<>("Chicago Cubs"); // Like a IF statement sort of
        baseballTeam.addPlayer(pat);

        // CODE ABOVE
        // Problem atm is that you can pass in any Team Type. There is no validation for it.
        // EG
//        Team<String> brokenTeam = new Team<>("this won't work");
//        brokenTeam.addPlayer("No-one");
        // THE CODE ABOVE shows no error but when it runs. It creates and exception. Because in Team.addPlayer() It casts a (PLayer)
        //Ned to restrict Team<T> type.
        // Called bounded type parameters. changing Team<T>  to Team<T extends Players> now throws an error for Team<String> above as it is not a Player type

        Team<SoccerPlayer> brokenTeam = new Team<>("this won't work");
//        brokenTeam.addPlayer("No-one");
        // ABOVE CODE
        // Still throws an error because we are passing a String and we need to pass a type Player. So player class or subclass or player. to fix.
        brokenTeam.addPlayer(beckham);



        Team<FootballPlayer> melbourne = new Team<>("Melbourne");
        FootballPlayer banks = new FootballPlayer("Gordon");
        melbourne.addPlayer(banks);

        Team<FootballPlayer> hawthorn = new Team<>("Hawthorn");
        Team<FootballPlayer> fremantle = new Team<>("Fremantle");

        hawthorn.matchResult(fremantle, 1, 0);
        hawthorn.matchResult(adelaideCrows, 3, 8);

        adelaideCrows.matchResult(fremantle, 2, 1);
//        adelaideCrows.matchResult(baseballTeam, 1, 1);
        // CODE ABOVE error because it is different teams.

        System.out.println("Rankings");
        System.out.println(adelaideCrows.getName() + ": " + adelaideCrows.ranking());
        System.out.println(melbourne.getName() + ": " + melbourne.ranking());
        System.out.println(fremantle.getName() + ": " + fremantle.ranking());
        System.out.println(hawthorn.getName() + ": " + hawthorn.ranking());

        System.out.println(adelaideCrows.compareTo(melbourne));
        System.out.println(adelaideCrows.compareTo(hawthorn));
        System.out.println(hawthorn.compareTo(adelaideCrows));
        System.out.println(melbourne.compareTo(fremantle));


        League<Team<FootballPlayer>> footballLeague = new League<>("AFL");
        footballLeague.add(melbourne);
        footballLeague.add(adelaideCrows);
        footballLeague.add(fremantle);
        footballLeague.add(hawthorn);
        footballLeague.showLeagueTable();

    }

}
