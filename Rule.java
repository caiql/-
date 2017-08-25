package com.yg.link;

public class Rule {
	public boolean doCheck(int [][] board,Point p1,Point p2) {
		if(p1.x==p2.x && p1.y==p2.y) {
			return false;
		}
		if(board[p1.x][p1.y] != board[p2.x][p2.y]) {
			return false;
		}
		if(p1.x>p2.x || (p1.x==p2.x && p1.y>p2.y)) {
			Point t = p1;
			p1 = p2;
			p2 = t;
		}
		if(isSameLine(board,p1,p2) || isSingleConer(board,p1,p2) ||isTwoleConer(board,p1,p2)) {
			return true;
		}
		return false;
	}

	@SuppressWarnings("unused")
	private boolean isSameLine(int[][] board, Point p1, Point p2) {
		// TODO Auto-generated method stub
		if(p1.x==p2.x) {
			if(p1.y+1 == p2.y) {
				return true;
			}
			for(int j=p1.y+1;j<p2.y;j++) {
				if(board[p1.x][j] != 0) {
					return false;
				}
			return true;
			}
		}
		if(p1.y==p2.y) {
			if(p1.x+1 == p2.x) {
				return true;
			}
			for(int i=p1.x+1;i<p2.x;i++) {
				if(board[i][p1.y] != 0) {
					return false;
				}
				return true;
			}
		}
		return false;
	}
	
	private boolean isSingleConer(int[][] board, Point p1, Point p2) {
		// TODO Auto-generated method stub
		Point p22 = new Point();
		Point p11 = new Point();
		p22.x = p2.x;
		p22.y = p1.y;
		p11.x = p1.x;
		p11.y = p2.y;
		if(p1.y>p2.y) {
			if(board[p11.x][p11.y]==0 && isSameLine(board,p11,p1) && isSameLine(board,p11,p2)) {
				return true;
			}
			if(board[p22.x][p22.y]==0 && isSameLine(board,p1,p22) && isSameLine(board,p2,p22)) {
				return true;
			}
		}else {
			if(board[p11.x][p11.y]==0 && isSameLine(board,p1,p11) && isSameLine(board,p11,p2)) {
				return true;
			}
			if(board[p22.x][p22.y]==0 && isSameLine(board,p1,p22) && isSameLine(board,p22,p2)) {
				return true;
			}
		}
		return false;
	}

	@SuppressWarnings("unused")
	private boolean isTwoleConer(int[][] board, Point p1, Point p2) {
		// TODO Auto-generated method stub
		Point p22 = new Point();
		Point p11 = new Point();
		if(p1.y<=p2.y) {
			for(int i=1;i<board.length-1;i++) {
				p22.x = i;
				p22.y = p2.y;
				p11.x = i;
				p11.y = p1.y;
				if(isSameLine(board,p11,p22)) {
					 if(i<p1.x && isSameLine(board,p11,p1) && isSameLine(board,p22,p2)) {
						return true;
					}else if(i>p2.x && isSameLine(board,p1,p11) && isSameLine(board,p2,p22)) {
						return true;
					}else if(isSameLine(board,p1,p11) && isSameLine(board,p22,p2)) {
						return true;
					}else {
						continue;
					}
				}
			}
			for(int j=1;j<board[0].length-1;j++) {
				p22.x = p2.x;
				p22.y = j;
				p11.x = p1.x;
				p11.y = j;
				if(isSameLine(board,p11,p22)) {
					 if(j<p1.y && isSameLine(board,p11,p1) && isSameLine(board,p22,p2)) {
						return true;
					}else if(j>p2.y && isSameLine(board,p1,p11) && isSameLine(board,p2,p22)) {
						return true;
					}else if(isSameLine(board,p1,p11) && isSameLine(board,p22,p2)) {
						return true;
					}else {
						continue;
					}
				}
			}
		}
		if(p1.y>p2.y) {
			for(int i=1;i<board.length-1;i++) {
				p22.x = i;
				p22.y = p2.y;
				p11.x = i;
				p11.y = p1.y;
				if(isSameLine(board,p22,p11)) {
					 if(i<p1.x && isSameLine(board,p11,p1) && isSameLine(board,p22,p2)) {
						return true;
					}else if(i>p2.x && isSameLine(board,p1,p11) && isSameLine(board,p2,p22)) {
						return true;
					}else if(isSameLine(board,p1,p11) && isSameLine(board,p22,p2)) {
						return true;
					}else {
						continue;
					}
				}
			}
			for(int j=1;j<board[0].length-1;j++) {
				p22.x = p2.x;
				p22.y = j;
				p11.x = p1.x;
				p11.y = j;
				if(isSameLine(board,p11,p22)) {
					 if(j<p2.y && isSameLine(board,p11,p1) && isSameLine(board,p22,p2)) {
						return true;
					}else if(j>p1.y && isSameLine(board,p1,p11) && isSameLine(board,p2,p22)) {
						return true;
					}else if(isSameLine(board,p11,p1) && isSameLine(board,p2,p22)) {
						return true;
					}else {
						continue;
					}
				}
			}
		}
		return false;
	}

}
