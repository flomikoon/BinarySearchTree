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

        BinarySearchTree g = new BinarySearchTree();

        g.insert(5);
        g.insert(6);
        g.remove(5);

        assertTrue(g.search(6));
        assertFalse(g.search(5));

        g.remove(6);
        assertFalse(g.search(6));

        g.insert(5);
        g.insert(6);
        g.insert(4);
        g.remove(5);
        assertFalse(g.search(5));

        BinarySearchTree p = new BinarySearchTree();

        p.insert(5);
        p.insert(6);
        p.insert(7);
        p.remove(5);
        assertFalse(p.search(5));
        assertTrue(p.search(6));
        assertTrue(p.search(7));

        BinarySearchTree l = new BinarySearchTree();

        l.insert(5);
        l.insert(4);
        l.insert(9);
        l.insert(7);
        l.insert(8);
        l.insert(6);
        l.remove(5);

        assertFalse(l.search(5));

        BinarySearchTree t = new BinarySearchTree();

        t.insert(10);
        t.insert(5);
        t.insert(9);
        t.insert(7);
        t.insert(3);
        t.insert(4);
        t.remove(10);

        assertFalse(l.search(10));
    }

    @Test
    public void SearchParentTest() {
        BinarySearchTree d = new BinarySearchTree();

        d.insert(5);
        d.insert(6);
        d.insert(3);
        d.insert(4);
        d.insert(7);
        d.remove(6);

        assertEquals(5 , d.searchParent(3));
        assertEquals(5 , d.searchParent(7));
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
