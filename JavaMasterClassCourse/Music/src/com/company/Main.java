package com.company;

import com.company.model.Artist;
import com.company.model.Datasource;
import com.company.model.SongArtist;

import java.util.List;


/**
 * NOTE:
 * Vulnerable to attacks and also performance can take a hit if coding like this at an enterprise level(this small thing it's fine this way)
 * So should be using prepared statements, sql statements have to be compiled for the database everytime we perform a new query.
 *
 * Vulnerable to attacks because of the way we are building our strings
 *
 *
 * There is a zip folder in JavaCourse folder that has the fixed code, called:
 * Databases-SQL-Injection-Attacks-and-Prepared-Statements-Source-code
 *
 * Also there is a project in JavaCourse folder called MusicFix that will have the updated code
 */


// The index we pass to the resultSet getter methods, is the indices in the result set, not the table

// indices are better for performance, names are better for readability in the Datasource Java file. - Just dependent on the program I guess

// Command line you could query the schema.
    // support for this in java can be different.
    // getMetaData() is good to get info of tables except in sqlite
    //

public class Main {

    public static void main(String[] args) {
        Datasource datasource = new Datasource();
        if(!datasource.open()) {
            System.out.println("Can't open datasource");
            return; // This exits
        }

        List<Artist> artists = datasource.queryArtists(5);
        if(artists.isEmpty()) {
            System.out.println("No artists!");
            return;
        }
        for(Artist artist : artists) {
            System.out.println("ID = " + artist.getId() + ", Name = " + artist.getName());
        }


        List<String> albumsForArtist = datasource.queryAlbumsForArtist("Carole King", Datasource.ORDER_BY_ASC); // probs still error handle for null... Could make a predicate method for it so can pass in error message and rest is the same
        for(String album : albumsForArtist) {
            System.out.println(album);
        }


        List<SongArtist> songArtists = datasource.queryArtistsForSong("Go Your Own Way", Datasource.ORDER_BY_ASC);
        if(songArtists.isEmpty()) {
            System.out.println("Couldn't find the artist for the song");
            return;
        }
        for(SongArtist artist : songArtists) {
            System.out.println("Artist name = " + artist.getArtistName() +
                    " Album name = " + artist.getAlbumName() +
                    " Track = " + artist.getTrack());
        }


        datasource.querySongsMetadata();

        int count = datasource.getCount(Datasource.TABLE_SONGS);
        System.out.println("Number of songs is: " + count);

        datasource.createViewForSongArtists();  // No problems because has IF NO EXISTS - So since it exists, it doesn't do anything


        songArtists = datasource.querySongInfoView("She's On Fire");
        if(songArtists.isEmpty()) {
            System.out.println("Couldn't find the artist for the song");
            return;
        }
        for(SongArtist artist : songArtists) {
            System.out.println("FROM VIEW - Artist name = " + artist.getArtistName() +
                    " Album name = " + artist.getAlbumName() +
                    " Track number = " + artist.getTrack());
        }


        datasource.close();
    }
}
