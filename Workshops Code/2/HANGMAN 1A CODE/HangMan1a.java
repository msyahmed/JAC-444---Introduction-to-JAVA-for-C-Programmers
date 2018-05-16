/**********************************************

Workshop # 2.1.a

Course:JAC444> - WINTER 2018

Last Name:<Ahmed>

First Name:<Muhammad>

ID:12633016
Section: D

This assignment represents my own work in accordance with Seneca Academic Policy.

Signature M.A

Date:<submission date>

**********************************************/
package hangman;


import java.util.Scanner;
import java.io.*;



public class Hangman {

    static String[] words = { "seneca", "java", "workshop", "hangman", "win" };
    static boolean flag;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String keepRunning = "y";
        while (keepRunning.equals("y")) {
            String word = getWord();
            String hiddenWord = getMaskedWord(word);
            int missCount = 0;
            while (!word.equals(hiddenWord)) {
                System.out.print("(Guess) Enter a letter in word " + hiddenWord + " > ");
                char ch = scan.next().charAt(0);

                if (!isAlreadyInWord(hiddenWord, ch)) {

                    hiddenWord = getGuess(word, hiddenWord, ch);

                    if (!flag) {
                        System.out.println(ch + " is not in the word.");
                        missCount++;
                    }
                }else
                    System.out.println(ch + " is already in word.");
            }
            System.out.println("The word is " + (hiddenWord) +". You missed "+ (missCount) +  " times");
            System.out.println("Do you want to guess another word? Enter y or n >");
            keepRunning = scan.next();
        }

    }

    public static String getWord() {
        return words[(int) (Math.random() * words.length)]; //generating random strings form array
    }

    public static boolean isAlreadyInWord(String hiddenWord, char ch) { //CHECKER METHOD
        int i = 0;
        while( i < hiddenWord.length()){
            if (ch == hiddenWord.charAt(i)) {
                return true;
            }
        i++;
        }
        return false;
    }
    
    static public String getGuess(String word, String hiddenWord, char ch) {

        flag = false;
        StringBuilder s = new StringBuilder(hiddenWord);
		int i = 0;
        
		while (i < word.length()){
                    if (ch == word.charAt(i) && s.charAt(i) == '*') {
                        flag = true;
                        s = s.deleteCharAt(i);
                        s = s.insert(i, ch);
                    }
                    i++;
		}
        return s.toString();
    }
    
    public static String getMaskedWord(String word) {

        String hidden = "";
        int i = 0;
        while (i < word.length()){
            hidden = hidden + "*";
            i++;
        }
        return hidden;
    }  
}