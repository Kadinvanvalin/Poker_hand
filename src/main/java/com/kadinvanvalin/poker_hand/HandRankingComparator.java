package com.kadinvanvalin.poker_hand;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class HandRankingComparator implements Comparator<Hand> {

    public int compare(Hand h1, Hand h2) {
        Map<String, Integer> handValues = SortValues();
        if (handValues.get(h1.getHandType()).compareTo((handValues.get(h2.getHandType()))) != 0) {
            return handValues.get(h1.getHandType()).compareTo((handValues.get(h2.getHandType())));
        } else {


            return new CardValueComparator().compare(h1.getHighCard(), h2.getHighCard());
        }
    }

    Map<String, Integer> SortValues() {
        Map<String, Integer> handValues = new HashMap<String, Integer>();
        handValues.put("High Card", 2);
        handValues.put("Pair", 3);
        handValues.put("Two Pair", 4);
        handValues.put("Three of a Kind", 5);
        handValues.put("Straight", 6);
        handValues.put("Flush", 7);
        handValues.put("Full House", 8);
        handValues.put("Four of a Kind", 9);
        handValues.put("Straight Flush", 10);


        return handValues;
    }

}
