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
public class WordSolverTest
    extends student.AndroidTestCase<WordFinderActivity>
{

    private WordSolver solver;

    /**
     * Calls super for WordFinderActivity
     */
    public WordSolverTest()
    {
        super(WordFinderActivity.class);
    }

    /**
     * Sets up tests. Called before each test.
     */
    public void setUp()
    {
        LetterGridView v = getView(LetterGridView.class, com.WordFinder.R.id.letterGrid);
        //Forces the view to be created, allowing the dictionary to be loaded.
        solver = WordSolver.getInstance();
    }

    /**
     * Tests the solve method
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
