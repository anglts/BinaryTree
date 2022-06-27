package com.exam.binarytree.exercise1and2;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class TreeTest {

    @BeforeAll
    static void doBefore() {
        System.out.println("EXERCISE 1 AND 2:");
    }

    @Test
    void shouldShowTreeStructure() {

        Tree tree = new Tree();
        tree.addNode(9);
        tree.addNode(8);
        tree.addNode(7);
        tree.addNode(6);
        tree.addNode(5);
        tree.addNode(4);
        tree.addNode(3);
        tree.addNode(2);
        tree.addNode(1);

        tree.printTree("", tree.getRoot());
    }
}
