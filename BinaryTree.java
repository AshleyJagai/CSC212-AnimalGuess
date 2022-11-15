/**
 *  Implements binary trees.
 *
 *  @author  Nicholas R. Howe
 *  @version CSC 212, November 2021
 */
public class BinaryTree<E> {
    /** The value at this node */
    private E data;

    /** Left child of this node */
    private BinaryTree<E> left;

    /** Right child of this node */
    private BinaryTree<E> right;

    /** This constructor creates a leaf node */
    public BinaryTree(E data) {
        this.data = data;
        right = left = null;
    }

    /** This constructor creates a branch node */
    public BinaryTree(E data, BinaryTree<E> left, BinaryTree<E> right) {
        this.data = data;
        this.right = right;
        this.left = left;
    }

    /** This constructor creates a deep copy of the entire tree structure */ 
    public BinaryTree(BinaryTree<E> tree) {
        this.data = tree.data;
        this.left = (tree.left == null)? null:(new BinaryTree<E>(tree.left));
        this.right = (tree.right == null)? null:(new BinaryTree<E>(tree.right));
    }

    /** Accessor for node data */
    public E getData() {
	      return data;
    }

    /** Accessor for left child */
    public BinaryTree<E> getLeft() {
      	return left;
    }

    /** Accessor for right child */
    public BinaryTree<E> getRight() {
      	return right;
    }

    /** Manipulator for node data */
    public void setData(E data) {
      	this.data = data;
    }

    /** Manipulator for left child */
    public void setLeft(BinaryTree<E> left) {
      	this.left = left;
    }

    /** Manipulator for right child */
    public void setRight(BinaryTree<E> right) {
      	this.right = right;
    }

    /** Determines whether a tree is empty */
    public static boolean isEmpty(BinaryTree node) {
	      return (node == null);
    }

    /** Determines whether this tree is a leaf */
    public boolean isLeaf() {
	      return (left == null)&&(right == null);
    }

    /** Determines whether this tree is a branch */
    public boolean isBranch() {
	      return (left != null)||(right != null);
    }

    /** Counts the number of nodes */
    public int count() {
        int lcount = (left == null) ? 0 : left.count();
        int rcount = (right == null) ? 0 : right.count();
        return lcount+rcount+1;
    }

    /** Computes the height of the tree */
    public int height() {
        int lheight = (left == null) ? 0 : left.height();
        int rheight = (right == null) ? 0 : right.height();
        return (lheight > rheight) ? lheight+1 : rheight+1;
    }

    /** Creates a string representation */
    public String toString() {
	      return inorderString(this);
    }

    public static <T> String preorderString(BinaryTree<T> t) {
        if (t==null) {
            return "";
        } else {
            return "("+t.data+" "+preorderString(t.left)+" "+preorderString(t.right)+")";
        }
    }

    public static <T> String inorderString(BinaryTree<T> t) {
        if (t==null) {
            return "";
        } else {
            return "("+inorderString(t.left)+" "+t.data+" "+inorderString(t.right)+")";
        }
    }

    public static <T> String postorderString(BinaryTree<T> t) {
        if (t==null) {
            return "";
        } else {
            return "("+postorderString(t.left)+" "+postorderString(t.right)+" "+t.data+")";
        }
    }
}
