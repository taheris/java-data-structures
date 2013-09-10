package main.com.taheris.data_structures.trees;

import main.com.taheris.data_structures.lookup.Entry;

public class BinaryTreeNode<T> {
    private Entry<T> entry;
    private BinaryTreeNode<T> left;
    private BinaryTreeNode<T> right;

    public BinaryTreeNode(Entry<T> entry) {
        this(entry, null, null);
    }

    public BinaryTreeNode(Entry<T> entry,
            BinaryTreeNode<T> left, BinaryTreeNode<T> right) {
        this.entry = entry;
        this.left = left;
        this.right = right;
    }

    public Entry<T> getEntry() {
        return entry;
    }

    public void setEntry(Entry<T> entry) {
        this.entry = entry;
    }

    public BinaryTreeNode<T> getLeft() {
        return left;
    }

    public void setLeft(BinaryTreeNode<T> left) {
        this.left = left;
    }

    public BinaryTreeNode<T> getRight() {
        return right;
    }

    public void setRight(BinaryTreeNode<T> right) {
        this.right = right;
    }
}
