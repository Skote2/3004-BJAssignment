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
    
    private Deck            deck;
    private Player          player;
    private Player          dealer;
    private UI              view;
    private Stack<String>   lines;
    private boolean         show;

    public BJ (UI v, Stack<String> fileText) {
        deck    = new Deck();
        Card[] c= {deck.draw(), deck.draw()};
        player  = new Player(c);
        c[0]    = deck.draw();
        c[1]    = deck.draw();
        dealer  = new Player(c);
        view    = v;
        show    = false;
    }

    public boolean game () {
        showBoard();
        
        String input = nextInput("asdf");

        while (!input.equals("quit") && input != null){
            System.out.println(input);
            input = nextInput("asd");
        }
        
        return true;
    }

    private String nextInput(String message) {
        if (lines == null)
            return view.getString(message);
        if (lines.isEmpty())
            return null;
        return lines.pop();
    }

    private void showBoard() {
        view.display("Player's hand: " + player.getHand());
        view.display("Dealer's hand: " + dealer.getHand(show));
    }
}