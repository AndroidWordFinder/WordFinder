package com.WordFinder;

public class Trie{
	private Node top;
	public Trie(){
		top = new Node('\u0000');
	}

	public void add(String word) throws Exception{
	String charSet = "abcdefghijklmnopqrstuvwxyz\r";
	word += "\r";
		Node current = top;
		for (char c:word.toCharArray()){
		if (charSet.contains(""+c)) current = current.addNode(c);
		else throw new Exception("Illegal Character: '" +c+ "'");
		}
	}

	public boolean startsWith(String word){
		Node current = top;
		for (char c:word.toCharArray()){
			if (current.branchContains(c)){
				current = current.getNode(c);
			}
			else return false;
		}
		return true;
	}


	public boolean contains(String word){
		return startsWith(word + "\r");
	}

	private class Node{
		private char letter = '\u0000';
		private Node[] branch;
		public Node(char c){
			letter = c;
			branch = new Node[27];
		}
		private int branchCount(){
			int toReturn = 0;
			for (Node n:branch){
				if (n != null) toReturn++;
			}
			return toReturn;
		}

		public Node addNode(char c){
			if(!branchContains(c)) branch[branchCount()] = new Node(c);

			return getNode(c);
		}

		public boolean branchContains(char c){
			return getNode(c)!=null;
		}


		public Node getNode(char c){
			for (int i=0; i<27; i++){
				if (branch[i] != null && branch[i].letter == c) return branch[i];
			}
			return null;
		}
	}
}