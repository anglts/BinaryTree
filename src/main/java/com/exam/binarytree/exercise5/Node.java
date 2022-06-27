package com.exam.binarytree.exercise5;

import lombok.Data;

@Data
public class Node {

    private Integer value;
    private Node leftChild;
    private Node rightChild;

    private int level;
    private int position;

    private Integer leftSidePosition;
    private Integer rightSidePosition;

    public Node(Integer value, Integer level){
        this.value = value;
        this.level = level;
    }
}
