package com.WordFinder;

public class Trie
{
    private Node top;
    private Node location;

    /**
     * Constructs a new Trie
     */
    public Trie()
    {
        top = new Node(null);
        location = top;
    }

    /**
     * Adds a word to the Trie (prefix tree)
     * Each letter in the word is a node in the Trie; each letter is the parent
     *  of the next letter.
     * @param add The word to add to the Trie
     * @return True if success, False if an error was encountered
     */
    public boolean add(String add)
    {
        String charSet = "abcdefghijklmnopqrstuvwxyz{";
        // Using { as word terminator as it's ASCII value is 1 higher than z
        // which makes array lookups easy
        Node current = top;

        String word = add + "{";
        for (char c : word.toCharArray())
        {
            if (charSet.contains("" + c))
            {
                current = current.addNode(c);
            }
            else
            {
                return false;
            }
        }
        return true;
    }

    /**
     * Checks to see if the current node has the passed char in a branch
     *
     * @param c the character that is checked for existence in the current
     *      node's branches
     * @return whether or not the current node in the Trie has the specified
     *      char in a branch
     */
    public boolean hasNext(char c)
    {
        return location.branchContains(c);
    }

    /**
     * Changes the state of the Trie Advances the current location to the branch
     * containing the passed char, if that branch exists.
     *
     * @param c The next character that the node will point to
     * @return whether or not the current node in the Trie has changed
     */
    public boolean gotoNext(char c)
    {
        Node n = location.getNode(c);
        if (n != null)
        {
            location = n;
            return true;
        }
        else
        {
            return false;
        }
    }


    /**
     * Determines if the set of letters from the top of the trie down to the
     *      current Node is a (full) word.
     * This is indicated by the existance of a '{' character Node as one of the
     *      children of the current Node.
     *
     * @return whether or not the current location in the trie is at the
     *      termination of a complete word
     */
    public boolean isWord()
    {
        return location.branchContains('{');
    }


    /**
     * Backs up the current location 1 step.
     */
    public void pop()
    {
        location = location.getParent();
    }


    /**
     * Node class for storing data in the Trie
     *
     * @author John Mooring (jmooring)
     * @author Bryan Malyn (bmalyn)
     * @author Christopher Buck (cmbuck)
     * @version 2011.11.10
     */
    private class Node
    {
        private Node[] branch;
        private Node   parent;

        public Node(Node parent)
        {
            branch = new Node[27];
            this.parent = parent;
        }


        public Node getParent()
        {
            return parent;
        }


        public Node addNode(char c)
        {
            if (!branchContains(c))
            {
                branch[c - 'a'] = new Node(this);
            }
            return getNode(c);
        }


        public boolean branchContains(char c)
        {
            return branch[c - 'a'] != null;
        }


        public Node getNode(char c)
        {
            return branch[c - 'a'];
        }
    }
}
