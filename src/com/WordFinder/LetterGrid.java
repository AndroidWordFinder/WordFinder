package com.WordFinder;

import java.util.Observable;
import java.util.Vector;


public class LetterGrid extends Observable{
    private Tile[][] grid;

    public LetterGrid(char[][] grid) {
	this.grid = new Tile[grid.length][grid[0].length];
	for (int i = 0; i < grid.length; i++) {
	    for (int j = 0; j < grid[i].length; j++) {
		boolean[] adjacent = new boolean[26];
		for (int di = i - 1; di <= i + 1; di++) {
		    for (int dj = j - 1; dj <= j + 1; dj++) {
			if (di >= 0 && di < grid.length && dj >= 0
				&& dj < grid[i].length && !(di == i && dj == j)) {
			    adjacent[grid[di][dj] - 'a'] = true;
			}
		    }
		}
		this.grid[i][j] = new Tile(grid[i][j], adjacent);
	    }
	}
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

    /**
     * Clears the current path, sets all tiles in the path to their default
     * color
     */
    public void deselectPath() {
	//TODO
    }


}
