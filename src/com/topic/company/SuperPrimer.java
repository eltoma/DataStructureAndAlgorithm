package com.topic.company;

import java.util.Scanner;
/**
 * ��������:p ^ q = n
 * �ж����������Ƿ�Ϊ����
 * @author elotoma
 *
 */
public class SuperPrimer {
	public static void main(String[] args) {
		 Scanner sin = new Scanner(System.in);
		 
		 long n =sin.nextLong(); 
	
		 //С��3ʱֱ���˳�
		 if(n < 3){
			 System.out.println("NA");
			 return;
		 }
		 
		 // Ѱ�� n ��С������
		 // һ������С������(�ų� 1 �� ����) �϶�������
		 long p = -1;
		 // �Ż������ n Ϊ���������� p * p <= n�� ���ٱȽϴ���
		 for(long i = 2; i * i < n; i++) {
			 if(n % i == 0 ) {
				 p = i;
				 break;
			 }
		 }
		 
		 // ������ֵΪ����, ֱ���˳�
		 if(p < 0) {
			 System.out.println("NA");
			 return;
		 }
		 
		 // n �� q շת��������ݴ�
		 long q = 0;
		 while(n % p == 0 && n > 0){
			 n = n / p;
			 q ++;
		 }
		 
		 // n != p ^ x(x > 1) 
		 // n �а����� p ֮������ӣ����ǳ����������˳�
		 if(n != 1) {
			 System.out.println("NA");
			 return;
		 }
		 
		 System.out.println(p + " " + q);
	}
}
