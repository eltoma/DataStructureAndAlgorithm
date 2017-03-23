package com.topic.company;
import java.util.Scanner;

/**
 * 给出堆结构，求某些节点的高度
 * 输入：a1b2c2d3e3f3(数结构：节点名|深度...)
 *      ab(查询节点)
 * 输出：3 2 (所查询节点的高度)
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

