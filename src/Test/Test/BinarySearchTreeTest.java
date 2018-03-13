package Test;

import Tree.BinarySearchTree;
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
        d.remove(5);

        assertFalse(d.search(5));

        BinarySearchTree v = new BinarySearchTree();

        v.insert(5);
        v.insert(6);
        v.insert(3);
        v.insert(4);
        v.insert(7);
        v.remove(5);
        v.remove(7);

        assertFalse(v.search(5));
        assertTrue(v.search(6));
        assertTrue(v.search(4));
        assertFalse(v.search(7));
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
        assertEquals(0 , d.searchParent(5));
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
        assertEquals(0 , d.searchLeftChildren(7));
    }

    @Test
    public void SearchRightChildrenTest() {
        BinarySearchTree d = new BinarySearchTree();

        assertEquals(0 , d.searchRightChildren(5));

        d.insert(5);
        d.insert(6);
        d.insert(3);
        d.insert(4);
        d.insert(7);
        d.remove(6);

        assertEquals( 4, d.searchRightChildren(3));
        assertEquals(7 , d.searchRightChildren(5));
        assertEquals(0 , d.searchRightChildren(7));
    }
}
