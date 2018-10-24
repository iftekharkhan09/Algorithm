package com.src.list.cyclicdetection;

public class JumpNodes<N> {
	private Node<N> head;

	private static class Node<N> {
		public Node(N data) {
			super();
			this.data = data;
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
		Node<N> next = head;
		while (current != null) {
			current = current.nextNode;
			for (int i = 0; i < 2; i++) {
				if (next != null) {
					next = next.nextNode;
				}
			}
			if (current == next)
				return true;
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
