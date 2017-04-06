package com.topic.company;

import java.util.Scanner;


public class ReverseIntNumber {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int input = in.nextInt();
		int flag = input < 0 ? -1 : 1;
		input = Math.abs(input);
		int[] existNum = new int[10];
		
		int output = 0;
		int a = 0;
		while(input > 0) {
			output *= 10;
			a = input % 10;
			output += a - existNum[a];
			existNum[a] = a;
			input /= 10;
		}
		
		System.out.println(output * flag);
	}
}
