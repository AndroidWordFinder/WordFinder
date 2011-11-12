package com.WordFinder.Tests;
import com.WordFinder.*;

/**
 *  Tests the Trie class and its operations
 *
 *  @author John Mooring (jmooring)
 *  @author Bryan Malyn (bmalyn)
 *  @author Christopher Buck (cmbuck)
 *  @version Nov 12, 2011
 */
public class TrieTest extends student.TestCase
{
    private Trie trie;

    /**
     * Sets up the testing environment
     */
    public void setUp()
    {
        trie = new Trie();
    }

    /**
     * Tests the basic functionality of the add() method
     * This also tests the hasNext() and gotoNext() methods
     */
    public void testAddBasic()
    {
        assertFalse(trie.hasNext('h'));
        trie.add("hello");
        assertTrue(trie.hasNext('h'));
        assertFalse(trie.hasNext('e'));
        trie.gotoNext('h');
        assertTrue(trie.hasNext('e'));
        trie.gotoNext('e');
        assertTrue(trie.gotoNext('l'));
        assertTrue(trie.gotoNext('l'));
        assertTrue(trie.gotoNext('o'));
    }

    /**
     * Tests the isWord() method
     */
    public void testIsWord()
    {
        assertFalse(trie.isWord());
        testAddBasic();
        assertTrue(trie.isWord());
    }

    /**
     * Tests the pop() method
     */
    public void testPop()
    {
        testAddBasic();
        assertFalse(trie.hasNext('o'));
        trie.pop();
        assertTrue(trie.hasNext('o'));
        assertFalse(trie.hasNext('l'));
        trie.pop();
        assertTrue(trie.hasNext('l'));
        trie.pop();
        assertTrue(trie.hasNext('l'));
        trie.pop();
        assertTrue(trie.hasNext('e'));
        trie.pop();
        assertTrue(trie.hasNext('h'));
    }
}
