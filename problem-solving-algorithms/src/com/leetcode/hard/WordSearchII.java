package com.leetcode.hard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *  Time  : O(m * n * WL * 4^WL) where m * n is the size of the board, and WL is the average length of the words in the list.
 *          Assuming we cannot find the word until the bottom right cell, that becomes m * n. 4^WL is the number of
 *          recursive calls for each start cell. This is because of the recursion. "4" means four recursive calls.
 *          And because we revisit lots of visited cell (which is necessary), it grows exponentially. In each recursive
 *          call, we do search word and startwith in trie which costs O(WL). Putting all these together, we get this complexity.
 *
 *          Another explanation for time complexity:
 *              With the trie, we don't care about iterating each word, but we rather just loop through each element
 *              in the matrix and then for each element we try to traverse the trie when ever there is a match.
 *              For each path there are 4 ways, and each of the 4 ways taken is terminated once we reach the WL,
 *              hence 4^wl. The worst case is every element in the matrix allows the traversal of the trie hence
 *              m * n * 4^WL
 *
 *  Space :  O(n * m) due to the extra matrix requirement for the visited cells (visited array).
 */
public class WordSearchII {
    /**
     Those are 2 different concepts. DFS doesn't mean backtracking, but backtracking
     often comes from DFS.

     Backtracking is only required if you need to reset a previous state if you prior
     paths modified it and you don't want that to propagate out of its own call stack /DFS
     path.

     You can avoid the backtracking here by building an entirely new board every time
     you recursively call down the path instead of re-using the same board, but it's
     obviously less efficient that way, thus we use the same board everywhere and
     backtrack by resetting "visited[x][y] = false", that's the only thing which
     makes it "backtracking".
     */
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isCompleteWord;
    }
    class Trie {
        TrieNode root;
        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode current = root;
            for(int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if(current.children[c - 'a'] == null)
                    current.children[c - 'a'] = new TrieNode();
                current = current.children[c - 'a'];
            }
            current.isCompleteWord = true;
        }

        public boolean search(String word) {
            TrieNode current = searchPrefixOrWord(word);
            return current != null && current.isCompleteWord;
        }

        public boolean startsWith(String word) {
            TrieNode current = searchPrefixOrWord(word);
            return current != null;
        }

        public TrieNode searchPrefixOrWord(String word) {
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
    }
    // Hashset to store the words found corresponding to the words in the dictionary
    Set<String> res = new HashSet();

    // Create a Trie instance
    Trie trie = new Trie();

    public List<String> findWords(char[][] board, String[] words) {
        // First we will add the words array into the Trie
        for(String word : words)
            trie.insert(word);

        // Next we will do a DFS of the matrix to see if the matrix has a combination inside the Trie
        int m = board.length;
        int n = board[0].length;

        // Visited array to denote if the char in the current cell is already visited
        boolean[][] visited = new boolean[m][n];

        // Iterate through the matrix to perform a DFS
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                dfs(board, i, j, visited, "", trie);
            }
        }
        return new ArrayList<>(res);
    }

    public void dfs(char[][] board, int i, int j, boolean[][] visited, String str, Trie trie) {
        // First check if the current i and j are within bounds, if not just return
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length)
            return;

        // If the visited array for the current cell has true in it, it means this cell is already visited, so return
        if (visited[i][j])
            return;

        // If we have come this far, it means we have found a valid candidate that we have to explore
        str += board[i][j];

        // First call the Trie implementation's startsWith() to check if the current prefix (str) is present in the Trie. If the prefix is not present then return
        if (!trie.startsWith(str))
            return;

        // Call the search() of the Trie's implementation to check if the current word (str) is a complete word in the Trie. If yes, add it to the HashSet
        if (trie.search(str))
            res.add(str);

        // If we have reached this far, which means the current cell is visited and either added as an word we found in the dictionary, or a partial match is found as a prefix in the Trie, so we make the visited value for the current cell [i][j] to true
        visited[i][j] = true;

        // Then continue to find other possibilities of the dictionary present if present in the Trie node for the combination of characters present in the given char array (board)
        dfs(board, i, j + 1, visited, str, trie);
        dfs(board, i, j - 1, visited, str, trie);
        dfs(board, i + 1, j, visited, str, trie);
        dfs(board, i - 1, j, visited, str, trie);

        /*
            Finally we have to make the visited[i][j] for the current cell to false so that
            other possibilties when DFS backtracks and tries out other combinations is not
            affected by the current path computed for the current DFS

            Think about the case { {a, b, c}, {a, e, d}, {a, f, g}} , "eaabcdgfa"
            first, we find 'e' locates at board[1][1], then we try to find 'a' at
            board[0][1] , and then another 'a', we have two choices (board[0][0] and
            board[0][2]) at this step (only one of them board[0][0] will lead to 'eaabcdgfa').
            If we try the wrong way board[0][2] at this step, try and mark visited[0][2] to
            'true' in 'visited' without setting it back to 'false'. Then when we try the right
            way later, it'll not return true because at the final step of the path
            (e -> a -> a -> b -> c -> d - f - > ???) the visited[0][2] is true...

            In one word, the purpose is to make it not affect other path.
        */
        visited[i][j] = false;
    }

    public static void main(String[] args) {
        WordSearchII obj = new WordSearchII();
        char[][] board = new char[][]{
                {'o','a','a','n'},
                {'e','t','a','e'},
                {'i','h','k','r'},
                {'i','f','l','v'}
        };
        List<String> searchedWords = obj.findWords(board, new String[]{"oath","pea","eat","rain"});
        System.out.print("[ ");
        int count = searchedWords.size();
        for(String searchedWord : searchedWords) {
            System.out.print("\"" + searchedWord + "\"");
            System.out.print(count > 1 ? ", " : "");
            count--;
        }
        System.out.print(" ]");
    }
}
