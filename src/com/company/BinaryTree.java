package com.company;
//---------------------------------------------------------------------------
// Linked Binary Tree
//
// Author: Lahcen Anjaimi
// Date: 04/30/19
// Class: MET CS342
// Issues: None known
//
// Description:
// Linked Binary tree specific to programming Assignment #3 for the MET CS342 course
//
// Assumptions:
// Should only be used for this specific problem
//---------------------------------------------------------------------------

public class BinaryTree {
    private Node root;// root of the tree
    private int count;// number of node in the tree
    private int total;// total number of words parsed(including duplicates)
    private String mostFrequentWord;//the word that appeared the most
    private int maxCount;//the count of the word that appeared the most
    private int counter;// used to print 20 first words, inorder, preorder and post order traversals

    //main method for adding to the tree
    public void add(String data) {

        // See if the data already exists in the tree
        // If it does just return
        if (search(data)) {
            Node node = search(this.root, data);
            node.setCount(node.getCount() + 1);
            total++;
            return;
        }

        if (root == null) {
            // Add root to the tree
            root = new Node();
            root.setData(data);
            root.setCount(1);
            //     root.setDepth(0);
            count++;
            total++;
        } else {
            internalAdd(root, data);
        }
    }

    // add to the tree if the word doesn't exist or the tree is not empty
    private void internalAdd(Node node, String data) {
        if (node == null) {
            return;
        }

        if (isSmaller(data, node.getData())) {
            if (node.getlChild() == null) {
                // add it here
                Node node1 = new Node();
                node1.setData(data);
                node1.setCount(1);
                node1.setNodeDepth(node.getNodeDepth() + 1);
                node.setlChild(node1);
                count++;
                total++;
            } else {
                // recurse
                internalAdd(node.getlChild(), data);
            }
        } else {
            if (node.getrChild() == null) {
                // add it here
                Node node2 = new Node();
                node2.setData(data);
                node2.setCount(1);
                node2.setNodeDepth(node.getNodeDepth() + 1);
                node.setrChild(node2);
                count++;
                total++;
            } else {
                internalAdd(node.getrChild(), data);
            }
        }


    }

    //search tree, return boolean
    public boolean search(String data) {
        return (search(this.root, data) != null);
    }

    //search tree return node
    private Node search(Node node, String data) {

        if (node == null)// tree empty
            return null;

        if (node.getData().equals(data)) {// node found
            return node;
        }

        if (isSmaller(data, node.getData())) {// recurse left
            return search(node.getlChild(), data);
        } else {// recurse right
            return search(node.getrChild(), data);
        }

    }

    // takes to string and compare lexical value and return boolean
    private static boolean isSmaller(String one, String two) {

        return (one.compareTo(two) < 0);
    }

    // return tree count
    public int getTreeCount() {
        return this.count;
    }

    // return tree total
    public int getTotal() {
        return this.total;
    }

    // takes word as input and return it's count
    public int getWordCount(String data) {
        if (search(this.root, data) != null) {//if word exist
            return search(this.root, data).getCount();// search for node and get count
        }

        return 0;// word is not in the tree
    }

    //return the word in the root node
    public String getRootData() {
        return this.root.getData();
    }

    //main depth of the tree method
    public int depth() {
        return depth(root, -1, -1);
    }

    // depth of tree helper
    private int depth(Node root, int curLevel, Integer maxLevel) {
        if (root == null) {
            return curLevel;
        }

        curLevel++;

        if (curLevel > maxLevel) {
            maxLevel = curLevel;
        }

        int lmax = depth(root.getlChild(), curLevel, maxLevel);
        int rmax = depth(root.getrChild(), curLevel, maxLevel);

        return rmax > lmax ? rmax : lmax;

    }

    // most Frequent Word main
    public String getMostFrequentWord() {
        mostFrequent(root);
        return mostFrequentWord;
    }

    //most Frequent Word helper method
    private void mostFrequent(Node root) {
        if (root == null) {
            return;
        }
        if (root.getCount() > maxCount) {
            maxCount = root.getCount();
            mostFrequentWord = root.getData();
        }

        mostFrequent(root.getlChild());
        mostFrequent(root.getrChild());

    }

    // return word at the deepest leave
    public void deepestWords() {
        deepestWordsHelper(root, depth());
    }

    //deepest word helper method
    private void deepestWordsHelper(Node root, int treeDepth) {
        if (root == null) {
            return;
        }

        if (root.getNodeDepth() == treeDepth) {// compare node depth to tree depth
            System.out.print(root.getData());
        }

        deepestWordsHelper(root.getlChild(), treeDepth);
        deepestWordsHelper(root.getrChild(), treeDepth);

    }

    // in order traversal main
    public void inOrder() {
        resetCounter();// reset counter
        inOrder(root);
        System.out.println();
    }

    // in order traversal helper
    private void inOrder(Node root) {
        if (root == null) {
            return;
        }

        inOrder(root.getlChild());
        if (counter < 20) {
            System.out.print(root.getData() + " ");
            counter++;
        }

        inOrder(root.getrChild());

    }

    // pre order traversal main
    public void preOrder() {
        resetCounter();
        preOrder(root);
        System.out.println();
    }

    // pre order traversal helper
    private void preOrder(Node root) {
        if (root == null) {
            return;
        }

        if (counter < 20) {
            System.out.print(root.getData() + " ");
            counter++;
        }

        preOrder(root.getlChild());
        preOrder(root.getrChild());

    }

    //post order traversal main
    public void postOrder() {
        resetCounter();
        postOrder(root);
        System.out.println();
    }

    // post order helper
    private void postOrder(Node root) {
        if (root == null) {
            return;
        }

        postOrder(root.getlChild());
        postOrder(root.getrChild());

        if (counter < 20) {
            System.out.print(root.getData() + " ");
            counter++;
        }


    }

    // reset printed words counter in traversal
    private void resetCounter() {
        counter = 0;
    }


}