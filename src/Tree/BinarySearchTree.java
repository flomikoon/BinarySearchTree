package Tree;

public final class BinarySearchTree {

    private Node root;

    static class Node {

        int key;

        Node left;
        Node right;
        Node parents;

        public Node (int key){
            this.key = key;
        }

    }

    private Node insert(Node tree, int key, Node parents) {
        if (tree == null) {
            tree = new Node(key);
            tree.parents = parents;
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
                if (tree.parents.left == tree) {
                    tree.parents.left = null;
                } else {
                    tree.parents.right = null;
                }
            } else if (tree.left != null && tree.right == null) {
                if (tree.parents.left == tree) {
                    tree.left.parents = tree.parents;
                    tree.parents.left = tree.left;
                }
                else {
                    tree.left.parents = tree.parents;
                    tree.parents.right = tree.left;
                }
            } else if (tree.left == null) {
                if (tree.parents.left == tree) {
                    tree.right.parents = tree.parents;
                    tree.parents.left = tree.right;
                } else {
                    tree.right.parents = tree.parents;
                    tree.parents.right = tree.right;
                }
            } else {
                Node k = tree.right;
                while (k.left != null) {
                    k = k.left;
                }
                tree.key = k.key;
                tree.right.left = k.right;
                k.right.parents = tree.right;
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




    private Node searchParents(Node tree, int key) {
        if (tree == null) {
            return null;
        }
        if (tree.key == key) {
            return tree.parents;
        }
        if (tree.key < key) {
            return searchParents(tree.right, key);
        } else {
            return searchParents(tree.left, key);
        }
    }



    public Node searchParent(int key){
        return searchParents(root , key);
    }





    private Node searchRightChildren(Node tree, int key) {
        if (tree == null) {
            return null;
        }
        if (tree.key == key) {
            return tree.right;
        }
        if (tree.key < key) {
            return searchRightChildren(tree.right, key);
        } else {
            return searchRightChildren(tree.left, key);
        }
    }


    public Node searchRightChildren(int key){
        return searchRightChildren(root , key);
    }



    private Node searchLeftChildren(Node tree, int key) {
        if (tree == null) {
            return null;
        }
        if (tree.key == key) {
            return tree.left;
        }
        if (tree.key < key) {
            return searchLeftChildren(tree.right, key);
        } else {
            return searchLeftChildren(tree.left, key);
        }
    }

    public Node searchLeftChilgren(int key){
        return searchLeftChildren(root , key);
    }


}