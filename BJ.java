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
public class BJ
{
    public static void main (String args[])
    {
        Deck d1 = new Deck();
        Deck d2 = new Deck(true);

        System.out.println("Shuffled Deck:\n" + d1.toString());
        System.out.println("Sorted Deck:\n" + d2.toString());
    }
}