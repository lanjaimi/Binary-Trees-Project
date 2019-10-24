package com.company;
//---------------------------------------------------------------------------
// Tree Node
//
// Author: Lahcen Anjaimi
// Date: 04/30/19
// Class: MET CS342
// Issues: None known
//
// Description:
// Specialized Node for programming Assignment #3 MET CS342 course
//
// Assumptions:
// Should only be used for this problem
//---------------------------------------------------------------------------

public class Node {
    private String data;
    private int count;// word count
    private int nodeDepth;// node depth
    private Node lChild;//left child
    private Node rChild;//right child

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Node getlChild() {
        return lChild;
    }

    public void setlChild(Node lChild) {
        this.lChild = lChild;
    }

    public Node getrChild() {
        return rChild;
    }

    public void setrChild(Node rChild) {
        this.rChild = rChild;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getNodeDepth() {
        return nodeDepth;
    }

    public void setNodeDepth(int nodeDepth) {
        this.nodeDepth = nodeDepth;
    }
}
