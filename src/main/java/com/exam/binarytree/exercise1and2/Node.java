package com.exam.binarytree.exercise1and2;

import lombok.Data;

@Data
public class Node {

    private Integer value;
    private Node left;
    private Node right;

    public Node(Integer value) {
        this.value = value;
    }
}
