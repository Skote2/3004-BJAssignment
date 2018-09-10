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
public class Card
{
    public static char[] Suits = {'A', 'S', 'H', 'C'};
    public static String[] Faces = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
    
    private char s; //suit
    private String f;//face

    public Byte getValue() {
        return 0;
    }
    
    public Card (char suit, String face) {
        s = suit;
        f = face;
    }

    public String toString() {
        return s + f;
    }
}