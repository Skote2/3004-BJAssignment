/* Carleton University
 * Fall 2018
 * COMP 3004A
 * Jean-Pierre Coriveau
 * 
 * David N. Zilio
 * 20/Sep/2018
 * 
 * 
 */
package com.zilio.blackjack;

import java.util.Stack;

public class App 
{
    public static void main( String[] args ) 
    {
        UI view = new UI();
        char[] option = {'c', 'f'};
        String[] message = {"Console based game input", "File based game input"};
        char inputMethod = view.getChar(option, message);

        Stack<String> lines = null;
        if (inputMethod == option[1])//file
            lines = readFromFile.getFileStrings(view);
        
        BJ.game(view, lines);

        view.close();
    }
}
