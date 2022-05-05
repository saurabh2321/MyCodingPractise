package com.saurabh.dsApps;

import com.saurabh.ds.BasicBinaryTree;

public class BinaryTreeApp {
	
	public static void main(String args[]) {
		
		BasicBinaryTree<Integer> tree = new BasicBinaryTree<>();
		
		tree.add(10);
		tree.add(5);
		tree.add(3);
		tree.add(6);
		tree.add(1);
		tree.add(20);
		tree.add(15);
		tree.add(25);
		
		System.out.println(tree.size());
		System.out.println("height:"+tree.countNbrOfLeaves());
		System.out.println(tree.contains(4));
		System.out.println(tree.findSmallest());
		System.out.println(tree.findlargest());
		System.out.println(tree.countNbrOfLeaves());
		System.out.println("in order traversal.....");
		tree.traverseInOrder();
		System.out.println();
		System.out.println("pre order traversal.....");
		tree.traversePreOrder();
		System.out.println();
		System.out.println("post order traversal.....");
		tree.traversePostOrder();
		System.out.println();
		System.out.println(tree.traverseLevelOrder().toString());
	}

}
