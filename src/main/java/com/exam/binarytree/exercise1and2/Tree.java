package com.exam.binarytree.exercise1and2;

import lombok.Data;

/**
 * Class that implements tree data structure.
 */
@Data
public class Tree {

    private Node root;

    /**
     * Add new node to the tree.
     * @param node: current tree.
     * @param value: value of the new node.
     * @return created new node.
     */
    private Node addChildNode(Node node, Integer value) {
        if (null == node) {
            return new Node(value);
        }
        if (value < node.getValue()) {
            node.setLeft(addChildNode(node.getLeft(), value));
        } else if (value > node.getValue()) {
            node.setRight(addChildNode(node.getRight(), value));
        }
        return node;
    }

    public void addNode(Integer value) {
        this.root = this.addChildNode(root, value);
    }

    public void printTree(String prefix, Node node) {
        if (node != null) {
            printTree(prefix + "     ", node.getRight());
            System.out.println(prefix + ("|-- ") + node.getValue());
            printTree(prefix + "     ", node.getLeft());
        }
    }
}
