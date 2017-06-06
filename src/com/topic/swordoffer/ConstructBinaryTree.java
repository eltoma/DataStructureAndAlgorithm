package com.topic.swordoffer;

public class ConstructBinaryTree {
	public static void main(String[] args) {
		int[] pre = {1,2,4,7,3,5,6,8};
		int[] in = {4,7,2,1,5,3,8,6};
		
		reConstructBinaryTree(pre, in);
	}
	
	public static TreeNode reConstructBinaryTree(int [] pre,int [] in) {
		if(pre.length != in.length) {
			System.out.println("非法的输入");
			return null;
		}
		return constructBT(pre, in, 0, pre.length - 1, 0, in.length - 1);
    }
	
	public static TreeNode constructBT(int[] pre, int[] in, int preSta, int preEnd, 
			int inSta, int inEnd) {
		// 构建节点, 前序遍历的第一个节点是根节点
		TreeNode tempRootNode = new TreeNode(pre[preSta]); 
		
		// 到达叶子节点
		if(preSta == preEnd) {
			if(inSta == inEnd && pre[inSta] == in[inEnd]) {
				return tempRootNode;
			} else {
				System.out.println("非法的输入");
			}
		}
		
		// 查找根节点在中序遍历序列中的位置
		int rIndex;
		for(rIndex = inSta; rIndex <= inEnd 
				&& in[rIndex] != pre[inSta]; 
			rIndex ++);
				
		// 如果存在左子树，构建左子树
		if(rIndex > inSta) {
			tempRootNode.left = constructBT(pre, in, 
									preSta + 1, preSta + rIndex - inSta, 
									inSta, rIndex - 1);
		}
		// 如果存在右子树，构建右子树
		if(rIndex < inEnd) {
			tempRootNode.right = constructBT(pre, in, 
									preSta + 1 + rIndex - inSta , preEnd, 
									rIndex + 1, inEnd);
		}
		
		return tempRootNode;
	}
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
