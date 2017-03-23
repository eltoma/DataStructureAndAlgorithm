package com.topic.company;
import java.util.Scanner;


public class TreeNodeDepth {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String treeStr = null;
		String queryNodes = null;
		treeStr = sc.nextLine();
		queryNodes = sc.nextLine();
		sc.close();
		
		System.out.println(treeStr);
		System.out.println(queryNodes);
		
		String[] nodes = queryNodes.split("");
		int maxDepth = treeStr.charAt(treeStr.length() - 1);
		int[] nodeDepth = new int[nodes.length];
		
		for(int i=0; i < nodes.length; i++) {
			if(treeStr.indexOf(nodes[i]) > -1) {
				nodeDepth[i] = maxDepth + 1 - treeStr.charAt(treeStr.indexOf(nodes[i]) + 1);
			}
		}
		for(int i = 0; i < nodes.length; i++) {
			System.out.print(nodeDepth[i] + " ");
		}
	}
}

