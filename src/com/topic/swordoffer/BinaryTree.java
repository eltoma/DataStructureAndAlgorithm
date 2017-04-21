package com.topic.swordoffer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * ������
 * 	1. �������Ĺ���(��������Ĳ�α����򣬰���ȫ������������������)
 *  2. �������� ǰ��|����|���� ����(�ݹ�ǵݹ�)
 *  3. main��������
 * @author elotoma
 */
public class BinaryTree {
	public static void main(String[] args) {
		Integer[] nodes = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };
		BTree<Integer> bTree = new BTree<Integer>(nodes);
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
		bTree.noRecPostorderTraversal(bTree.root);
	}
}

class Node<E> {
	E val;
	Node<E> lNode;
	Node<E> rNode;
	
	public Node(E val) {
		this.val = val;
	}
}
class BTree<E> {
	Node<E> root;
	
	/**
	 * ����α�����˳����������
	 * @param list �������Ĳ�α�������
	 */
	public BTree(E[] list) {
		Queue<Node<E>> q = new LinkedList<Node<E>>();
		this.root = new Node<E>(list[0]);;
		q.add(root);
		for (int i = 1; i < list.length; i++) {
			Node<E> qhead = q.peek();
			// ���ڵ������Ϊ��ʱ������ӵ��ڵ������
			if(q.peek().lNode == null) {
				qhead.lNode = new Node<E>(list[i]);
				q.add(qhead.lNode);
			}
			else if (q.peek().rNode == null) {
				qhead.rNode = new Node<E>(list[i]);
				q.add(qhead.rNode);
			    // �ýڵ�ĺ����Ѿ�����꣬�Ƴ�����
				q.remove();
			} else {
			}
		}
	}
	
	public void preorderTraversal(Node<E> n) {
		if(n != null) {
			System.out.print(n.val + ", ");
			preorderTraversal(n.lNode);
			preorderTraversal(n.rNode);
		}
	}
	
	public void inorderTraversal(Node<E> n) {
		if(n != null) {
			inorderTraversal(n.lNode);
			System.out.print(n.val + ", ");
			inorderTraversal(n.rNode);
		}
	}
	
	public void postorderTraversal(Node<E> n) {
		if(n != null) {
			postorderTraversal(n.lNode);
			postorderTraversal(n.rNode);
			System.out.print(n.val + ", ");
		}
	}
	/**
	 * ��ջ˳��
	 * @param n
	 */
	public void noRecPreorderTraversal(Node<E> n) {
		Node<E> cNode = n;
		Stack<Node<E>> stack = new Stack<Node<E>>();
		while(cNode != null || !stack.isEmpty()) {
			// һֱ���󲢽���;���ѹ���ջ
			while(cNode != null) {
				stack.push(cNode);
				System.out.print(cNode.val + ", ");
				cNode = cNode.lNode;
			}
			
			if(!stack.isEmpty()) {
				// �������
				cNode = stack.pop();
				// ת��������
				cNode = cNode.rNode;
			}
		}
	}
	/**
	 * ��ջ˳��
	 * @param n
	 */
	public void noRecInorderTraversal(Node<E> n) {
		Node<E> cNode = n;
		Stack<Node<E>> stack = new Stack<Node<E>>();
		while(cNode != null || !stack.isEmpty()) {
			while(cNode != null) {
				stack.push(cNode);
				cNode = cNode.lNode;
			}
			
			if(!stack.isEmpty()) {
				cNode = stack.pop();
				System.out.print(cNode.val + ", ");
				cNode = cNode.rNode;
			}
		}
	}
	public void noRecPostorderTraversal(Node<E> n) {
		Node<E> cNode = n;
		Stack<Node<E>> stack = new Stack<Node<E>>();
		Stack<Boolean> visited = new Stack<Boolean>();
		while(cNode != null || !stack.isEmpty()) {
			// �������ڵ�ѭ����ջ
			while(cNode != null) {
				stack.push(cNode);
				// ��ǵ�һ�η���
				visited.push(false);
				cNode = cNode.lNode;
			}
			// ����������ѭ����ջ
			while(!stack.isEmpty() && visited.peek()) {
				visited.pop();
				System.out.print(stack.pop().val + ", ");
			}
			
			// ����Ҷ�ӽڵ㣬��ʼ��ջ
			if(!stack.isEmpty()) {
				// ���ڵ��Ȳ���ջ(����)
				cNode = stack.peek();
				// ת��������
				cNode = cNode.rNode;
				// ��ǵڶ��η���
				visited.pop();
				visited.push(true);
			}
		}
	}
}
