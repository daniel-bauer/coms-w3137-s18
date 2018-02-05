public class LinkedListStack<T> implements Stack<T> {

    List<T> theList;

    public LinkedListStack() {
        theList = new MyLinkedList<>();
    }

    public void push(T x) {
        theList.add(theList.size(), x);
    }

    public T pop() {
        return theList.remove(theList.size()-1);    
    }

    public T top() {
        return theList.get(theList.size()-1);
    }

    public empty() {
        theList.isEmpty();
    }

}






