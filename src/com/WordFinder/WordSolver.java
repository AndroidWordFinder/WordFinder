package com.WordFinder;

import android.content.Context;
import java.util.ArrayList;
import java.util.Vector;

/**
 * // -------------------------------------------------------------------------
 * /** Solves LetterGrids, checks to see if a found word is valid.
 *
 * @author John Mooring (jmooring)
 * @version 2011.11.8
 */
public class WordSolver
{
    private WordSolver        instance;
    private ArrayList<String> foundWords;
    private Trie              dictionary;
    private final int         MAX_DEPTH = 10;


    /**
     * Singleton constructor
     */
    private WordSolver()
    {
        loadDictionary();
        dictionary = new Trie();
        foundWords = new ArrayList<String>();
    }


    /**
     * Loads the dictionary into a prefix tree
     */
    private void loadDictionary()
    {
        Context c = WordFinderActivity.getInstance(); // will need context to
                                                      // load from assets

        // TODO
        // Add all words contained in assets/en.dict to the Trie
    }


    /**
     * Solves the passed grid
     */
    public ArrayList<String> solve(LetterGrid grid)
    {
        for (int i = 0; i < grid.size(); i++)
        {
            for (int j = 0; j < grid.size(); j++)
            {
                solve(
                    grid.getTile(i, j),
                    "",
                    new boolean[grid.size()][grid.size()],
                    MAX_DEPTH);
            }
        }
        return foundWords;
    }


    /**
     * Uses recursion to solve the letter grid
     */
    private void solve(Tile tile, String current, boolean[][] visited, int depth)
    {
        String word = current + tile.getLetter();
        visited[tile.getX()][tile.getY()] = true;
        boolean hadNext = dictionary.hasNext(tile.getLetter());
        if (!hadNext)
        { // Path plus current tile is not in the dictionary.
            return;
        }
        if (dictionary.isWord())
        {
            foundWords.add(word);
        }
        if (depth <= 0)
        {
            return;
        }
        for (Tile t : tile.getAdjascent())
        {
            if (!visited[t.getX()][t.getY()])
            {
                solve(t, word, visited, depth - 1);
            }
        }
        if (hadNext)
        {
            visited[tile.getX()][tile.getY()] = false;
            dictionary.pop();
        }
    }


    /**
     * Checks to see if the dictionary contains the passed word
     *
     * @param word
     *            the word to check
     * @return whether or not the word is a word
     */
    public boolean isWord(String word)
    {
        // TODO
        return false;
    }


    /**
     * Returns an instance of this class
     */
    public WordSolver getSolver()
    {
        if (instance == null)
        {
            instance = new WordSolver();
        }
        return instance;
    }
}
