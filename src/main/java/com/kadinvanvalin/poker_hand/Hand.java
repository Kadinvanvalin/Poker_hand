package com.kadinvanvalin.poker_hand;

import java.util.*;

class Hand {
    private ArrayList<Card> cards = new ArrayList(5);
    private String handType;
    private Card highCard;
    private Card secondRanked;

    Hand(String[][] cards) {
        for (String[] card : cards) {
            this.cards.add(new Card(card));
        }

        this.handType = setHandType();

    }

    Card getHighCard() {
        return highCard;
    }

    Card getSecondRanked() {
        return secondRanked;
    }
    String getHandType() {
        return this.handType;
    }


    private ArrayList<Map<String, Integer>> countCards() {
        Map<String, Integer> cardValues = new HashMap<String, Integer>();
        Map<String, Integer> cardSuits = new HashMap<String, Integer>();
        ArrayList<Map<String, Integer>> returnValue = new ArrayList();

        for (Card card : cards) {
            if (cardValues.containsKey(card.getValue())) {
                cardValues.put(card.getValue(), cardValues.get(card.getValue()) + 1);
            } else {
                cardValues.put(card.getValue(), 1);
            }

            if (cardSuits.containsKey(card.getSuit())) {
                cardSuits.put(card.getSuit(), cardSuits.get(card.getSuit()) + 1);
            } else {
                cardSuits.put(card.getSuit(), 1);
            }

        }
        returnValue.add(0, cardValues);
        returnValue.add(1, cardSuits);
        return returnValue;
    }

    private Card assignCardValue(Map<String, Integer> cardValues, int target) {
        for (Map.Entry<String, Integer> entry : cardValues.entrySet()) {

            if (entry.getValue() == target) {
                for (Card card : this.cards) {
                    if (card.getValue().equals(entry.getKey())) {
                        return card;
                    }

                }
            }

        }

        String[] error = {"0", "0"};
        return new Card(error);
    }

    private void assignTwoPair(Map<String, Integer> cardValues) {

        for (Map.Entry<String, Integer> entry : cardValues.entrySet()) {

            if (entry.getValue() == 2) {
                for (Card card : this.cards) {
                    if (card.getValue().equals(entry.getKey())) {
                        if (this.highCard == null) {
                            this.highCard = card;
                        } else if (this.highCard == card) {
                            continue;
                        } else {
                            this.secondRanked = card;
                        }

                    }

                }
            }

        }


    }

    private String setHandType() {
        Collections.sort(this.cards, new CardValueComparator());
        ArrayList<Map<String, Integer>> countedCards = countCards();

        Map<String, Integer> cardValues = countedCards.get(0);
        Map<String, Integer> cardSuits = countedCards.get(1);



        if (isAStraight() && cardSuits.containsValue(5)) {
            this.highCard = cards.get(4);
            this.secondRanked = cards.get(0);
            return "Straight Flush";
        } else if (cardValues.containsValue(4)) {
            this.highCard = assignCardValue(cardValues, 4);
            return "Four of a Kind";
        } else if (cardValues.containsValue(3) && cardValues.containsValue(2)) {

            this.highCard = assignCardValue(cardValues, 3);
            this.secondRanked = assignCardValue(cardValues, 2);
            return "Full House";
        } else if (cardSuits.containsValue(5)) {
            this.highCard = cards.get(4);
            return "Flush";
        } else if (isAStraight()) {
            this.highCard = cards.get(4);
            this.secondRanked = cards.get(0);
            return "Straight";
        } else if (cardValues.containsValue(3)) {
            this.highCard = assignCardValue(cardValues, 3);
            return "Three of a Kind";
        } else if (cardValues.containsValue(2) && cardValues.size() == 3) {
            assignTwoPair(cardValues);
            return "Two Pair";
        } else if (cardValues.containsValue(2)) {
            this.highCard = assignCardValue(cardValues, 2);
            return "Pair";
        } else {
            this.highCard = this.cards.get(4);
            return "High Card";
        }
    }



    private Boolean isAStraight() {
        Map<String, Integer> cardValues = new CardValueComparator().SortValues();

        for (int i = 0; i < 4; i++) {
            String c1 = cards.get(i).getValue();
            String c2 = cards.get(i + 1).getValue();

            Integer cI1 = cardValues.get(c1);
            Integer cI2 = cardValues.get(c2) - 1;

            if (cI1 != cI2 && (cI1 != 5 && cI2 != 13)) {
                return false;
            }
        }
        return true;
    }





}
