/*******************************************************
 *  @Author : Ali Azhari
 *  Created On : Sun Oct 19 2025
 *  @File : AdaptablePriorityQueue.java
 *  Description: An abstract base class to
 * assist implementations of the PriorityQueue interface
 *******************************************************/

public interface AdaptablePriorityQueue<K, V> {

    void remove(Entry<K, V> entry);
    void replaceKey(Entry<K, V> entry, K key);
    void replaceValue(Entry<K, V> entry, V value);

}
