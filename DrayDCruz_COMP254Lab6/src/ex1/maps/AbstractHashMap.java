package ex1.maps;

import java.util.ArrayList;
import java.util.Random;

public abstract class AbstractHashMap<K,V> extends AbstractMap<K,V> {
    protected int n = 0;                 // number of entries in the dictionary
    protected int capacity;              // length of the table
    private int prime;                   // prime factor
    private long scale, shift;           // the shift and scaling factors

    // User-defined max load factor
    private double maxLoadFactor = 0.5;

    /** Creates a hash table with the given capacity and prime factor. */
    public AbstractHashMap(int cap, int p) {
        prime = p;
        capacity = cap;
        Random rand = new Random();
        scale = rand.nextInt(prime-1) + 1;
        shift = rand.nextInt(prime);
        createTable();
    }

    /** Creates a hash table with given capacity and prime factor 109345121. */
    public AbstractHashMap(int cap) { this(cap, 109345121); }

    /** Creates a hash table with capacity 17 and prime factor 109345121. */
    public AbstractHashMap() { this(17); }


    // NEW CONSTRUCTORS

    public AbstractHashMap(int cap, int p, double loadFactor) {
        this(cap, p);
        this.maxLoadFactor = loadFactor;
    }

    public AbstractHashMap(int cap, double loadFactor) {
        this(cap);
        this.maxLoadFactor = loadFactor;
    }

    public AbstractHashMap(double loadFactor) {
        this();
        this.maxLoadFactor = loadFactor;
    }

    //

    @Override
    public int size() { return n; }

    @Override
    public V get(K key) { return bucketGet(hashValue(key), key); }

    @Override
    public V remove(K key) { return bucketRemove(hashValue(key), key); }

    @Override
    public V put(K key, V value) {
        V answer = bucketPut(hashValue(key), key, value);

        // use user-defined load factor instead of fixed 0.5
        if ((double) n / capacity > maxLoadFactor)
            resize(2 * capacity - 1);

        return answer;
    }

    /** Hash function applying MAD method to default hash code. */
    private int hashValue(K key) {
        return (int) ((Math.abs(key.hashCode()*scale + shift) % prime) % capacity);
    }

    /** Updates the size of the hash table and rehashes all entries. */
    private void resize(int newCap) {
        ArrayList<Entry<K,V>> buffer = new ArrayList<>(n);
        for (Entry<K,V> e : entrySet())
            buffer.add(e);
        capacity = newCap;
        createTable();
        n = 0;
        for (Entry<K,V> e : buffer)
            put(e.getKey(), e.getValue());
    }

    // protected abstract methods to be implemented by subclasses
    /** Creates an empty table having length equal to current capacity. */
    protected abstract void createTable();

    /**
     * Returns value associated with key k in bucket with hash value h.
     * If no such entry exists, returns null.
     * @param h  the hash value of the relevant bucket
     * @param k  the key of interest
     * @return   associate value (or null, if no such entry)
     */
    protected abstract V bucketGet(int h, K k);

    /**
     * Associates key k with value v in bucket with hash value h, returning
     * the previously associated value, if any.
     * @param h  the hash value of the relevant bucket
     * @param k  the key of interest
     * @param v  the value to be associated
     * @return   previous value associated with k (or null, if no such entry)
     */
    protected abstract V bucketPut(int h, K k, V v);

    /**
     * Removes entry having key k from bucket with hash value h, returning
     * the previously associated value, if found.
     * @param h  the hash value of the relevant bucket
     * @param k  the key of interest
     * @return   previous value associated with k (or null, if no such entry)
     */
    protected abstract V bucketRemove(int h, K k);
}