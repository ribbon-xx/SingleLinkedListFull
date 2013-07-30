package com.qsoft.longdt;

public class Node {

	private Object node;
	private int nextNodeIndex;
	private int prevNodeIndex;

	public Object getNode() {
		return node;
	}

	public void setNode(Object node) {
		this.node = node;
	}

	public int getNextNodeIndex() {
		return nextNodeIndex;
	}

	public void setNextNodeIndex(int nextNodeIndex) {
		this.nextNodeIndex = nextNodeIndex;
	}

	public int getPrevNodeIndex() {
		return prevNodeIndex;
	}

	public void setPrevNodeIndex(int prevNodeIndex) {
		this.prevNodeIndex = prevNodeIndex;
	}

}
