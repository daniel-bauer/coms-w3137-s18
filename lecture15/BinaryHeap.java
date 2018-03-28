import java.util.Arrays;

/**
 * Data Structures in Java 
 * COMS W3134, Columbia University - Spring 2016
 * 
 * Implements a generic Binary Min Heap. 
 * All "matching" is based on the compareTo method in java.lang.Comparable. 
 * Adapted from Weiss, Data Structures and Algorithm Analysis in Java. 3rd ed. 
 * http://users.cis.fiu.edu/~weiss/dsaajava3/code/BinaryHeap.java
 */
public class BinaryHeap<T extends Comparable<? super T>> {

    private static final int DEFAULT_CAPACITY = 100;
    private int currentSize; // Number of elements in heap
    private T [ ] array; // The heap array

    /**
     * Construct the binary heap.
     */
    public BinaryHeap( ) {
        this( DEFAULT_CAPACITY );
    }

    /**
     * Construct the binary heap.
     * @param capacity the capacity of the binary heap.
     */
    @SuppressWarnings("unchecked")
    public BinaryHeap( int capacity ) {
        currentSize = 0;
        array = (T []) new Comparable[ capacity + 1 ];
    }

    /**
     * Test if the priority queue is logically empty.
     * @return true if empty, false otherwise.
     */
    public boolean isEmpty( ) {
        return currentSize == 0;
    }

    /**
     * Test if the priority queue is logically full.
     * @return true if full, false otherwise.
     */
    public boolean isFull( ) {
        return currentSize == array.length - 1;
    }

    /**
     * Make the priority queue logically empty.
     */
    public void makeEmpty( ) {
        currentSize = 0;
    }

    /**
     * Insert into the priority queue, maintaining heap order.
     * Duplicates are allowed.
     * @param x the item to insert.
     * @exception IndexOutOfBoundsException if container is full.
     */
    public void insert( T x ) throws IndexOutOfBoundsException {
        if( isFull( ) )
            throw new IndexOutOfBoundsException( );

        // Percolate up
        int hole = ++currentSize;

        for( ; hole > 1 && x.compareTo( array[ hole / 2 ] ) < 0; hole /= 2 )
            array[ hole ] = array[ hole / 2 ];
    
       
        /*while (hole>1 && x.compareTo[array [hole /2]) <0 ) {
            array[hole] = array[hole/2];
            if (x.compareTo[array [hol] /2]) <0)
                hole /= 2; 
        }*/
            
        array[ hole ] = x;
    }

    /**
     * Find the smallest item in the priority queue.
     * @return the smallest item, or null, if empty.
     */
    public T findMin( ) {
        if( isEmpty( ) )
            return null;
        return array[ 1 ];
    }

    /**
     * Remove the smallest item from the priority queue.
     * @return the smallest item, or null, if empty.
     */
    public T deleteMin( ) {
        if( isEmpty( ) )
            return null;

        T minItem = findMin( );
        array[ 1 ] = array[ currentSize-- ];
        percolateDown( 1 );

        return minItem;
    }

        /**
     * Establish heap order property from an arbitrary
     * arrangement of items. Runs in linear time.
     */
    private void buildHeap( ) {
        for( int i = currentSize / 2; i > 0; i-- )
            percolateDown( i );
    }

    /**
     * Internal method to percolate down in the heap.
     * @param hole the index at which the percolate begins.
     */
    private void percolateDown( int hole ) {
        int child;
        T tmp = array[ hole ];

        for( ; hole * 2 <= currentSize; hole = child ) {
/* 4*/      child = hole * 2; // find left child
/* 5*/      if( child != currentSize && // do we have a right child? 
/* 6*/          array[ child + 1 ].compareTo( array[ child ] ) < 0 ) // is the right child smaller?
/* 7*/          child++; //if so, swap with right instead of left child.
/* 8*/      if( array[ child ].compareTo( tmp ) < 0 )
/* 9*/          array[ hole ] = array[ child ];
            else
/*10*/          break;
        }
/*11*/  array[ hole ] = tmp;
    }

    /**
     * Get a string representation of the heap array.
     * @return string representation of the array backing the this heap.
     */
    public String printArray() {
        return Arrays.asList(array).toString();
    }
    
    /**
     * Get a string representation of the heap. 
     * @return a tree representing the tree encoded in this heap. 
     */
    public String printAsTree() {
        StringBuilder sb = new StringBuilder();
        printAsTree(sb,1);
        return sb.toString(); 
    }
   
    /**
     * Recursive internal method to assemble a tree
     * string representing the heap.
     */ 
    private void printAsTree(StringBuilder sb,int i) {
        if (2*i <= currentSize) {  // has left child
            sb.append("("); 
            sb.append(array[i]);
            sb.append(" ");
            printAsTree(sb,2*i); 
            if ((2*i + 1) <= currentSize){  // has right child
                sb.append(" ");
                printAsTree(sb, 2*i+1);
            }
            sb.append(")");
        } else {
            sb.append(array[i]);
        }
    }

    public static void main( String [ ] args ) {
        BinaryHeap<Integer> h = new BinaryHeap<>( 20 );
        h.insert(1);  
        h.insert(4);  
        h.insert(2);
        h.insert(3);  
        h.insert(5);  
        h.insert(6);  

        System.out.println(h.printArray());
        System.out.println(h.printAsTree());


        System.out.println(h.deleteMin());
        
        System.out.println(h.printArray());
        System.out.println(h.printAsTree());

    }
}
