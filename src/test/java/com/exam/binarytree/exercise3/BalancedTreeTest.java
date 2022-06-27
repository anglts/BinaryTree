package com.exam.binarytree.exercise3;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class BalancedTreeTest {

    @BeforeAll
    static void doBefore() {
        System.out.println("EXERCISE 3:");
    }

    @Test
    void shouldShowTreeStructure() {

        BalancedTree tree = new BalancedTree();
        tree.addNode(9);
        tree.addNode(8);
        tree.addNode(7);
        tree.addNode(6);
        tree.addNode(5);
        tree.addNode(4);
        tree.addNode(3);
        tree.addNode(2);
        tree.addNode(1);
        tree.addNode(10);
        tree.addNode(11);
        tree.addNode(12);
        tree.addNode(13);
        tree.addNode(14);
        tree.addNode(15);
        tree.addNode(16);
        tree.addNode(17);
        tree.addNode(18);
        tree.addNode(19);
        tree.addNode(20);
        tree.addNode(21);
        tree.addNode(22);
        tree.addNode(23);
        tree.addNode(24);
        tree.addNode(25);
        tree.addNode(26);
        tree.addNode(27);
        tree.addNode(28);
        tree.addNode(29);
        tree.addNode(30);

        tree.printTree("", tree.getRoot());
    }
}
