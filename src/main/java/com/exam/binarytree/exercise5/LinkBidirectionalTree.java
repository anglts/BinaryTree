package com.exam.binarytree.exercise5;

import lombok.Data;

import java.util.*;

/**
 * Class that links nodes horizontally in each tree level.
 */
@Data
public class LinkBidirectionalTree {

    private Node root;
    private Map<Integer, List<Integer>> storedPositions = new HashMap<>();

    /**
     * Add new node to the tree.
     *
     * @param node:     current tree.
     * @param value:    value of the new node.
     * @param level:    indicates 0 for tree root, 1, 2, 3, etc. for child levels hierarchy.
     * @param position: is the place occupied by each node in the tree, starting with root=1.
     * @return created new node.
     */
    private Node addChildNode(Node node, Integer value, Integer level, Integer position) {
        if (null == node) {
            var newNode = new Node(value, level);
            newNode.setPosition(position);
            this.linkBidirectionalNode(newNode, level, position);
            this.storePositions(level, position);
            return newNode;
        }
        if (value < node.getValue()) {
            node.setLeftChild(addChildNode(node.getLeftChild(), value, level + 1, position * 2));
        } else if (value > node.getValue()) {
            node.setRightChild(addChildNode(node.getRightChild(), value, level + 1, position * 2 + 1));
        }
        return node;
    }

    public void addNode(Integer value) {
        if (null == root) {
            root = new Node(value, 0);
            return;
        }
        this.addChildNode(root, value, root.getLevel(), 1);
    }

    public void printTree(String prefix, Node node) {
        if (node != null) {
            printTree(prefix + "     ", node.getRightChild());
            var msg = prefix + ("|-- ") + node.getValue();
            System.out.println(msg);
            printTree(prefix + "     ", node.getLeftChild());
        }
    }

    /**
     * Store position of each node into a given level.
     * @param level: where the node belongs to.
     * @param position: node position in the tree.
     */
    private void storePositions(Integer level, Integer position) {
        var positionsByLevel = storedPositions.get(level);
        if (positionsByLevel == null) {
            var positions = new ArrayList<Integer>();
            positions.add(position);
            storedPositions.put(level, positions);
        } else {
            positionsByLevel.add(position);
            storedPositions.put(level, positionsByLevel);
        }
    }

    public void navigateLinkedNodes(Node node) {
        if (this.storedPositions.size() < 1) return;
        for (Integer level : this.storedPositions.keySet()) {
            var positions = this.storedPositions.get(level);
            Collections.sort(positions);
            var msgLevel = "Level " + level + ":  ";
            for (int i = 0; i < positions.size() - 1; i++) {
                var current = positions.get(i);
                var foundNode = findNodeByPosition(node, current);
                if (foundNode.getRightSidePosition() != null) {
                    var foundNextNode = findNodeByPosition(node, foundNode.getRightSidePosition());
                    msgLevel += foundNode.getValue() + " <---> " + foundNextNode.getValue() + ", ";
                }
            }
            msgLevel = msgLevel.substring(0, msgLevel.length() - 2);
            System.out.println(msgLevel);
        }
    }

    public Node findNodeByPosition(Node current, int position) {
        if (current == null) return null;
        if (position == current.getPosition()) return current;
        var foundNode = findNodeByPosition(current.getLeftChild(), position);
        if (foundNode == null) {
            foundNode = findNodeByPosition(current.getRightChild(), position);
        }
        return foundNode;
    }

    /**
     * Links one node to another if it has a horizontal neighbor, either left or right.
     * @param newNode: node where left o right neighbor will be linked.
     * @param level: where the node belongs to.
     * @param position: node position in the tree.
     */
    private void linkBidirectionalNode(Node newNode, Integer level, Integer position) {
        var leftSide = getSideNode(level, position - 1);
        if (leftSide != null) {
            newNode.setLeftSidePosition(leftSide.getPosition());
            leftSide.setRightSidePosition(position);
        }
        var rightSide = getSideNode(level, position + 1);
        if (rightSide != null) {
            newNode.setRightSidePosition(rightSide.getPosition());
            rightSide.setLeftSidePosition(position);
        }
    }

    private Node getSideNode(Integer level, Integer position) {
        var positionsByLevel = storedPositions.get(level);
        if (positionsByLevel == null) return null;
        for (Integer storedPosition : positionsByLevel) {
            if (storedPosition == position) {
                return findNodeByPosition(root, position);
            }
        }
        return null;
    }
}
