package com.WordFinder.Tests;

import com.WordFinder.LetterGrid;
import com.WordFinder.Tile;
import java.util.ArrayList;
import student.TestCase;

public class LetterGridTest extends TestCase {

    private LetterGrid grid;

    public void setUp() {
	grid = new LetterGrid();
    }

    public void testLoadRandom() {
	grid.loadRandom(4);
	assertEquals(grid.size(), 4);
	for (int i = 0; i < grid.size(); i++) {
	    for (int j = 0; j < grid.size(); j++) {
		char c = (char) (grid.getTile(i, j).getLetter() - 'a');
		assertTrue(c >= 0 && c <= 26); // make sure all letters are in
					       // [a,z]
	    }
	}
    }

    public void testLoad() {
	grid.load(generateGrid("abc","def","ghi"));
	assertTilesString("abcdfghi",grid.getTile(1,1).getAdjascent());
    }

    public void testSetSelected() {
	grid.load(generateGrid("ab", "cd"));
	//grid.setSelected(0, 0);
	//grid.setSelected(1, 0);
	//grid.setSelected(0, 1);
	assertTilesString("abc",grid.getPath());

    }

    public void testSubmitWord() {
	//TODO
    }

    private void assertTilesString(String string,ArrayList<Tile> path) {
	assertNotNull(path);
	String  s = "";
	for (int i = 0; i < path.size(); i++) {
	    s+=path.get(i).getLetter();
	}
	assertEquals(string,s);
    }

    private char[][] generateGrid(String... strings) {
	char[][] letters = new char[strings.length][strings.length];
	for (int i = 0; i < strings.length; i++) {
	    letters[i] = strings[i].toCharArray();
	}
	return letters;
    }
}
