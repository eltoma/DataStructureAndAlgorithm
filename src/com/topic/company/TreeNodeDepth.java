package com.topic.company;
import java.util.Scanner;

/**
 * �����ѽṹ����ĳЩ�ڵ�ĸ߶�
 * ���룺a1b2c2d3e3f3(���ṹ���ڵ���|���...)
 *      ab(��ѯ�ڵ�)
 * �����3 2 (����ѯ�ڵ�ĸ߶�)
 * @author elotoma
 */
public class TreeNodeDepth {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String treeStr = null;
		String queryNodes = null;
		treeStr = sc.nextLine();
		queryNodes = sc.nextLine();
		sc.close();
		
		int maxDepth = treeStr.charAt(treeStr.length() - 1);
		int qNodePostion = 0;
		for(int i=0; i < queryNodes.length(); i++) {
			qNodePostion = treeStr.indexOf(queryNodes.charAt(i));
			if(qNodePostion > -1) {
				System.out.print(maxDepth + 1 - (treeStr.charAt(qNodePostion + 1)) + " ");
			}
		}
	}
	
}

