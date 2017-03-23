package com.topic.NiuKe;

import java.util.ArrayList;
import java.util.Scanner;


public class BalanceNumber {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {//ע��while������case
            int num = in.nextInt();
            String outString = isBalanceNumber(num) ? "YES" : "NO";
            System.out.println(outString);
        }
        in.close();
    }
    
    public static boolean isBalanceNumber(int number) {
    	// С��10��ֱ���ų�
    	if(number < 10) {
        	return false;
        }
    	
    	ArrayList<Integer> alist = new  ArrayList<Integer>();
    	int zeroCount = 0;
    	int left = 1, right = 1;
        
        // ��ֳ����ֵ�ÿһλ(10��λ)
        while( number > 0 ) {
        	alist.add(number % 10);
        	if(number % 10 == 0) {
        		zeroCount ++;
        		// ��1������0�Ŀ϶���ƽ����
        		if(zeroCount > 1) {
        			return true;
        		}
        	}
        	right *= alist.get(alist.size() - 1);
        	number /= 10;
        }
        

        // ֻ��һ��0��ʱ��϶�����ƽ����
        if(zeroCount == 1) { return false; }
        
        // ��¼���˻�
        int MAX = right;
        // ���Ҳ�����Ѱ��ƽ��㣬left^2 <= MAX
        for(int i = 0;  left * left  < MAX; i++) {
        	right = right / alist.get(i);
        	left *= alist.get(i);
        	if(right == left) {
        		return true;
        	}
		}
    	return false;
    }
}















