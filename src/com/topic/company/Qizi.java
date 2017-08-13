package com.topic.company;

import java.util.*;
/**
 * 小易将n个棋子摆放在一张无限大的棋盘上。
 * 第i个棋子放在第x[i]行y[i]列。同一个格子允许放置多个棋子。
 * 每一次操作小易可以把一个棋子拿起并将其移动到原格子的上、下、左、右的任意一个格子中。
 * 小易想知道要让棋盘上出现有一个格子中至少有i(1 ≤ i ≤ n)个棋子所需要的最少操作次数.
 * 
 * @author elotoma
 */

public class Qizi {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int n = in.nextInt();
        
        int[] xs = new int[n];
        int[] ys = new int[n];
        for (int i = 0; i < n; i ++) {
            xs[i] = in.nextInt();
        }
        for (int i = 0; i < n; i ++) {
            ys[i] = in.nextInt();
        }
        
        in.close();
        
        // 存储结果res[i]代表重叠i颗棋子最少需要的棋子数量
        int[] res = new int[n];
        Arrays.fill(res, Integer.MAX_VALUE);
  
        int[] dists = new int[n];
        
        // 待选重叠点横坐标=xs[row]
        for(int row = 0; row < n; row++) {
        	// 待选重叠点纵坐标 =xs[col]
        	for (int col = 0; col < n; col++) { 
        		// 遍历棋子，计算到中心点的距离
        		for (int i = 0; i < n; i++) {
        			// 各颗棋子到以(xs[row], ys[col])为重叠点时的距离
        			dists[i] = Math.abs(xs[i] - xs[row]) + Math.abs(ys[i] - ys[col]);
        		}
        		
        		// 排序，前k个数的和即为，以(xs[row], ys[col])为重叠点时，重叠k颗棋子的最小步数
        		Arrays.sort(dists);
        		int sum = 0;
        		for (int i = 0; i < n; i++) {
					sum += dists[i];
					// 如果该重叠点的结果更优，则更新
					res[i] = Math.min(sum, res[i]);
				}
        	}
    	}
        
        // 输出结果
        for (int i = 0; i < n - 1; i++) {
			System.out.print(res[i] + " ");
		}
        System.out.print(res[n - 1]);
    }
}
