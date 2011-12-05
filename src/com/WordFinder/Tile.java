package com.WordFinder;

import java.util.ArrayList;

// -------------------------------------------------------------------------
/**
 * Contains the letter in a grid cell, along with a table of all adjacent
 * letters.
 *
 * @author John Mooring (jmooring)
 * @author Christopher Buck (cmbuck)
 * @author Bryan Malyn (bmalyn)
 * @version 2011.11.29
 */
public class Tile
{
    /**
     * Write a one-sentence summary of your class here. Follow it with
     * additional details about its purpose, what abstraction it represents, and
     * how to use it.
     *
     * @author John Mooring (jmooring)
     * @version Dec 4, 2011
     */
    public enum State
    {
        /**
         * The tile is up. (Default position)
         */
        UP,
        /**
         * The tile is down.
         */
        DOWN,
        /**
         * The submitted word was good.
         */
        GOOD,
        /**
         * The submitted word was bad.
         */
        BAD,
        /**
         * The submitted word was a duplicate.
         */
        DUPE;
    }

    private int             x;
    private int             y;
    private State           state          = State.UP;
    private char            character;
    private boolean[]       adjacentChar   = new boolean[26];
    private ArrayList<Tile> adjascentTiles = new ArrayList<Tile>();


    /**
     * Constructs a letter object, takes the center character and an array of
     * adjacent characters
     *
     * @param x
     *            the x coordinate of the tile
     * @param y
     *            the y coordinate of the tile
     * @param letter
     *            character in the cell
     */
    public Tile(int x, int y, char letter)
    {
        this.x = x;
        this.y = y;
        character = letter;
    }


    /**
     * Get the contained character
     *
     * @return the contained char
     */
    public char getLetter()
    {
        return character;
    }


    /**
     * Sets the state of the tile
     *
     * @param s
     *            state to set this tile to
     */
    public void setState(State s)
    {
        state = s;
    }


    /**
     * Gets the state of the tile
     *
     * @return the state of the tile
     */
    public State getState()
    {
        return state;
    }


    /**
     * Checks to see if the passed character is adjacent to this letter
     *
     * @param letter
     *            the letter to check for adjacency
     * @return boolean whether or not the passed character is adjacent
     */
    public boolean hasAdjascent(char letter)
    {
        return adjacentChar[letter - 'a'];
    }


    // ----------------------------------------------------------
    /**
     * Returns a list of all adjacent tiles
     *
     * @return ArrayList<Tile> containing all adjacent tiles
     */
    public ArrayList<Tile> getAdjascent()
    {
        return adjascentTiles;
    }


    /**
     * Adds an adjacent tile (Note: duplicate tiles alowed)
     *
     * @param tile
     *            the tile to add to the adjacent tiles list
     */
    public void addAdjascent(Tile tile)
    {
        adjacentChar[tile.getLetter() - 'a'] = true;
        adjascentTiles.add(tile);
    }


    /**
     * Returns the x coordinate of the tile
     *
     * @return the x coordinate of the tile
     */
    public int getX()
    {
        return x;
    }


    /**
     * Returns the y coordinate of the tile
     *
     * @return the y coordinate of the tile
     */
    public int getY()
    {
        return y;
    }
}
