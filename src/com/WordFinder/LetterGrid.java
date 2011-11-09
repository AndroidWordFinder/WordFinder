package com.WordFinder;

import java.util.Observable;
<<<<<<< HEAD

public class LetterGrid
    extends Observable
{
    private Letter[][] grid;


    public LetterGrid(char[][] grid)
    {
        this.grid = new Letter[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++)
        {
            for (int j = 0; j < grid[i].length; j++)
            {
                boolean[] adjacent = new boolean[26];
                for (int di = i - 1; di <= i + 1; di++)
                {
                    for (int dj = j - 1; dj <= j + 1; dj++)
                    {
                        if (di >= 0 && di < grid.length && dj >= 0
                            && dj < grid[i].length && !(di == i && dj == j))
                        {
                            adjacent[grid[di][dj] - 'a'] = true;
                        }
                    }
                }
                this.grid[i][j] = new Letter(grid[i][j], adjacent);
            }
        }
    }

    public int size() {
        return grid.length;
=======
import java.util.Vector;


public class LetterGrid extends Observable{
    private Tile[][] grid;

    public LetterGrid(char[][] letters) {
	this.grid = new Tile[letters.length][letters[0].length];
	for (int i = 0; i < letters.length; i++) {
	    for (int j = 0; j < letters[i].length; j++) {
		this.grid[i][j] = new Tile(letters[i][j]);
	    }
	}
	for (int i = 0; i < letters.length; i++) {
	    for (int j = 0; j < letters[i].length; j++) {
		for (int di = i - 1; di <= i + 1; di++) {
		    for (int dj = j - 1; dj <= j + 1; dj++) {
			if (di >= 0 && di < letters.length && dj >= 0
				&& dj < letters[i].length && !(di == i && dj == j)) {
			    grid[i][j].addAdjascent(grid[di][dj]);
			}
		    }
		}
	    }
	}
>>>>>>> 0ea2d929ac2ad2d34e9e1c913844ef413d87bd05
    }

    /**
     * If the tile is valid, (based on the last selected tile) the tile is
     * added to the current path list and has its state changed to DOWN
     */
    public void setSelected(int x, int y) {
	/*if( is valid tile)*/
	setChanged();
	notifyObservers();
	//TODO
    }

    /**
     * Returns the currently selected path
     */
    public Vector<Tile> getPath() {
	//TODO
	return null;
    }

    /**
     * Called when tile selection is done and the word is submitted.
     * Uses WordSolver to check if the word contained in the current path
     * is valid
     * Sets the tiles in the path as good or bad depending on whether the
     * word was good or bad
     * @precondition the contained in the current path is valid
     */
    public void submitWord() {
	//TODO
    }

    public Tile getTile(int x, int y) {
	return grid[x][y];
    }

    /**
     * Clears the current path, sets all tiles in the path to their default
     * color
     */
    public void deselectPath() {
	//TODO
    }


}
