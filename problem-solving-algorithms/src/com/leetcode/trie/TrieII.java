package com.leetcode.trie;

import java.util.HashMap;
import java.util.Map;

/**
 * With Delete word functionality. Significantly slower runtime than the array approach.
 *
 * Runtime: 87 ms, faster than 24.74% of Java online submissions for Implement Trie (Prefix Tree) - HashMap
 *
 *                                      vs
 *
 * Runtime: 73 ms, faster than 95.01% of Java online submissions for Implement Trie (Prefix Tree) - Arrays[26]
 */



/**
 * We declare the TrieNode class that requires two properties
 *  1. An HashMap of children (that will hold each character's child). The character can be any character including
 *  unicode characters as the map here will support all character sets unlike the Trie implementation with arrays
 *
 *  2. A flag that which specifies whether the current node corresponds to the end of the key, or is just a key prefix.
 *     If the node is the end of the key, then it will have this property set to true. Otherwise, false.
 */
class TrieNodeII {
    Map<Character, TrieNodeII> children = new HashMap<>();
    boolean isCompleteWord;
}

class TrieII {

    TrieNodeII root;
    /** Initialize your data structure here. */
    public TrieII() {
        root = new TrieNodeII();
    }

    /**
     *
     * Inserts a word into the trie.
     *
     *  Complexity Analysis
     *
     *    Time complexity : O(m), where m is the key length.
     *
     *    In each iteration of the algorithm, we either examine or create a node in the trie till we reach the end
     *    of the key. This takes only m operations.
     *
     *    Space complexity : O(m)
     *
     *    In the worst case newly inserted key doesn't share a prefix with the the keys already inserted in the trie.
     *    We have to add mm new nodes, which takes us O(m) space.
     *
     */
    public void insert(String word) {
        TrieNodeII current = root;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(current.children.get(c) == null) {
                current.children.put(c, new TrieNodeII());
            }
            current = current.children.get(c);
        }
        current.isCompleteWord = true;
    }

    /**
     *
     * Returns if the word is in the trie.
     *
     * Complexity Analysis
     *
     *    Time complexity : O(m)
     *
     *    In each step of the algorithm we search for the next key character.
     *    In the worst case the algorithm performs m operations.
     *
     *    Space complexity : O(1)
     *
     */
    public boolean search(String word) {
        TrieNodeII current = searchWordOrPrefix(word);
        return current != null && current.isCompleteWord;
    }

    /**
     *
     * Returns if there is any word in the trie that starts with the given prefix.
     *
     * Complexity Analysis - Same as above search method implementation
     *
     *    Time complexity : O(m)
     *
     *    Space complexity : O(1)
     */
    public boolean startsWith(String prefix) {
        TrieNodeII current = searchWordOrPrefix(prefix);
        return current != null;
    }

    /**
     *
     * Common implementation for both search word and search prefix cause the two implementations vary little
     *
     */
    private TrieNodeII searchWordOrPrefix(String word) {
        TrieNodeII current = root;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            TrieNodeII node = current.children.get(c);
            if(node == null)
                return null;
            current = node;
        }
        return current;
    }

    /**
     * Delete word from trie.
     */
    public void delete(String word) {
        delete(root, word, 0);
    }

    /**
     * Returns true if parent should delete the mapping
     */
    private boolean delete(TrieNodeII current, String word, int index) {
        if (index == word.length()) {
            //when end of word is reached only delete if currrent.isCompleteWord is true.
            if (!current.isCompleteWord) {
                return false;
            }
            current.isCompleteWord = false;
            //if current has no other mapping then return true
            return current.children.size() == 0;
        }
        char ch = word.charAt(index);
        TrieNodeII node = current.children.get(ch);
        if (node == null) {
            return false;
        }
        boolean shouldDeleteCurrentNode = delete(node, word, index + 1);

        //if true is returned then delete the mapping of character and TrieNode reference from map.
        if (shouldDeleteCurrentNode) {
            current.children.remove(ch);
            //return true if no mappings are left in the map.
            return current.children.size() == 0;
        }
        return false;
    }

    public static void main(String[] args) {
        TrieII trie = new TrieII();
        // Insertion
        trie.insert("apple");
        System.out.println("Inserted the word \"apple\"");

        // Search for the inserted "apple" word, followed by the "app" word search
        System.out.println("Search for the word \"apple\" - " +trie.search("apple"));
        System.out.println("Search for the word \"app\" - " +trie.search("app"));

        // Startwith search for "app"
        System.out.println("Search for the prefix \"app\" - " +trie.startsWith("app"));

        // Insert "app", it wont be inserted cause its already there, so this will turn on the isCompleteWord to true
        // for the character followed by the second 'p', i.e 'l'
        trie.insert("app");
        System.out.println("Inserted the word \"app\"");

        // Search for app, after the property change
        System.out.println("Search for the word \"app\" - " +trie.search("app"));

        // Try to delete "app". We can't delete this cause it has other dependencies. So the isCompleteWord flag
        // will be turned from true (from the previous step - insert "app") to false in this step
        trie.delete("app");
        System.out.println("Won't be deleted cause the word \"app\" is used by other words. Just changes the flag to false");

        // Insert a new word, "car"
        trie.insert("car");
        System.out.println("Inserted the word \"car\"");

        // Search for "car"
        System.out.println("Search for the word \"car\" - " +trie.search("car"));

        // Delete "car"
        trie.delete("car");
        System.out.println("Deleted the word \"car\"");

        // Search after deleting "car"
        System.out.println("Search for the word \"car\" - " +trie.search("car"));
    }
}
