package com.topic.company;
import static java.lang.Math.*;

/**
 * 小东所在公司要发年终奖，而小东恰好获得了最高福利，他要在公司年会上参与一个抽奖游戏，
 * 游戏在一个6*6的棋盘上进行，上面放着36个价值不等的礼物，每个小的棋盘上面放置着一个礼物，
 * 他需要从左上角开始游戏，每次只能向下或者向右移动一步，到达右下角停止，一路上的格子里的礼物小东都能拿到，
 * 请设计一个算法使小东拿到价值最高的礼物。
 * 给定一个6*6的矩阵board，其中每个元素为对应格子的礼物价值,左上角为[0,0],请返回能获得的最大价值，
 * 保证每个礼物价值大于100小于1000。
 * 
 * 思路：依次更新右上角点到每一点能获取到的最大值，最后返回到右下角点的最大值（感觉像贪心啊。。）
 * @author elotoma
 */
public class FindMaxInMatrix {
	public static int getMost(int[][] board) {
		for (int i = 0; i < board.length; i++) {
			
			for (int j = 0; j < board.length; j++) {
				int left = j - 1;
				int top = i - 1;
				
				if(top < 0 && left < 0){
					continue;
				}
				else if(top < 0) { // 第一行，直接取左边进来的路径
					board[i][j] += board[i][left];
				} 
				else if(left < 0) { // 第一列，直接取上边进来的路径
					board[i][j] += board[top][j];
				} 
				else { //中间，取左边和上边较大者
					board[i][j] += max(board[top][j], board[i][left]);
				}
			}
		}
		
		//showMat(board, 3);
		
		return board[board.length - 1][board.length - 1];
	}
	
	public static void main(String[] args) {
		int[][] m = {{426,306,641,372,477,409},{223,172,327,586,363,553},
				{292,645,248,316,711,295},{127,192,495,208,547,175},{131,448,178,264,207,676},{655,407,309,358,246,714}};
		
		//showMat(m, 5);
		System.out.println(getMost(m));

	}
}
