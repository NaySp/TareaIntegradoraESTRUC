package model;
import java.util.ArrayList;

public class HashTable<K, V> implements IHash<K, V> {

    private final int CAPACITY = 80;
    private final double LOAD_FACTOR = 0.75;
    private int size;

    private ArrayList<Node<K, V>>[] table;

    public HashTable() {
        size = 0;
        table = new ArrayList[CAPACITY];
        for (int i = 0; i < CAPACITY; i++) {
            table[i] = new ArrayList<>();
        }
    }

    @Override
    public void put(K key, V value) {
        int index = hash(key);
        ArrayList<Node<K, V>> nodes = table[index];
        for (Node<K, V> node : nodes) {
            if (node.key.equals(key)) {
                node.value = value;
                return;
            }
        }
        Node<K, V> newNode = new Node<>(key, value);
        nodes.add(newNode);
        size++;
        if (size > table.length * LOAD_FACTOR) {
            resize();
        }
    }

    @Override
    public V get(K key) {
        int index = hash(key);
        ArrayList<Node<K, V>> nodes = table[index];
        for (Node<K, V> node : nodes) {
            if (node.key.equals(key)) {
                return node.value;
            }
        }
        return null;
    }


    @Override
    public boolean containsKey(K key) {
        int index = hash(key);
        ArrayList<Node<K, V>> nodes = table[index];
        for (Node<K, V> node : nodes) {
            if (node.key.equals(key)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    public int hash(K key) {
        return Math.abs(key.hashCode() % table.length);
    }

    public void resize() {
        ArrayList<Node<K, V>>[] oldTable = table;
        table = new ArrayList[oldTable.length * 2];
        for (int i = 0; i < table.length; i++) {
            table[i] = new ArrayList<>();
        }
        size = 0;
        for (ArrayList<Node<K, V>> nodes : oldTable) {
            for (Node<K, V> node : nodes) {
                put(node.key, node.value);
            }
        }
    }

}
