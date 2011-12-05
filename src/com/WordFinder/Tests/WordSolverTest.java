package com.WordFinder.Tests;

import com.WordFinder.LetterGrid;
import com.WordFinder.LetterGridView;
import com.WordFinder.WordFinderActivity;
import com.WordFinder.WordSolver;

/**
 * Word Solver Test
 * 
 * @author John Mooring (jmooring)
 * @author Bryan Malyn (bmalyn)
 * @author Christopher Buck (cmbuck)
 * @version 2011.12.3
 */
public class WordSolverTest extends student.AndroidTestCase<WordFinderActivity> {

	private WordSolver solver;

	/**
	 * <<<<<<< HEAD Calls super for WordFinderActivity ======= Constructs a new
	 * WordSolverTest >>>>>>> branch 'refs/heads/master' of
	 * git@github.com:AndroidWordFinder/WordFinder.git
	 */
	public WordSolverTest() {
		super(WordFinderActivity.class);
	}

	/**
	 * <<<<<<< HEAD Sets up tests. Called before each test. ======= Sets up the
	 * testing environment >>>>>>> branch 'refs/heads/master' of
	 * git@github.com:AndroidWordFinder/WordFinder.git
	 */
	public void setUp() {
		@SuppressWarnings("unused")
		LetterGridView v = getView(LetterGridView.class,
				com.WordFinder.R.id.letterGrid);
		solver = WordSolver.getInstance();
	}

	/**
	 * <<<<<<< HEAD Tests the solve method ======= Tests the solve() method
	 * >>>>>>> branch 'refs/heads/master' of
	 * git@github.com:AndroidWordFinder/WordFinder.git
	 */
	public void testSolve() {
		LetterGrid grid = new LetterGrid();
		char[][] cgrid = { { 'a', 'n' }, { 'c', 'd' } };
		grid.load(cgrid);
		assertEquals(solver.solve(grid).size(), 4);
		assertEquals(solver.solve(grid), solver.getWords());

	}

	/**
	 * Test if a word is in the dictionary.
	 */
	public void testIsWord() {
		assertTrue(solver.isWord("and"));
		assertTrue(solver.isWord("cad"));
		assertTrue(solver.isWord("can"));
		assertTrue(solver.isWord("dan"));
		assertFalse(solver.isWord("zasldkjzz"));

	}

	/**
	 * Test if a word cold be in the dictionary.
	 */
	public void testCouldBeWord() {
		assertTrue(solver.couldBeWord("an"));
		assertTrue(solver.couldBeWord("ca"));
		assertTrue(solver.couldBeWord("ca"));
		assertTrue(solver.couldBeWord("da"));
		assertFalse(solver.couldBeWord("zasldkjzz"));
	}
}
