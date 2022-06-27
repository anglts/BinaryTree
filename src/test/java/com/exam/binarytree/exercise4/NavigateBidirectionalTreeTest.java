package com.exam.binarytree.exercise4;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class NavigateBidirectionalTreeTest {

    @BeforeAll
    static void doBefore() {
        System.out.println("EXERCISE 4:");
    }

    @Test
    void shouldShowTreeStructure() {

        NavigateBidirectionalTree tree = new NavigateBidirectionalTree();
        tree.addNode(5);
        tree.addNode(3);
        tree.addNode(4);
        tree.addNode(2);
        tree.addNode(1);
        tree.addNode(7);
        tree.addNode(9);
        tree.addNode(8);
        tree.addNode(6);

        tree.printTree("", tree.getRoot());
        System.out.println("\nNavigate horizontally through the tree levels:");
        tree.navigateBidirectionally(tree.getRoot());
    }
}
