package com.kadinvanvalin.poker_hand;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameInput {
    @Test
    public void testKadinWonWithHighCardAces() {

        Game game = new Game("Kadin AD TC 4S 5H 2C Steve 4D 9C 3S TH 6C");
        assertEquals("Kadin wins. - with High Card : Ace", game.render());

    }

    @Test
    public void testKadinWonWithAPairOfAces() {

        Game game = new Game("Kadin AD AC 4S 5H 2C Steve 4D 9C 3S TH 6C");
        assertEquals("Kadin wins. - with Pair : Ace", game.render());

    }

    @Test
    public void testSteveWonWithTwoPairFourAndTwos() {

        Game game = new Game("Kadin AD AC 4S 5H 2C Steve 4D 4C 2S 2H 6C");
        assertEquals("Steve wins. - with Two Pair : Two and Four", game.render());

    }

    @Test
    public void testKadinWonWithThreeOfAKind() {

        Game game = new Game("Steve AD AC 4S TH 6C Kadin 5S AH 5C 5H 2H");
        assertEquals("Kadin wins. - with Three of a Kind : Five", game.render());

    }

    @Test
    public void testSteveWinsWithStraight() {

        Game game = new Game("Kadin 6C AH 4H 5H 2H Steve AD KC TS QH JC");
        assertEquals("Steve wins. - with Straight : Ace through Ten", game.render());

    }

    @Test
    public void testKadinWonWithAFlushOfHearts() {

        Game game = new Game("Steve AD AC 4S TH 6C Kadin 6H AH 4H 5H 2H");
        assertEquals("Kadin wins. - with Flush : Hearts", game.render());

    }

    @Test
    public void testSteveWinsWithFullHouse() {


        Game game = new Game("Steve AD AC AS 6H 6C Kadin 6H AH 4H 5H 2H");
        assertEquals("Steve wins. - with Full House : Ace over Six", game.render());

    }

    @Test
    public void testKadinWinsWithFourOfAKindTwos() {


        Game game = new Game("Steve AD AC AS 6H 6C Kadin 2H 2C 2S 2D 3H");
        assertEquals("Kadin wins. - with Four of a Kind : Two", game.render());

    }

    @Test
    public void testSteveWinsWithStraightFlush() {


        Game game = new Game("Steve TD 8D 9D 7D 6D Kadin 2H 2C 2S 2D 3H");
        assertEquals("Steve wins. - with Straight Flush : Ten through Six", game.render());

    }

    @Test
    public void testTrueTie() {


        Game game = new Game("Black 2H 3D 5S 9C KD White 2D 3H 5C 9S KH");
        assertEquals("Tie.", game.render());

    }

    @Test
    public void testKadinWonWithAPairOfAcesTieBreaker() {

        Game game = new Game("Kadin AD AC 4S 5H 2C Steve TD 9C 3S TH 6C");
        assertEquals("Kadin wins. - with Pair : Ace", game.render());

    }

    @Test
    public void testSteveWonWithTwoPairFourAndTwosTieBreaker() {

        Game game = new Game("Kadin TD TC 9S 9H 2C Steve AD AC 2S 2H 6C");
        assertEquals("Steve wins. - with Two Pair : Ace and Two", game.render());

    }

    @Test
    public void testKadinWonWithThreeOfAKindTieBreaker() {

        Game game = new Game("Steve 4D 4C 4S TH 6C Kadin 5S AH 5C 5H 2H");
        assertEquals("Kadin wins. - with Three of a Kind : Five", game.render());

    }

    @Test
    public void testSteveWinsWithStraightTieBreaker() {

        Game game = new Game("Kadin 2C 3H 4H 5H 6H Steve AD KC TS QH JC");
        assertEquals("Steve wins. - with Straight : Ace through Ten", game.render());

    }

    @Test
    public void testKadinWonWithAFlushOfHeartsTieBreaker() {

        Game game = new Game("Steve TD 5D 4D 9D 6D Kadin 6H AH 4H 5H 2H");
        assertEquals("Kadin wins. - with Flush : Hearts", game.render());

    }

    @Test
    public void testSteveWinsWithFullHouseTieBreaker() {


        Game game = new Game("Steve AD AC AS 6H 6C Kadin KH KD KC 5H 2H");
        assertEquals("Steve wins. - with Full House : Ace over Six", game.render());

    }

    @Test
    public void testKadinWinsWithFourOfAKindTwosTieBreaker() {


        Game game = new Game("Steve AD 2C 2S 2H 2C Kadin 8H 3C 3S 3D 3H");
        assertEquals("Kadin wins. - with Four of a Kind : Three", game.render());

    }

    @Test
    public void testSteveWinsWithStraightFlushTieBreaker() {


        Game game = new Game("Steve TD 8D 9D 7D 6D Kadin 2C 3C 4C 5C 6C");
        assertEquals("Steve wins. - with Straight Flush : Ten through Six", game.render());

    }

    @Test
    public void testSteveWinsWithLowStraight() {


        Game game = new Game("Steve 2D 4D 3D AD 5C Kadin 2C 6D 4C 5C 6C");
        assertEquals("Steve wins. - with Straight : Ace through Two", game.render());

    }

    @Test
    public void testSteveWinsWithLowStraightFlush() {


        Game game = new Game("Steve 2D 4D 3D AD 5D Kadin 2C 6D 4C 5C 6C");
        assertEquals("Steve wins. - with Straight Flush : Ace through Two", game.render());

    }


}
