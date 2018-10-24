package com.src.integer;

import java.awt.Point;

public class MinPathInGrid {
	class point {
		int x, y;

		point(int a, int b) {
			x = a;
			y = b;

		}
	}

	static int coverPoints(Point sequence[], int size) {
		int stepCount = 0;

		// finding steps for
		// each consecutive
		// point in the sequence
		for (int i = 0; i < size - 1; i++) {
			stepCount += minDistance(sequence[i], sequence[i + 1]);
		}

		return stepCount;
	}

	public static int minDistance(Point p1, Point p2) {
		int dx = (int) Math.abs(p1.getX() - p2.getX());
		int dy = (int) Math.abs(p1.getY() - p2.getY());
		return Math.max(dx, dy);
	}

	public static void main(String[] args) {
		Point arr[] = new Point[4];
		arr[0] = new Point(4, 6);
		arr[1] = new Point(1, 2);
		arr[2] = new Point(4, 5);
		arr[3] = new Point(10, 12);
		int count = coverPoints(arr, arr.length);
		System.out.println(count);
	}
}
