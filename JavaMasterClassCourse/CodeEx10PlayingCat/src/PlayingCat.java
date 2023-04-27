public class PlayingCat {

    public static boolean isCatPlaying(boolean summer, int temperature){
        return (!summer && (temperature >= 25) && (temperature <= 35)) ||
                (summer && (temperature >= 25) && (temperature <= 45));

//        A lot better way to do it with ternary operator

//        return ((temperature >= 25) && (temperature <= (summer ? 45 : 35)));
    }
}
