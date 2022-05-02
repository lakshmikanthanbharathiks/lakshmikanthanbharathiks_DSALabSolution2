package com.greatlearning.PairWithSumInBST.Model;

import java.util.HashSet;
import java.util.Set;
import java.util.*;

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
	public static Node insert(Node root, int key)
	{
		if (root == null) 
		{
			return new Node(key);
		}

		if (key < root.data) {
			root.left = insert(root.left, key);
		}

		else {
			root.right = insert(root.right, key);
		}

		return root;
	}

	public static boolean findPair(Node root, int target, Set<Integer> set)
	{
		if (root == null) {
			return false;
		}

		if (findPair(root.left, target, set)) {
			return true;
		}

		if (set.contains(target - root.data))
		{
			System.out.println("Pair is (" + (target - root.data) + ","
									+ root.data + ")");
			return true;
		}

		else {
			set.add(root.data);
		}

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

		System.out.println("Sum = "+target);
        
		Set<Integer> set = new HashSet<>();

		if (!findPair(root, target, set)) {
			System.out.println("Nodes are not found");
		}
	}
}
