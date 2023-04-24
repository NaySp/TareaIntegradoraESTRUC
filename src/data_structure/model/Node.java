package data_structure.model;
public class Node <K, V> {

    K key;
    V value;
    private Node<K, V> next;
    public int getKey;

    public Node(K key, V value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }

    public V getValue(){
        return this.value;
    }

    public K getKey(){
        return this.key;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public Node<K, V> getNext() {
        return next;
    }

    public void setNext(Node<K, V> next) {
        this.next = next;
    }

}