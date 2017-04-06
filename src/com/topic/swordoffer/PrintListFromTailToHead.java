package com.topic.swordoffer;

import java.util.ArrayList;
import java.util.Stack;

public class PrintListFromTailToHead {
	
	// 栈形式
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
    	Stack<Integer> tempres = new Stack<Integer>();
    	while(listNode != null) {
    		tempres.push(listNode.val);
    		listNode = listNode.next;
    	}
    	ArrayList<Integer> res = new ArrayList<Integer>();
    	while(!tempres.isEmpty()) {
    		res.add(tempres.pop());
    	}
    	return res;
    }
    
    // 递归形式
    ArrayList<Integer> res = new ArrayList<Integer>();
    private ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {
    	if(listNode != null) {
    		printListFromTailToHead1(listNode.next);
    		res.add(listNode.val);
    	}
    	return res;
	}
}
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
