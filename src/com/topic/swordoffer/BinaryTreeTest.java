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
		System.out.println("�ݹ�ǰ��:");
		bTree.preorderTraversal(bTree.root);
		System.out.println("\n�ǵݹ�ǰ��");
		bTree.noRecPreorderTraversal(bTree.root);
		
		System.out.println("\n\n�ǵݹ�����");
		bTree.noRecInorderTraversal(bTree.root);
		System.out.println("\n�ݹ�����");
		
		bTree.inorderTraversal(bTree.root);
		System.out.println("\n\n�ݹ����");
		bTree.postorderTraversal(bTree.root);
		System.out.println("\n�ǵݹ����");
		String[] orders = bTree.noRecPostorderTraversal(bTree.root);

		System.out.println("\n\n�ǵݹ������һ�ַ���ʵ�����б�����");
		for (int i = 0; i < orders.length; i++) {
			System.out.println(orders[i]);
		}*/
	}
}
