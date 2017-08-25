package com.yg.link;

import java.util.Scanner;

public class test {
	public static void main(String args[]) {
		Link link = new Link();
		Rule rule = new Rule();
		Point p1 = new Point();
		Point p2 = new Point();
		int [][] board;
		boolean isOver = false;
		link.init();
		board = link.getBoard();
		do {
			Scanner sc = new Scanner(System.in);
			p1.x = sc.nextInt();
			p1.y = sc.nextInt();
			p2.x = sc.nextInt();
			p2.y = sc.nextInt();
			if(rule.doCheck(board, p1, p2)) {
				board[p1.x][p1.y] = 0;
				board[p2.x][p2.y] = 0;
				isOver = checkBoard(board);
				link.showBoard(board);
			}
		}while(isOver==false);
		System.out.println("Game over!");
	}

	private static boolean checkBoard(int[][] board) {
		// TODO Auto-generated method stub
		for(int i=1;i<board.length-1;i++) {
			for(int j=1;j<board[0].length-1;j++) {
				if(board[i][j]!=0) {
					return false;
				}
			}
		}
		return true;
	}

}
