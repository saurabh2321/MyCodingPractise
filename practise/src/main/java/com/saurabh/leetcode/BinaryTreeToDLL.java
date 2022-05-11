package com.saurabh.leetcode;
//convert binary tree to doubly linked list using recursion

class BinaryTreeToDLL {

	TreeNode root;
	TreeNode head;
	TreeNode prev = null;

	void binaryTree2DoubleLinkedList(TreeNode root) {

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

	void printList(TreeNode TreeNode) {
		while (TreeNode != null) {
			System.out.print(TreeNode.data + " ");
			TreeNode = TreeNode.right;
		}
	}

	public static void main(String[] args) {

		BinaryTreeToDLL tree = new BinaryTreeToDLL();
		tree.root = new TreeNode(10);
		tree.root.left = new TreeNode(12);
		tree.root.right = new TreeNode(15);
		tree.root.left.left = new TreeNode(25);
		tree.root.left.right = new TreeNode(30);
		tree.root.right.left = new TreeNode(36);
		tree.binaryTree2DoubleLinkedList(tree.root);
		tree.printList(tree.head);
	}
}
