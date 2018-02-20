package Test;

import Tree.BinarySearchTree;
import org.junit.Assert;
import org.testng.annotations.Test;

import static org.junit.Assert.*;

public class BinarySearchTreeTest {

    @Test
    public void insert() {
        BinarySearchTree d = new BinarySearchTree();
        d.insert(5);
        if (!d.search(5)){
            Assert.fail();
        }
    }
}