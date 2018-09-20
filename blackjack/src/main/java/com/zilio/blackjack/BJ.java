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
        char[] option = {'h', 's', 'q'};
        String[] message = {"Hit", "Stand", "Quit"};
        char input;
        do{//player's turn
            input = nextInput(option, message);
            if (input == 'h')
                player.hit(deck.draw());
            showBoard();
        }while(input != 'q' && input != 's' && !player.checkBust());
        

        show = true;
        if (!player.checkBust()) {
            do{//dealers turn
                input = (dealer.getValue() <= 16 || dealer.checkSoft17() ? 'h' : 's');
                if (input == 'h')
                    dealer.hit(deck.draw());
                showBoard();
            }while(input != 'q' && input != 's' && !dealer.checkBust());

            if (dealer.checkBust())
                view.display("Player Wins, Dealer busted");
            else {
                if (dealer.checkBlackJack()) {
                    view.display("Dealer Wins, Bslackjack!");
                }
                else if (player.checkBlackJack()) {
                    view.display("Player Wins, Blackjack!");
                }
                else {
                    if (dealer.getValue() >= player.getValue())
                        view.display("Dealer Wins");
                    else
                        view.display("Player Wins");
                }
            }
        }
        else
            view.display("Dealer Wins, Player busted");
        view.display("Player Score: " + player.getValue() + "\nDealer Score: " + dealer.getValue());

        return true;
    }

    private String nextInput(String message) {
        if (lines == null)
            return view.getString(message);
        if (lines.isEmpty())
            return null;
        return lines.pop();
    }
    private char nextInput(char[] options, String[] message) {
        //if (lines == null)
        return view.getChar(options, message);
        //if (lines.isEmpty())
        //    return 's';
        //return lines.pop();
    }

    private void showBoard() {
        view.display("\nPlayer's hand: " + player.getHand() + "\nScore: " + player.getValue());
        view.display("Dealer's hand: " + dealer.getHand(show));
    }
}