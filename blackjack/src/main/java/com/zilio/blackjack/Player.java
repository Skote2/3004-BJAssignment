/* Carleton University
 * Fall 2018
 * COMP 3004A
 * Jean-Pierre Coriveau
 * 
 * David N. Zilio
 * 10/Sep/2018
 * 
 * BlackJack v0.0
 * The associated "BJ Requirements.pdf" file provides the requirements for this project.
 * This is the main (class.
 */
package com.zilio.blackjack;


public class Player
{
    Card[] hand;
    byte handSize;

    public Player() {
        hand = new Card[12];
        handSize = 0;
    }
    public Player(Card[] cards){
        hand = new Card[12];
        handSize = 0;
        start(cards);
    }

    public boolean checkBust() {
        if (getValue() > BJ.MAX_VALUE)
            return true;
        return false;
    }
    public String getHand() { 
        String s = "[";
        for (int i = 0; i < handSize; i++) {
            s += hand[i].toString();
            if (i != handSize-1)
                s += ", ";
        }
        return s + ']';
    }
    public byte getValue() {
        byte val = 0;
        byte aces = 0;
        for (int i = 0; i < handSize; i++)
            if (hand[i].getValue() == 11)
                aces++;
            else
                val += hand[i].getValue();
        for (byte i = 0; i < aces; i++)
            if (val + 11 > BJ.MAX_VALUE)
                val += 1;
            else
                val += 11;

        return val;
    }

    public boolean hit(Card c) {
        if (handSize < 12)
            hand[handSize++] = c;
        return checkBust();
    }
    public void split() {}
    public void start(Card[] cards) {
        handSize = 0;
        for (byte i = 0; i < cards.length; i++)
            if (cards[i] != null )
                hit(cards[i]);
    }
}