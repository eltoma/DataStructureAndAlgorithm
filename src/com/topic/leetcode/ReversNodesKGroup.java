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
	 * �ݹ�ⷨ
	 * @param head 
	 * @param k
	 * @return ��ת�������
	 */
	public ListNode reverseKGroup(ListNode head, int k) {        
        if(head == null) { return head; }
        
        // ���ʣ�������Ƿ�k���ڵ�
        ListNode curNode = head;
        for(int i = 0; i < k; i++) {
            // ����k��������תֱ�ӷ���
            if(curNode == null) {
                return head;
            }
            curNode = curNode.next;
        }
        
        ListNode preNode = null;
        curNode = head;
        // ���η�ת���ڵĽڵ�
        for(int i = 0; i < k; i++) {
            ListNode temp = curNode.next;
            curNode.next = preNode;
            
            preNode = curNode;
            curNode = temp;
        }
        
        // �ݹ鷴ת����һ�鷴ת���β�ͽ���һ�鷴ת��ͷ
        head.next = reverseKGroup(curNode, k);
        return preNode;
   }
}
