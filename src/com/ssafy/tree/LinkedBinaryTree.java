package com.ssafy.tree;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LinkedBinaryTree {
	public static final int PRE  = 1;
	public static final int IN   = 2;
	public static final int POST = 3;
	private TreeNode root;
	
	public TreeNode insertKey(TreeNode current, int x) {
		TreeNode p = current;
		TreeNode c = new TreeNode(x);
		if(p == null)
			return c;	//부모가 없으면 현재 만든 node가 parent가 됨
		else if(p.data > x)
			p.left = insertKey(p.left, x);
		else if(p.data < x)
			p.right = insertKey(p.right, x);
		return p;
	}
	
	public TreeNode searchBST(int x) {
		return findKey(this.root, x);
	}
//	public TreeNode searchBST(int x) {
//		TreeNode p = root;
//		while(p != null) {
//			if(p.data > x)
//				p = p.left;
//			else if(p.data < x)
//				p = p.right;
//			else
//				return p;
//		}
//		return null;
//	}
	
	public TreeNode findKey(TreeNode current, int x) {
		if(current == null)
			return current;
		else {
			if(current.data == x)
				return current;
			else {
				TreeNode node = null;
				if(current.data > x)
					node = current.left;
				else if(current.data < x)
					node = current.right;
				return findKey(node,x);
			}
		}
	}
	
	public void insertBST(int x) {
		root = insertKey(root, x);
	}
	
	public void printBST(int method, TreeNode node) {
		switch(method) {
			case 1:
				preOrder(node);
				break;
			case 2:
				inOrder(node);
				break;
			case 3:
				postOrder(node);
				break;
		}
		System.out.println();
	}
	
	public void inOrder(TreeNode root) {
		if(root != null) {
			inOrder(root.left);
			System.out.print(root.data+" ");
			inOrder(root.right);
		}
	}
	public void postOrder(TreeNode root) {
		if(root != null) {
			postOrder(root.left);
			postOrder(root.right);
			System.out.print(root.data+" ");
		}
	}
	public void preOrder(TreeNode root) {
		if(root != null) {
			System.out.print(root.data+" ");
			preOrder(root.left);
			preOrder(root.right);
		}
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/tree.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		LinkedBinaryTree bst = new LinkedBinaryTree();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			bst.insertBST(Integer.parseInt(st.nextToken()));
		}
		
		System.out.println("[inOrder]");
		bst.printBST(IN, bst.root);
		System.out.println("\n-------------------------");
		TreeNode find = bst.searchBST(4);
		if(find == null) System.out.println("탐색 실패");
		else {
			System.out.println(find.data+" 탐색 성공");
			bst.printBST(IN, find);
		}
		
		find = bst.searchBST(19);
		if(find == null) System.out.println("탐색 실패");
		else {
			System.out.println(find.data+" 탐색 성공");
			bst.printBST(IN, find);
		}
	}
}
