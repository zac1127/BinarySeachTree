import java.util.*;
import java.io.*;


 class BinarySearchTree<T extends java.lang.Comparable<T>> {
  
  private static class BinaryNode<T> {
    
    private T item;
    private BinaryNode<T> left;
    private BinaryNode<T> right;
    private BinaryNode<T> file;
    
    
    private BinaryNode(T value) {
      item = value;
      left = null;
      right = null;
      file = null; // pointer to file trees
    }
    
    
   
    private BinaryNode(T value, BinaryNode<T> l, BinaryNode<T> r, BinaryNode<T> f) {
      item = value;
      left = l;
      right = r;
      file = f;
    }
    
  } // end Binary Search Tree
  
  protected BinaryNode<T> root = null; // null when tree is empty
  
  public BinarySearchTree() {
    super();
  }// end constructor
  
  public BinarySearchTree(T value) {
    super();
    root = new BinaryNode<T>(value);
  } // end constructor
  
  public BinarySearchTree(BinaryNode<T> newRoot) {
    super();
    root = newRoot;
  } // end constructor

  public BinaryNode<T> get(T key) {
    BinaryNode<T> node = root;
    while (node != null) {
      if (key.compareTo(node.item) == 0) {
        return node;
      }// end if
      if (key.compareTo(node.item) < 0) {
        node = node.left;
      } else {
        node = node.right;
      }// end if
    }// end while
    return null;
  } // end get 
  
  public void add(T value) {
    root = add(value, root);
  } // end add

  public BinaryNode<T> add(T value, BinaryNode<T> node) {
    if (node == null) {
      return new BinaryNode<T>(value);
    } // end if null
    if (value.compareTo(node.item) == 0) {
      node.item = value;
      // alternative code creates new node, leaves old node unchanged:
      //return new BinaryNode<T>(value, node.left, node.right);
    } else {
      if (value.compareTo(node.item) < 0) { // add to left subtree
        node.left = add(value, node.left);
      } else {  // add to right subtree
        node.right = add(value, node.right);
      } // end if else
    }// end if else
    return node;
  } // end add
  
    
  // Go to directory 
  // point to tree
  // add tree to that node
  
  public void addFile(T value, T directory) {
    
    BinaryNode<T> fileRoot = get(directory);
   
    if(fileRoot != null){
   
    fileRoot.file = addFile(value, fileRoot.file);
    
    } else {
      
     System.out.println("No directory found for: "+ directory + "!"); 
      
    }// end if else 
    
  } //end addFile

  public BinaryNode<T> addFile(T value, BinaryNode<T> node) {
    
    if(node == null) {
     
      return new BinaryNode<T>(value);

    } else if(node == null) {
      
      node = addFile(value, node.file);

    } else {
      
    

      if (value.compareTo(node.item) == 0) {
        node.item = value;

      } else {
        if (value.compareTo(node.item) < 0) { // add to left subtree

          node.left = addFile(value, node.left);
          System.out.println("LEFT");

        } else {  // add to right subtree

          node.right = addFile(value, node.right);
                    System.out.println("RIGHT");

          
        }// end if
    
    } // end if else
      
    } // end else if
    return node;
  
  } // end add file
  
  

  public void printFileTree(T directory){
    
    BinaryNode<T> fileRoot = get(directory);
    
    if(fileRoot != null){
      fileRoot = fileRoot.file;
    printFileTree(fileRoot);
    
    }else {
      System.out.println("No directory found for: " + directory + "!");
    }// end if 
  } // end print file Tree
  
  public void printFileTree(BinaryNode<T> root) {
    if(root != null) {
       printFileTree(root.left);
       System.out.println(root.item);
       printFileTree(root.right);
    } // end if null
  } // end printFileTree
  
  
  
  
  public void printInOrder(){
    
    if(root != null){
     
    printInOrder(root);
    
    }else {
      System.out.println("No root found");
    }// end if 
  } // end print file Tree
  
  public void printInOrder(BinaryNode<T> root) {
    if(root != null) {
       printInOrder(root.left);
       System.out.print(root.item + ", ");
       if(root.file != null){
         printInOrder(root.file);
       }
       printInOrder(root.right);
    } // end if null
  } // end printFileTree
} // end BinarySearchTree class
 