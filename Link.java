package com.yg.link;

import java.util.Random;
import java.util.Scanner;

public class Link {
	private int cols;
	private int rows;
	private int [][] board;
	private int level;
	Random rd = new Random();
	
	public void init() {
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("rows:");
			rows = sc.nextInt();
		}while(rows<2);
		do {
			System.out.println("cols");
			cols = sc.nextInt();
		}while(cols<2 || cols%2!=0);
		do {
			System.out.println("level");
			level = sc.nextInt();
		}while(level<5 || level>20);
		sc.nextLine();
//		sc.close();
		board = new int [rows][cols];
		genBoard(board,level);
		shuffle(board);
		showBoard(board);
	}
	
	public void genBoard(int [][] board,int level) {
		if(null == board) {
			return;
		}
		for(int i=1;i<board.length-1;i++) {
			for(int j=1;j<board[i].length-1;j+=2) {
				board[i][j] = rd.nextInt(level)+1;
				board[i][j+1] = board[i][j];
			}
		}
	}
	
	public void shuffle(int [][] board) {
		if(null == board) {
			return;
		}
		for(int i=0;i<board.length*board[0].length*200;i++) {
			int x1 = rd.nextInt(board.length-2)+1;
			int y1 = rd.nextInt(board[0].length-2)+1;
			int x2 = rd.nextInt(board.length-2)+1;
			int y2 = rd.nextInt(board[0].length-2)+1;
			int temp = board[x1][y1];
			board[x1][y1] = board[x2][y2];
			board[x2][y2] = temp;
		}
	}
	
	public void showCols(int [][] board) {
		if(null == board) {
			return;
		}
		System.out.print("\t");
		for(int i=1;i<board.length-1;i++) {
			System.out.print(i+"\t");
		}
		System.out.println();
	}
	
	public void showBoard(int [][] board) {
		showCols(board);
		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board[i].length;j++) {
				if(i !=0 && j !=0 && i !=board.length-1 && j !=board[i].length-1) {
					if(board[i][j] == 0) {
						System.out.print("\t");
					}else{
						System.out.print(board[i][j]+"\t");
					}
				}else {
					if((i==0 && j==0) || (i==0 && j==board[i].length-1) || (j==0 && i==board.length-1) || (i==board.length-1 && j==board[i].length-1)) {
						System.out.print("\t");
					}else if(i!=0 && i!=board.length-1 && j==0){
						System.out.print(i+"*\t");
					}else if(i!=0 && i!=board.length-1 && j==board[i].length-1) {
						System.out.print("*"+i);
					}else {
						System.out.print("*\t");
					}
				}
			}
			System.out.println();
		}
		showCols(board);
	}
	
	public int [][] getBoard() {
		return board;
	}
}
