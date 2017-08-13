package com.topic.swordoffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import org.junit.Test;

/**
 * ������
 * 	1. �������Ĺ���(��������Ĳ�α����򣬰���ȫ������������������)
 *  2. �������� ǰ��|����|���� ����(�ݹ�ǵݹ�)
 *  3. �����������Ƿ�����ӽṹ��ϵ
 * @author elotoma
 */
public class BinaryTree<E> {
	TreeNode<E> root;
	
	/**
	 * ����α�����˳����������
	 * @param list �������Ĳ�α�������
	 */
	public BinaryTree(E[] list) {
		Queue<TreeNode<E>> q = new LinkedList<TreeNode<E>>();
		this.root = new TreeNode<E>(list[0]);;
		q.add(root);
		for (int i = 1; i < list.length; i++) {
			TreeNode<E> qhead = q.peek();
			// ���ڵ������Ϊ��ʱ������ӵ��ڵ������
			if(q.peek().left == null) {
				qhead.left = new TreeNode<E>(list[i]);
				q.add(qhead.left);
			}
			else if (q.peek().right == null) {
				qhead.right = new TreeNode<E>(list[i]);
				q.add(qhead.right);
			    // �ýڵ�ĺ����Ѿ�����꣬�Ƴ�����
				q.remove();
			} else {
			}
		}
	}
	
	public void preorderTraversal(TreeNode<E> n) {
		if(n != null) {
			System.out.print(n.val + ", ");
			preorderTraversal(n.left);
			preorderTraversal(n.right);
		}
	}
	
	public void inorderTraversal(TreeNode<E> n) {
		if(n != null) {
			inorderTraversal(n.left);
			System.out.print(n.val + ", ");
			inorderTraversal(n.right);
		}
	}
	
	public void postorderTraversal(TreeNode<E> n) {
		if(n != null) {
			postorderTraversal(n.left);
			postorderTraversal(n.right);
			System.out.print(n.val + ", ");
		}
	}
	/**
	 * ��ջ˳��
	 * @param n
	 */
	public void noRecPreorderTraversal(TreeNode<E> n) {
		TreeNode<E> cNode = n;
		Stack<TreeNode<E>> stack = new Stack<TreeNode<E>>();
		while(cNode != null || !stack.isEmpty()) {
			// һֱ���󲢽���;���ѹ���ջ
			while(cNode != null) {
				stack.push(cNode);
				System.out.print(cNode.val + ", ");
				cNode = cNode.left;
			}
			
			if(!stack.isEmpty()) {
				// �������
				cNode = stack.pop();
				// ת��������
				cNode = cNode.right;
			}
		}
	}
	/**
	 * ��ջ˳��
	 * @param n
	 */
	public void noRecInorderTraversal(TreeNode<E> n) {
		TreeNode<E> cNode = n;
		Stack<TreeNode<E>> stack = new Stack<TreeNode<E>>();
		while(cNode != null || !stack.isEmpty()) {
			while(cNode != null) {
				stack.push(cNode);
				cNode = cNode.left;
			}
			
			if(!stack.isEmpty()) {
				cNode = stack.pop();
				System.out.print(cNode.val + ", ");
				cNode = cNode.right;
			}
		}
	}
	/**
	 * �ǵݹ����������
	 * @param n
	 * @return ���ֱ���������ַ������� 0 ��ǰ   1:��  2����
	 */
	public String[] noRecPostorderTraversal(TreeNode<E> n) {
		TreeNode<E> cNode = n;
		Stack<TreeNode<E>> stack = new Stack<TreeNode<E>>();
		Stack<Boolean> visited = new Stack<Boolean>();
		String[] order = {"ǰ��","�У�","��"};
		while(cNode != null || !stack.isEmpty()) {
			// ��һ�η��ʣ��������ڵ�ѭ����ջ
			while(cNode != null) {
				stack.push(cNode);
				// ��ǵ�һ�η���
				visited.push(false);
				order[0] = order[0] + cNode.val + ",";
				cNode = cNode.left;
			}
			// �����η��ʣ�������Ѿ��������Σ�visited == true������ջ
			while(!stack.isEmpty() && visited.peek()) {
				visited.pop();
				TreeNode node = stack.pop();
				order[2] = order[2] + node.val+ ",";
				System.out.print(node.val + ", ");
			}
			
			// �ڶ��η��ʣ�ת��������
			if(!stack.isEmpty()) {
				// ���ڵ��Ȳ���ջ(����)
				cNode = stack.peek();
				// ת��������
				order[1] = order[1] + cNode.val+ ",";
				cNode = cNode.right;
				// ��ǵڶ��η���
				visited.pop();
				visited.push(true);
			}
		}
		return order;
	}
	
	/**
	 * ���root2�Ƿ�Ϊroot1���ӽṹ
	 * @param root1
	 * @param root2
	 * @return
	 */
	public boolean hasSubtree(TreeNode root1,TreeNode root2) {
		 // root1 Ϊ�յĻ���root2�϶�����root1������
		 if(root1 == null || root2 == null) {
			 return false;
		 }
		 
		 return // �ж�root2�Ƿ�Ϊroot1�Ե�ǰ�ڵ�Ϊ���ڵ���������
				doseTree1HaveTree2(root1, root2)
				// ��������㣬�����������
				|| hasSubtree(root1.left, root2)
				// �������������
				|| hasSubtree(root1.right, root2);
	 }
	 
	 /**
	  * ��� root1 ��Ϊ root1 ������(root1�ĸ��ڵ�ȷ��Ϊroot1)
	  * @param root1
	  * @param root2
	  * @return
	  */
	 public boolean doseTree1HaveTree2(TreeNode root1, TreeNode root2) {
		 // �ȵ���root2��Ҷ�ӽڵ㣬������
		 if(root2 == null) {
			 return true;
		 }
		 // �ȵ���root1�ĸ��ڵ㣬���ؼ�
		 if(root1 == null) {
			 return false;
		 }
		 
		 // ���ڽڵ㲻��ȣ���ǰ�˳�
		 if(root1.val != root2.val) {
			 return false;
		 }
		 
		 // �ݹ���ã��鿴���������Ƿ����������ϵ
		 return  // ������
				 doseTree1HaveTree2(root1.left, root2.left) && 
				 // ������
				 doseTree1HaveTree2(root1.right, root2.right);
	 }
	 
	 public static void mirror(TreeNode root) {
		if(root == null) {
			return;
		}
		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;
		
		mirror(root.left);
		mirror(root.right);
	 }
	 
	 /**
	  * ���Ĳ�α�����
	  * @param root
	  * @return
	  */
	 public static ArrayList<Integer> printFromTopToBottom(TreeNode root) {
		 ArrayList res = new ArrayList();
		 Queue queue = new LinkedList();
		 if(root == null) {
			 return res;
		 }
		 queue.offer(root);
		 while(queue.size() > 0) {
			 TreeNode tempNode = (TreeNode) queue.remove();
			 if(tempNode.left != null) {
				 queue.add(tempNode.left);
			 }
			 if(tempNode.right != null) {
				 queue.add(tempNode.right);
			 }
			 res.add(tempNode.val);
		 }
		 return res;
	 }
	 
}