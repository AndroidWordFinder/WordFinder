package com.WordFinder;


import java.io.DataInputStream;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

/**
 * // -------------------------------------------------------------------------
 * /** Solves LetterGrids, checks to see if a found word is valid.
 * 
 * @author John Mooring (jmooring)
 * @version 2011.11.8
 */
public class WordSolver {
	public static WordSolver instance;
	public TreeSet<String> foundWords;
	public long[] dictionary;
	public final int MAX_DEPTH = 10;
	public final int DICTIONARY_LENGTH = 126905;

	/**
	 * Singleton constructor
	 */
	private WordSolver() {
		dictionary = new long[DICTIONARY_LENGTH];
		foundWords = new TreeSet<String>();
		loadDictionary();
	}

	/**
	 * Clears all found words from the list
	 */
	private void clearWords() {
		foundWords.clear();
	}

	/**
	 * Loads the dictionary into a prefix tree
	 */
	private void loadDictionary() {
		try {
			DataInputStream in = new DataInputStream(WordFinderActivity.getInstance().getAssets().open("dict.png"));
			for (int i = 0; i < dictionary.length; i++) {
				dictionary[i] = in.readLong();
			}
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Solves the passed grid
	 */
	public TreeSet<String> solve(LetterGrid grid) {
		clearWords();
		for (int i = 0; i < grid.size(); i++) {
			for (int j = 0; j < grid.size(); j++) {
				solve(grid.getTile(i, j), "",
						new boolean[grid.size()][grid.size()], MAX_DEPTH);
			}
		}
		return foundWords;
	}

	/**
	 * Uses recursion to solve the letter grid
	 */
	private void solve(Tile tile, String current, boolean[][] visited, int depth) {
		String word = current + tile.getLetter();
		if (!isWord(word)) {
			
		} else {
			visited[tile.getX()][tile.getY()] = true;
			foundWords.add(word);
		}
		if (depth <= 0) {
			return;
		}
		for (Tile t : tile.getAdjascent()) {
			if (!visited[t.getX()][t.getY()]) {
				solve(t, word, visited, depth - 1);
			}
		}
		visited[tile.getX()][tile.getY()] = false;
	}

	/**
	 * Checks to see if the dictionary contains the passed word
	 * 
	 * @param word
	 *            the word to check
	 * @return whether or not the word is a word
	 */
	public boolean isWord(String word) {
		long longWord = stringToLong(word);
		int loc = Arrays.binarySearch(dictionary, longWord);
		if (loc >= 0 && dictionary[loc]==longWord) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Checks to see if the dictionary could contain the passed word
	 * 
	 * @param word
	 *            the word to check
	 * @return whether or not the word is a word
	 */
	public boolean couldBeWord(String word) {
		long longWord = stringToLong(word);
		int loc = Math.abs(Arrays.binarySearch(dictionary, longWord));
		return (dictionary[loc]&longWord)==longWord;		
	}
	
	public long find(String word){
		return (dictionary[Math.abs(Arrays.binarySearch(dictionary,stringToLong(word)))]);
	}

	/**
	 * Converts a String up to 12 characters in length into a long
	 * @param word the string to be converted
	 * @return the long form of the string
	 */
	private long stringToLong(String s) {
		int length = s.length() > 12 ? 12 : s.length();
		long l = 0;
		for (int i = 0; i < length; i++) {
			l += (long) ((s.charAt(i) - '`') & 31) << (55 - (i * 5));
		}
		return l;
	}

	/**
	 * Returns a set of all words the user has found on the grid
	 * @return set of all words on the grid
	 */
	public Set<String> getWords() {
		return foundWords;
	}


    /**
     * Returns an instance of this class
     */
    public static WordSolver getInstance()
    {
        if (instance == null)
        {
            instance = new WordSolver();
        }
        return instance;
    }
}
