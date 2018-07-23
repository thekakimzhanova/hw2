package com.epam.homework2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Алия
 */


public class Task2 {
    public static void main(String[] args) {
        String inputText = "";        
        Scanner scanner = new Scanner(System.in);       
        int count;  
        int check =0;
        System.out.println("Enter your text: ");        
        inputText = scanner.nextLine();
        
        String[] arrayOfSentences = inputText.replaceAll("[,]", "").split("(?<=[a-z])\\.\\s+");
        Map<String, Map<Integer, Integer>> outerMap = new HashMap<>();       
        
        for(int nthSentence=0; nthSentence<arrayOfSentences.length; nthSentence++){
            String[] sentence = arrayOfSentences[nthSentence].split("[\\s.,?!]+");       
            for (int word =0; word<sentence.length; word++) {    
                if (outerMap.containsKey(sentence[word])) {
                    if(outerMap.get(sentence[word]).containsKey(nthSentence+1)){                        
                    count = outerMap.get(sentence[word]).get(nthSentence+1);
                    outerMap.get(sentence[word]).put(nthSentence+1, count+1);
                    } else{ 
                        outerMap.get(sentence[word]).put(nthSentence+1, 1);
                    }
                    
                } else {
                    Map<Integer, Integer> innerMap = new HashMap<>();
                    innerMap.put(nthSentence+1, 1);
                    innerMap.replace(nthSentence+1, 1);
                    outerMap.put(sentence[word], innerMap);                   
                }
            }      
        }
         
         for (Map.Entry<String, Map<Integer,Integer>> entry : outerMap.entrySet()) {
             if(entry.getValue().size()>1){
                    System.out.println(entry.getKey() + " : " + entry.getValue());
             }
            }
    }
}
