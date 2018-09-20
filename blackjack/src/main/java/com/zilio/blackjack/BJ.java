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

import java.util.Stack;

public class BJ
{
    public static final byte MAX_VALUE = 21;
    
    public static boolean game (UI view, Stack<String> lines) {
        Deck d = new Deck();
        Player p = new Player();
        String input = nextInput(view, lines, "asdf");

        while (!input.equals("quit") && input != null){
            System.out.println(input);
            input = nextInput(view, lines, "asd");
        }
        
        return true;
    }

    private static String nextInput(UI view, Stack<String> lines, String message) {
        if (lines == null)
            return view.getString(message);
        if (lines.isEmpty())
            return null;
        return lines.pop();
    }
}