package com.kadinvanvalin.poker_hand;


public class Player {
    private Hand hand;
    private String name;

    Player(Hand hand, String name) {
        this.hand = hand;
        this.name = name;
    }


    public Hand getHand() {
        return hand;
    }

    public String getName() {
        return name;
    }

}
