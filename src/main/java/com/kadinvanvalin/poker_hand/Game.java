package com.kadinvanvalin.poker_hand;

import java.util.*;

public class Game {
    private Player player1;
    private Player player2;


    Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    Game(String string) {
        String[] splitString = string.split(" ");

        String[] temp = Arrays.copyOfRange(splitString, 1, 6);
        String[] temp2 = Arrays.copyOfRange(splitString, 7, 12);
        String[][] hand1 = {{"", ""}, {"", ""}, {"", ""}, {"", ""}, {"", ""}};
        String[][] hand2 = {{"", ""}, {"", ""}, {"", ""}, {"", ""}, {"", ""}};

        for (int i = 0; i < 5; i++) {
            hand1[i] = temp[i].split("");
        }


        for (int i = 0; i < 5; i++) {
            hand2[i] = temp2[i].split("");
        }


        Hand player1hand = new Hand(hand1);
        Hand player2hand = new Hand(hand2);

        this.player1 = new Player(player1hand, splitString[0]);
        this.player2 = new Player(player2hand, splitString[6]);
    }


    public String render() {
        int compareInt = new HandRankingComparator().compare(player1.getHand(), player2.getHand());
        String winConditions;
        Player winner;
        if (compareInt > 0) {
            winner = player1;
        } else if (compareInt < 0) {
            winner = player2;
        } else {
            return "Tie.";
        }
        if (winner.getHand().getHandType().equals("Straight") || winner.getHand().getHandType().equals("Straight Flush")) {
            winConditions = multicardRender(winner, " through ");
        } else if (winner.getHand().getHandType().equals("Flush")) {
            winConditions = winner.getHand().getHighCard().getSuit();
        } else if (winner.getHand().getHandType().equals("Full House")) {
            winConditions = multicardRender(winner, " over ");
        } else if (winner.getHand().getHandType().equals("Two Pair")) {
            winConditions = multicardRender(winner, " and ");
        } else {
            String valueOfHighCard = winner.getHand().getHighCard().getValue();
            String prettyValue = StringValues().get(valueOfHighCard);

            winConditions = prettyValue;
        }

        return winner.getName() + " wins. - with " + winner.getHand().getHandType() + " : " + winConditions;
    }

    private String multicardRender(Player winner, String type) {
        String valueOfHighCard = winner.getHand().getHighCard().getValue();
        String prettyValue = StringValues().get(valueOfHighCard);

        String valueOf2ndHighCard = winner.getHand().getSecondRanked().getValue();
        String prettyValue2nd = StringValues().get(valueOf2ndHighCard);

        return prettyValue + type + prettyValue2nd;

    }

    private Map<String, String> StringValues() {
        Map<String, String> cardValues = new HashMap<String, String>();
        cardValues.put("2", "Two");
        cardValues.put("3", "Three");
        cardValues.put("4", "Four");
        cardValues.put("5", "Five");
        cardValues.put("6", "Six");
        cardValues.put("7", "Seven");
        cardValues.put("8", "Eight");
        cardValues.put("9", "Nine");
        cardValues.put("T", "Ten");
        cardValues.put("J", "Jack");
        cardValues.put("Q", "Queen");
        cardValues.put("K", "King");
        cardValues.put("A", "Ace");

        return cardValues;
    }


}
