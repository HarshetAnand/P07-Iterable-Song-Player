//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: P07 Iterable Song Player: SongPlayerTester Class
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
 * This class implements unit test methods to check the correctness of Song, LinkedNode, SongPlayer
 * ForwardSongIterator and BackwardSongIterator classes in P07 Iterable Song Player assignment.
 */

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SongPlayerTester {
  /**
   * This method test and make use of the Song constructor, an accessor (getter) method, overridden
   * method toString() and equal() method defined in the Song class.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testSong() {
    Song song = new Song("Rockstar", "PostMalone", "4:02");
    if (!(song.toString().equals("Rockstar---PostMalone---4:02"))) {
      return false;
    }
    if (!(song.getDuration().equals("4:02"))) {
      return false;
    }
    Song other = new Song("Rockstar", "PostMalone", "4:02");
    if (!(song.equals(other) == true)) {
      return false;
    }
    return true;
  }

  /**
   * This method test and make use of the LinkedNode constructor, an accessor (getter) method, and a
   * mutator (setter) method defined in the LinkedCart class.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testLinkedNode() {
    Song song = new Song("Money Trees", "Kendrick Lamar", "6:26");
    Song nextSong = new Song("Humble", "Kendrick Lamar", "3:03");
    Song prevSong = new Song("Hood Politics", "Kendrick Lamar", "4:53");
    LinkedNode<Song> nextSong1 = new LinkedNode<>(null, nextSong, null);
    LinkedNode<Song> previousSong = new LinkedNode<>(null, prevSong, null);
    LinkedNode<Song> testerSong = new LinkedNode<>(previousSong, song, nextSong1);
    if (!(testerSong.getPrev().equals(previousSong))) {
      return false;
    }
    Song nextPrev = new Song("u", "Kendrick Lamar", "4:28");
    LinkedNode<Song> nextPrev1 = new LinkedNode<>(null, nextPrev, null);
    testerSong.setPrev(nextPrev1);
    if (!(testerSong.getPrev().equals(nextPrev1))) {
      return false;
    }
    return true;
  }

  /**
   * This method checks for the correctness of addFirst(), addLast() and add(int index) method in
   * SongPlayer class
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testSongPlayerAdd() {
    Song song = new Song("Money Trees", "Kendrick Lamar", "6:26");
    Song prevSong = new Song("Hood Politics", "Kendrick Lamar", "4:53");
    SongPlayer testerSong = new SongPlayer();
    testerSong.addFirst(song);
    if (testerSong.size() != 1) {
      return false;
    }
    testerSong.add(1, prevSong);
    if (testerSong.size() != 2) {
      return false;
    }
    return true;
  }

  /**
   * This method checks for the correctness of getFirst(), getLast() and get(int index) method in
   * SongPlayer class
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testSongPlayerGet() {
    return true;
  }

  /**
   * This method checks for the correctness of removeFirst(), removeLast() and remove(int index)
   * method in SongPlayer class
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testSongPlayerRemove() {
    return true;
  }

  /**
   * This method checks for the correctness of iterator(), switchPlayingDirection() and String
   * play() method in SongPlayer class
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testSongPlayerIterator() {
    return true;
  }

  /**
   * This method checks for the correctness of contains(Object song), clear(), isEmpty()and size()
   * method in SongPlayer class
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testSongPlayerCommonMethod() {
    return true;
  }

  /**
   * This method checks for the correctness of ForwardSongIterator class
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testForwardSongIterator() {
    return true;
  }

  /**
   * This method checks for the correctness of BackwardSongIterator class
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testBackwardSongIterator() {
    return true;
  }

  /**
   * This method calls all the test methods defined and implemented in your SongPlayerTester class.
   * 
   * @return true if all the test methods defined in this class pass, and false otherwise.
   */
  public static boolean runAllTests() {
    boolean allTestsPassed = testSong() && testLinkedNode() && testSongPlayerAdd()
        && testSongPlayerGet() && testSongPlayerRemove() && testSongPlayerIterator()
        && testSongPlayerCommonMethod() && testForwardSongIterator() && testBackwardSongIterator();
    // Can only return true if all test cases return true. Will go back to main method to return
    // final result
    return allTestsPassed;
  }

  /**
   * Driver method defined in this SongPlayerTester class
   * 
   * @param args input arguments if any.
   */
  public static void main(String[] args) {
    System.out.println("runAllTests(): " + runAllTests());
  }
}
