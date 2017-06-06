package com.topic.swordoffer;

public class ConstructBinaryTree {
	public static void main(String[] args) {
		int[] pre = {1,2,4,7,3,5,6,8};
		int[] in = {4,7,2,1,5,3,8,6};
		
		reConstructBinaryTree(pre, in);
	}
	
	public static TreeNode reConstructBinaryTree(int [] pre,int [] in) {
		if(pre.length != in.length) {
			System.out.println("�Ƿ�������");
			return null;
		}
		return constructBT(pre, in, 0, pre.length - 1, 0, in.length - 1);
    }
	
	public static TreeNode constructBT(int[] pre, int[] in, int preSta, int preEnd, 
			int inSta, int inEnd) {
		// �����ڵ�, ǰ������ĵ�һ���ڵ��Ǹ��ڵ�
		TreeNode tempRootNode = new TreeNode(pre[preSta]); 
		
		// ����Ҷ�ӽڵ�
		if(preSta == preEnd) {
			if(inSta == inEnd && pre[inSta] == in[inEnd]) {
				return tempRootNode;
			} else {
				System.out.println("�Ƿ�������");
			}
		}
		
		// ���Ҹ��ڵ���������������е�λ��
		int rIndex;
		for(rIndex = inSta; rIndex <= inEnd 
				&& in[rIndex] != pre[inSta]; 
			rIndex ++);
				
		// �������������������������
		if(rIndex > inSta) {
			tempRootNode.left = constructBT(pre, in, 
									preSta + 1, preSta + rIndex - inSta, 
									inSta, rIndex - 1);
		}
		// �������������������������
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
