package com.saurabh.ds;

import java.util.ArrayList;
import java.util.List;

public class BasicBinaryTree<X extends Comparable<X>> {

	private Node root;
	private int size;

	public BasicBinaryTree() {
		this.root = null;
	}

	public int size() {
		return this.size;
	}

	private void insert(Node parent, Node child) {

		// if the child is less than the parent, it goes to the the left
		if (child.getItem().compareTo(parent.getItem()) < 0) {
			// if the left node is null, then we have found our spot
			if (parent.getLeft() == null) {
				parent.setLeft(child);
				child.setParent(parent);
				size++;
			} else {
				insert(parent.getLeft(), child);
			}
		}
		// if the child is greater than the parent, it goes to the the right
		else if (child.getItem().compareTo(parent.getItem()) > 0) {
			// if the right node is null, then we have found our spot
			if (parent.getRight() == null) {
				parent.setRight(child);
				child.setParent(parent);
				size++;
			} else {
				insert(parent.getRight(), child);
			}
		}
		// if parent and child is equal then we dont do anything since data in binary
		// tree data is assumed to be unique

	}

	public void add(X item) {
		Node node = new Node(item);

		// if this is the first item in the tree, set it as root

		if (this.root == null) {
			this.root = node;
			System.out.println("Setting root: " + node.getItem());
			this.size++;
		} else {
			insert(this.root, node);
		}
	}

	public boolean contains(X item) {

		Node currentNode = getNode(item);

		if (currentNode == null) {
			// didnt find it
			return false;
		} else {
			return true;
		}

	}

	private Node getNode(X item) {

		Node currentNode = root;
		while (currentNode != null) {
			int val = item.compareTo(currentNode.getItem());

			// see if the node is a match
			if (val == 0) {
				return currentNode;
			}
			// if value is less than 0 then goto the left of the tree
			else if (val < 0) {
				currentNode = currentNode.getLeft();
			} else {
				// otherwise go the right
				currentNode = currentNode.getRight();
			}
		}

		return null;
	}

	// find smallest using recursion
	private X smallest(Node node) {
		if (node.left == null) {
			return node.item;
		}
		return smallest(node.left);
	}

	public X findSmallest() {

		if (this.root != null) {
			return smallest(this.root);
		}
		return null;
	}

	// find largest using iterative way
	public X findlargest() {

		Node current = this.root;

		while (current.getRight() != null) {

			current = current.right;
		}
		return current.getItem();
	}

	public int countNbrOfLeaves() {
		if (this.root != null) {
			return height(this.root);
		}
		return 0;
	}

	// count the nbr of leaf nodes
	private int nbrOfLeafNodes(Node node) {

		if (isLeaf(node)) {
			return 1;
		}
		int leftLeaves = 0;
		int rightLeaves = 0;
		if (node.getLeft() != null) {
			leftLeaves = nbrOfLeafNodes(node.getLeft());
		}
		if (node.getRight() != null) {
			rightLeaves = nbrOfLeafNodes(node.getRight());
		}
		return leftLeaves + rightLeaves;

	}

	private boolean isLeaf(Node node) {
		return node.left == null && node.right == null;
	}
	
	public int getHeight() {
		if (this.root != null) {
			return height(this.root);
		}
		return 0;
	}
	
	private int height(Node node) {

		if (isLeaf(node)) {
			return 1;
		}
		int left = 0;
		int right = 0;
		if (node.getLeft() != null) {
			left = nbrOfLeafNodes(node.getLeft());
		}
		if (node.getRight() != null) {
			right = nbrOfLeafNodes(node.getRight());
		}
		return (left > right) ? (left + 1) : (right + 1);

	}


	private void inOrder(Node node) {

		if (node.getLeft() != null) {
			inOrder(node.getLeft());
		}
		System.out.print(node.getItem() + " ");
		if (node.getRight() != null) {
			inOrder(node.getRight());
		}
	}

	public void traverseInOrder() {
		if (this.root != null) {
			inOrder(this.root);
		}
	}

	private void preOrder(Node node) {

		System.out.print(node.getItem() + " ");
		if (node.getLeft() != null) {
			preOrder(node.getLeft());
		}
		if (node.getRight() != null) {
			preOrder(node.getRight());
		}
	}

	public void traversePreOrder() {
		if (this.root != null) {
			preOrder(this.root);
		}
	}

	private void postOrder(Node node) {

		if (node.getLeft() != null) {
			postOrder(node.getLeft());
		}
		if (node.getRight() != null) {
			postOrder(node.getRight());
		}
		System.out.print(node.getItem() + " ");
	}

	public void traversePostOrder() {
		if (this.root != null) {
			postOrder(this.root);
		}
	}
	
	List<List<X>> levels  = new ArrayList<>();
	public List<List<X>> traverseLevelOrder() {
	        
	        if(root == null)
	            return levels;
	        
	        traverseByLevel(root, 0);
	        return levels;
	        
	    }
	
	 public void traverseByLevel(Node node, int level){
	        
	        if(levels.size() == level)
	            levels.add(new ArrayList<X>());
	        
	        levels.get(level).add(node.item);
	        
	        if(node.left != null)
	           traverseByLevel(node.left, level+1); 
	         
	         if(node.right != null)
	           traverseByLevel(node.right, level+1); 
	    }

	private class Node {

		private Node left;
		private Node right;
		private Node parent;
		private X item;

		public Node(X item) {
			this.item = item;
			this.right = null;
			this.left = null;
			this.parent = null;
		}

		public Node getLeft() {
			return left;
		}

		public void setLeft(Node left) {
			this.left = left;
		}

		public Node getRight() {
			return right;
		}

		public void setRight(Node right) {
			this.right = right;
		}

		public Node getParent() {
			return parent;
		}

		public void setParent(Node parent) {
			this.parent = parent;
		}

		public X getItem() {
			return item;
		}

		public void setItem(X item) {
			this.item = item;
		}

	}

}
