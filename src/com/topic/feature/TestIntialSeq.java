package com.topic.feature;

import java.util.Scanner;
import java.util.Stack;

/**
 * ��ʼ������ִ��˳�򣺸��ྲ̬ -> ���ྲ̬ -> ����Ǿ�̬ -> ���๹�캯�� -> ����Ǿ�̬ -> ���๹�캯��
 * @author elotoma
 */
public class TestIntialSeq {
	public static void main(String[] args) {
		//Child child = new Child();
		
		Scanner in = new Scanner(System.in);
		// �������Ŀ
		int n = in.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
		}
		
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}

class Parent {
	static {
		System.out.println("parent static code");
	}
	
	public Parent() {
		// TODO Auto-generated constructor stub
		System.out.println("parent init code");
	}
	
	{
		System.out.println("parent non-static code");
	}
	
}

class Child extends Parent {
	static {
		System.out.println("child static code");
	}
	
	public Child() {
		// TODO Auto-generated constructor stub
		System.out.println("child init code");
	}
	
	{
		System.out.println("child non-static code");
	}
}


