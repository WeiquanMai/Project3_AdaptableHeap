
/**
 * CSC-242 Project 3: Priority Queue
 * Student: Weiquan Mai
 * Created On: November 3, 2025
 * @File: HeapPriorityQueue
 * Description:
 * Implement upheap, downheap, left(int j), right(int j), parent(int j), hasLeft(int j), and hasRight(int j) methods
 */

import java.util.ArrayList;
import java.util.Comparator;

/** An implementation of a priority queue using an array-based heap. */
public class HeapPriorityQueue<K, V> extends AbstractPriorityQueue<K, V> {
    /** primary collection of priority queue entries */
    protected ArrayList<Entry<K, V>> heap = new ArrayList<>();

    /**
     * Creates an empty priority queue based on the natural ordering of its keys.
     */
    public HeapPriorityQueue() {
        super();
    }

    /** Creates an empty priority queue using the given comparator to order keys. */
    public HeapPriorityQueue(Comparator<K> comp) {
        super(comp);
    }

    // protected utilities

    /**
     * Determines position of parent node
     * @param j position of current node
     * @return position of parent node
     */
    protected int parent(int j) {
        // Todo: to be  be implemented
        return (j - 1) / 2;
    }

    /**
     * Determines position of left node
     * @param j position of current node
     * @return position of left node
     */
    protected int left(int j) {
        // Todo: to be  be implemented
        return (j * 2) + 1;
    }

    /**
     * Determines position of right node
     * @param j position of current node
     * @return position of right node
     */
    protected int right(int j) {
        // Todo: to be  be implemented
        return (j * 2) + 2;
    }

    /**
     * Determines if left node exists
     * @param j position of current node
     * @return boolean value determining if left node exists
     */
    protected boolean hasLeft(int j) {
        // Todo: to be  be implemented
        return left(j) < heap.size();
    }

    /**
     * Determines if right node exists
     * @param j position of current node
     * @return boolean value determining if right node exists
     */
    protected boolean hasRight(int j) {
        // Todo: to be  be implemented;
        return right(j) < heap.size();
    }

    /** Exchanges the entries at indices i and j of the array list. */
    protected void swap(int i, int j) {
        Entry<K, V> temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    /**
     * Moves the entry at index j higher, if necessary, to restore the heap
     * property.
     * @param j position of current node to upheap
     */
    protected void upheap(int j) {
        // Todo: to be be implemented

        while(j > 0){
            int parentIndex = parent(j);
            // Compare current to parent returns 1 if current is larger than parent, and thus no further upheap is needed
            if(compare(heap.get(j), heap.get(parentIndex)) >= 0){
                break;
            }
            // Else current is smaller than parent, and swap current and parent
            swap(j, parentIndex);

            // update position
            j = parentIndex;
        }
    }

    /**
     * Moves the entry at index j lower, if necessary, to restore the heap property.
     * @param j position of current node to downheap
     */
    protected void downheap(int j) {

        // Todo: to be  be implemented
        // downheap while current node has child node
        while (hasLeft(j)) {
            int smallestChild = left(j);

            // Compare left child to right child
            if(hasRight(j)){
                // compare returns 1 if left child is bigger than right child
                if(compare(heap.get(left(j)), heap.get(right(j))) > 0){
                    smallestChild = right(j);
                }
            }

            // Compare current to smallest child returns -1 if current is smaller than smallest child
            // Thus break, since no more swaps are necessary
            if(compare(heap.get(j), heap.get(smallestChild)) < 0){
                break;
            }

            // Else, current is bigger than child, swap them
            swap(j, smallestChild);

            // Update position
            j = smallestChild;
        }
    }

    // public methods
    /** Returns the number of items in the priority queue. */
    public int size() {
        return heap.size();
    }

    /** Returns (but does not remove) an entry with minimal key (if any). */
    public Entry<K, V> min() {
        if (heap.isEmpty())
            return null;
        return heap.get(0);
    }

    /** Inserts a key-value pair and returns the entry created. */
    public Entry<K, V> insert(K key, V value) throws IllegalArgumentException {
        checkKey(key); // auxiliary key-checking method (could throw exception)
        Entry<K, V> newest = new PQEntry<>(key, value);
        heap.add(newest); // add to the end of the list
        upheap(heap.size() - 1); // upheap newly added entry
        return newest;
    }

    /** Removes and returns an entry with minimal key (if any). */
    public Entry<K, V> removeMin() {
        if (heap.isEmpty())
            return null;
        Entry<K, V> answer = heap.get(0);
        swap(0, heap.size() - 1); // put minimum item at the end
        heap.remove(heap.size() - 1); // and remove it from the list;
        downheap(0); // then fix new root
        return answer;
    }

}
