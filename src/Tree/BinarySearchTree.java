package Tree;

public final class BinarySearchTree {

    private Node root;

    public BinarySearchTree() {

        root = null;

    }

    static public class Node {

        public int key;

        Node left;
        Node right;
        Node parent;

         Node(int key) {
            this.key = key;
        }

    }

    private Node insert(Node tree, int key, Node parent) {
        if (tree == null) {
            tree = new Node(key);
            tree.parent = parent;
        } else if (tree.key == key) {
            return tree;
        } else if (key > tree.key) {
            parent = tree;
            tree.right = insert(tree.right, key, parent);
        } else {
            parent = tree;
            tree.left = insert(tree.left, key, parent);
        }
        return tree;
    }


    public void insert(int key) {
        root = insert(root, key, null);
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
                if (tree.parent == null) {
                    root = null;
                } else if (tree.parent.left == tree) {
                    tree.parent.left = null;
                } else {
                    tree.parent.right = null;
                }
            } else if (tree.left != null && tree.right == null) {
                if (tree.parent == null) {
                    tree.left.parent = null;
                    root = tree.left;
                } else if (tree.parent.left == tree) {
                    tree.left.parent = tree.parent;
                    tree.parent.left = tree.left;
                } else {
                    tree.left.parent = tree.parent;
                    tree.parent.right = tree.left;
                }
            } else if (tree.left == null) {
                if (tree.parent == null) {
                    tree.right.parent = null;
                    root = tree.right;
                } else if (tree.parent.left == tree) {
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
                if (tree.right.right == null && tree.right.left == null) {
                    tree.right = null;
                } else if (tree.right.right != null && tree.right.left == null) {
                    tree.right = tree.right.right;
                    tree.right.parent = tree;
                } else {
                    tree = tree.right;
                    while (tree.parent != k.parent) {
                        tree = tree.left;
                    }
                    tree = tree.parent;
                    tree.left = k.right;
                    tree = tree.left;
                    if (tree != null) {
                        tree.parent = k.parent;
                    }
                }
            }
            return tree;
        }
    }


    public void remove(int key) {
        remove(root, key);
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


    public boolean search(int key) {
        return search(root, key);
    }


    private Node searchParents(Node tree, int key) {
        if(tree == null) {
            return null;
        } else if (tree.key == key) {
            return tree.parent;
        } else if (tree.key < key) {
            return searchParents(tree.right, key);
        } else {
            return searchParents(tree.left, key);
        }

    }


    public Node searchParent(int key) {
        return searchParents(root, key);
    }


    private Node searchRightChildren(Node tree, int key) {
        if(tree == null) {
            return null;
        } else if (tree.key == key) {
            return tree.right;
        } else if (key > tree.key) {
            return searchRightChildren(tree.right, key);
        } else {
            return searchRightChildren(tree.left, key);
        }
    }


    public Node searchRightChildren(int key) {
        return searchRightChildren(root, key);
    }


    private Node searchLeftChildren(Node tree, int key) {
        if(tree == null) {
            return null;
        } else if (tree.key == key) {
            return tree.left;
        } else if (key > tree.key) {
            return searchLeftChildren(tree.right, key);
        } else {
            return searchLeftChildren(tree.left, key);
        }
    }


    public Node searchLeftChildren(int key) {
        return searchLeftChildren(root, key);
    }



}