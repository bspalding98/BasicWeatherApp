import java.util.*;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<Album> albums = new ArrayList<Album>();

    public static void main(String[] args) {

        Album album = new Album("Stormbringer", "Deep Purple");
        album.addSong("Stormbringer", 4.6);
        album.addSong("Love don't mean a thing", 4.22);
        album.addSong("Holy man", 4.3);
        album.addSong("Hold on", 5.6);
        album.addSong("Lady double dealer", 3.21);
        album.addSong("You can't do it right", 6.23);
        album.addSong("High ball shooter", 4.27);
        album.addSong("The gypsy", 4.6);
        album.addSong("Soldier of fortune", 4.6);
        albums.add(album);

        album = new Album("For those about to rock", "AC/DC");
        album.addSong("For those about to rock", 5.44);
        album.addSong("I put the finger on you", 3.25);
        album.addSong("Lets go", 3.45);
        album.addSong("Inject the venom", 3.33);
        album.addSong("Snowballed", 4.51);
        album.addSong("Evil walks", 3.45);
        album.addSong("C.O.D.", 5.25);
        album.addSong("breaking the rules", 5.32);
        album.addSong("Night of the long knives", 5.12);
        albums.add(album);

        LinkedList<Song> playList = new LinkedList<>();
        albums.get(0).addToPlayList("You can't do it right", playList);
        albums.get(0).addToPlayList("Holy man", playList);
        albums.get(0).addToPlayList("Speed King", playList);    // Does not exist
        albums.get(0).addToPlayList(9, playList);
        albums.get(1).addToPlayList(8, playList);
        albums.get(1).addToPlayList(3, playList);
        albums.get(1).addToPlayList(2, playList);
        albums.get(1).addToPlayList(24, playList);  // Does not exist

        play(playList);
    }

    private static void play(LinkedList<Song> playList) {
        ListIterator<Song> listIterator = playList.listIterator();
        boolean quit = false;
        boolean goingForward = true;
        if(playList.isEmpty()) {
            System.out.println("You have no songs in the playlist");
            quit = true;    // Without this. Even if there is no playList. It will still run the while loop below and ask for input to change song, etc.
        } else {
            System.out.println("Now playing: " + listIterator.next());
            printMenu();
        }

        while(!quit) {
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 0: quit = true; break;
                case 1:
                    if(!goingForward) {
                        if(listIterator.hasNext()) {    // Same as line 83 comment
                            listIterator.next();
                        }
                        goingForward = true;
                    }
                    if(listIterator.hasNext()) {
                        System.out.println("Skipped to next song: " + listIterator.next());
                    } else {
                        System.out.println("You are at the end of the playlist");
                        goingForward = false;
                    }
                    break;
                case 2:
                    if(goingForward) {
                        if(listIterator.hasPrevious()) {    // Used to check if it at start. If at start and still do .previous() will error.
                            listIterator.previous();
                        }
                        goingForward = false;
                    }
                    if(listIterator.hasPrevious()) {
                        System.out.println("Back to previous song: " + listIterator.previous());
                    } else {
                        System.out.println("You are at the start of the playList");
                        goingForward = true;
                    }
                    break;
                case 3:
                    if(goingForward) {
                        if(listIterator.hasPrevious()) {    // Same as above one
                            System.out.println(listIterator.previous());
//                            listIterator.next();
                            // Line below is so much better as it makes more sense and does not need to move the position again.
                            goingForward = false;
                        } else {
                            System.out.println("We are at the start of the list");
                        }
                    } else {
                        if(listIterator.hasNext()) {    // Same as above one
                            System.out.println(listIterator.next());
//                            listIterator.previous();
                            goingForward = true;
                        } else {
                            System.out.println("We are at the end of the list");
                        }
                    }
                    break;
                case 4: printList(playList); break;
                case 5: printMenu(); break;
                case 6:
                    if(playList.size() > 0) {   // Need to still test larger than 0 even though done it above because we could delete all songs with this
                        listIterator.remove();
                        if(listIterator.hasNext()) System.out.println("Now playing " + listIterator.next());
                        else if(listIterator.hasPrevious()) System.out.println("Now playing " + listIterator.hasPrevious());
                    }
                    break;
            }
        }
        System.out.println("Quitting");
    }

    private static void printMenu() {
        System.out.println("Choose menu options:\n" +
                "0 -> Quit\n" +
                "1 -> Next Song\n" +
                "2 -> Previous Song\n" +
                "3 -> Replay current Song\n" +
                "4 -> Print playlist\n" +
                "5 -> Print options again\n" +
                "6 -> Delete current song from playlist");
    }

    private static void printList(LinkedList<Song> playList) {
        Iterator<Song> iterator = playList.iterator(); // Do not need listIterator as you do not need to go backwards. This is perfect for looping through just once.
        System.out.println("=========================");
        for(int i = 0; i < playList.size(); i ++) {
            System.out.println(("[" + (i + 1) + "]\t" + iterator.next()));
        }
        System.out.println("=========================");

//        for(Song s : playList) {
//        System.out.println(s);
//        }
        // This code below is better if do not need number. Or can do . while(iterator.hasnext()) { -> System.out.println(s); }
    }
}
