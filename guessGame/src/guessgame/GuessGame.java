/* GuessGame Application
 * CSCIS 111
 * @author David Seng
 * last modified on October 1, 8:43 pm
 */

package guessgame;
import java.util.*;
import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;


/** this method generate a random number from 1-100 for a user to guess.the input will then determine whether the number that the user guess is too high or too low
 * this program will ask the user to try again if guess wrong while allowing them to try again.
 * 
 * @author d3lite
 */
@SuppressWarnings("empty-statement")
public class GuessGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     int pick ; // the random number that the computer pick
     int guess = 0; // the user's guess, initiailized to zero
     int count=1; // the number of guesses
     String intro = "I am thinking of a number between 1 and 100";
     String what = "Try to guess what it is";
     String guesshigh = "too high. try again";
     String guesslow = "too low. try again";
     String your = "your guess?";
     
       
     
      //Declare a new voice
        Voice voice;
        VoiceManager voiceManager = VoiceManager.getInstance();
        voice = voiceManager.getVoice("kevin16");       
        voice.allocate();
        voice.setRate(120);
        voice.setPitch(100);
        
     // declare an instance of Scanner to read the datastream from the keyboard.
        Scanner keyboard = new Scanner(System.in);
        
       // let the computer pick a number between 1 and 100
        pick = (1 + (int) (Math.random() * 99));   
       
        voice.speak(intro);
      // print “I am thinking of a number between 1 and 100.”
       {  System.out.println("I am thinking of a number between 1 and 100");
     
        voice.speak(what);
       // print ”Try to guess what it is.”
       System.out.println("Try to guess what it is.");
       
         guess = keyboard.nextInt();   // get value of guess from the keyboard input
  
        // set up a loop to repeat until the user guess the right number
       
        while (!(pick == guess))
        { 
            count++;   // keep track of how many guesses

            
            if (guess < pick) // in the loop guess cannot equal pick: it will be low or high
            { voice.speak(guesslow);
            System.out.println("Too Low. Try again");   
             } 
            else {
            voice.speak(guesshigh);
            System.out.println("Too high. Try again");     }
            
            voice.speak(your);
            System.out.println("Your guess?"); // print your guess?
             guess = keyboard.nextInt(); // input user guess
            
            
            } // end while (guess ≠ pick) 
        // the loop ends when the user picks the right number
         String correct = "Correct! the number is " + pick;
        voice.speak(correct);
        //print “Correct. The number Is ” + pick
       System.out.println("Correct. The number is " + pick);
        String amount = "It took you " + count + "guess";
        voice.speak(amount);
        // print “It took you ” + count + “ guesses”
       System.out.println("It took you " + count + " guesses");
        
       
     
     } // end GuessGame application
     
   
       
     }}