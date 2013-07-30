package com.qsoft.longdt;

import java.util.ArrayList;

import junit.framework.TestCase;

public class SingleLinkedListTest extends TestCase {

	private ArrayList<Node> strArray;

	private String newStr;

	private String objToFind;

	private String objWillNull;

	private String objInsertFirst;

	private Node nodeAnchor;

	private Node nodeToDelete;

	private Node nodeFirst;

	private Node nodeLast;

	private Node nodeBeforeNodeAnchor;

	private Node nodeAfterNodeAnchor;

	private Node nodeWillBeReturnAfterInsertFirst;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		strArray = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			Node node = new Node();
			node.setNode("String " + i);
			int nextIndex = i < 4 ? i + 1 : -1;
			int prevIndex = i > 0 ? i - 1 : -1;
			node.setNextNodeIndex(nextIndex);
			node.setPrevNodeIndex(prevIndex);
			strArray.add(node);
		}

		newStr = "New Strings With Random Position Per Test";

		objToFind = "String 0";

		objWillNull = "This object will make list return null when find it";

		objInsertFirst = "This object will be inserted to first of list";

		nodeAnchor = new Node();
		nodeAnchor.setNode("String 2");
		nodeAnchor.setNextNodeIndex(3);
		nodeAnchor.setPrevNodeIndex(1);

		nodeToDelete = new Node();
		nodeToDelete.setNode("String 3");
		nodeToDelete.setNextNodeIndex(4);
		nodeToDelete.setPrevNodeIndex(2);

		nodeFirst = new Node();
		nodeFirst.setNode("String 0");
		nodeFirst.setNextNodeIndex(1);
		nodeFirst.setPrevNodeIndex(-1);

		nodeLast = new Node();
		nodeLast.setNode("String 4");
		nodeLast.setNextNodeIndex(-1);
		nodeLast.setPrevNodeIndex(3);

		nodeBeforeNodeAnchor = new Node();
		nodeBeforeNodeAnchor.setNode("String 1");
		nodeBeforeNodeAnchor.setNextNodeIndex(2);
		nodeBeforeNodeAnchor.setPrevNodeIndex(0);

		nodeAfterNodeAnchor = new Node();
		nodeAfterNodeAnchor = nodeToDelete;

		nodeWillBeReturnAfterInsertFirst = new Node();
		nodeWillBeReturnAfterInsertFirst.setNode(objInsertFirst);
		nodeWillBeReturnAfterInsertFirst.setNextNodeIndex(1);
		nodeWillBeReturnAfterInsertFirst.setPrevNodeIndex(-1);
	}

	// Step 1
	public void testCreateNewLinkListWithEmptyList() {
		SingleLinkedList linkedList = new SingleLinkedList();
		assertEquals(0, linkedList.size());
	}

	// Step 2
	public void testCreateNewLinkListWithObjectList() {
		SingleLinkedList list = new SingleLinkedList(strArray);
		assertEquals(strArray, list.getList());
	}

	// Step 3
	public void testGetSizeOfLinkList() {
		SingleLinkedList list = new SingleLinkedList(strArray);
		assertEquals(strArray.size(), list.size());
	}

	// Step 4
	public void testInsertAfterIndexN() {
		SingleLinkedList list = new SingleLinkedList(strArray);

		list.insertAfter(nodeAnchor, newStr);

		assertEquals(strArray.size() + 1, list.size());
		assertEquals(newStr, list.get(3).getNode());
	}

	// Step 5
	public void testDeleteANode() {
		SingleLinkedList list = new SingleLinkedList(strArray);
		list.delete(nodeToDelete);

		assertEquals(strArray.size() - 1, list.size());
	}

	// Step 6
	public void testGetTheFirstNode() {
		SingleLinkedList list = new SingleLinkedList(strArray);

		Node firstNode = list.first();

		assertEquals(nodeFirst.getNextNodeIndex(), firstNode.getNextNodeIndex());
		assertEquals(nodeFirst.getNode(), firstNode.getNode());
		assertEquals(nodeFirst.getPrevNodeIndex(), firstNode.getPrevNodeIndex());
	}

	// Step 7
	public void testGetTheLastNode() {
		SingleLinkedList list = new SingleLinkedList(strArray);

		Node lastNode = list.last();

		assertEquals(nodeLast.getNextNodeIndex(), lastNode.getNextNodeIndex());
		assertEquals(nodeLast.getNode(), lastNode.getNode());
		assertEquals(nodeLast.getPrevNodeIndex(), lastNode.getPrevNodeIndex());
	}

	// Step 8
	public void testGetTheNodeBeforeAnother() {
		SingleLinkedList list = new SingleLinkedList(strArray);
		Node targetNode = list.before(nodeAnchor);

		assertEquals(nodeBeforeNodeAnchor.getNextNodeIndex(),
				targetNode.getNextNodeIndex());
		assertEquals(nodeBeforeNodeAnchor.getNode(), targetNode.getNode());
		assertEquals(nodeBeforeNodeAnchor.getPrevNodeIndex(),
				targetNode.getPrevNodeIndex());
	}

	// Step 8.1
	public void testNullNodeWillReturnWhenGetBeforeTheFirstNode() {
		SingleLinkedList list = new SingleLinkedList(strArray);
		Node targetNode = list.before(nodeFirst);
		assertEquals(null, targetNode);
	}

	// Step 9
	public void testGetTheNodeAfterAnother() {
		SingleLinkedList list = new SingleLinkedList(strArray);
		Node targetNode = list.after(nodeAnchor);

		assertEquals(nodeAfterNodeAnchor.getNextNodeIndex(),
				targetNode.getNextNodeIndex());
		assertEquals(nodeAfterNodeAnchor.getNode(), targetNode.getNode());
		assertEquals(nodeAfterNodeAnchor.getPrevNodeIndex(),
				targetNode.getPrevNodeIndex());
	}

	// Step 9.1
	public void testNullNodeWillReturnWhenGetAfterTheLastNode() {
		SingleLinkedList list = new SingleLinkedList(strArray);
		Node targetNode = list.after(nodeLast);
		assertEquals(null, targetNode);
	}

	// Step 10
	public void testFindTheNodeContainsObject() {
		SingleLinkedList list = new SingleLinkedList(strArray);

		Node foundNode = list.find(objToFind);
		assertEquals(nodeFirst.getNode(), foundNode.getNode());
		assertEquals(nodeFirst.getNextNodeIndex(), foundNode.getNextNodeIndex());
		assertEquals(nodeFirst.getPrevNodeIndex(), foundNode.getPrevNodeIndex());
	}

	// Step 11
	public void testGetNullNodeWhenFindObjectNotBelongToTheList() {
		SingleLinkedList list = new SingleLinkedList(strArray);

		Node foundNode = list.find(objWillNull);

		assertEquals(null, foundNode);
	}

	// Step 12
	public void testInsertAnObjectIntoFirstOfList() {
		SingleLinkedList list = new SingleLinkedList(strArray);

		list.insertFirst(objInsertFirst);

		assertEquals(strArray.size() + 1, list.size());
		assertEquals(nodeWillBeReturnAfterInsertFirst.getNode(), list.first()
				.getNode());
		assertEquals(nodeWillBeReturnAfterInsertFirst.getNextNodeIndex(), list
				.first().getNextNodeIndex());
		assertEquals(nodeWillBeReturnAfterInsertFirst.getPrevNodeIndex(), list
				.first().getPrevNodeIndex());
	}
}
