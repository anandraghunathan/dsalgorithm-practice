package com.leetcode.linkedlist;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class RevealCardsInIncreasingOrder {

    public static int[] deckRevealedIncreasing(int[] deck) {
        int n = deck.length;
        Deque<Integer> index = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            index.add(i);
        }

        int[] sortedDeck = new int[n];
        Arrays.sort(deck);
        for(int card : deck) {
            sortedDeck[index.pollFirst()] = card;
            if(!index.isEmpty())
                index.add(index.pollFirst());
        }
        return sortedDeck;
    }

    public static void main(String[] args) {
        int[] deck = new int[]{17,13,11,2,3,5,7};
        for(int card : deckRevealedIncreasing(deck))
            System.out.print(card + ",");
    }
}
