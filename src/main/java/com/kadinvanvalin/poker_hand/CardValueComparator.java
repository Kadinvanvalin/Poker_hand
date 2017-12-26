package com.kadinvanvalin.poker_hand;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class CardValueComparator implements Comparator<Card> {


    public int compare(Card c1, Card c2) {
        Map<String, Integer> cardValues = SortValues();
        return cardValues.get(c1.getValue()).compareTo((cardValues.get(c2.getValue())));
    }


    static public Map<String, Integer> SortValues() {
        Map<String, Integer> cardValues = new HashMap<String, Integer>();
        cardValues.put("2", 2);
        cardValues.put("3", 3);
        cardValues.put("4", 4);
        cardValues.put("5", 5);
        cardValues.put("6", 6);
        cardValues.put("7", 7);
        cardValues.put("8", 8);
        cardValues.put("9", 9);
        cardValues.put("T", 10);
        cardValues.put("J", 11);
        cardValues.put("Q", 12);
        cardValues.put("K", 13);
        cardValues.put("A", 14);

        return cardValues;
    }

}
