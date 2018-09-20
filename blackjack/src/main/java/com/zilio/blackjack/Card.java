/* Carleton University
 * Fall 2018
 * COMP 3004A
 * Jean-Pierre Coriveau
 * 
 * David N. Zilio
 * 10/Sep/2018
 * 
 * A Class for standard playing Cards
 */
package com.zilio.blackjack;

public class Card
{
    public static char[] Suits = {'S', 'H', 'D', 'C'};
    public static String[] Faces = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
    
    private char s; //suit
    private String f;//face

    public Byte getValue() {
        if (f == "J" || f == "Q" || f == "K")
            return 10;
        if (f == "A")
            return 11;
        return Byte.parseByte(f);
    }
    
    public Card (String face, char suit) {
        s = suit;
        f = face;
    }

    @Override
    public String toString() { return s + f; }
}