package com.leetcode.design.hashmap;

/**
 *
 *  https://leetcode.com/problems/design-hashmap
 *
 *  Some of the questions which can be asked to the interviewer before implementing the solution
 *
 *  For simplicity, are the keys integers only?
 *  For collision resolution, can we use chaining?
 *  Do we have to worry about load factors?
 *  Can we assume inputs are valid or do we have to validate them?
 *  Can we assume this fits memory?
 *
 *  Time  : O(1) average and O(n) worst case - for all get(), put() and remove() methods.
 *  Space : O(n) - where n is the number of entries in HashMap
 */
public class DesignHashmap {
    class ListNode {
        int key, value;
        ListNode next;

        public ListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    ListNode[] nodes;
    int range = 10000;

    int getHashedIndex(int key) {
        return Integer.hashCode(key) % nodes.length;
    }

    /** Initialize your data structure here. */
    public DesignHashmap() {
        nodes = new ListNode[range];
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int i = getHashedIndex(key);
        if(nodes[i] == null) {
            nodes[i] = new ListNode(-1, -1);
        }
        ListNode prev = find(nodes[i], key);
        if(prev.next == null) {
            prev.next = new ListNode(key, value);
        }
        prev.next.value = value;
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int i = getHashedIndex(key);
        if(nodes[i] == null)
            return -1;
        ListNode prev = find(nodes[i], key);
        return prev.next == null ? -1 : prev.next.value;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int i = getHashedIndex(key);
        if(nodes[i] == null)
            return;
        ListNode prev = find(nodes[i], key);
        if(prev.next == null)
            return;
        prev.next = prev.next.next;
    }

    ListNode find(ListNode cluster, int key) {
        ListNode node = cluster, prev = null;
        while(node != null && key != node.key) {
            prev = node;
            node = node.next;
        }
        return prev;
    }

    public static void main(String[] args) {
        DesignHashmap obj = new DesignHashmap();
        System.out.println("Put 1 as key and it's value");
        obj.put(1, 11);
        obj.put(2, 12);
        System.out.println("Get the value of key 1 -> " +obj.get(1));
        System.out.println("Remove the key 1 and it's value");
        obj.remove(1);;
        System.out.println("Get the value of key 1 -> " +obj.get(1));
    }
}
