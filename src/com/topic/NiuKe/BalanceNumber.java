package com.topic.NiuKe;

import java.util.ArrayList;
import java.util.Scanner;


public class BalanceNumber {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {//注意while处理多个case
            int num = in.nextInt();
            String outString = isBalanceNumber(num) ? "YES" : "NO";
            System.out.println(outString);
        }
        in.close();
    }
    
    public static boolean isBalanceNumber(int number) {
    	// 小于10的直接排除
    	if(number < 10) {
        	return false;
        }
    	
    	ArrayList<Integer> alist = new  ArrayList<Integer>();
    	int zeroCount = 0;
    	int left = 1, right = 1;
        
        // 拆分出数字的每一位(10分位)
        while( number > 0 ) {
        	alist.add(number % 10);
        	if(number % 10 == 0) {
        		zeroCount ++;
        		// 有1个以上0的肯定是平衡树
        		if(zeroCount > 1) {
        			return true;
        		}
        	}
        	right *= alist.get(alist.size() - 1);
        	number /= 10;
        }
        

        // 只有一个0的时候肯定不是平衡数
        if(zeroCount == 1) { return false; }
        
        // 记录最大乘积
        int MAX = right;
        // 从右侧依次寻找平衡点，left^2 <= MAX
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















