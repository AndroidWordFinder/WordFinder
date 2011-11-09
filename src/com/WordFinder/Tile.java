package com.WordFinder;

import java.util.Vector;

 // -------------------------------------------------------------------------
 /**
 *  Contains the letter in a grid cell, along with
 *  a table of all adjacent letters.
 *
 *  @author John Mooring (jmooring)
 *  @version Oct 30, 2011
 */
public class Tile {
    public enum State{
	UP,DOWN,GOOD,BAD;
    }
    private State state = State.UP;
    private char character;
    private boolean[] adjacentChar = new boolean[26];
    private Vector<Tile>adjascentTiles = new Vector<Tile>();

    /**
     * Constructs a letter object, takes the center character and an array of adjacent characters
     * @param letter character in the cell
     */
    public Tile(char letter) {
	character = letter;
    }

    /**
     * Get the contained character
     * @return the contained char
     */
    public char getLetter() {
	return character;
    }

    /**
     * Sets the state of the tile
     * @param s state to set this tile to
     */
    public void setState(State s) {
	state = s;
    }

    /**
     * Gets the state of the tile
     * @returns the state of the tile
     */
    public State getState() {
	return state;
    }

    /**
     * Checks to see if the passed character is adjacent to this letter
     * @param letter the letter to check for adjacency
     * @return boolean whether or not the passed character is adjacent
     */
    public boolean hasAdjascent(char letter) {
	return adjacentChar[letter - 'a'];
    }

    /**
     * Adds an adjacent tile
     */
    public void addAdjascent(Tile tile) {
	adjacentChar[tile.getLetter()-'a']=true;
	adjascentTiles.add(tile);
    }
}
