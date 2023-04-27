import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Player tim = new Player("Tim", 10, 15);
        System.out.println(tim.toString());
        saveObject(tim);

        tim.setHitPoints(8);
        System.out.println(tim);        // toString() will be assumed if you do not enter it
        tim.setWeapon("StormBringer");
        saveObject(tim);
//        loadObject(tim);
        System.out.println(tim);

        ISaveable werewolf = new Monster("Werewolf", 20, 40);
//        werewolf.getStrength();   // Even though this getter is created this still doesn't work
//        DO LINE BELOW
        System.out.println(((Monster) werewolf).getStrength()); // This is because you have declared were as type interface.
        System.out.println(werewolf);
        saveObject(werewolf);
    }

    public static ArrayList<String> readValues() {
        ArrayList<String> values = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        int index = 0;
        System.out.println("Choose\n" +
                "1 To enter a string\n" +
                "0 to quit");

        while(!quit) {
            System.out.println("Choose an option");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch(choice) {
                case 0: quit = true; break;
                case 1:
                    System.out.println("Enter a string: ");
                    String stringInput = scanner.nextLine();
                    values.add(index, stringInput);
                    index ++;
                    break;
            }
        }
        return values;
    }

    public static void saveObject(ISaveable objectToSave) {     // Can save any object now with ISaveable implemented
        for(int i = 0; i < objectToSave.write().size(); i ++) {     // Returns the size of class and then saves each one below with get(i)
            System.out.println("Saving " + objectToSave.write().get(i) + " to storage device");
        }
    }

    public static void loadObject(ISaveable objectToLoad) {     // Pretty much reads values from player class method and stores the information to be later saved again.
        List<String> values = readValues();
        objectToLoad.read(values);
    }
}
