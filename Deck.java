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
import java.util.Stack;
import java.util.Collections;

public class Deck
{
    private Stack<Card> cards;

    public Deck () { Deck(false); }
    public Deck (boolean sorted){
        buildDeck();
        if (!sorted)
            Collections.shuffle(cards);
    }

    public Card draw () { return cards.pop(); }

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