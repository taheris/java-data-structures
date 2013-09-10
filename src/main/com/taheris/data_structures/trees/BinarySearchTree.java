package main.com.taheris.data_structures.trees;

import main.com.taheris.data_structures.lookup.Entry;
import main.com.taheris.data_structures.lookup.Key;
import main.com.taheris.data_structures.lookup.LookupADT;

public class BinarySearchTree<T> implements LookupADT<T> {
    private BinaryTreeNode<T> root;

    public BinarySearchTree() {
        root = null;
    }

    @Override
    public void insert(String key, T value) {
        addToTree(new BinaryTreeNode<>(new Entry<>(new Key(key), value)), root);
    }

    @Override
    public void remove(String key) {
        removeFromTree(new Key(key), root);
    }

    @Override
    public void update(String key, T value) {
        Key find = new Key(key);
        BinaryTreeNode<T> node = getFromTree(find, root);
        node.getEntry().setValue(value);
    }

    @Override
    public T retrieve(String key) {
        Key find = new Key(key);
        BinaryTreeNode<T> node = getFromTree(find, root);
        return node.getEntry().getValue();
    }

    @Override
    public String stringify() {
        return print(root);
    }

    private void addToTree(BinaryTreeNode<T> add, BinaryTreeNode<T> node) {
        if (root == null) {
            root = add;
            return;
        }

        Key addKey = add.getEntry().getKey();
        Key nodeKey = node.getEntry().getKey();

        if (addKey.lessThan(nodeKey)) {
            if (node.getLeft() == null) {
                node.setLeft(add);
            } else {
                addToTree(add, node.getLeft());
            }
        } else {
            if (node.getRight() == null) {
                node.setRight(add);
            } else {
                addToTree(add, node.getRight());
            }
        }
    }

    private BinaryTreeNode<T> getFromTree(Key key, BinaryTreeNode<T> node) {
        if (node == null) {
            throw new IllegalArgumentException("Key not found.");
        }

        if (key.equals(node.getEntry().getKey())) {
            return node;
        } else if (key.lessThan(node.getEntry().getKey())) {
            return getFromTree(key, node.getLeft());
        } else {
            return getFromTree(key, node.getRight());
        }
    }

    protected void removeFromTree(Key key, BinaryTreeNode<T> node) {
        if (node == null) {
            throw new IllegalArgumentException("Key not found.");
        }

        if (key.equals(root.getEntry().getKey())) {
            root = mergeLeftRight(root);
        } else if (key.lessThan(node.getEntry().getKey())) {
            if (node.getLeft() == null) {
                throw new IllegalArgumentException("Key not found.");
            } else if (key.equals(node.getLeft().getEntry().getKey())) {
                node.setLeft(mergeLeftRight(node.getLeft()));
            } else {
                removeFromTree(key, node.getLeft());
            }
        } else {
            if (node.getRight() == null) {
                throw new IllegalArgumentException("Key not found.");
            } else if (key.equals(node.getRight().getEntry().getKey())) {
                node.setRight(mergeLeftRight(node.getRight()));
            } else {
                removeFromTree(key, node.getRight());
            }
        }
    }

    private BinaryTreeNode<T> mergeLeftRight(BinaryTreeNode<T> node) {
        if (node.getLeft() == null) {
            return node.getRight();
        } else if (node.getRight() == null) {
            return node.getLeft();
        } else {
            addToTree(node.getRight(), node.getLeft());
            return node.getLeft();
        }
    }

    private String print(BinaryTreeNode<T> node) {
        if (node == null) {
            return "";
        }

        Entry<T> entry = node.getEntry();
        String current = entry.getKey().name() + ":"
                + entry.getValue().toString() + ", ";

        return print(node.getLeft()) + current + print(node.getRight());
    }
}
