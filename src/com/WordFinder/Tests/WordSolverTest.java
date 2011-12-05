package com.WordFinder.Tests;

import android.R;
import com.WordFinder.LetterGridView;
import com.WordFinder.WordFinderActivity;
import com.WordFinder.LetterGrid;
import com.WordFinder.WordSolver;

public class WordSolverTest
    extends student.AndroidTestCase<WordFinderActivity>
{

    public WordSolverTest()
    {
        super(WordFinderActivity.class);
    }


    public void setUp()
    {
        LetterGridView v = getView(LetterGridView.class, com.WordFinder.R.id.letterGrid);
    }

    public void testSolve()
    {
        WordSolver solver = WordSolver.getInstance();
        LetterGrid grid = new LetterGrid();
        char[][] cgrid = { { 'a', 'n' }, { 'c', 'd' } };
        grid.load(cgrid);
        assertEquals(solver.solve(grid).size(), 4);

    }


    public static String ltos(long l)
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
