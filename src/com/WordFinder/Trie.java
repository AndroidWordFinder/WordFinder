package com.WordFinder;

public class Trie
{
    private Node top;
    private Node location;


    public Trie()
    {
        top = new Node();
        location = top;
    }


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
     * Checks to see if the current node has the passed char in a branch NOTE:
     * Changes the state of the Trie Advances the current location to the branch
     * containing the passed char, if that branch exists.
     *
     * @param c
     *            the character that is checked for existance in the current
     *            node's branches
     * @return whether or not the current node in the Trie has the passed char
     *         in a branch
     */
    public boolean hasNext(char c)
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
     * Place a description of your method here.
     *
     * @return whether or not the current location in the trie is at the
     *         termination of a complete word
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
     * // ----------------------------------------------------------------------
     * --- /** Write a one-sentence summary of your class here. Follow it with
     * additional details about its purpose, what abstraction it represents, and
     * how to use it.
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
        private char   letter;


        public Node()
        {
            this('\0');
        }


        public Node(char c)
        {
            this(c, null);
        }


        public Node(char c, Node parent)
        {
            letter = c;
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
                branch[c - 'a'] = new Node(c, this);
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
