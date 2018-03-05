package Tree;

public final class BinarySearchTree {

    private Node root;

    static class Node {

        int key;

        Node left;
        Node right;
        Node parent;

        public Node (int key){
            this.key = key;
        }

    }

    private Node insert(Node tree, int key, Node parents) {
        if (tree == null) {
            tree = new Node(key);
            tree.parent = parents;
        } else if (tree.key == key){
            return tree;
        } else if (key > tree.key) {
            parents = tree;
            tree.right = insert(tree.right, key, parents);
        } else {
            parents = tree;
            tree.left = insert(tree.left, key, parents);
        }
        return tree;
    }



    public void insert(int key){
        root = insert(root , key , null);
    }



    private Node remove(Node tree, int key) {
        if (tree == null) {
            return null;
        }
        if (key < tree.key) {
            return remove(tree.left, key);
        } else if (key > tree.key) {
            return remove(tree.right, key);
        } else {
            if (tree.left == null && tree.right == null) {
                if (tree.parent.left == tree) {
                    tree.parent.left = null;
                } else {
                    tree.parent.right = null;
                }
            } else if (tree.left != null && tree.right == null) {
                if (tree.parent.left == tree) {
                    tree.left.parent = tree.parent;
                    tree.parent.left = tree.left;
                }
                else {
                    tree.left.parent = tree.parent;
                    tree.parent.right = tree.left;
                }
            } else if (tree.left == null) {
                if (tree.parent.left == tree) {
                    tree.right.parent = tree.parent;
                    tree.parent.left = tree.right;
                } else {
                    tree.right.parent = tree.parent;
                    tree.parent.right = tree.right;
                }
            } else {
                Node k = tree.right;
                while (k.left != null) {
                    k = k.left;
                }
                tree.key = k.key;
                tree.right.left = k.right;
                tree.right.left.parent = tree.right;
            }
            return tree;
        }
    }



    public void remove(int key){
        remove(root , key);
    }




    private boolean search(Node tree, int key) {
        if (tree == null) {
            return false;
        }
        if (tree.key == key) {
            return true;
        }
        if (tree.key < key) {
            return search(tree.right, key);
        } else {
            return search(tree.left, key);
        }
    }



    public boolean search(int key){
        return search(root , key);
    }




    private int searchParents(Node tree, int key) {
        if (tree == null) {
            return Integer.parseInt(null);
        }
        if (tree.key == key) {
            return tree.parent.key;
        }
        if (tree.key < key) {
            return searchParents(tree.right, key);
        } else {
            return searchParents(tree.left, key);
        }
    }



    public int searchParent(int key){
        return searchParents(root , key);
    }





    private int searchRightChildren(Node tree, int key) {
        if (tree == null) {
            return Integer.parseInt(null);
        }
        if (tree.key == key) {
            return tree.right.key;
        }
        if (tree.key < key) {
            return searchRightChildren(tree.right, key);
        } else {
            return searchRightChildren(tree.left, key);
        }
    }


    public int searchRightChildren(int key){
        return searchRightChildren(root , key);
    }



    private int searchLeftChildren(Node tree, int key) {
        if (tree == null) {
            return Integer.parseInt(null);
        }
        if (tree.key == key) {
            return tree.left.key;
        }
        if (tree.key < key) {
            return searchLeftChildren(tree.right, key);
        } else {
            return searchLeftChildren(tree.left, key);
        }
    }

    public int searchLeftChildren(int key){
        return searchLeftChildren(root , key);
    }


}