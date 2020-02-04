package com.ssafy.tree;

public class LinkedTree {
	private TreeNode root;
	
	public void makeTree(int parentNode, int childNode) {
		// root 가 없으면 첫 parentNode가 root가 된다.
		if(this.root == null)
			this.root = new TreeNode(parentNode);
		// root가 있으면 root의 자손으로 parentNode를 찾아서 parentNode의 자식으로 childNode 추가
		makeTree(this.root, parentNode, childNode);
	}
	
	public void makeTree(TreeNode current, int parentNode, int childNode) {
		if(current != null) {
			if(current.data == parentNode) {  // parentNode는 root가 되므로 childNode를 자식에 추가
				TreeNode node = new TreeNode(childNode);
				if(current.left == null) current.left = node;
				else if(current.right == null) current.right = node;
				return;
			}
			makeTree(current.left, parentNode, childNode);
			makeTree(current.right, parentNode, childNode);
		}
	}
	
	public void preOrder(TreeNode node) {
		if(node != null) {
			System.out.print(node.data+" ");
			preOrder(node.left);
			preOrder(node.right);
		}
	}
	
	public TreeNode getRoot() {
		return this.root;
	}
}
