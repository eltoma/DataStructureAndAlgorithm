package com.topic.company;

public class countBitDiff {
	/**
	 * 题目描述:
		世界上有10种人，一种懂二进制，一种不懂。
		那么你知道两个int32整数m和n的二进制表达, 有多少个位(bit)不同么？ 
		
	      输入例子:
		1999 2299
	      输出例子:
		7
	      知识点：
	      1. 异或位运算
	      2. 计算一个整数中二进制字符串中 “1” 的个数算法
	 * @param args
	 */
	public static void main(String[] args) {
		countBitDiff aTest = new countBitDiff();
		System.out.println(aTest.countBitDiffs(1999, 2299));
	}
	
	public int countBitDiffs(int m, int n) {
		System.out.println("/n --------------------");
		System.out.println("m's binary string:   " + Integer.toBinaryString(m));
		System.out.println("n's binary string:  " + Integer.toBinaryString(n));
		int res = m ^ n;
        
		System.out.println("res's binary string:" + Integer.toBinaryString(res));
		System.out.println("--------------------");
		
		int count = 0;
        for(int i = 0; i < 32 && res!= 0; i++) {
        	// count += res % 2;
            // res /= 2;
        	
        	/* ！！！ 除去res最右边位的 1   
        	 * 如：任意数n = ...xxx(1)00...  括号所在位为最右边的1， 
			 * 对于：n-1 它左边高m位肯定保持不变,该位本身必 变为 0 , 低k位不确定
			 * 所以 n-1 = ...xxx(0)xx... 
			 * 所以： n & n-1 = ...xxx(0)00..., 最右边的1被重置为0，达到目的
			 */
        	count ++ ;
        	res &= (res - 1);  
        }
        
        return count;
    }
}
