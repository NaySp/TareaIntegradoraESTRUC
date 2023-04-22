package model;

public interface IHash<K, V> {

    public void put(K key, V value);
    public V get(K key);
    public void remove(K key);
    public boolean containsKey(K key);
    public int hash(K key);
    public boolean isEmpty();
    public int getSize();
    public void resize();

}
