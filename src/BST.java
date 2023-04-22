import java.util.ArrayList;

/**
 * An Integer Binary Search Tree
 * @author: Damian Villarreal-Ayala
 * @version: Friday April 21 2023
 */

public class BST {
    private BSTNode root;

    public BSTNode getRoot() {
        return this.root;
    }

    public void setRoot(BSTNode root) {
        this.root = root;
    }

    /**
     * Sets up a binary search tree
     * with some default values
     */
    public void setupTestData() {
        this.root = new BSTNode(10);
        this.root.setLeft(new BSTNode(5));
        this.root.setRight(new BSTNode((15)));
        this.root.getLeft().setLeft(new BSTNode(3));
        this.root.getLeft().setRight(new BSTNode(9));
    }

    /**
     * Prints the provided ArrayList of nodes
     * in the form node1-node2-node3
     * @param nodes ArrayList of BSTNodes
     */
    public static void printNodes(ArrayList<BSTNode> nodes) {
        for(int i=0; i < nodes.size()-1; i++) {
            System.out.print(nodes.get(i) + "-");
        }
        System.out.println(nodes.get(nodes.size()-1));
    }

    /**
     * A function that searches for a value in the tree
     * @param val integer value to search for
     * @return true if val is in the tree, false otherwise
     */
    public boolean search(int val) {
        // TODO: Complete the search function
        //Calling outside function created to recursively look through tree.
        return helper(root, val);
    }

    //Helper method to recursively find value in tree.
    public boolean helper(BSTNode currentNode, int value)
    {
        if(currentNode == null)
        {
            return false;
        }
        if(currentNode.getVal() == value)
        {
            return true;
        }
        if(currentNode.getVal() > value)
        {
            return helper(currentNode.getLeft(), value);
        }
        if(currentNode.getVal() < value)
        {
            return helper(currentNode.getRight(), value);
        }
        return false;
    }
    /**
     * @return ArrayList of BSTNodes in inorder
     */
    public ArrayList<BSTNode> getInorder() {
        // TODO: Complete inorder traversal
        ArrayList<BSTNode> newArray = new ArrayList<BSTNode>();
        inOrderArray(root, newArray);
        return newArray;
    }

    public void inOrderArray(BSTNode current, ArrayList<BSTNode> array)
    {
        if(current == null)
        {
            return;
        }
        inOrderArray(current.getLeft(), array);
        array.add(current);
        inOrderArray(current.getRight(), array);
    }
    /**
     * @return ArrayList of BSTNodes in preorder
     */
    public ArrayList<BSTNode> getPreorder() {
        // TODO: Complete preorder traversal
        ArrayList<BSTNode> newArray = new ArrayList<BSTNode>();
        preOrderArray(root, newArray);
        return newArray;
    }
    public void preOrderArray(BSTNode current, ArrayList<BSTNode> array)
    {
        if(current == null)
        {
            return;
        }
        array.add(current);
        preOrderArray(current.getLeft(), array);
        preOrderArray(current.getRight(), array);
    }
    /**
     * @return ArrayList of BSTNodes in postorder
     */
    public ArrayList<BSTNode> getPostorder() {
        // TODO: Complete postorder traversal
        ArrayList<BSTNode> newArray = new ArrayList<BSTNode>();
        postOrderArray(root, newArray);
        return newArray;
    }
    public void postOrderArray(BSTNode current, ArrayList<BSTNode> array)
    {
        if(current == null)
        {
            return;
        }
        postOrderArray(current.getLeft(), array);
        postOrderArray(current.getRight(), array);
        array.add(current);
    }
    /**
     * Inserts the given integer value to the tree
     * if it does not already exist. Modifies the
     * root instance variable to be the root of the new modified tree.
     * @param val The value ot insert
     */
    public void insert(int val) {
        // TODO: Complete insert
        BSTNode node = new BSTNode(val);
        if(!search(val))
        {
            helpInsert(node, root);
        }
    }

    public void helpInsert(BSTNode node, BSTNode current)
    {
        if(node.getVal() < current.getVal() && current.getRight() == null)
        {
            current.setLeft(node);
        }
        else if(node.getVal() > current.getVal() && current.getRight() == null)
        {
            current.setRight(node);
        }
        if(node.getVal() < current.getVal())
        {
            helpInsert(node, current.getLeft());
        }
        if(node.getVal() > current.getVal())
        {
            helpInsert(node, current.getRight());
        }
    }

    /**
     * Determines if the current BST is
     * a valid BST.
     * @return true if valid false otherwise
     */
    public boolean isValidBST() {
        // TODO: Optional Challenge!
        return false;
    }

    public static void main(String[] args) {
        // Tree to help you test your code
        BST tree = new BST();
        tree.setupTestData();

        System.out.println("\nSearching for 15 in the tree");
        System.out.println(tree.search(15));

        System.out.println("\nSearching for 22 in the tree");
        System.out.println(tree.search(22));

        System.out.println("\nPreorder traversal of binary tree is");
        ArrayList<BSTNode> sol = tree.getPreorder();
        printNodes(sol);

        System.out.println("\nInorder traversal of binary tree is");
        sol = tree.getInorder();
        printNodes(sol);

        System.out.println("\nPostorder traversal of binary tree is");
        sol = tree.getPostorder();
        printNodes(sol);

        tree.insert(8);
        System.out.println("\nInorder traversal of binary tree is");
        sol = tree.getInorder();
        printNodes(sol);
    }
}
