package com.WordFinder.Tests;

import com.WordFinder.LetterGridView;
import com.WordFinder.WordFinderActivity;
import com.WordFinder.LetterGrid;
import com.WordFinder.Tile;
import com.WordFinder.Tile.State;

import java.util.ArrayList;
import student.TestCase;

/**
 *  Tests the LetterGrid class
 *
 *  @author John Mooring (jmooring)
 *  @author Bryan Malyn (bmalyn)
 *  @author Christopher Buck (cmbuck)
 *  @version 2011.12.04
 */
public class LetterGridTest extends student.AndroidTestCase<WordFinderActivity> {


    public LetterGridTest()
    {
        super(WordFinderActivity.class);
    }

	private LetterGrid grid;

	/**
	 * Set up a grid.
	 */
	public void setUp() {
		grid = new LetterGrid();
        LetterGridView v = getView(LetterGridView.class, com.WordFinder.R.id.letterGrid);
	}

	/**
	 * Load a random board.
	 */
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

	/**
	 * Load a custom board.
	 */
	public void testLoad() {
		grid.load(generateGrid("abc", "def", "ghi"));
		assertTilesString("abcdfghi", grid.getTile(1, 1).getAdjascent());
	}

	/**
	 * Test setSelected.
	 */
	public void testSetSelected() {
		grid.load(generateGrid("ab", "cd"));
		grid.setSelected(grid.getTile(0, 0));
		grid.setSelected(grid.getTile(1, 0));
		grid.setSelected(grid.getTile(0, 1));
		assertEquals(grid.getTile(0, 0).getState(), State.DOWN);
		assertEquals(grid.getTile(1, 0).getState(), State.DOWN);
		assertEquals(grid.getTile(0, 1).getState(), State.DOWN);
		assertEquals(grid.getTile(1, 1).getState(), State.UP);
		assertTilesString("acb", grid.getPath());

	}

	/**
	 * Test adding word by selecting tiles.
	 */
	public void testSubmitWordAndGetFoundWords() {
	    grid.load(generateGrid("ab", "cd"));
        grid.setSelected(grid.getTile(0, 0));
        grid.setSelected(grid.getTile(1, 0));
        grid.setSelected(grid.getTile(0, 1));
        grid.submitWord();
        assertFalse(grid.getFoundWords().contains("acb"));
        grid.setSelected(grid.getTile(1, 0));
        grid.setSelected(grid.getTile(0, 0));
        grid.setSelected(grid.getTile(1, 1));
        grid.submitWord();
        assertTrue(grid.getFoundWords().contains("cad"));
        grid.setSelected(grid.getTile(1, 0));
        grid.setSelected(grid.getTile(0, 0));
        grid.setSelected(grid.getTile(1, 1));
        grid.submitWord();
        assertTrue(grid.getFoundWords().contains("cad"));


	}

	/**
	 * Test the getTile method.
	 */
	public void testGetTile() {
		grid.load(generateGrid("ab", "cd"));
		assertEquals(grid.getTile(1, 0).getX(), 1);
		assertEquals(grid.getTile(1, 0).getLetter(), 'c');
		assertEquals(grid.getTile(1, 0).getY(), 0);
		assertEquals(grid.getTile(0, 1).getX(), 0);
		assertEquals(grid.getTile(0, 1).getY(), 1);
	}


	private void assertTilesString(String string, ArrayList<Tile> path) {
		assertNotNull(path);
		String s = "";
		for (int i = 0; i < path.size(); i++) {
			s += path.get(i).getLetter();
		}
		assertEquals(string, s);
	}

	private char[][] generateGrid(String... strings) {
		char[][] letters = new char[strings.length][strings.length];
		for (int i = 0; i < strings.length; i++) {
			letters[i] = strings[i].toCharArray();
		}
		return letters;
	}

}
