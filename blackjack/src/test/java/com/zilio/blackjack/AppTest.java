package com.zilio.blackjack;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    @Test
    public void CardDeckObjectTests()
    {
        //Test card and deck creation and toString override
        Deck d = new Deck(true);
        String validSortedDeck = "SA, S2, S3, S4, S5, S6, S7, S8, S9, S10, SJ, SQ, SK, HA, H2, H3, H4, H5, H6, H7, H8, H9, H10, HJ, HQ, HK, DA, D2, D3, D4, D5, D6, D7, D8, D9, D10, DJ, DQ, DK, CA, C2, C3, C4, C5, C6, C7, C8, C9, C10, CJ, CQ, CK";

        assertTrue( d.toString() != validSortedDeck );

        //Deck Shuffles
        Deck d2 = new Deck(true);
        d.shuffle();
        assertTrue(!d.toString().equals(d2.toString()));

        //Deck Size
        byte c;
        for (c = 0; c < 53; c++)//can I pull more cards than exist in the deck?
            if (d.draw() == null)
                break;
        assertTrue(c == 52);
    }

    @Test
    public void PlayerObjectTests()
    {
        //Test that the player object takes cards
        Deck d = new Deck(true);
        Player p1 = new Player();
        
        p1.hit(d.draw());
        assertTrue(p1.getHand().equals("[CK]"));
        assertTrue(p1.getValue() == 10);
        assertTrue(!p1.checkBust());
        
        p1.hit(d.draw());
        p1.hit(d.draw());
        p1.hit(d.draw());
        assertTrue(p1.getHand().equals("[CK, CQ, CJ, C10]"));
        assertTrue(p1.getValue() == 40);
        assertTrue(p1.checkBust());
        
        Card[] c = new Card[13];
        p1.start(c);
        assertTrue(p1.getHand().equals("[]"));

        for (byte i = 0; i < 13; i++)
            c[i] = d.draw();
        p1.start(c);
        assertTrue(p1.getHand().equals("[C9, C8, C7, C6, C5, C4, C3, C2, CA, DK, DQ, DJ]"));
        assertTrue(p1.getValue() == 75);
        assertTrue(p1.checkBust());

        c = new Card[13];
        c[0] = new Card("A", 'S');
        c[1] = new Card("A", 'D');
        c[2] = new Card("A", 'H');
        p1.start(c);
        assertTrue(p1.getHand().equals("[SA, DA, HA]"));
        assertTrue(p1.getValue() == 13);
        assertTrue(!p1.checkBust());
    }
}
