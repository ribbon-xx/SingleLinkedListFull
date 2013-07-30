package com.qsoft.longdt;

import java.util.ArrayList;

public class SingleLinkedList {

	private ArrayList<Node> listObject;

	public SingleLinkedList() {
		listObject = new ArrayList<Node>();
	}

	public SingleLinkedList(ArrayList<Node> strArray) {
		listObject = new ArrayList<Node>();
		listObject.addAll(strArray);
	}

	public int size() {
		return listObject.size();
	}

	public Object getList() {
		return listObject;
	}

	public void insertAfter(Node nodeAnchor, Object nodeInsert) {
		int nodeAnchorPos = 0;
		ArrayList<Node> tmpNodesBegin = new ArrayList<>();
		Node newNode = new Node();
		newNode.setNode(nodeInsert);
		for (Node node : listObject) {
			if (node.getNode().equals(nodeAnchor.getNode())
					&& node.getNextNodeIndex() == nodeAnchor.getNextNodeIndex()
					&& node.getPrevNodeIndex() == nodeAnchor.getPrevNodeIndex()) {
				newNode.setPrevNodeIndex(listObject.indexOf(node));
				newNode.setNextNodeIndex(listObject.indexOf(node) + 2);
				nodeAnchorPos = listObject.indexOf(node);
				break;
			}
		}
		tmpNodesBegin.addAll(listObject.subList(0, nodeAnchorPos + 1));
		tmpNodesBegin.add(newNode);

		ArrayList<Node> tmpNodesEnd = new ArrayList<>();
		tmpNodesEnd.addAll(listObject.subList(nodeAnchorPos + 1, size()));
		for (Node node : tmpNodesEnd) {
			node.setPrevNodeIndex(node.getPrevNodeIndex() + 1);
			node.setNextNodeIndex(node.getNextNodeIndex() + 1);
			tmpNodesBegin.add(node);
		}

		listObject.clear();
		listObject.addAll(tmpNodesBegin);
	}

	public Node get(int i) {
		return listObject.get(i);
	}

	public void delete(Node nodeToDelete) {
		for (Node node : listObject) {
			if (node.getNode().equals(nodeToDelete.getNode())
					&& node.getNextNodeIndex() == nodeToDelete
							.getNextNodeIndex()
					&& node.getPrevNodeIndex() == nodeToDelete
							.getPrevNodeIndex()) {
				listObject.remove(node);
				break;
			}
		}
	}

	public Node first() {
		return listObject.get(0);
	}

	public Node last() {
		return listObject.get(listObject.size() - 1);
	}

	public Node before(Node nodeAnchor) {
		int pos = 0;
		for (Node node : listObject) {
			if (node.getNode().equals(nodeAnchor.getNode())
					&& node.getNextNodeIndex() == nodeAnchor.getNextNodeIndex()
					&& node.getPrevNodeIndex() == nodeAnchor.getPrevNodeIndex()) {
				if (pos > 1)
					return listObject.get(pos - 1);
				else
					return null;
			}
			pos++;
		}
		return null;
	}

	public Node after(Node nodeAnchor) {
		int pos = 0;
		for (Node node : listObject) {
			if (node.getNode().equals(nodeAnchor.getNode())
					&& node.getNextNodeIndex() == nodeAnchor.getNextNodeIndex()
					&& node.getPrevNodeIndex() == nodeAnchor.getPrevNodeIndex()) {
				if (pos < listObject.size() - 1)
					return listObject.get(pos + 1);
				else
					return null;
			}
			pos++;
		}
		return null;
	}

	public Node find(Object objToFind) {
		int pos = 0;
		for (Node node : listObject) {
			if (node.getNode().equals(objToFind)) {
				return listObject.get(pos);
			}
			pos++;
		}
		return null;
	}

	public void insertFirst(Object objInsertFirst) {
		ArrayList<Node> newList = new ArrayList<>();
		Node newNode = new Node();
		newNode.setNode(objInsertFirst);
		newNode.setNextNodeIndex(1);
		newNode.setPrevNodeIndex(-1);
		newList.add(newNode);

		for (Node node : listObject) {
			node.setNextNodeIndex(node.getNextNodeIndex() + 1);
			node.setPrevNodeIndex(node.getPrevNodeIndex() + 1);
			newList.add(node);
		}

		listObject.clear();
		listObject.addAll(newList);
	}

}
