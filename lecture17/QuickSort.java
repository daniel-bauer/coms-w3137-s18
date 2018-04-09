import java.util.Random;
import java.util.Arrays;

/**
 * Data Structures in Java 
 * COMS W3134, Columbia University - Spring 2016
 * 
 * Quick Sort implementation. If a partition contains less than 10 elements, 
 * switch to insertion sort, which is also implemented in this class as a 
 * private method. 
 * Adapted from Weiss, Data Structures and Algorithm Analysis in Java. 3rd ed. 
 * http://users.cis.fiu.edu/~weiss/dsaajava3/code/Sort.java
 */
public final class QuickSort {

    private static final int CUTOFF = 10;

    /**
     * Quicksort algorithm.
     * @param a an array of <T extends Comparable<? super T>> items.
     */
    public static <T extends Comparable<? super T>> void quicksort(T [ ] a ) {
        quicksort( a, 0, a.length - 1 );
    }

    /**
     * Method to swap to elements in an array.
     * @param a an array of objects.
     * @param index1 the index of the first object.
     * @param index2 the index of the second object.
     */
    public static final void swapReferences( Object[ ] a, int index1, int index2 ) {
        Object tmp = a[ index1 ];
        a[ index1 ] = a[ index2 ];
        a[ index2 ] = tmp;
    }

    /**
     * Return median of left, center, and right.
     * Order these and hide the pivot.
     */
    private static <T extends Comparable<? super T>> T median3( T[ ] a, int left, int right ) {
        int center = ( left + right ) / 2;
        if( a[ center ].compareTo( a[ left ] ) < 0 )
            swapReferences( a, left, center );
        if( a[ right ].compareTo( a[ left ] ) < 0 )
            swapReferences( a, left, right );
        if( a[ right ].compareTo( a[ center ] ) < 0 )
            swapReferences( a, center, right );

            // Place pivot at position right - 1
        swapReferences( a, center, right - 1 );
        return a[ right - 1 ];
    }

    /**
     * Internal quicksort method that makes recursive calls.
     * Uses median-of-three partitioning and a cutoff of 10.
     * @param a an array of <T extends Comparable<? super T>> items.
     * @param left the left-most index of the subarray.
     * @param right the right-most index of the subarray.
     */
    private static <T extends Comparable<? super T>> void quicksort( T[ ] a, int left, int right ) {
/* 1*/      if( left + CUTOFF <= right ) {
/* 2*/          T pivot = median3( a, left, right );

                // Begin partitioning
/* 3*/          int i = left, j = right - 1;

/* 4*/          for (;;) {   // or while(true)
/* 5*/              while( a[ ++i ].compareTo( pivot ) < 0 ) { }
/* 6*/              while( a[ --j ].compareTo( pivot ) > 0 ) { }
/* 7*/              if( i < j ) 
/* 8*/                  swapReferences( a, i, j );
                    else
/* 9*/                  break;
            }

/*10*/      swapReferences( a, i, right - 1 );   // Restore pivot

/*11*/      quicksort( a, left, i - 1 );    // Sort small elements
/*12*/      quicksort( a, i + 1, right );   // Sort large elements

        } else  // Do an insertion sort on the subarray
/*13*/          insertionSort( a, left, right );
    }

    /**
     * Internal insertion sort routine for subarrays
     * that is used by quicksort.
     * @param a an array of <T extends Comparable<? super T>> items.
     * @param left the left-most index of the subarray.
     * @param right the right-most index of the subarray.
     */
    private static <T extends Comparable<? super T>> void insertionSort(T[ ] a, int left, int right ) {
        for( int p = left + 1; p <= right; p++ ) {
            T tmp = a[ p ];
            int j;

            for( j = p; j > left && tmp.compareTo( a[ j - 1 ] ) < 0; j-- )
                a[ j ] = a[ j - 1 ];
            a[ j ] = tmp;
        }
    }

  
    public static void main( String[ ] args ) {
        Integer[] a = {12,3,1,97,50,5,9,0,10,20,51,2,1,6,1,2,3,18,2012,2,1351};
        QuickSort.quicksort(a);
        System.out.println(Arrays.toString(a));
    }
}
