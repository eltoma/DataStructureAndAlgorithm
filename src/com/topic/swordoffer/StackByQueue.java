package com.topic.swordoffer;

import java.util.Stack;

public class StackByQueue {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    
    public void push(int node) {
        stack1.push(node);
    }
    
    public int pop() {
    	if(stack2.isEmpty()) {
	        while(!stack1.isEmpty()){
	        	stack2.push(stack1.pop());
	        }
    	}
        return stack2.pop();
    }
    
    public static void main(String[] args) {
    	StackByQueue testackByQueue = new StackByQueue();
    	testackByQueue.push(1);
    	testackByQueue.push(2);
    	testackByQueue.push(3);
    	System.out.println(testackByQueue.pop());
    	System.out.println(testackByQueue.pop());
    	System.out.println(testackByQueue.pop());
	}
}
