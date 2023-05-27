//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: P07 Iterable Song Player: ForwardSongIterator Class
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
 * This class models an iterator to play songs in the rforward direction from a doubly linked list
 * of songs.
 */

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ForwardSongIterator implements Iterator<Song> {

  private LinkedNode<Song> next; // reference to the next linked node in a list of nodes.


  /**
   * Creates a new iterator which iterates through songs in front/head to back/tail order.
   * 
   * @param first - reference to the head of a doubly linked list of songs
   */
  public ForwardSongIterator(LinkedNode<Song> first) {
    this.next = first;
  }


  /**
   * Checks whether there are more songs to return.
   * 
   * @return true if there are more songs to return
   */
  @Override
  public boolean hasNext() {
    return next != null;
  }


  /**
   * Returns the next song in the iteration.
   * 
   * @return next song in the iteration
   * @throws NoSuchElementException with a descriptive error message if there are no more songs to
   *                                return in the reverse order (meaning if this.hasNext() returns
   *                                false)
   */
  @Override
  public Song next() {
    if (!(hasNext())) {
      throw new NoSuchElementException(
          "Error! There are no more songs to return in reverse order!");
    }
    LinkedNode<Song> current = next;
    next = next.getNext();
    return current.getData();
  }
}
