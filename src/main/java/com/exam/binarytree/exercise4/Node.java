package com.exam.binarytree.exercise4;

import lombok.Data;

@Data
public class Node {

    private Integer value;
    private Node left;
    private Node right;

    private int level;
    private int position;

    public Node(Integer value, Integer level){
        this.value = value;
        this.level = level;
    }
}
