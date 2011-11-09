package com.WordFinder;

import java.util.Vector;
/**
 * // -------------------------------------------------------------------------
/**
 *  Solves LetterGrids, checks to see if a found word is valid.
 *
 *  @author John Mooring (jmooring)
 *  @version 2011.11.8
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
     * Checks to see if the dictionary contains the passed word
     * @param word the word to check
     * @returns whether or not the word is a word
     */
    public boolean isWord(String word) {
	//TODO
	return false;
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
