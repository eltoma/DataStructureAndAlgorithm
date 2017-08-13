package com.topic.swordoffer;

public class FindKthToTail {
	
	class ListNode {
	    int val;
	    ListNode next = null;
	
	    ListNode(int val) {
	        this.val = val;
	    }
	}
	
	public static void main(String[] args) {
		int[] t = {1,2,3,4,5};
		ListNode head = new FindKthToTail().buildList(t);
		ListNode node = head;
		while(node != null) {
			System.out.print(node.val + ",");
			node = node.next;
		}
		
		System.out.println("\n" + FindKthToTail(head, 6));
	}
	
	
	public ListNode  buildList(int[] vals) {
		if(vals.length == 0) {
			return null;
		}
		
		ListNode currNode,lastNode,root;
		root = new ListNode(vals[0]);
		currNode = root;
		for (int i = 1; i < vals.length; i++) {
			lastNode = currNode;
			currNode = new ListNode(vals[i]);
			lastNode.next = currNode;
		}
		return root;
	}
	public static ListNode FindKthToTail(ListNode head,int k) {
		if(head == null) {
			return null;
		}
		// 如果k==0, 返回尾节点
		if(k == 0) {
			while((head = head.next) != null);
			return head;
		}
		
		ListNode tail = head;		
		for(int i = k-1; i > 0; i--) {
			// k 大于了 链表的长度
			if(tail.next == null) {
				System.out.println("错误1");
				return null;
			}
			System.out.println(i);
			tail = tail.next;
		}
		
		while(tail.next != null){
			head = head.next;
			tail = tail.next;
		}
		
		return head;
	}
}

