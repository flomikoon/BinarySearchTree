package Test;

import Tree.BinarySearchTree;
import org.junit.Assert;
import org.testng.annotations.Test;

import static org.junit.Assert.*;

public class BinarySearchTreeTest {

    @Test
    public void Insert_Search_Test() {
        BinarySearchTree d = new BinarySearchTree();

        d.insert(5);
        d.insert(6);
        d.insert(3);
        d.insert(4);
        d.insert(7);


        assertTrue(d.search(5));
        assertFalse( d.search(9));
        assertTrue(d.search(6));
        assertTrue(d.search(3));
    }


    @Test
    public void RemoveTest() {
        BinarySearchTree d = new BinarySearchTree();

        d.insert(5);
        d.insert(6);
        d.insert(3);
        d.insert(4);
        d.insert(7);
        d.remove(3);
        d.remove(7);

        assertFalse(d.search(3));
        assertTrue(d.search(4));
        assertFalse(d.search(7));
    }

    @Test
    public void SearchParentTest() {
        BinarySearchTree d = new BinarySearchTree();

        d.insert(5);
        d.insert(6);
        d.insert(3);
        d.insert(4);
        d.insert(7);

        assertEquals(5 , d.searchParent(3));
    }

    @Test
    public void SearchLeftChildrenTest() {
        BinarySearchTree d = new BinarySearchTree();

        d.insert(5);
        d.insert(6);
        d.insert(3);
        d.insert(4);
        d.insert(2);
        d.insert(7);

        assertEquals( 2, d.searchLeftChildren(3));
    }

    @Test
    public void SearchRightChildrenTest() {
        BinarySearchTree d = new BinarySearchTree();

        d.insert(5);
        d.insert(6);
        d.insert(3);
        d.insert(4);
        d.insert(7);

        assertEquals( 4, d.searchRightChildren(3));
    }
}
