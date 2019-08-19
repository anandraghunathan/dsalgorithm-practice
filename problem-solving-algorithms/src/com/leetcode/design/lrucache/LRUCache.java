package com.leetcode.design.lrucache;

/**
  LRU Cache - LeetCode: https://leetcode.com/problems/lru-cache/

  An adaption of the answer from user "liaison" on Leetcode.
  Link: https://leetcode.com/problems/lru-cache/discuss/45911/Java-Hashtable-%2B-Double-linked-list-(with-a-touch-of-pseudo-nodes)

  Revision by Benyam Ephrem (Dec. 31th 2018)
    > Making variable names more conventional
    > Adding more clarifying comments
    > Moving code around to be more conventional

  This code passes all Leetcode test cases as of Dec. 31st 2018
  Runtime: 77 ms, faster than 95.85% of Java online submissions for LRU Cache.

  The video to explain this code is here: https://www.youtube.com/watch?v=S6IfqDXWa10
*/

import java.util.HashMap;
import java.util.Map;

class LRUCache {

    /*
      Our internal definition of a doubly linked list
      node, put in this class for convenience since
      this is submitted in one file on Leetcode
    */
    // Implementation of Doubly-linked list node that's used for implementing the LRUCache
    private class DNode {
        // We need four properties, key and values to store the entries into the cache
        int key;
        int value;

        // Prev and next nodes to store the current node's prev and next nodes
        DNode prev;
        DNode next;
    }

    // We need a hashtable to store the DNodes backed by the hashmap.
    private Map<Integer, DNode> hashtable = new HashMap<>();
    private DNode head, tail; // We need this to efficiently remove/replace nodes at constant time O(1)
    private int totalItemsInCache;
    private int maxCapacity;

    public LRUCache(int maxCapacity) {

        // Cache starts empty and capacity is set by client by calling the LRUCache constructor from the main method
        totalItemsInCache = 0;
        this.maxCapacity = maxCapacity;

        // Initialize the dummy head of the cache
        head = new DNode();
        head.prev = null;

        // Init the dummy tail of the cache
        tail = new DNode();
        tail.next = null;

        // Wire the head and tail together
        head.next = tail;
        tail.prev = head;
    }

    /*
      Retrieve an item from the cache based on the key passed
    */
    public int get(int key) {
        /*
            We first check if the value corresponding to the key is present, if it is we then proceed doing further
            steps to return the value of the key.

            Else, we return -1 meaning, there is no such key available in the cache
        */
        DNode node = hashtable.get(key);
        boolean itemFoundInCache = node != null;

        // Empty state check. Should raise exception here.
        if(!itemFoundInCache){
            return -1;
        }

        // Item has been accessed. Move to the front of the list.
        moveToHead(node);

        return node.value;
    }

    /*
      Add an item to the cache if it is not already there,
      if it is already there update the value and move it
      to the front of the cache
    */
    public void put(int key, int value) {

        DNode node = hashtable.get(key);
        boolean itemFoundInCache = node != null;

        // The items looked up for in not in the cache, so we have to add it to the cache.
        if(!itemFoundInCache){

            // Create a new node
            DNode newNode = new DNode();
            newNode.key = key;
            newNode.value = value;

            // Add to the hashtable and the doubly linked list
            hashtable.put(key, newNode);
            addNode(newNode);

            // We just added an item to the cache
            totalItemsInCache++;

            // If over capacity evict an item with LRU cache eviction policy
            if(totalItemsInCache > maxCapacity){
                removeLRUEntryFromStructure();
            }

        } else {
            // If item is in cache just update and move it to the head
            /*
                If it comes into the else condition means, the item is indeed already present in the cache,
                so we just update it's value and move the pointer corresponding to the key to the front of the
                cache as its updated recently
            */
            node.value = value;
            moveToHead(node);
        }

    }

    /*
      Remove the least used entry from the doubly linked
      list as well as the hashtable. Hence it is evicted
      from the whole LRUCache structure
    */
    private void removeLRUEntryFromStructure() {
        // We first get the last item of the linked list since that's the least recently used item
        DNode tail = popTail();

        // We remove that tail/last item from the hashtable as well.
        hashtable.remove(tail.key);

        // Decrement the overall count in the cache as we removed the last item from the linked list
        --totalItemsInCache;
    }

    /*
      Insertions to the doubly linked list will always
      be right after the dummy head
    */
    private void addNode(DNode node){

        // Wire the node being inserted
        node.prev = head;
        node.next = head.next;

        // Re-wire the head's old next
        head.next.prev = node;

        // Re-wire the head to point to the inserted node
        head.next = node;
    }

    /*
      Remove the given node from the doubly linked list
    */
    private void removeNode(DNode node){

        // Grab reference to the prev and next of the node
        DNode savedPrev = node.prev;
        DNode savedNext = node.next;

        // Mark the head's next's prev to the current node. Basically rewiring the head's old next's prev pointer
        // that in future will be the current node
        savedPrev.next = savedNext;

        // Head's next node will become the current new node
        savedNext.prev = savedPrev;
    }

    /*
      Move a node to the head of the doubly linked lsit
    */
    private void moveToHead(DNode node){
        removeNode(node);
        addNode(node);
    }

    /*
      Pop the last item from the structure
    */
    private DNode popTail(){
        // First get the tail's prev node cause the tail node will be pointing to the null node
        DNode itemToBeRemoved = tail.prev;

        // Call the remove node function that will remove the tail node
        removeNode(itemToBeRemoved);

        // Return the removed tail node back to the caller function
        return itemToBeRemoved;
    }

    public static void main(String[] args) {
        /**
         * The LRUCache object will be instantiated and called as such:
         * LRUCache obj = new LRUCache(maxCapacity);
         * int param_1 = obj.get(key);
         * obj.put(key,value);
         */
        LRUCache obj = new LRUCache(4);
        int read0 = obj.get(0);
        System.out.println("Reading 0 before inserting anything : "+read0);
        obj.put(0, 1);
        System.out.println("Reading 0 after insert : "+read0);
        obj.put(1, 2);
        obj.put(2, 3);
        obj.put(3, 4);
        obj.put(4, 5);

        System.out.println("Accessing 1 after inserting all values will move it's node to head : "+obj.get(1));

        int read4 = obj.get(4);
        System.out.println("Reading 4 after insert: "+read4);

        System.out.println("Reading 0 after max capacity reached. Value with key 0 gets removed: "+obj.get(0));

        // New value
        obj.put(1, 6);

        // Read 1 again, it should show the new value
        int read1 = obj.get(1);
        System.out.println("Reading 1 after modify value : "+read1);
    }
}


