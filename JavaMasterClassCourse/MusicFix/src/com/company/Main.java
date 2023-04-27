package com.company;

import com.company.model.Artist;
import com.company.model.Datasource;
import com.company.model.SongArtist;


// CANNOT rollback to a specific point, just use a savepoint object - But only do this where it would make sense

import java.util.List;

// Transactions
    // JDBC Connection class auto commits changes by default
// Can be a problem
// Imagine online banking web portal
    // Need to run two sql statements, one to update source account and destination account upon transfer
// If we executed the first statement, but the second failed
// money could go missing or something
    // EG transfer 400 to an account. you minus 400 from source, adding statement fails, 400 goes missing

// another EG - add artist for the songs to artists table
    // Add the album the song is on to the albums table
    // Add the song to the songs table
// if some fail there wouldn't be associations and the integrity of the data could be compromised.


// Transactions - make all sql statements run together or not at all
    // The way it works, if one fails, the other sql statements will be rolled back and are never saved

// Database Transactions must be ACID-compliant
    // Atomicity - If a series of SQL statements change the database, then either all the changes are committed, or none of them are
    // Consistency - Before a transaction begins, the database is in a valid state. when it completes, the database is still in a valid state
    // Isolation - Until the changes committed by a transaction are completed, they won't be visible to other connections. Transactions can't depend on each other.
    // Durability - Once the changes performed by a transaction are committed to the database, they're permanent. If an application then
        // crashes or the database server goes down (in the case of a client/server database like MySQL).
        // the changes made by the transaction are still there when the application runs again, or the database comes back up.

// ONLY NEED TO USE TRANSACTIONS when we change the data in a database
// in fact, no changes can be made to a database outside a transaction. All teh updates, etc. sqlite is auto making them transactions
// if we close a connection before we commit any outstanding changes, the changes are rolled back.


/**
 * NOTE:
 * This is the fixed version for attacks and performance
 *
 * Code is still not put into better practice though
 *
 * PreparedStatements are because of the potential performance benefit, and because they protect the database against SQL injections attacks.
 *  Still can be hacked obviously other ways.
 *
 * Attacks:
 * instead of building up query strings and using the statement class to execute them, use prepared statements
 * When getting using input, since we are concatenating strings the user can inject a sql attack
 *
 * prepared statements stop this because when we use them, we don't concatenate user input into the sql statement we are running
 * In the example below, it would treat an input as a SINGLE literal value
 * eg, without prepared statement - has //Here to show
 * if I had user input passed in for title, they could write
 * GO Your Own Way" or 1=1 or""
 * which would equal:
 *  "Go Your Own Way" or 1=1 or ""
 * With prepared statement
 *  "Go Your Own Way or 1=1 or ""
 */

public class Main {

    public static void main(String[] args) {
        Datasource datasource = new Datasource();
        if(!datasource.open()) {
            System.out.println("Can't open datasource");
            return;
        }

        List<Artist> artists = datasource.queryArtists(5);
        if(artists == null) {
            System.out.println("No artists!");
            return;
        }

        for(Artist artist : artists) {
            System.out.println("ID = " + artist.getId() + ", Name = " + artist.getName());
        }

        List<String> albumsForArtist =
                datasource.queryAlbumsForArtist("Carole King", Datasource.ORDER_BY_ASC);

        for(String album : albumsForArtist) {
            System.out.println(album);
        }

        List<SongArtist> songArtists = datasource.queryArtistsForSong("Go Your Own Way", Datasource.ORDER_BY_ASC);
        if(songArtists == null) {
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

        datasource.createViewForSongArtists();

        //Here
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter a song title: ");
//        String title = scanner.nextLine();

//        songArtists = datasource.querySongInfoView(title);
//        if(songArtists.isEmpty()) {
//            System.out.println("Couldn't find the artist for the song");
//            return;
//        }
//
//        for(SongArtist artist : songArtists) {
//            System.out.println("FROM VIEW - Artist name = " + artist.getArtistName() +
//                " Album name = " + artist.getAlbumName() +
//                " Track number = " + artist.getTrack());
//        }

        datasource.insertSong("Bird Dog", "Everly Brothers", "All-Time Greatest Hits", 7);
        datasource.close();
    }
}


