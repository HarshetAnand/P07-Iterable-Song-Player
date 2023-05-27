//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: P07 Iterable Song Player: Song Class
// Course: CS 300 Spring 2022
//
// Author: Harshet Anand
// Email: hanand2@wisc.edu
// Lecturer: Mouna Kacem
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name: Ahan Nair
// Partner Email: nair27@wisc.edu
// Partner Lecturer's Name: Mouna Kacem
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// _X_ Write-up states that pair programming is allowed for this assignment.
// _X_ We have both read and understand the course Pair Programming Policy.
// _X_ We have registered our team prior to the team registration deadline.
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons: NONE
// Online Sources: NONE
//
///////////////////////////////////////////////////////////////////////////////

/**
 * This class models a song.
 */

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Song {

  private String songName; // name or title of the song
  private String artist; // artist of the song
  private String duration; // duration of the song


  /**
   * Creates a new Song given the song name, the name of the artist, and the duration of the song.
   * 
   * @param songName - title of the song
   * @param artist   - name of the artist who performed this song
   * @param duration - duration of the song in the format mm:ss
   * @throws IllegalArgumentException with a descriptive error message if either of songName, or
   *                                  artist, or duration is null or is blank, or if the duration is
   *                                  not formatted as mm:ss where both mm and ss are in the 0 .. 59
   *                                  range
   */
  public Song(String songName, String artist, String duration) {
    try {
      String[] timeSplit = duration.split(":");
      if (!(songName == null || artist == null || songName.equals("") || artist.equals("")
          || (Integer.parseInt(timeSplit[0]) % 60 != Integer.parseInt(timeSplit[0]))
          || (Integer.parseInt(timeSplit[1]) % 60 != Integer.parseInt(timeSplit[1])))) {
        this.songName = songName;
        this.artist = artist;
        this.duration = duration;
      } else {
        throw new IllegalArgumentException(
            "Error! The name of the song, or the name of the artist, or the duration of the song "
                + "is invalid!");
      }
    } catch (Exception e) {
      System.out.println(
          "Error! The name of the song, or the name of the artist, or the duration of the song "
              + "is invalid!");
    }
  }


  /**
   * Gets the title or name of this song.
   * 
   * @return the title or name of this song
   */
  public String getSongName() {
    return this.songName;
  }


  /**
   * Gets the name of the artist who performed this song.
   * 
   * @return the artist who performed this song
   */
  public String getArtist() {
    return this.artist;
  }


  /**
   * Gets the duration of this song.
   * 
   * @return the duration of the song
   */
  public String getDuration() {
    return this.duration;
  }


  /**
   * Returns a string representation of this song. This string should be formatted as follows.
   * "songName---artist---duration" where songName is the title of the song, artist is the name of
   * the artist, and duration is the duration of the song.
   * 
   * @return a string representation of this song
   */
  @Override
  public String toString() {
    String songFormat = this.songName + "---" + this.artist + "---" + this.duration;
    return songFormat;
  }


  /**
   * Returns true when this song's name and artist strings equals to the other song's name and
   * artist strings, and false otherwise. Note that this method takes an Object rather than a Song
   * argument, so that it Overrides Object.equals(Object). If an object that is not an instance of
   * Song is ever passed to this method, it should return false.
   * 
   * @param other - Song object to compare this object to
   * @return true when the this song has matching name and artist with respect to another song (case
   *         insensitive comparison)
   */
  @Override
  public boolean equals(Object other) {
    if (other == null) {
      return false;
    }
    if (other instanceof Song) {
      Song otherSong = (Song) other;
      if (otherSong.getSongName().equalsIgnoreCase(this.getSongName())
          && otherSong.getArtist().equalsIgnoreCase(this.getArtist())) {
        return true;
      }
    }
    return false;
  }
}
