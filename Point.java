package com.yg.link;

public class Point {
	public int x;
	public int y;
	
	public boolean equals(Point p) {
		if(p.x==this.x && p.y==this.y) {
			return true;
		}else {
			return false;
		}
	}
}
