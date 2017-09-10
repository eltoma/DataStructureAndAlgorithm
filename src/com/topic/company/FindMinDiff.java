package com.topic.company;

import java.awt.image.RescaleOp;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

import static java.lang.Math.*;
/**
 * 找到一种切分序列的方法，使得两个序列的和只差最小
 * @author elotoma
 *
 */
public class FindMinDiff {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		ArrayList<Integer> a = new ArrayList<Integer>();
		
		for(int i = 0; i < n; i++) {
			a.add(in.nextInt());
		}
		
		int res = diff(a);
		System.out.println(res);
		in.close();
	}
	
	public static int diff(ArrayList<Integer> vec)
	{
	    int len = vec.size();

	    int sum = 0;
	    for (int i = 0; i < len; ++i) {
	        sum += vec.get(i);
	    }

	    ArrayList<ArrayList<Integer>> dp = new ArrayList<>();
	    for (int i = 0; i <= len; i++) {
	    	ArrayList<Integer> tmp = new ArrayList<Integer>();
	        
	    	for (int j = 0; j <= sum / 2; ++j) {
	            tmp.add(0);
	        }
	        dp.add(tmp);
	    }

	    for (int i = 1; i <= len; ++i) {
	        for (int j = 1; j <= sum / 2; ++j) {
	            if(j >= vec.get(i-1)) { 
	            	Integer b = dp.get(i-1).get(j);
	            	Integer c1 = vec.get(i-1);
	            	Integer c = dp.get(i-1).get(j - c1);
	            	
	            	Integer res = max(b, c + vec.get(i - 1));
	            	
	            	dp.get(i).set(j,res);
	            }
	            else {
	            	dp.get(i).set(j,dp.get(i-1).get(j));
	            }
	        }
	    }
	    return sum - 2 * dp.get(len).get(sum / 2);
	}
}