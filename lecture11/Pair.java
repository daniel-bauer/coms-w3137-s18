public class Pair<K extends Comparable<K>,V> implements Comparable<Pair<K,?>>{
    public K key;
    public V value;
    public Pair(K theKey, V theValue) {
       key = theKey; value = theValue;        
    }
   
    public int compareTo(Pair<K,?> other) {
        return key.compareTo(other.key);
    }
}
