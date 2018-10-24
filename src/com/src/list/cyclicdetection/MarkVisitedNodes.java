package com.src.list.cyclicdetection;

public class MarkVisitedNodes<N> {
	private Node<N> head;

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

		public Boolean getIsVisited() {
			return isVisited;
		}

		public void setIsVisited(Boolean isVisited) {
			this.isVisited = isVisited;
		}

		private N data;
		private Boolean isVisited;
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
			if (current.isVisited == true)
				return true;
			current.isVisited = true;
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
