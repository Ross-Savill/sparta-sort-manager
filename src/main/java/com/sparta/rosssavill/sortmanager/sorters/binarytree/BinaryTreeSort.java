package com.sparta.rosssavill.sortmanager.sorters.binarytree;

import com.sparta.rosssavill.sortmanager.sorters.Sortable;
import com.sparta.rosssavill.sortmanager.util.ChildNotFoundException;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeSort implements Sortable, BinaryTreeInterface {
    private Node rootNode;
    private int[] arrayToSort;
    private int indexAsc;

    public BinaryTreeSort() {
    }

    @Override
    public int[] sort(int[] arrayToSort) {
        rootNode = new Node(arrayToSort[0]);
        this.arrayToSort = arrayToSort;
        addElements(arrayToSort);
        return getSortedTreeAsc();
    }

    @Override
    public int getRootElement() {
        return rootNode.getValue();
    }

    @Override
    public void addElement(final int element) {
        addNodeToTree(rootNode, element);
    }

    @Override
    public void addElements(final int[] arrayToSort) {
        int index = 1;
        addNodesToTree(arrayToSort);
    }

    @Override
    public int getNumberOfElements() {
        return nodeNum(rootNode);
    }

    private int nodeNum(Node rootNode) {
        if (rootNode == null)
            return 0;
        return 1 + nodeNum(rootNode.getLeftChild()) + nodeNum(rootNode.getRightChild());
    }

    @Override
    public boolean findElement(final int value) {
        Node node = findNode(value);
        if(node != null) {
            try {
                getLeftChild(value);
                getRightChild(value);
            } catch (ChildNotFoundException e) {
                e.printStackTrace();
            }
            return true;
        }
        return false;
    }

    @Override
    public int getLeftChild(int element) throws ChildNotFoundException {
        Node node = findNode(element);
            if(node.getLeftChild() == null) {
                throw new ChildNotFoundException("This Node has No Left Child");
            }
        return node.getLeftChild().getValue();
    }

    @Override
    public int getRightChild(int element) throws ChildNotFoundException {
        Node node = findNode(element);
            if(node.getRightChild() == null) {
                throw new ChildNotFoundException("This Node has No Right Child");
            }
        return node.getRightChild().getValue();
    }

    private Node findNode(int element) {
        Node node = rootNode;
        while(node != null) {
            if(element == node.getValue()) {
                return node;
            }
            if(element < node.getValue()) {
                node = node.getLeftChild();
            } else {
                node = node.getRightChild();
            }
        }
        return null;
    }

    private void addNodeToTree(Node node, int element) {
        if(element == node.getValue()) return;

        if(element < node.getValue()) {
            if(node.isLeftChildEmpty()) {
                node.setLeftChild(new Node(element));
            } else {
                addNodeToTree(node.getLeftChild(), element);
            }
        } else if(element > node.getValue()) {
            if(node.isRightChildEmpty()) {
                node.setRightChild(new Node(element));
            } else {
                addNodeToTree(node.getRightChild(), element);
            }
        }
    }

    private void addNodesToTree(int[] arrayToAdd) {
        int index = 1;
        Node node = rootNode;
        for(int i = 1; i < arrayToAdd.length; i++) {
            NewNodeSet:
            do {
                if (arrayToAdd[i] < node.getValue()) {
                    if (node.isLeftChildEmpty()) {
                        node.setLeftChild(new Node(arrayToAdd[i]));
                        i++; index++; node = rootNode;
                    } else {
                        node = node.getLeftChild();
                        continue NewNodeSet;
                    }
                } else if (arrayToAdd[i] > node.getValue()) {
                    if (node.isRightChildEmpty()) {
                        node.setRightChild(new Node(arrayToAdd[i]));
                        i++; index++; node = rootNode;
                    } else {
                        node = node.getRightChild();
                        continue NewNodeSet;
                    }
                } else if(arrayToAdd[i] == node.getValue()) {
                    if (node.isLeftChildEmpty()) {
                        node.setLeftChild(new Node(arrayToAdd[i]));
                        i++; index++; node = rootNode;
                    } else {
                        node = node.getLeftChild();
                        continue NewNodeSet;
                    }
                }
            } while(index < arrayToAdd.length);
        }
    }

    @Override
    public int[] getSortedTreeAsc() {
        int[] sortedArrayToFill = new int[arrayToSort.length];
        return returnAscendingTree(sortedArrayToFill, rootNode);
    }

    @Override
    public int[] getSortedTreeDesc() {
        int[] sortedArrayToFill = new int[arrayToSort.length];
        return returnDescendingTree(sortedArrayToFill, rootNode);
    }

    public int[] returnAscendingTree(int[] sortedArray, Node node) {
            if (!node.isLeftChildEmpty()) {
                returnAscendingTree(sortedArray, node.getLeftChild());
            }
            sortedArray[indexAsc] = node.getValue();
            indexAsc += 1;
            if (!node.isRightChildEmpty()) {
                returnAscendingTree(sortedArray, node.getRightChild());
            }
        return sortedArray;
    }

    public int[] returnDescendingTree(int[] sortedArray, Node node) {
        if (!node.isRightChildEmpty()) {
            returnDescendingTree(sortedArray, node.getRightChild());
        }
        sortedArray[indexAsc] = node.getValue();
        indexAsc += 1;
        if (!node.isLeftChildEmpty()) {
            returnDescendingTree(sortedArray, node.getLeftChild());
        }
        return sortedArray;
    }
}
