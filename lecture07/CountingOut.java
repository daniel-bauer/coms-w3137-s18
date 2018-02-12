import java.util.LinkedList;

public class CountingOut {


    public static void main(String[] args) {
    
        int n = 9;
        int k = 8;

        LinkedList<Integer> q = new LinkedList<>();
        for(int i = 0; i<n; i++)
            q.add(i);
       
        while (q.size() > 1){ 
            for(int i = 0; i<k-1; i++) {
                q.add(q.remove()); // move counter by one
            }
            System.out.println(q.remove()+ " is out."); 
        }
        System.out.println(q.remove()+ " wins."); 

    }

}
