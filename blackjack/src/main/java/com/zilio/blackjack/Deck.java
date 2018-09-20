/* Carleton University
 * Fall 2018
 * COMP 3004A
 * Jean-Pierre Coriveau
 * 
 * David N. Zilio
 * 10/Sep/2018
 * 
 * A collection class to manage cards as a deck.
 */
package com.zilio.blackjack;

import java.util.Stack;
import java.util.Collections;

public class Deck
{
    private Stack<Card> cards;

    public Deck () { 
        buildDeck();
        Collections.shuffle(cards);
     }
    public Deck (boolean sorted){
        buildDeck();
        if (!sorted)
            Collections.shuffle(cards);
    }

    private void buildDeck(){
        cards = new Stack<Card>();
        for (char s : Card.Suits)
            for (String f : Card.Faces)
                cards.push(new Card(f, s));
    }
    public Card draw () { 
        if (cards.isEmpty())
            return null;
        return cards.pop();
    }
    public void shuffle() { Collections.shuffle(cards); }

    @Override
    public String toString() {
        String s = "";
        for (Card c : cards)
            s += c.toString() + ", ";
        if (s.charAt(s.length()-2) == ',')
        s = s.substring(0, s.length()-2);
        return s;
    }
}