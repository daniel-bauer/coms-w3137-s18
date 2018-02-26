public class BinarySearchTree<T extends Comparable<? super T>>
                                extends BinaryTree<T> {

    
    /**
     * Internal method to insert into a subtree.
     * @param x the item to insert.
     * @param t the node that roots the subtree.
     * @return the new root of the subtree.
     */
    private BinaryNode<T> insert( T x, BinaryNode<T> t )
    {
        if( t == null ) // insert new node
            return new BinaryNode<>( x, null, null );
        
        int compareResult = x.compareTo( t.data );
            
        if (compareResult < 0 )
            t.left = insert( x, t.left );
        else if( compareResult > 0 )
            t.right = insert( x, t.right );

        return t;
    }

    /**
     * Insert into the tree; duplicates are ignored.
     * @param x the item to insert.
     */
    public void insert( T x ) {
        root = insert( x, root );
    }

    /**
     * Internal method to find an item in a subtree.
     * @param x is item to search for.
     * @param t the node that roots the subtree.
     * @return node containing the matched item.
     */
    private boolean contains( T x, BinaryNode<T> t ) {
        if( t == null )
            return false;
            
        int compareResult = x.compareTo( t.data );
            
        if( compareResult < 0 )
            return contains( x, t.left );
        else if( compareResult > 0 )
            return contains( x, t.right );
        else
            return true;    // Match
    }

    /**
     * Find an item in the tree.
     * @param x the item to search for.
     * @return true if not found.
     */
    public boolean contains(T x) {
        return contains(x, root);
    } 

    /**
     * Internal method to find the smallest item in a subtree.
     * @param t the node that roots the subtree.
     * @return node containing the smallest item.
     */
    private BinaryNode<T> findMin( BinaryNode<T> t ) {
        if( t == null )
            return null;
        else if( t.left == null )
            return t;
        return findMin( t.left );
    }

    /**
     * Find the smallest item in the tree.
     * @return the largest item of null if empty.
     */
    public T findMin() {
        BinaryNode<T> found = findMin(root);
        if (found == null) 
            return found.data;
        else 
            return null;
    }


    /**
     * Internal method to find the largest item in a subtree.
     * @param t the node that roots the subtree.
     * @return node containing the largest item.
     */
    private BinaryNode<T> findMax( BinaryNode<T> t ) {
        if( t != null ) 
            while( t.right != null ) // iterative solution
                t = t.right;
        return t;
    }
    
    /**
     * Find the largest item in the tree.
     * @return the largest item of null if empty.
     */
    public T findMax() {
        BinaryNode<T> found = findMax(root);
        if (found == null) 
            return found.data;
        else 
            return null;
    }

    /**
     * Internal method to remove from a subtree.
     * @param x the item to remove.
     * @param t the node that roots the subtree.
     * @return the new root of the subtree.
     */
    private BinaryNode<T> remove( T x, BinaryNode<T> t ) {
        if( t == null )
            return t;   // Item not found; do nothing
            
        int compareResult = x.compareTo( t.data );
            
        if( compareResult < 0 )
            t.left = remove( x, t.left ); 
        else if( compareResult > 0 )
            t.right = remove( x, t.right );
        else // found x 
            if( t.left != null && t.right != null ){ // 2 children
                t.data = findMin( t.right ).data;
                t.right = remove( t.data, t.right );
            } else 
                if (t.left != null)  // 0 or 1 children
                    return t.left;
                else
                    return t.right;
        return t;
    }

    /**
     * Remove from the tree. Nothing is done if x is not found.
     * @param x the item to remove.
     */
    public void remove(T x) {
        root = remove(x, root);
    }

}
