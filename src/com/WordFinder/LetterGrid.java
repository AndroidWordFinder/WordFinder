package com.WordFinder;

import java.util.Vector;


public class LetterGrid {
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

    public void setSelected(int x, int y) {
	//TODO
    }

    public Vector<Tile> getPath() {
	//TODO
	return null;
    }


}
