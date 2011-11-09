package com.WordFinder;


public class LetterGrid {
    private Letter[][] grid;

    public LetterGrid(char[][] grid) {
	this.grid = new Letter[grid.length][grid[0].length];
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
		this.grid[i][j] = new Letter(grid[i][j], adjacent);
	    }
	}
    }


}
