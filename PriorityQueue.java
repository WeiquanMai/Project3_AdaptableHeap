
/*******************************************************
 *  @Author : Ali Azhari
 *  Created On : Sun Oct 19 2025
 *  @File : HeapPriorityQueue.java
 *
 *  Description: Interface for the priority queue ADT
 *******************************************************/


public interface PriorityQueue<K, V> {

    int size();
    boolean isEmpty();
    Entry<K, V> insert(K key, V value) throws IllegalArgumentException;
    Entry<K, V> min();
    Entry<K, V> removeMin();
}
