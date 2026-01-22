/**
 * CSC-242 Project 3: Priority Queue
 * Student: Weiquan Mai
 * Created On: November 3, 2025
 * @File: HeapAdaptablePriorityQueue
 * Description:
 * Implemented remove(entry), replaceKey(entry, key), replaceValue(entry, value)
 */

import java.util.Comparator;

public class HeapAdaptablePriorityQueue<K, V> extends HeapPriorityQueue<K, V> implements AdaptablePriorityQueue<K, V> {

    // ---------------- nested AdaptablePQEntry class ----------------
    /** Extension of the PQEntry to include location information. */
    protected static class AdaptablePQEntry<K, V> extends PQEntry<K, V> {
        private int index; // entry’s current index within the heap

        public AdaptablePQEntry(K key, V value, int j) {
            super(key, value); // this sets the key and value
            index = j; // this sets the new field
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int j) {
            index = j;
        }
    }
    // ----------- end of nested AdaptablePQEntry class -----------

    /** Creates an empty adaptable priority queue using natural ordering of keys. */
    public HeapAdaptablePriorityQueue() {
        super();
    }

    /** Creates an empty adaptable priority queue using the given comparator. */
    public HeapAdaptablePriorityQueue(Comparator<K> comp) {
        super(comp);
    }

    // protected utilites
    /** Validates an entry to ensure it is location-aware. */
    protected AdaptablePQEntry<K, V> validate(Entry<K, V> entry) throws IllegalArgumentException {
        if (!(entry instanceof AdaptablePQEntry))
            throw new IllegalArgumentException("Invalid entry");
        AdaptablePQEntry<K, V> locator = (AdaptablePQEntry<K, V>) entry; // safe
        int j = locator.getIndex();
        if (j >= heap.size() || heap.get(j) != locator)
            throw new IllegalArgumentException("Invalid entry");
        return locator;
    }

    /** Exchanges the entries at indices i and j of the array list. */
    protected void swap(int i, int j) {
        super.swap(i, j); // perform the swap
        ((AdaptablePQEntry<K, V>) heap.get(i)).setIndex(i); // reset entry's index
        ((AdaptablePQEntry<K, V>) heap.get(j)).setIndex(j); // reset entry's index
    }

    /**
     * Restores the heap property by moving the entry at index j upward/downward.
     */
    protected void bubble(int j) {
        // Implemented by Professor Ali Azhari
        if (j > 0 && compare(heap.get(j), heap.get(parent(j))) < 0)
            upheap(j);
        else
            downheap(j); // although it might not need to move
    }

    /** Inserts a key-value pair and returns the entry created. */
    @Override
    public Entry<K, V> insert(K key, V value) throws IllegalArgumentException {
        checkKey(key); // might throw an exception
        Entry<K, V> newest = new AdaptablePQEntry<>(key, value, heap.size());
        heap.add(newest); // add to the end of the list
        upheap(heap.size() - 1); // upheap newly added entry
        return newest;
    }

    /** Removes the given entry from the priority queue.
     * @param entry The entry to be removed.
     * @throws IllegalArgumentException if entry is not valid
     */
    @Override
    public void remove(Entry<K, V> entry) throws IllegalArgumentException {
        AdaptablePQEntry<K, V> locator = validate(entry);
        int removalIndex = locator.getIndex();
        // TO DO
        // If entry is the last element, simply remove the element
        if(removalIndex == heap.size() - 1){
            heap.remove(size() - 1);
        }

        // Else entry is not the last element, swap entry with the last element
        swap(removalIndex, size() - 1);

        // Remove entry from last index
        heap.remove(size() - 1);

        // Adjust position on swapped entry
        bubble(removalIndex);
    }

    /** Replaces the key of an entry.
     * @param entry The entry to be replaced.
     * @param key The value to replace the key in the specified entry.
     * @throws IllegalArgumentException If entry is not valid.
     */
    @Override
    public void replaceKey(Entry<K, V> entry, K key) throws IllegalArgumentException {

        // TO DO
        AdaptablePQEntry<K, V> locator = validate(entry);
        locator.setKey(key);
        bubble(locator.getIndex());
    }

    /** Replaces the value of an entry.
     * @param entry The entry to be replaced
     * @param value The value to replace the value in the specified entry.
     * @throws IllegalArgumentException If entry is not valid
     */
    @Override
    public void replaceValue(Entry<K, V> entry, V value) throws IllegalArgumentException {

        // TO DO
        AdaptablePQEntry<K, V> locator = validate(entry);
        locator.setValue(value);
    }
}
