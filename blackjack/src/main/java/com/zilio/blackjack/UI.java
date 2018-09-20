/* Carleton University
 * Fall 2018
 * COMP 3004A
 * Jean-Pierre Coriveau
 * 
 * David N. Zilio
 * 10/Sep/2018
 * 
 * This class should be called for all user interfacing from messages to input.
 */
package com.zilio.blackjack;

import java.util.Scanner;

public class UI {
    private static Scanner input;
    public UI () { input = new Scanner(System.in); }
    public void close () { input.close(); }
    public void finalize() { input.close(); }

    public char getChar (char[] options, String[] message)
    {
        char answer = '0';
        boolean answered = false;
        while (!answered) {
            System.out.println("Please select one of the below:");
            for (int i = 0; i < options.length &&  i < message.length; i++)
                System.out.println("    " + options[i] + ") " + message[i]);
            
            answer = input.nextLine().charAt(0);
            for (char o : options)
                if (o == answer)
                    answered = true;
            if (!answered)
                System.out.println("Invalid input, please try again");
        }
        
        return answer;
    }

    public String getString(String message) {
        System.out.println(message);
        String in = input.nextLine();
        
        return in;    
    }
}