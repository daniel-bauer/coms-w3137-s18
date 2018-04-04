import java.util.Arrays;

public class Sorting {


    public static <T extends Comparable<? super T>> void 
        selectionSort(T[] array) {
   
        for (int p = 0 ; p < array.length - 1; p++){
            int minPos = p; 
            T currentMin = array[p];  
            for (int j = p + 1; j < array.length; j++) { 
                if (currentMin.compareTo(array[j]) > 0) {
                    minPos = j;
                    currentMin = array[minPos];
                }
            }
            T tmp = array[p];
            array[p] = currentMin;
            array[minPos] = tmp;
        }

    }


    public static <T extends Comparable<? super T>> void 
        insertionSort(T[] array) {

        for (int p=0; p <= array.length-2; p++) {
           int j=p+1;
           while ((j > 0) && (array[j].compareTo(array[j-1]) < 0)) {
               T tmp = array[j-1];
               array[j-1] = array[j];
               array[j] = tmp;
               j--;
           } 
        }

    }        


    public static void main(String[] args) {

        Integer[] ints = {83, 42, 1, 10, 17, 42, 5, 1};
        System.out.println(Arrays.toString(ints));
        insertionSort(ints);
        System.out.println(Arrays.toString(ints));
    }



}
