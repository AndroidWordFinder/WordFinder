package com.WordFinder;

import java.util.Vector;
/**
 * // -------------------------------------------------------------------------
/**
 *  Solves LetterGrids, checks to see if a found word is valid.
 *
 *  @author John Mooring (jmooring)
 *  @version Nov 8, 2011
 */
public class WordSolver {
    private WordSolver instance;

    /**
     * Singleton constructor
     */
    private WordSolver() {
	loadDictionary();
    }

    /**
     * Loads the dictionary into a prefix tree
     */
    private void loadDictionary() {
	//TODO
    }

    /**
     * Solves the passed grid
     */
    public Vector<String> solve(LetterGrid grid){
	//TODO
	return null;
    }

    /**
     * Returns an instance of this class
     */
    public WordSolver getSolver() {
	if (instance == null) {
	    instance = new WordSolver();
	}
	return instance;
    }
}
