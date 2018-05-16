package hangmanfileinput;

/**********************************************

Workshop # 2.1.b (Hangman using file input

Course:JAC444> - WINTER 2018

Last Name:<Ahmed>

First Name:<Muhammad>

ID:12633016
Section: D

This assignment represents my own work in accordance with Seneca Academic Policy.

Signature M.A

Date:<submission date>

**********************************************/

import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;


public class HangmanFIleInput {

    static String[] words = readArray("Hangman.txt");
    static boolean flag;
    
    public static void main(String[] args) {
        /*for (int i = 0; i < words.length; i++){
        System.out.println(words[i]);
        }*/
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
    
    public static String[] readArray(String file){
       //count elements
       //create and copy elements in and return.
       int count = 0;
       try{
           Scanner s1 = new Scanner(new File(file));
           while(s1.hasNextLine()){
               count++;
               s1.next();
           }
           String [] words = new String[count];
           Scanner s2 = new Scanner(new File(file));
           for (int i = 0;i < count; i++){
               words[i] = s2.next();
           }
           return words;
       }catch(FileNotFoundException e){
           System.out.println("File not found");
       }
       return null;
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