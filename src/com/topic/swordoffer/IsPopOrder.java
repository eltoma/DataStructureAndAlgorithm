package com.topic.swordoffer;

import java.util.Stack;


public class IsPopOrder {
	
	public static void main(String[] args) {
		int[] pushA = {1,2,3,4,5};
		int[] popB = {4,5,3,1,2};
		
		System.out.println(isPopOrder(pushA,popB));
	}
	
	
	/**
	 * 判断popA出栈序列是不是来自pushA入栈序列
	 * 通过模拟 出栈 和 入栈行为 检验
	 * @param pushA
	 * @param popA
	 * @return
	 */
	public static boolean isPopOrder(int [] pushA,int [] popA) {
	    Stack<Integer> temp = new Stack<Integer>();
		if(pushA.length != popA.length) {
			return false;
		}
		
		int toPush = 0;
	    int toPop = 0;
	    // 循环控制标志位
	    boolean flag = true;
	    while(flag) {
	    	flag = false;
	    	if(toPush < pushA.length){
	    		temp.push(pushA[toPush]);
	    		toPush ++;
	    		// 有压栈操作继续
	    		flag = true;
	    	}
	    	
	    	if (!temp.isEmpty() && temp.peek() == popA[toPop]) {
	    		temp.pop();
	    		toPop ++;
	    		// 有出栈操作继续
	    		flag = true;
	    	} 
	    }
	    // 如果存在待出栈的元素，代表不是出栈序列
	    return temp.isEmpty();
    }
}
