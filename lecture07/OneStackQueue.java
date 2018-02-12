import java.util.LinkedList;

public class OneStackQueue {

    LinkedList<Integer> stack;

    public OneStackQueue() {
        stack = new LinkedList<>();
    }    

    public void enqueue(Integer x) {
        stack.push(x);
    }
     
    public Integer dequeue() {

        Integer top = stack.pop();
        if (stack.isEmpty()) {
            return top;
        } else {
            Integer result = dequeue();
            stack.push(top);
            return result;
        }

    }

    public static void main(String[] args) {
            
        OneStackQueue q = new OneStackQueue();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        
    }
    

}
