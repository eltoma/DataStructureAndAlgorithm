package com.topic.leetcode;

/**
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 * k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 * You may not alter the values in the nodes, only nodes itself may be changed.
 
 * Only constant memory is allowed.
 * For example,
 * Given this linked list: 1->2->3->4->5
 * For k = 2, you should return: 2->1->4->3->5
 * For k = 3, you should return: 3->2->1->4->5
 * 
 * @author elotoma
 */
public class ReversNodesKGroup {
	class ListNode {
		int val;
		ListNode next;
	} 
	
	/**
	 * 递归解法
	 * @param head 
	 * @param k
	 * @return 反转后的链表
	 */
	public ListNode reverseKGroup(ListNode head, int k) {        
        if(head == null) { return head; }
        
        // 检查剩余链表是否k个节点
        ListNode curNode = head;
        for(int i = 0; i < k; i++) {
            // 不足k个，不反转直接返回
            if(curNode == null) {
                return head;
            }
            curNode = curNode.next;
        }
        
        ListNode preNode = null;
        curNode = head;
        // 依次反转组内的节点
        for(int i = 0; i < k; i++) {
            ListNode temp = curNode.next;
            curNode.next = preNode;
            
            preNode = curNode;
            curNode = temp;
        }
        
        // 递归反转，这一组反转后的尾巴接下一组反转的头
        head.next = reverseKGroup(curNode, k);
        return preNode;
   }
}
