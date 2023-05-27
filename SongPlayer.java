//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: P07 Iterable Song Player: SongPlayer Class
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
 * This class models an iterable collection of songs. Songs can be played in the forward or reverse
 * order.
 */

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SongPlayer implements Iterable<Song> {

  private int size; // size of the list
  private LinkedNode<Song> head; // head of this doubly linked list
  private LinkedNode<Song> tail; // tail of this doubly linked list
  private boolean playingBackward; // true if this song player is reading the list backward


  /**
   * Creates a new instance of song player which contains zero songs and set by default to play
   * songs in the forward direction. [Implementing this constructor is optional since it will be
   * added by default by the compiler]
   */
  public SongPlayer() {
    size = 0;
    head = null;
    tail = null;
  }


  /**
   * Adds a Song as Last Song.
   * 
   * @param oneSong - the song that is going to be added to the tail of this doubly linked list of
   *                songs
   */
  public void addLast(Song oneSong) {
    LinkedNode<Song> linkedSongNode = new LinkedNode<Song>(tail, oneSong, null);
    if (this.isEmpty()) {
      this.head = linkedSongNode;
      this.tail = linkedSongNode;
      size++;
      return;
    }
    if (!(tail == null)) {
      this.tail.setNext(linkedSongNode);
    }
    this.tail = linkedSongNode;
    size++;
  }


  /**
   * Add Song as First Song.
   * 
   * @param oneSong - the song that is going to be added to the head of this doubly linked list of
   *                songs
   * @throws NullPointerException with a descriptive error message if the passed oneSong is null
   */
  public void addFirst(Song oneSong) {
    try {
      LinkedNode<Song> linkedSongNode = new LinkedNode<>(null, oneSong, head);
      if (this.isEmpty()) {
        this.head = linkedSongNode;
        this.tail = linkedSongNode;
        size++;
        return;
      }
      if (!(head == null)) {
        this.head.setPrev(linkedSongNode);
      }
      this.head = linkedSongNode;
      size++;
    } catch (IllegalArgumentException e) {
      throw new NullPointerException(e.getMessage());
    }
  }


  /**
   * Adds Song at a given position/order within this collection of songs.
   * 
   * @param index   - the given index where the new song will be added
   * @param oneSong - the song that is going to be added
   * @throws NullPointerException      with a descriptive error message if the passed oneSong is
   *                                   null
   * @throws IndexOutOfBoundsException with a descriptive error message if index is out of the 0 ..
   *                                   size() range
   */
  public void add(int index, Song oneSong) {
    if (oneSong == null) {
      throw new NullPointerException("Error! The song is invalid!");
    }
    if (index > size() || index < 0) {
      throw new IndexOutOfBoundsException("Error! The index is out of bounds!");
    } else if (size == 0) {
      head = new LinkedNode<Song>(null, oneSong, null);
      tail = new LinkedNode<Song>(null, oneSong, null);
      size++;
      return;
    } else if (index == 0) {
      addFirst(oneSong);
      return;
    }
    if (index == size) {
      addLast(oneSong);
      return;
    }
    LinkedNode<Song> prevNode = head;
    for (int j = 0; j < index - 1; j++) {
      prevNode = prevNode.getNext();
    }
    LinkedNode<Song> next = prevNode.getNext();
    LinkedNode<Song> newNode = new LinkedNode<Song>(prevNode, oneSong, next);
    prevNode.setNext(newNode);
    next.setPrev(newNode);
    size++;
  }


  /**
   * Returns the first Song in this list.
   * 
   * @return the Song at the head of this list
   * @throws NoSuchElementException with a descriptive error message if this list is empty
   */
  public Song getFirst() {
    if (size == 0) {
      throw new NoSuchElementException("Error! The list is empty and should not be empty!");
    }
    return head.getData();
  }


  /**
   * Returns the last Song in this list.
   * 
   * @return the Song at the tail of this list
   * @throws NoSuchElementException with a descriptive error message if this list is empty
   */
  public Song getLast() {
    if (size == 0) {
      throw new NoSuchElementException("Error! The list is empty and should not be empty!");
    }
    return tail.getData();
  }


  /**
   * Returns the song at the specified position in this list.
   * 
   * @param index - index of the song to return
   * @return the song at the specified position in this list
   * @throws IndexOutOfBoundsException with a descriptive error message if index is out of the 0 ..
   *                                   size()-1 range
   */
  public Song get(int index) {
    if (index > size() || index < 0) {
      throw new IndexOutOfBoundsException("Error! The index is out of bounds!");
    }
    LinkedNode<Song> prevNode = head;
    for (int j = 0; j <= index; j++) {
      prevNode = prevNode.getNext();
    }
    return prevNode.getData();
  }


  /**
   * Removes and returns the first song from this list.
   * 
   * @return the first song from this list
   * @throws NoSuchElementException with a descriptive error message if this list is empty
   */
  public Song removeFirst() {
    if (size == 0) {
      throw new NoSuchElementException("Error! The list is empty and should not be empty!");
    }
    Song current;
    try {
      current = head.getData();
    } catch (NullPointerException e) {
      return null;
    }
    if (size == 1) {
      this.head = null;
      this.tail = null;
      size = 0;
      return current;
    }
    this.head = this.head.getNext();
    try {
      head.setPrev(null);
    } catch (NullPointerException e) {
    }
    size--;
    return current;
  }


  /**
   * Removes and returns the last song from this list.
   * 
   * @return the last song from this list
   * @throws NoSuchElementException with a descriptive error message if this list is empty
   */
  public Song removeLast() {
    if (size == 0) {
      throw new NoSuchElementException("Error! The list is empty and should not be empty!");
    }
    Song current;
    try {
      current = tail.getData();
    } catch (NullPointerException e) {
      return null;
    }
    if (size == 1) {
      this.head = null;
      this.tail = null;
      size = 0;
      return current;
    }
    this.tail = this.tail.getPrev();
    try {
      tail.setNext(null);
    } catch (NullPointerException e) {
    }
    size--;
    return current;
  }


  /**
   * Removes the song at the specified position in this list and returns the song that was removed
   * from the list. The order of precedence of the other songs in the list should not be modified.
   * 
   * @param index - the index of the song to be removed
   * @return the song previously at the specified position
   * @throws IndexOutOfBoundsException with a descriptive error message if index is out of the 0 ..
   *                                   size()-1 range
   */
  public Song remove(int index) {
    if (index > size() - 1 || index < 0) {
      throw new IndexOutOfBoundsException("Error! The index is out of bounds!");
    }
    LinkedNode<Song> current = head;
    for (int j = 0; j < index; j++) {
      current = current.getNext();
    }
    try {
      current.getPrev().setNext(current.getNext());
    } catch (NullPointerException e) {
    }
    try {
      current.getNext().setPrev(current.getPrev());
    } catch (NullPointerException e) {
    }
    size--;
    return current.getData();
  }


  /**
   * Returns true if this list contains a match with the specified song. More formally, returns true
   * if and only if this list contains at least one song e such that Objects.equals(o, e).
   * 
   * @param o - song whose presence in this list is to be tested
   * @return true if this list contains the specified song
   */
  public boolean contains(Song o) {
    LinkedNode<Song> current = head;
    for (int j = 0; j < size(); j++) {
      if (current.getData().equals(o)) {
        return true;
      }
      current = current.getNext();
    }
    return false;
  }


  /**
   * Removes all of the songs from this list. The list will be empty after this call returns.
   */
  public void clear() {
    size = 0;
    head = null;
    tail = null;
  }


  /**
   * Returns true if this list is empty.
   * 
   * @return true if this list is empty
   */
  public boolean isEmpty() {
    return size == 0;
  }


  /**
   * Returns the number of songs in this list.
   * 
   * @return the number of songs in this list
   */
  public int size() {
    return this.size;
  }


  /**
   * Returns an iterator to iterate through the songs in this list with respect to current playing
   * direction of this song player (either in the forward or in the backward direction).
   * 
   * @return an Iterator to traverse the list of songs in this SongPlayer with respect to the
   *         current playing direction specified by the playingBackward data field
   */
  @Override
  public java.util.Iterator<Song> iterator() {
    if (this.playingBackward) {
      return new BackwardSongIterator(tail);
    } else {
      return new ForwardSongIterator(head);
    }
  }


  /**
   * Mutator of the playingDirection of this song player. It switches the playing direction by
   * setting playingBackward to its opposite value.
   */
  public void switchPlayingDirection() {
    this.playingBackward = !this.playingBackward;
  }


  /**
   * Plays the songs in this song player in the current playing direction. This method MUST be
   * implemented using an enhanced for-each loop.
   * 
   * @return a String representation of the songs in this song player. String representations of
   *         each song are separated by a newline. If this song player is empty, this method returns
   *         an empty string
   */
  public String play() {
    String songPlayer = "";
    for (Song song : this) {
      songPlayer = songPlayer + song;
    }
    return songPlayer;
  }
}
