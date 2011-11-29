package com.WordFinder;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Random;
import java.util.Vector;

public class LetterGrid
    extends Observable
{
    private Tile[][]        grid;
    private ArrayList<Tile> path;


    /**
     * Builds a LetterGrid
     */
    public LetterGrid()
    {
        path = new ArrayList<Tile>();
    }


    /**
     * Generates and loads a square grid of characters with a side length of the
     * passed integer
     *
     * @param size
     *            the side length of the square character grid
     */
    public void loadRandom(int size)
    {
        char[][] lettersGrid = new char[size][size];
        String letters = "";
        int length = size * size;
        int hardLetters = ((int)(Math.random() * length * .1875 + .5));
        int vowles =
            (int)(Math.random() * (length * .4375 - length / 4.0 + 1) +
                length / 4.0);
        int regLetters = length - vowles - hardLetters;
        String[] letterTypes = { "bcdfghklmnprstwy", "aeiou", "jqkzxv", };
        int numOfLetterTypes[] = { regLetters, vowles, hardLetters };

        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < numOfLetterTypes[i]; j++)
            {
                int insertHere = (int)(letters.length() * Math.random());
                letters =
                    letters.substring(0, insertHere)
                        + letterTypes[i]
                            .charAt(((int)(letterTypes[i].length() * Math
                                .random()))) + letters.substring(insertHere);
            }
        }
        int loopCount = 0;
        for (int i = 0; i < size; i++)
        {
            for (int j = 0; j < size; j++)
            {
                lettersGrid[i][j] = letters.charAt(loopCount);
                loopCount++;
            }
        }
        load(lettersGrid);
    }


    /**
     * Creates the grid from the passed array of letters. Characters are
     * transformed into Tiles, and the tiles are given an array of all adjascent
     * tiles.
     */
    public void load(char[][] letters)
    {
        // TODO check to see if letters is square, if it is not, throw an
        // exception or something like that
        this.grid = new Tile[letters.length][letters[0].length];
        for (int i = 0; i < letters.length; i++)
        {
            for (int j = 0; j < letters[i].length; j++)
            {
                this.grid[i][j] = new Tile(i, j, letters[i][j]);
            }
        }
        for (int i = 0; i < grid.length; i++)
        {
            for (int j = 0; j < grid[i].length; j++)
            {
                for (int di = i - 1; di <= i + 1; di++)
                {
                    for (int dj = j - 1; dj <= j + 1; dj++)
                    {
                        if (di >= 0 && di < grid.length && dj >= 0
                            && dj < grid[i].length && !(di == i && dj == j))
                        {
                            grid[i][j].addAdjascent(grid[di][dj]);
                        }
                    }
                }
            }
        }
    }


    /**
     * If the tile is valid, (based on the last selected tile) the tile is added
     * to the current path list and has its state changed to DOWN
     */
    public void setSelected(Tile tile)
    {
        /* if( is valid tile) */
        setChanged();
        notifyObservers();
        // TODO
    }


    /**
     * Returns the currently selected path
     */
    public ArrayList<Tile> getPath()
    {
        // TODO
        return null;
    }


    /**
     * Called when tile selection is done and the word is submitted. Uses
     * WordSolver to check if the word contained in the current path is valid
     * Sets the tiles in the path as good or bad depending on whether the word
     * was good or bad
     *
     * @precondition the contained in the current path is valid
     */
    public void submitWord()
    {
        // TODO
    }


    public Tile getTile(int x, int y)
    {
        return grid[x][y];
    }


    /**
     * Clears the current path, sets all tiles in the path to their default
     * color
     */
    public void deselectPath()
    {
        // TODO
    }


    /**
     * Returns the side length of the square grid
     */
    public int size()
    {
        return grid.length;
    }

}
