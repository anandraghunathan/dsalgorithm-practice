package com.leetcode.design.hashset;

public class DesignHashset {
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
        return Integer.hashCode(key) % range;
    }
    /** Initialize your data structure here. */
    public DesignHashset() {
        nodes = new ListNode[range];
    }

    public void add(int key) {
        int i = getHashedIndex(key);
        if(nodes[i] == null)
            nodes[i] = new ListNode(-1, -1);
        ListNode prev = find(key, nodes[i]);
        if(prev.next == null) {
            prev.next = new ListNode(key, key);
        }
    }

    public void remove(int key) {
        int i = getHashedIndex(key);
        if(nodes[i] == null)
            return;
        ListNode prev = find(key, nodes[i]);
        if(prev.next == null)
            return;
        prev.next = prev.next.next;
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int i = getHashedIndex(key);
        if(nodes[i] == null)
            return false;
        ListNode prev = find(key, nodes[i]);
        if(prev.next ==  null)
            return false;
        return true;
    }

    ListNode find(int key, ListNode bucket) {
        ListNode node = bucket, prev = null;
        while(node != null && key != node.key) {
            prev = node;
            node = node.next;
        }
        return prev;
    }

    public static void main(String[] args) {
        DesignHashset obj = new DesignHashset();
        System.out.println("Add 1");
        obj.add(1);
        System.out.println("Add 2");
        obj.add(2);
        System.out.println("Check if 1 exists -> " +obj.contains(1));
        System.out.println("Check if 3 exists -> " +obj.contains(3));
        System.out.println("Add 2 AGAIN");
        obj.add(2);
        System.out.println("Check if 2 exists -> " +obj.contains(2));
        System.out.println("Remove 2");
        obj.remove(2);;
        System.out.println("Check if 2 exists -> " +obj.contains(2));
    }
}
