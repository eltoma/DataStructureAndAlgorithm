package com.topic.swordoffer;

import java.util.Stack;


public class IsPopOrder {
	
	public static void main(String[] args) {
		int[] pushA = {1,2,3,4,5};
		int[] popB = {4,5,3,1,2};
		
		System.out.println(isPopOrder(pushA,popB));
	}
	
	
	/**
	 * �ж�popA��ջ�����ǲ�������pushA��ջ����
	 * ͨ��ģ�� ��ջ �� ��ջ��Ϊ ����
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
	    // ѭ�����Ʊ�־λ
	    boolean flag = true;
	    while(flag) {
	    	flag = false;
	    	if(toPush < pushA.length){
	    		temp.push(pushA[toPush]);
	    		toPush ++;
	    		// ��ѹջ��������
	    		flag = true;
	    	}
	    	
	    	if (!temp.isEmpty() && temp.peek() == popA[toPop]) {
	    		temp.pop();
	    		toPop ++;
	    		// �г�ջ��������
	    		flag = true;
	    	} 
	    }
	    // ������ڴ���ջ��Ԫ�أ������ǳ�ջ����
	    return temp.isEmpty();
    }
}
