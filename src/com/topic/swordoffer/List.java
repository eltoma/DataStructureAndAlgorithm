package com.topic.swordoffer;

import com.topic.swordoffer.FindKthToTail.ListNode;
/**
 * 算法列表：
 * 1. 反转list
 * 2. 合并两个有序链表
 * @author elotoma
 */
public class List {
	
	// 单元测试
	public static void main(String[] args) {
		int[] listNodes1 = {1,3,5,7,9,};
		int[] listNodes2 = {2,4,6,8,10};
		ListNode list1 = buildList(listNodes1);
		ListNode list2 = buildList(listNodes2);
		System.out.println("合并测试...");
		System.out.println("list:");
		showList(list1);
		System.out.println("list:");
		showList(list2);
		System.out.println("合并后：");
		ListNode mergedList = merge(null, list2);
		showList(mergedList);
	}
	
	
	public static class ListNode {
	    int val;
	    ListNode next = null;

	    ListNode(int val) {
	        this.val = val;
	    }
	}
	
	public static ListNode  buildList(int[] vals) {
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
	
	public static void showList(ListNode head) {
		System.out.print("{");
		while(head != null) {
			System.out.printf("%2d ,",head.val);
			head = head.next;
		}
		System.out.println("}");
	}
	
	
    public static ListNode reverseList(ListNode head) {
    	ListNode preNode = null, 
    			 curNode = head,
    			 nextNode = null;;
		while(curNode != null) {
			nextNode = curNode.next;
			curNode.next = preNode;
			
			preNode = curNode;
			curNode = nextNode;
		}
    	return preNode;
    }
    /**
     * 合并两个链表，递归方式
     * @param list1
     * @param list2
     * @return 合并后的头节点
     */
    public static  ListNode mergeWithRecursion(ListNode list1, ListNode list2) {
    	if(list1 == null) {
    		return list2;
    	} else if(list2 == null) {
    		return list1;
    	}  
    	
    	ListNode mergedHead;
		if(list1.val < list2.val) {
			mergedHead = list1;
			mergedHead.next = mergeWithRecursion(list1.next, list2);
		} else {
			mergedHead = list2;
			mergedHead.next = mergeWithRecursion(list1, list2.next);
		}
		return mergedHead;
    }
    
    /**
     * 合并两个链表，非递归方式
     * @param list1
     * @param list2
     * @return
     */
    public static ListNode merge(ListNode list1,ListNode list2) {
    	ListNode head = null, tail=null;
    	
    	if(list1 == null) {
    		return list2;
    	} else if (list2 == null){
    		return list1;
    	}
    	
    	if(list1.val <= list2.val) {
    		head = list1;
    		tail = list1;
    		list1 = list1.next;
    	} else {
    		head = list2;
    		tail = list2;
    		list2 = list2.next;
    	}
    	
		while(list1 != null || list2 != null) {

			if(list1 == null) {
				tail.next = list2;
				return head;
			} else if(list2 == null) {
				tail.next = list2;
				return head;
			}
			
			if(list1.val <= list2.val) {
				tail.next = list1;
				tail = list1;
				list1 = list1.next;
			} else {
				tail.next = list2;
				tail = list2;
				list2 = list2.next;
			}
		}
    	return head;
    }
}
