package com.kadinvanvalin.poker_hand;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameRenderTest {
    @Test
    public void testKadinWonWithHighCardAces() {
        String[][] steveHand = {{"4", "D"}, {"9", "C"}, {"3", "S"}, {"T", "H"}, {"6", "C"}};
        String[][] kadinHand = {{"A", "D"}, {"T", "C"}, {"4", "S"}, {"5", "H"}, {"2", "C"}};

        Player player1 = new Player(new Hand(steveHand), "steve");
        Player player2 = new Player(new Hand(kadinHand), "Kadin");
        Game game = new Game(player1, player2);
        assertEquals("Kadin wins. - with High Card : Ace", game.render());

    }

    @Test
    public void testKadinWonWithAPairOfAces() {
        String[][] steveHand = {{"4", "D"}, {"9", "C"}, {"4", "S"}, {"T", "H"}, {"6", "C"}};
        String[][] kadinHand = {{"A", "D"}, {"A", "C"}, {"4", "S"}, {"5", "H"}, {"2", "C"}};

        Player player1 = new Player(new Hand(steveHand), "steve");
        Player player2 = new Player(new Hand(kadinHand), "Kadin");
        Game game = new Game(player1, player2);
        assertEquals("Kadin wins. - with Pair : Ace", game.render());

    }

    @Test
    public void testSteveWonWithTwoPairFourAndTwos() {
        String[][] steveHand = {{"4", "D"}, {"4", "C"}, {"2", "S"}, {"2", "H"}, {"6", "C"}};
        String[][] kadinHand = {{"A", "D"}, {"A", "C"}, {"4", "S"}, {"5", "H"}, {"2", "C"}};

        Player player1 = new Player(new Hand(steveHand), "Steve");
        Player player2 = new Player(new Hand(kadinHand), "Kadin");
        Game game = new Game(player1, player2);
        assertEquals("Steve wins. - with Two Pair : Two and Four", game.render());

    }

    @Test
    public void testKadinWonWithThreeOfAKind() {
        String[][] steveHand = {{"A", "D"}, {"A", "C"}, {"4", "S"}, {"T", "H"}, {"6", "C"}};
        String[][] kadinHand = {{"5", "S"}, {"A", "H"}, {"5", "C"}, {"5", "H"}, {"2", "H"}};

        Player player1 = new Player(new Hand(steveHand), "steve");
        Player player2 = new Player(new Hand(kadinHand), "Kadin");
        Game game = new Game(player1, player2);
        assertEquals("Kadin wins. - with Three of a Kind : Five", game.render());

    }

    @Test
    public void testSteveWinsWithStraight() {
        String[][] steveHand = {{"A", "D"}, {"K", "C"}, {"T", "S"}, {"Q", "H"}, {"J", "C"}};
        String[][] kadinHand = {{"6", "C"}, {"A", "H"}, {"4", "H"}, {"5", "H"}, {"2", "H"}};

        Player player1 = new Player(new Hand(steveHand), "Steve");
        Player player2 = new Player(new Hand(kadinHand), "Kadin");
        Game game = new Game(player1, player2);
        assertEquals("Steve wins. - with Straight : Ace through Ten", game.render());

    }


    @Test
    public void testKadinWonWithAFlushOfHearts() {
        String[][] steveHand = {{"A", "D"}, {"A", "C"}, {"4", "S"}, {"T", "H"}, {"6", "C"}};
        String[][] kadinHand = {{"6", "H"}, {"A", "H"}, {"4", "H"}, {"5", "H"}, {"2", "H"}};

        Player player1 = new Player(new Hand(steveHand), "steve");
        Player player2 = new Player(new Hand(kadinHand), "Kadin");
        Game game = new Game(player1, player2);
        assertEquals("Kadin wins. - with Flush : Hearts", game.render());

    }

    @Test
    public void testSteveWinsWithFullHouse() {
        String[][] steveHand = {{"A", "D"}, {"A", "C"}, {"A", "S"}, {"6", "H"}, {"6", "C"}};
        String[][] kadinHand = {{"6", "H"}, {"A", "H"}, {"4", "H"}, {"5", "H"}, {"2", "H"}};

        Player player1 = new Player(new Hand(steveHand), "Steve");
        Player player2 = new Player(new Hand(kadinHand), "Kadin");
        Game game = new Game(player1, player2);
        assertEquals("Steve wins. - with Full House : Ace over Six", game.render());

    }

    @Test
    public void testKadinWinsWithFourOfAKindTwos() {
        String[][] steveHand = {{"A", "D"}, {"A", "C"}, {"A", "S"}, {"6", "H"}, {"6", "C"}};
        String[][] kadinHand = {{"2", "H"}, {"2", "C"}, {"2", "S"}, {"2", "D"}, {"3", "H"}};

        Player player1 = new Player(new Hand(steveHand), "Steve");
        Player player2 = new Player(new Hand(kadinHand), "Kadin");
        Game game = new Game(player1, player2);
        assertEquals("Kadin wins. - with Four of a Kind : Two", game.render());

    }

    @Test
    public void testSteveWinsWithStraightFlush() {
        String[][] steveHand = {{"T", "D"}, {"8", "D"}, {"9", "D"}, {"7", "D"}, {"6", "D"}};
        String[][] kadinHand = {{"2", "H"}, {"2", "C"}, {"2", "S"}, {"2", "D"}, {"3", "H"}};

        Player player1 = new Player(new Hand(steveHand), "Steve");
        Player player2 = new Player(new Hand(kadinHand), "Kadin");
        Game game = new Game(player1, player2);
        assertEquals("Steve wins. - with Straight Flush : Ten through Six", game.render());

    }


}
