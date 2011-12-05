package com.WordFinder.Tests;

import com.WordFinder.LetterGrid;
import com.WordFinder.LetterGridView;
import com.WordFinder.WordFinderActivity;
import com.WordFinder.WordSolver;

/**
 * Test class for @link WordSolver.
 *
 * @author John Mooring (jmooring)
 * @author Christopher Buck (cmbuck)
 * @author Bryan Malyn (bmalyn)
 * @version 2011.11.29
 */
public class WordSolverTest
    extends student.AndroidTestCase<WordFinderActivity>
{

    private WordSolver solver;

    /**
     * Constructs a new WordSolverTest
     */
    public WordSolverTest()
    {
        super(WordFinderActivity.class);
    }

    /**
     * Sets up the testing environment
     */
    public void setUp()
    {
        @SuppressWarnings("unused")
        LetterGridView v = getView(LetterGridView.class, com.WordFinder.R.id.letterGrid);
        solver = WordSolver.getInstance();
    }

    /**
     * Tests the solve() method
     */
    public void testSolve()
    {
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
