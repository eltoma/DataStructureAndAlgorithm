package com.topic.swordoffer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 包含：
 * 	1. 二叉树的构造(根据输入的层次遍历序，按完全二叉树规则建立二叉树)
 *  2. 二叉树的 前序|中序|后序 遍历(递归非递归)
 *  3. main函数测试
 * @author elotoma
 */
public class BinaryTree {
	public static void main(String[] args) {
		Integer[] nodes = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };
		BTree<Integer> bTree = new BTree<Integer>(nodes);
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
	 * 按层次遍历的顺序建立二叉树
	 * @param list 二叉树的层次遍历序列
	 */
	public BTree(E[] list) {
		Queue<Node<E>> q = new LinkedList<Node<E>>();
		this.root = new Node<E>(list[0]);;
		q.add(root);
		for (int i = 1; i < list.length; i++) {
			Node<E> qhead = q.peek();
			// 当节点的左孩子为空时，先添加到节点的左孩子
			if(q.peek().lNode == null) {
				qhead.lNode = new Node<E>(list[i]);
				q.add(qhead.lNode);
			}
			else if (q.peek().rNode == null) {
				qhead.rNode = new Node<E>(list[i]);
				q.add(qhead.rNode);
			    // 该节点的孩子已经添加完，移出队列
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
	 * 入栈顺序
	 * @param n
	 */
	public void noRecPreorderTraversal(Node<E> n) {
		Node<E> cNode = n;
		Stack<Node<E>> stack = new Stack<Node<E>>();
		while(cNode != null || !stack.isEmpty()) {
			// 一直向左并将沿途结点压入堆栈
			while(cNode != null) {
				stack.push(cNode);
				System.out.print(cNode.val + ", ");
				cNode = cNode.lNode;
			}
			
			if(!stack.isEmpty()) {
				// 弹出结点
				cNode = stack.pop();
				// 转向右子树
				cNode = cNode.rNode;
			}
		}
	}
	/**
	 * 出栈顺序
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
			// 左子树节点循环入栈
			while(cNode != null) {
				stack.push(cNode);
				// 标记第一次访问
				visited.push(false);
				cNode = cNode.lNode;
			}
			// 右子树孩子循环出栈
			while(!stack.isEmpty() && visited.peek()) {
				visited.pop();
				System.out.print(stack.pop().val + ", ");
			}
			
			// 到达叶子节点，开始出栈
			if(!stack.isEmpty()) {
				// 根节点先不出栈(访问)
				cNode = stack.peek();
				// 转向右子数
				cNode = cNode.rNode;
				// 标记第二次访问
				visited.pop();
				visited.push(true);
			}
		}
	}
}
