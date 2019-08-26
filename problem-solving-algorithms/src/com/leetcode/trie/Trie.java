package com.leetcode.trie;

/**
 * https://leetcode.com/problems/implement-trie-prefix-tree/
 *
 * https://leetcode.com/problems/implement-trie-prefix-tree/solution/
 * https://leetcode.com/problems/implement-trie-prefix-tree/discuss/58832/AC-JAVA-solution-simple-using-single-array
 *
 * We declare the TrieNode class that requires two properties
 *  1. An array of children (that will hold each character's child). Since the question says the characters will
 *      be a-z, we can go with the 26 character set
 *
 *  2. A flag that which specifies whether the current node corresponds to the end of the key, or is just a key prefix.
 *     If the node is the end of the key, then it will have this property set to true. Otherwise, false.
 */

public class Trie {

    TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
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
        TrieNode current = root;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(current.children[c - 'a'] == null) {
                current.children[c - 'a'] = new TrieNode();
            }
            current = current.children[c - 'a'];
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
        TrieNode current = searchWordOrPrefix(word);
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
        TrieNode current = searchWordOrPrefix(prefix);
        return current != null;
    }

    /**
     *
     * Common implementation for both search word and search prefix cause the two implementations vary little
     *
     */
    private TrieNode searchWordOrPrefix(String word) {
        TrieNode current = root;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            TrieNode node = current.children[c - 'a'];
            if(node == null)
                return null;
            current = node;
        }
        return current;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
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

        // Insert a new word, "car"
        trie.insert("car");
        System.out.println("Inserted the word \"car\"");

        // Search for "car"
        System.out.println("Search for the word \"car\" - " +trie.search("car"));
    }
}
