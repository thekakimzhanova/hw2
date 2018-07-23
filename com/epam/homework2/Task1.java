
package com.epam.homework2;

import java.util.Scanner;

/**
 *
 * @author Алия
 * Строки
 * Вариант А
 * 1 задание
 */


public class Task1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String inputText = "";
        String outputText = "";
        int kToken = 0;
        char replacingToken = 0;
        
        Scanner scanText = new Scanner(System.in);
        Scanner scanK = new Scanner(System.in); 
        Scanner scanToken = new Scanner(System.in); 
        
        System.out.println("Enter your text: ");        
        inputText = scanText.nextLine();
        
        System.out.println("Enter a number: ");        
        kToken = scanK.nextInt();
        
        System.out.println("Enter a token you want replace instead: ");        
        replacingToken = scanToken.next().charAt(0);
        
        String[] wordsArray = inputText.replaceAll("[^a-z^A-Z]"," ").split("\\s+");
        StringBuilder str = new StringBuilder(inputText);
        
        for(String word : wordsArray){
            StringBuilder replacedWord = new StringBuilder(word);
            if(kToken<=word.length()){
               replacedWord.setCharAt(kToken-1, (char)replacingToken);
               outputText+=" "+replacedWord;
            } else{
                outputText+=" "+word;
            }
        }
        
        System.out.println("Result: "+ outputText);
        scanText.close();
        scanK.close();
        scanToken.close();
    }
    
}
