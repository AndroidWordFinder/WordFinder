package com.WordFinder.Tests;
/**
 * Test class for @link WordSolver.
 *
 * @author John Mooring (jmooring)
 * @author Christopher Buck (cmbuck)
 * @author Bryan Malyn (bmalyn)
 * @version 2011.11.29
 */
import com.WordFinder.LetterGrid;
import com.WordFinder.LetterGridView;
import com.WordFinder.WordFinderActivity;
import com.WordFinder.WordSolver;

public class WordSolverTest
    extends student.AndroidTestCase<WordFinderActivity>
{

    private WordSolver solver;


    public WordSolverTest()
    {
        super(WordFinderActivity.class);
    }


    public void setUp()
    {
        LetterGridView v = getView(LetterGridView.class, com.WordFinder.R.id.letterGrid);
        solver = WordSolver.getInstance();
    }

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


    private static String ltos(long l)
    {
        StringBuffer stb = new StringBuffer();
        int x = 0;
        byte n;
        while ((l & 31) == 0 && x++ <= 12)
        {
            l >>>= 5;
        }
        while ((n = (byte)(l & 31)) != 0)
        {
            stb.insert(0, (char)('a' + n - 1));
            l >>>= 5;
        }
        return stb.toString();
    }
}
