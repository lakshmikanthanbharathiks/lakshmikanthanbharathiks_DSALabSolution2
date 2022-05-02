package com.greatlearning.PairWithSumInBST.Model;

import java.util.HashSet;
import java.util.Set;
import java.util.*;

// A class to store a BST node
class Node
{
	int data;
	Node left = null, right = null;

	Node(int data) {
		this.data = data;
	}
}

class Main
{
	// Recursive function to insert a key into a BST
	public static Node insert(Node root, int key)
	{
		// if the root is null, create a new node and return it
		if (root == null) {
			return new Node(key);
		}

		// if the given key is less than the root node, recur for the left subtree
		if (key < root.data) {
			root.left = insert(root.left, key);
		}

		// if the given key is more than the root node, recur for the right subtree
		else {
			root.right = insert(root.right, key);
		}

		return root;
	}

	// Function to find a pair with a given sum in the BST
	public static boolean findPair(Node root, int target, Set<Integer> set)
	{
		// base case
		if (root == null) {
			return false;
		}

		// return true if pair is found in the left subtree; otherwise, continue
		// processing the node
		if (findPair(root.left, target, set)) {
			return true;
		}

		// if a pair is formed with the current node, print the pair and return true
		if (set.contains(target - root.data))
		{
			System.out.println("Pair is (" + (target - root.data) + ","
									+ root.data + ")");
			return true;
		}

		// insert the current node's value into the set
		else {
			set.add(root.data);
		}

		// search in the right subtree
		return findPair(root.right, target, set);
	}

	public static void main(String[] args)
	{
		int[] keys = { 40,20,60,10,30,50,70 };

		Node root = null;
		for (int key: keys) {
			root = insert(root, key);
		}
		
		Scanner sc = new Scanner(System.in); 
        
		System.out.println("Enter the sum for searching the pair in the BST: ");
			int target = sc.nextInt();

		// find pair with the given sum
		System.out.println("Sum = "+target);
        
		// create an empty set
		Set<Integer> set = new HashSet<>();

		if (!findPair(root, target, set)) {
			System.out.println("Nodes are not found");
		}
	}
}
