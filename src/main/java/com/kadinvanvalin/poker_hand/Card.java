package com.kadinvanvalin.poker_hand;

import java.util.Map;

class Card {
    private String suit;
    private String value;

    Card(String[] value) {
        try {
            this.value = checkValue(value[0]);
            this.suit = suitifiy(value[1]);
        } catch (NotASuitException e) {
            System.err.println("NotASuitException " + e.getMessage());
        } catch (NotAValueException e) {
            System.err.println("NotAValueException" + e.getMessage());
        }
    }

    String getValue() {
        return this.value;
    }
    String getSuit() {
        return this.suit;
    }


    private String checkValue(String val) throws NotAValueException {
        Map<String, Integer> cardValues = CardValueComparator.SortValues();
        if (cardValues.containsKey(val)) {

            return val;
        } else {
            throw new NotAValueException("Not a valid value");
        }
    }


    private String suitifiy(String suit) throws NotASuitException {
        if (suit.equals("H")) {
            return "Hearts";
        } else if (suit.equals("C")) {
            return "Clubs";
        } else if (suit.equals("D")) {
            return "Diamonds";
        } else if (suit.equals("S")) {
            return "Spades";
        } else {
            throw new NotASuitException("Not a valid suit");
        }

    }


}

class NotASuitException extends Exception {
    NotASuitException(String s) {
        super(s);
    }
}

class NotAValueException extends Exception {
    NotAValueException(String s) {
        super(s);
    }
}