package com.topic.swordoffer;

import java.util.ArrayList;


/**
 * @author elotoma
 */
public class BinaryTreeTest {
	public static void main(String[] args) {
		//Integer[] nodes = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };
		Integer[] list1 = { 8,8,7,9,3};
		
		BinaryTree<Integer> bTree1 = new BinaryTree<Integer>(list1);
		ArrayList res = new ArrayList();
		
		res = BinaryTree.printFromTopToBottom(null);
		
		for(Object integer : res) {
			System.out.print(integer);
		}
		
/*		BTree<Integer> bTree2 = new BTree<Integer>(list2);
		
		boolean res = bTree1.hasSubtree(bTree1.root, bTree2.root);
		System.out.println(res);*/
		
		
		
/*		BTree<Integer> bTree = new BTree<Integer>(nodes);
		System.out.println("递归前序:");
		bTree.preorderTraversal(bTree.root);
		System.out.println("\n非递归前序");
		bTree.noRecPreorderTraversal(bTree.root);
		
		System.out.println("\n\n非递归中序");
		bTree.noRecInorderTraversal(bTree.root);
		System.out.println("\n递归中序");
		
		bTree.inorderTraversal(bTree.root);
		System.out.println("\n\n递归后序");
		bTree.postorderTraversal(bTree.root);
		System.out.println("\n非递归后序");
		String[] orders = bTree.noRecPostorderTraversal(bTree.root);

		System.out.println("\n\n非递归遍历，一种方法实现所有遍历序：");
		for (int i = 0; i < orders.length; i++) {
			System.out.println(orders[i]);
		}*/
	}
}
