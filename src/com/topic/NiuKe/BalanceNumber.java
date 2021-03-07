package com.topic.NiuKe;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * N = x1x2x3x4..xn (xn=[0-9])
 * ???????i??? x1 * x2 * ... * xj = xj+1 * xj+2 * ... xn
 * ???N??????
 * @author elotoma
 */
public class BalanceNumber {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {//???while??????case
            int num = in.nextInt();
            String outString = isBalanceNumber(num) ? "YES" : "NO";
            System.out.println(outString);
        }
        in.close();
    }
    
    public static boolean isBalanceNumber(int number) {
    	// §³??10????????
    	if(number < 10) {
        	return false;
        }
    	
    	ArrayList<Integer> alist = new  ArrayList<Integer>();
    	int zeroCount = 0;
    	int left = 1, right = 1;
        
        // ???????????¦Ë(10??¦Ë)
        while( number > 0 ) {
        	alist.add(number % 10);
        	if(number % 10 == 0) {
        		zeroCount ++;
        		// ??1??????0???????????
        		if(zeroCount > 1) {
        			return true;
        		}
        	}
        	right *= alist.get(alist.size() - 1);
        	number /= 10;
        }
        

        // ??????0????????????????
        if(zeroCount == 1) { return false; }
        
        // ????????
        int MAX = right;
        // ????????????????left^2 <= MAX
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
