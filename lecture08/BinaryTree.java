/**
 * Honors Data Structures in Java 
 * COMS W3137, Columbia University - Spring 2017
 * Basic structure of a binary tree.
 */
public class BinaryTree<T> {

    // The BinaryTree is essentially just a wrapper around the linked 
    // structure of BinaryNodes, rooted in root.
    protected BinaryNode<T> root;

    /**
     * Represents a binary subtree.
     */
    protected static class BinaryNode<T>{

        public T             data;  // the data 
        public BinaryNode<T> left;  // left subtree
        public BinaryNode<T> right; // right subtree
    
        /**
         * Construct a new binary node. 
         */
        public BinaryNode( T theData, BinaryNode<T> leftChild, 
                                      BinaryNode<T> rightChild ) {
            data    = theData; 
            left    = leftChild;
            right   = rightChild;
        }

        public BinaryNode(T theData) {
            data = theData;
            left = null;
            right = null;
        }

        /**
         * Print tree rooted at current node using preorder traversal.
         */
        public void printTree(int indent ) {
            for (int i=0;i<indent;i++)
                System.out.print(" ");

            System.out.println(data);        // Node
            if( left != null )
                left.printTree(indent + 1);  // Left
            if( right != null )
                right.printTree(indent + 1);  // Right
        }


        public int height() {
            int height_l = -1;
            int height_r = -1;

            if (left != null)
                height_l = left.height();

            if (right != null) 
                height_r = right.height();

            return Math.max(height_l, height_r) + 1;
        }

        

        /**
         * Return a bracketed string represention of this tree.        
         */
        public String toString() {

            if (left == null && right == null) // if this is a leaf
                return data.toString();
           
            StringBuilder sb = new StringBuilder( "("); 
            sb.append(data);
            sb.append(" ");
            if (left != null)
                sb.append(left.toString());
            else 
                sb.append("*");
            sb.append(" ");
            if (right != null) 
                sb.append(right.toString());
            else
                sb.append("*");
            sb.append(")");
            return sb.toString();
        }


    } // Nested class BinaryNode ends here.
   

 
    /**
     * Construct a new empty BinaryTree
     */
    public BinaryTree() {
        root = null;
    }

    /**
     * Construct a new BinaryTree wrapper around the BinaryNode rootNode.
     */
    public BinaryTree(BinaryNode<T> rootNode) {
        root = rootNode;
    }

    /**
     * Display the tree as an indented in-order notation.
     */
    public void printTree() {
        if (root != null)
            root.printTree(0);
        else
            System.out.println("Empty Tree");
    }

    public int height() {
        if (root == null)
            return -1;

        return root.height();
    }

    /** 
     * Factory method that creates a new BinaryTree with two subtrees, that contains theItem
     * as the data object attached to its root.  
     * The two btree methods make it possible to easily construt binary trees like this: 
     * BinaryTree<Integer> t = btree(1,btree(2,btree(3),btree(4)),btree(5));
     * @return a new BinaryTree with two children.  
     */ 
    public static <T> BinaryTree<T> btree(T theItem, BinaryTree<T> t1, BinaryTree<T> t2) {
        BinaryNode<T> newRoot = new BinaryNode<T>(theItem, t1.root, t2.root);
        return new BinaryTree<T>(newRoot);
    }
    
    /**
     * Factory method that creates a new BinaryTree with no children, which contains 
     * theItem as data object attached to its root.
     * @return a new BinaryTree with no children.
     */
    public static <T> BinaryTree<T> btree(T theItem) {
        return new BinaryTree<T>(new BinaryNode<T>(theItem, null, null ));
    }


    public String toString() {
        if (root == null) 
            return "()";
        else 
            return root.toString();
    }

    /**
     * Test method: Create and print a BinaryTree. 
     */ 
    public static void main(String[] args) {
        //BinaryTree<String> t = btree("2",btree("2",btree("3"),btree("4")),btree("5"));
        //t.printTree();
        
        //BinaryTree<Integer> t = btree(3, btree(1), btree(2, btree(4), btree(5)));


        BinaryTree<Integer> t = new BinaryTree();
        System.out.println(t);


        System.out.println(t.height());

        //BinaryNode<Integer> t = new BinaryNode<Integer>(1, new BinaryNode<Integer>(2),
        //                                                   new BinaryNode<Integer>(3));


    }

}
