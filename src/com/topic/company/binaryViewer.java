package com.topic.company;

import java.util.Scanner;


public class binaryViewer {
	
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		String src = "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz";
		String dealSrc = scanner.nextLine();
		byte[] dealBytes = null;
		int rowCount = 0;
		while(src.length() > 16) {
			dealSrc = src.substring(0,15);
			System.out.print(toFullBinaryString(rowCount) + "  ");
			dealBytes = dealSrc.getBytes();
			
			for (int i = 0; i < dealBytes.length; i++) {
				System.out.print(Integer.toHexString(dealBytes[i]) + " ");
				if(i == 7) {
					System.out.print(" ");
				}
			}
			System.out.print(" ");
			rowCount ++;
			System.out.println(dealSrc);
			src = src.substring(15);
		}
		
	}
	
	private static String toFullBinaryString(int x) {
        int[] buffer = new int[Integer.SIZE];
        for (int i = (Integer.SIZE - 1); i >= 0; i--) {
            buffer[i] = x >> i & 1;
        }
        String s = "";
        for (int j = (Integer.SIZE - 1); j >= 0; j--) {
            s = s + buffer[j];
        }
        return s.substring(24);
    }
}
