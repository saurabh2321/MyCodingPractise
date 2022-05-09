package com.saurabh.leetcode;
//convert binary tree to doubly linked list using recursion

class BinaryTreeToDLL {

	Node root;
	Node head;
	Node prev = null;

	void binaryTree2DoubleLinkedList(Node root) {

		if (root == null) {
			return;
		}

		binaryTree2DoubleLinkedList(root.left);

		if (prev == null) {
			head = root;
		} else {
			root.left = prev;
			prev.right = root;
		}
		prev = root;

		binaryTree2DoubleLinkedList(root.right);
	}

	void printList(Node node) {
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.right;
		}
	}

	public static void main(String[] args) {

		BinaryTreeToDLL tree = new BinaryTreeToDLL();
		tree.root = new Node(10);
		tree.root.left = new Node(12);
		tree.root.right = new Node(15);
		tree.root.left.left = new Node(25);
		tree.root.left.right = new Node(30);
		tree.root.right.left = new Node(36);
		tree.binaryTree2DoubleLinkedList(tree.root);
		tree.printList(tree.head);
	}
}
