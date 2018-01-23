public class BinarySearch {


    public static int binarySearch(Integer[] a, Integer x) {
        
        int low = 0;
        int high = a.length - 1;

        int mid; 

        while (low <= high) {
        
            mid = (high + low) / 2;

            if (a[mid] < x) { // x is in second half 
                low = mid + 1;
            } else if (a[mid] > x) { // x is in first half
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;

    }

    public static void main(String[] argv) {

        Integer[] a = new Integer[]{0,5,10,13,15,23,42,217,1024,4929};
        Integer n = 42;

        int position = binarySearch(a, 1024); // should be 8
        System.out.println(position);

    }

}
