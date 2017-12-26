package com.kadinvanvalin.poker_hand;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HandTypeTest {
    @Test
    public void testHighCard() {
        String[][] myhand = {{"7", "D"}, {"5", "C"}, {"9", "S"}, {"8", "H"}, {"2", "C"}};
        assertEquals("High Card", new Hand(myhand).getHandType());
    }

    @Test
    public void testPair() {
        String[][] myhand = {{"3", "D"}, {"3", "C"}, {"4", "D"}, {"7", "D"}, {"5", "D"}};
        assertEquals("Pair", new Hand(myhand).getHandType());
    }

    @Test
    public void testTwoPair() {
        String[][] myhand = {{"3", "D"}, {"3", "C"}, {"4", "D"}, {"5", "C"}, {"5", "D"}};
        assertEquals("Two Pair", new Hand(myhand).getHandType());
    }

    @Test
    public void testThreeOfAKind() {
        String[][] myhand = {{"3", "D"}, {"9", "C"}, {"5", "S"}, {"5", "C"}, {"5", "D"}};
        assertEquals("Three of a Kind", new Hand(myhand).getHandType());
    }


    @Test
    public void testStraight() {
        String[][] myhand = {{"J", "C"}, {"T", "D"}, {"Q", "D"}, {"K", "D"}, {"9", "D"}};
        assertEquals("Straight", new Hand(myhand).getHandType());
    }

    @Test
    public void testFlush() {
        String[][] myhand = {{"7", "D"}, {"5", "D"}, {"9", "D"}, {"8", "D"}, {"2", "D"}};
        assertEquals("Flush", new Hand(myhand).getHandType());
    }

    @Test
    public void testFullHouse() {
        String[][] myhand = {{"3", "D"}, {"3", "C"}, {"5", "S"}, {"5", "C"}, {"5", "D"}};
        assertEquals("Full House", new Hand(myhand).getHandType());
    }

    @Test
    public void testFourOfAKind() {
        String[][] myhand = {{"5", "D"}, {"5", "C"}, {"5", "S"}, {"5", "H"}, {"2", "C"}};
        assertEquals("Four of a Kind", new Hand(myhand).getHandType());
    }

    @Test
    public void testStraightflush() {
        String[][] myhand = {{"3", "D"}, {"6", "D"}, {"4", "D"}, {"7", "D"}, {"5", "D"}};
        assertEquals("Straight Flush", new Hand(myhand).getHandType());
    }


}
