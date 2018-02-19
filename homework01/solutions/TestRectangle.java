import java.util.List;
import java.util.ArrayList;

public class TestRectangle {

    public static <T extends Comparable<? super T>> T findMax(List<T> items) {
        // assume items is not empty
        int max = 0;
        for (int i = 1; i < items.size(); i++){
            if (items.get(i).compareTo(items.get(max)) > 0)
                max = i;
        }
        return items.get(max);
    }

    public static void main(String[] args) {
    
        List<Rectangle> rects = new ArrayList<>();

        rects.add(new Rectangle(2,3));
        rects.add(new Rectangle(3,2));
        rects.add(new Rectangle(1,1));
        rects.add(new Rectangle(6,2));

        // This should print the return value of the toString() method
        // of the 6 x 2 rectangle.  
        System.out.println(findMax(rects)); 
        
    }

}
