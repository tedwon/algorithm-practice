package com.realtimecep.data.structure.tree.binarysearchtree;

class TreeNode {

  char data;
  TreeNode left;
  TreeNode right;
}

class BinarySearchTree {

  private TreeNode root = new TreeNode();

  public TreeNode insertKey(TreeNode root, char x) {
    TreeNode p = root;
    TreeNode newNode = new TreeNode();
    newNode.data = x;
    newNode.left = null;
    newNode.right = null;
    if (p == null) {
      return newNode;
    } else if (newNode.data < p.data) {
      p.left = insertKey(p.left, x);
      return p;
    } else if (newNode.data > p.data) {
      p.right = insertKey(p.right, x);
      return p;
    } else {
      return p;
    }
  }

  public void insertBST(char x) {
    root = insertKey(root, x);
  }

  public TreeNode searchBST(char x) {
    TreeNode p = root;
    while (p != null) {
      if (x < p.data) {
        p = p.left;
      } else if (x > p.data) {
        p = p.right;
      } else {
        return p;
      }
    }
    return p;
  }

  /**
   * 이진 트리 순회 방법 중 inorder traversal
   * LVR
   * @param root
   */
  public void inorder(TreeNode root) {
    if (root != null) {
      // L
      inorder(root.left);
      // V
      System.out.printf(" %c", root.data);
      // R
      inorder(root.right);
    }
  }

  public void printBST() {
    inorder(root);
    System.out.println();
  }
}

class Ex9_2 {

  public static void main(String args[]) {
    BinarySearchTree bsT = new BinarySearchTree();
    bsT.insertBST('3');
    bsT.insertBST('5');
    bsT.insertBST('7');
    bsT.insertBST('2');
    bsT.insertBST('4');
    bsT.insertBST('8');
    bsT.insertBST('9');
    bsT.insertBST('1');
//    bsT.insertBST('6');
    bsT.insertBST('0');


    System.out.printf("\nBinary Tree >>> ");
    bsT.printBST();

    System.out.printf("Is There \"5\" ? >>> ");
    TreeNode p1 = bsT.searchBST('5');
    if (p1 != null) {
      System.out.printf("Searching Success! Searched key : %c \n", p1.data);
    } else {
      System.out.printf("Searching fail!! There is no %c \n", p1.data);
    }

    System.out.printf("Is There \"6\" ? >>> ");
    TreeNode p2 = bsT.searchBST('6');
    if (p2 != null) {
      System.out.printf("Searching Success! Searched key : %c \n", p2.data);
    } else {
      System.out.printf("Searching fail!! \n");
    }
  }
}