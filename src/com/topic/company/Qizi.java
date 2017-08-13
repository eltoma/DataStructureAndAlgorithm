package com.topic.company;

import java.util.*;
/**
 * С�׽�n�����Ӱڷ���һ�����޴�������ϡ�
 * ��i�����ӷ��ڵ�x[i]��y[i]�С�ͬһ������������ö�����ӡ�
 * ÿһ�β���С�׿��԰�һ���������𲢽����ƶ���ԭ���ӵ��ϡ��¡����ҵ�����һ�������С�
 * С����֪��Ҫ�������ϳ�����һ��������������i(1 �� i �� n)����������Ҫ�����ٲ�������.
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
        
        // �洢���res[i]�����ص�i������������Ҫ����������
        int[] res = new int[n];
        Arrays.fill(res, Integer.MAX_VALUE);
  
        int[] dists = new int[n];
        
        // ��ѡ�ص��������=xs[row]
        for(int row = 0; row < n; row++) {
        	// ��ѡ�ص��������� =xs[col]
        	for (int col = 0; col < n; col++) { 
        		// �������ӣ����㵽���ĵ�ľ���
        		for (int i = 0; i < n; i++) {
        			// �������ӵ���(xs[row], ys[col])Ϊ�ص���ʱ�ľ���
        			dists[i] = Math.abs(xs[i] - xs[row]) + Math.abs(ys[i] - ys[col]);
        		}
        		
        		// ����ǰk�����ĺͼ�Ϊ����(xs[row], ys[col])Ϊ�ص���ʱ���ص�k�����ӵ���С����
        		Arrays.sort(dists);
        		int sum = 0;
        		for (int i = 0; i < n; i++) {
					sum += dists[i];
					// ������ص���Ľ�����ţ������
					res[i] = Math.min(sum, res[i]);
				}
        	}
    	}
        
        // ������
        for (int i = 0; i < n - 1; i++) {
			System.out.print(res[i] + " ");
		}
        System.out.print(res[n - 1]);
    }
}
