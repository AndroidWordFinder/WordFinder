package com.WordFinder.Tests;

import com.WordFinder.LetterGrid;
import com.WordFinder.WordSolver;

public class WordSolverTest extends student.TestCase{
    private WordSolver solver;
    private LetterGrid grid;

    public void setUp() {
	solver = WordSolver.getInstance();
	char[][]cgrid = {{'a','n'},
			{'c','d'}};
	grid = new LetterGrid();
	grid.load(cgrid);

    }
    //TODO Add javadocs, more and better tests

    public void testSolve() {
	solver.addWord("and");
	solver.addWord("can");
	solver.addWord("cad");
	solver.addWord("andd");
	solver.addWord("aand");
	solver.addWord("acca");
	solver.addWord("dada");
	solver.addWord("daca");
	solver.addWord("ncad");
	solver.solve(grid);
	assertEquals(4,solver.getWords().size());

    }
}
