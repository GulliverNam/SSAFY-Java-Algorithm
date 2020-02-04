package com.ssafy.tree;

import java.io.FileInputStream;
import java.util.Scanner;


public class TreeListTest {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/tree3.txt"));
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		LinkedTree blt = new LinkedTree();
		for (int i = 0; i < N-1; i++) {
			blt.makeTree(sc.nextInt(), sc.nextInt());
		}
		blt.preOrder(blt.getRoot());
		System.out.println();
		sc.close();
	}

}
