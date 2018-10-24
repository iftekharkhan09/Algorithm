package com.src.sorting;

public class QuickSort {
	public static void main(String[] args) {
		int arr[] = { 2, 1, 4, 6, 2, 1 };
		new QuickSort().sort(0, arr.length - 1, arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

	private int partition(int low, int high, int arr[]) {
		int pivot = arr[high];
		int temp;
		int i = low - 1;
		for (int j = low; j < high; j++) {
			if (arr[j] <= pivot) {
				i++;
				temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}	
		temp = arr[i + 1];
		arr[i + 1] = arr[high];
		arr[high] = temp;
		return i + 1;
	}

	private void sort(int low, int high, int[] arr) {
		if (low < high) {
			int key = partition(low, high, arr);
			sort(low, key - 1, arr);
			sort(key + 1, high, arr);
		}
	}
}
