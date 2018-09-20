/* Carleton University
 * Fall 2018
 * COMP 3004A
 * Jean-Pierre Coriveau
 * 
 * David N. Zilio
 * 20/Sep/2018
 * 
 */
package com.zilio.blackjack;

import java.io.*;
import java.util.Stack;

public class readFromFile
{
    public static Stack<String> getFileStrings(UI view) {
        Stack<String> out = new Stack<String>();
        boolean fileRead = false;

        while (!fileRead)
        {
            String fileName = view.getString("Please enter the name of the file to read from:");
            File file = new File(fileName);

            try {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                String s;
                while ((s = reader.readLine()) != null)
                    out.push(s);
                fileRead = true;
                reader.close();
            }
            catch (Exception e)
            { System.out.println(e.getMessage()); }
        }
        return out;
    }
}