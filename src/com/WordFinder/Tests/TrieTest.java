package com.WordFinder.Tests;
import com.WordFinder.*;

public class TrieTest extends student.TestCase
{
    public Trie trie;
    public void setUp() {
        trie = new Trie();
    }

    public void testAdd() {
        trie.add("hello");
    }
}
