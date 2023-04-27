import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name;
    private String artist;
    private ArrayList<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<Song>();
    }

    public boolean addSong(String title, double songDuration) {
        if(findSong(title) == null) {
            this.songs.add(new Song(title, songDuration));
            return true;
        }
        return false;
    }

    private Song findSong(String title) {
        for (Song checkedSong : this.songs) {       // for each command. So creates a variables called checkedSong for each this.songs and iterates through the whole this.songs ArrayList
            if (checkedSong.getTitle().equals(title)) return checkedSong;
        }
        return null;
    }

    public boolean addToPlayList(int trackNumber, LinkedList<Song> playList) {  // When they pass in playList variable it needs to be LINKLIST<SONG> idiot so if it passes it was already created.
        int index = trackNumber - 1;    // Done because the user should not need to input and cater for index starting at 0.
        if((index >= 0) && (index <= this.songs.size())) {   // index <= this.songs.size() means that if the index (trackNumber) is inside the songs arraylist (meaning it exists) add it to the playlist.
            playList.add(this.songs.get(index));
            return true;
        }
        System.out.println("This album does not have a track " + trackNumber);
        return false;
    }

    public boolean addToPlayList(String title, LinkedList<Song> playList) {
        Song checkedSong = findSong(title);
        if(checkedSong != null) {
            playList.add(checkedSong);
            return true;
        }
        System.out.println("The song " + title + " is not this album");
        return false;
    }
}
