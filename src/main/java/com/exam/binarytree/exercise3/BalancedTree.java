package com.exam.binarytree.exercise3;

import lombok.Data;

/**
 * Class that implements balanced tree based on the input sequence.
 */
@Data
public class BalancedTree {

    private Node root;

    private int childQuantity = 1;
    private int currentTreeLevel;

    /**
     * Add new node to the tree.
     * @param node: current tree.
     * @param value: value of the new node.
     * @param level: indicates 0 for tree root, 1, 2, 3, etc. for child levels hierarchy.
     * @param position: is the place occupied by each node in the tree, starting with root=1.
     * @return created new node.
     */
    private Node addChildNode(Node node, Integer value, Integer level, Integer position) {
        if (null == node) {
            var newNode = new Node(value, level);
            newNode.setPosition(childQuantity + 1);
            this.setChildQuantity(childQuantity + 1);
            return newNode;
        }
        if (position == 0) {
            position = childQuantity + 1;
            currentTreeLevel = this.calculateNodeLevel(position);
        } else {
            currentTreeLevel--;
            position = position - Double.valueOf(Math.pow(2, currentTreeLevel)).intValue();
        }
        var module = position % Math.pow(2, currentTreeLevel);
        var mid = Math.pow(2, currentTreeLevel) / 2;
        if (mid > module) {
            node.setLeft(addChildNode(node.getLeft(), value, level + 1, position));
        } else {
            node.setRight(addChildNode(node.getRight(), value, level + 1, position));
        }
        return node;
    }

    public void addNode(Integer value) {
        if (null == root) {
            root = new Node(value, 0);
            return;
        }
        this.addChildNode(root, value, root.getLevel(), 0);
    }

    public void printTree(String prefix, Node node) {
        if (node != null) {
            printTree(prefix + "     ", node.getRight());
            System.out.println(prefix + ("|-- ") + node.getValue());
            printTree(prefix + "     ", node.getLeft());
        }
    }

    private int calculateNodeLevel(Integer newPosition) {
        if (newPosition == 1) return 0;
        var level = 0;
        var result = newPosition;
        Double pow = Math.pow(2, level);
        while (result >= pow) {
            pow = Math.pow(2, ++level);
            result = newPosition - pow.intValue();
        }
        return level;
    }

}
