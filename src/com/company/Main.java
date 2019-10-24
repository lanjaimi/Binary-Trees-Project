package com.company;
//---------------------------------------------------------------------------
// Programming Assignment #3
// Binary Trees
//
// Author: Lahcen Anjaimi
// Date: 04/30/19
// Issues: None known
//
// Description:
//This program reads a text file, remove white space, and fill a binary search tree
// methods are answers to Programming Assignment #3 for the MET CS342 course
//---------------------------------------------------------------------------

import java.io.FileReader;

public class Main {
    //main method
    public static void main(String[] args) {

        Main me = new Main();
        me.run();


    }

    //worker method called from main
    public void run() {
        BinaryTree tree = new BinaryTree();
        populateTree(tree);

        System.out.println("The word \"transylvania\" Appeared: " + tree.getWordCount("transylvania") + " Times!");
        System.out.println("The word \"harker\" Appeared: " + tree.getWordCount("harker") + " Times!");
        System.out.println("The word \"renfield\" Appeared: " + tree.getWordCount("renfield") + " Times!");
        System.out.println("The word \"vampire\" Appeared: " + tree.getWordCount("vampire") + " Times!");
        System.out.println("The word \"expostulate\" Appeared: " + tree.getWordCount("expostulate") + " Times!");
        System.out.println("The word \"fang\" Appeared: " + tree.getWordCount("fang") + " Times!");
        System.out.println();

        System.out.println("The Depth of the Tree is: " + tree.depth());
        System.out.println();
        System.out.println("The Number of Different Words in The Book is: " + tree.getTreeCount());
        System.out.println();
        System.out.println("The Word at The Root of the Tree is: \"" + tree.getRootData()+"\"");
        System.out.println();

        System.out.print("The Word At the Deepest Leave of the Tree is: \"");
        tree.deepestWords();
        System.out.print("\"");
        System.out.println();
        System.out.println();

        System.out.println("The Total Number of Words in the Book is: " + tree.getTotal());
        System.out.println();

        System.out.println("The Word That Appeared The Most in The Book is: \"" + tree.getMostFrequentWord() + "\" Appeared " + tree.getWordCount(tree.getMostFrequentWord()) + " Times!");
        System.out.println();
        System.out.println("First 20 Words in a Pre-Order Traversal:");
        tree.preOrder();

        System.out.println();
        System.out.println("First 20 Words in a Post-Order Traversal:");
        tree.postOrder();

        System.out.println();
        System.out.println("First 20 Words in a In-Order Traversal:");
        tree.inOrder();


    }

    // takes a binary tree as input
    // parse text file and fill the tree
    public static void populateTree(BinaryTree tree) {
        StringBuilder str = new StringBuilder();

        try {
            FileReader fileReader = new FileReader("dracula.txt");
            int character;
            String data;
            while ((character = fileReader.read()) != -1) {// read the file one character at the time
                if (Character.isDigit(character) || Character.isLetter(character)) {
                    str.append((char) character);
                } else if (Character.isWhitespace(character) && !str.toString().isEmpty()) {
                    data = str.toString().toLowerCase();

                    tree.add(data);

                    str.setLength(0);//reset string

                }//end if else
            }//end while

        } catch (Exception e) {
            System.out.println("There was a problem opening the text file.Try again!");
            System.exit(0);
        }

    }


}