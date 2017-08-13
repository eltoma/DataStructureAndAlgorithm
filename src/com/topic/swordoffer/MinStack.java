package com.topic.swordoffer;
import java.util.Stack;

import org.w3c.dom.Node;

public class MinStack {
	public static void main(String[] args) {
		Solution solution = new Solution();
		
		solution.push(5);
		solution.push(4);
		solution.push(2);
		solution.push(1);
		solution.push(3);
		
		System.out.println(solution.min());
	
	}
	
	
	static class Solution {
		Stack<Integer> data = new Stack<Integer>();
		Stack<Integer> min = new Stack<Integer>();
	    public void push(int node) {
	    	if(min.size() == 0 || node < top()) {
	    		min.push(node);
	    	} else {
	    		min.push(data.peek());
	    	}
	        data.push(node);
	    }
	    
	    public void pop() {
	        data.pop();
	        min.pop();
	    }
	    
	    public int top() {
	        return min.peek();
	    }
	    
	    public int min() {
	        return top();
	    }
	}
}
