package com.topic.swordoffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import org.junit.Test;

/**
 * 包含：
 * 	1. 二叉树的构造(根据输入的层次遍历序，按完全二叉树规则建立二叉树)
 *  2. 二叉树的 前序|中序|后序 遍历(递归非递归)
 *  3. 两个二叉树是否存在子结构关系
 * @author elotoma
 */
public class BinaryTree<E> {
	TreeNode<E> root;
	
	/**
	 * 按层次遍历的顺序建立二叉树
	 * @param list 二叉树的层次遍历序列
	 */
	public BinaryTree(E[] list) {
		Queue<TreeNode<E>> q = new LinkedList<TreeNode<E>>();
		this.root = new TreeNode<E>(list[0]);;
		q.add(root);
		for (int i = 1; i < list.length; i++) {
			TreeNode<E> qhead = q.peek();
			// 当节点的左孩子为空时，先添加到节点的左孩子
			if(q.peek().left == null) {
				qhead.left = new TreeNode<E>(list[i]);
				q.add(qhead.left);
			}
			else if (q.peek().right == null) {
				qhead.right = new TreeNode<E>(list[i]);
				q.add(qhead.right);
			    // 该节点的孩子已经添加完，移出队列
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
	 * 入栈顺序
	 * @param n
	 */
	public void noRecPreorderTraversal(TreeNode<E> n) {
		TreeNode<E> cNode = n;
		Stack<TreeNode<E>> stack = new Stack<TreeNode<E>>();
		while(cNode != null || !stack.isEmpty()) {
			// 一直向左并将沿途结点压入堆栈
			while(cNode != null) {
				stack.push(cNode);
				System.out.print(cNode.val + ", ");
				cNode = cNode.left;
			}
			
			if(!stack.isEmpty()) {
				// 弹出结点
				cNode = stack.pop();
				// 转向右子树
				cNode = cNode.right;
			}
		}
	}
	/**
	 * 出栈顺序
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
	 * 非递归遍历二叉树
	 * @param n
	 * @return 三种遍历结果的字符串数组 0 ：前   1:中  2：后
	 */
	public String[] noRecPostorderTraversal(TreeNode<E> n) {
		TreeNode<E> cNode = n;
		Stack<TreeNode<E>> stack = new Stack<TreeNode<E>>();
		Stack<Boolean> visited = new Stack<Boolean>();
		String[] order = {"前：","中：","后："};
		while(cNode != null || !stack.isEmpty()) {
			// 第一次访问：左子树节点循环入栈
			while(cNode != null) {
				stack.push(cNode);
				// 标记第一次访问
				visited.push(false);
				order[0] = order[0] + cNode.val + ",";
				cNode = cNode.left;
			}
			// 第三次访问：如果是已经访问两次（visited == true），弹栈
			while(!stack.isEmpty() && visited.peek()) {
				visited.pop();
				TreeNode node = stack.pop();
				order[2] = order[2] + node.val+ ",";
				System.out.print(node.val + ", ");
			}
			
			// 第二次访问：转向右子树
			if(!stack.isEmpty()) {
				// 根节点先不出栈(访问)
				cNode = stack.peek();
				// 转向右子树
				order[1] = order[1] + cNode.val+ ",";
				cNode = cNode.right;
				// 标记第二次访问
				visited.pop();
				visited.push(true);
			}
		}
		return order;
	}
	
	/**
	 * 检查root2是否为root1的子结构
	 * @param root1
	 * @param root2
	 * @return
	 */
	public boolean hasSubtree(TreeNode root1,TreeNode root2) {
		 // root1 为空的话，root2肯定不是root1的子树
		 if(root1 == null || root2 == null) {
			 return false;
		 }
		 
		 return // 判断root2是否为root1以当前节点为根节点树的子树
				doseTree1HaveTree2(root1, root2)
				// 如果不满足，继续检查子树
				|| hasSubtree(root1.left, root2)
				// 继续检查右子树
				|| hasSubtree(root1.right, root2);
	 }
	 
	 /**
	  * 检查 root1 否为 root1 的子树(root1的根节点确定为root1)
	  * @param root1
	  * @param root2
	  * @return
	  */
	 public boolean doseTree1HaveTree2(TreeNode root1, TreeNode root2) {
		 // 先到达root2的叶子节点，返回真
		 if(root2 == null) {
			 return true;
		 }
		 // 先到达root1的根节点，返回假
		 if(root1 == null) {
			 return false;
		 }
		 
		 // 存在节点不相等，提前退出
		 if(root1.val != root2.val) {
			 return false;
		 }
		 
		 // 递归调用，查看左右子树是否满足包含关系
		 return  // 左子树
				 doseTree1HaveTree2(root1.left, root2.left) && 
				 // 右子树
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
	  * 树的层次遍历序
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