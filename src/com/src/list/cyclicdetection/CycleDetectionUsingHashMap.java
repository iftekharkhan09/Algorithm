package com.src.list.cyclicdetection;

import java.util.HashMap;
import java.util.Map;

public class CycleDetectionUsingHashMap<N> {
	private Node<N> head;
	private Map<Node<N>, N> map = new HashMap<>();

	private static class Node<N> {
		public Node(N data) {
			super();
			this.data = data;
		}

		public Node(N data, Node<N> nextNode) {
			super();
			this.data = data;
			this.nextNode = nextNode;
		}

		private N data;
		private Node<N> nextNode;
	}

	public void add(N n) {
		Node<N> node = new Node<N>(n);
		if (null == head) {
			head = node;
		} else {
			Node<N> prev = null;
			Node<N> current = head;
			while (current != null) {
				prev = current;
				current = current.nextNode;
			}
			prev.nextNode = node;
		}
	}

	public void addCyclicNode(N n) {
		Node<N> node = new Node<N>(n);
		if (null == head) {
			head = node;
		} else {
			Node<N> prev = null;
			Node<N> current = head;
			while (current != null) {
				prev = current;
				current = current.nextNode;
			}
			prev.nextNode = head;
		}
	}

	public Boolean isCyclic() {
		Node<N> current = head;
		while (current != null) {
			if (map.get(current) != null)
				return true;
			map.put(current, current.data);
			current = current.nextNode;
		}
		return false;
	}

	public static void main(String[] args) {
		CycleDetectionUsingHashMap<Integer> cycleDetection = new CycleDetectionUsingHashMap<>();
		cycleDetection.add(new Integer(1));
		cycleDetection.add(new Integer(4));
		cycleDetection.add(new Integer(3));

		cycleDetection.addCyclicNode(new Integer(6));

		System.out.println(cycleDetection.isCyclic());
	}
}
