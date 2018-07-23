package com.epam.homework2;

import java.util.Scanner;

/**
 *
 * @author Алия
 * Вариант C
1. Текст из n2 символов шифруется по следующему правилу:
— все символы текста записываются в квадратную таблицу размерно-
сти n в порядке слева направо, сверху вниз;
— таблица поворачивается на 90° по часовой стрелке;
* — 1-я строка таблицы меняется местами с последней, 2-я — с предпо-
следней и т. д.
— 1-й столбец таблицы меняется местами со 2-м, 3-й — с 4-м и т. д.
— зашифрованный текст получается в результате обхода результирую-
щей таблицы по спирали по часовой стрелке, начиная с левого верхнего
угла.
Зашифровать текст по указанному правилу.
 */


public class Task3 {
    
    public static void main(String[] args) {
        String inputText = "";        
        Scanner scanner = new Scanner(System.in);     
        String[] text;
        double perfectSqrt;
        int x ;
        do{
            System.out.println("Enter your text with n^2 symbols: ");   
            inputText = scanner.nextLine();
            text = inputText.split("");
            System.out.println("Number of symbols: "+text.length);
            perfectSqrt = Math.sqrt(text.length);
            x = (int) perfectSqrt;
        } while(Math.pow(perfectSqrt, 2)!=Math.pow(x, 2));
        
        String[][] tableFirst = new String[x][x];
        
        int element = text.length;
        for(int i=0; i<x; i++){
            for(int j=0; j<x; j++){
                tableFirst[i][j]=text[text.length-element];
                element--;
                System.out.print(""+tableFirst[i][j]+" ");
            }
            System.out.println();
        } 
        System.out.println("----------");
        String[][] tableSecond = new String[x][x];
        for(int i=0; i<x; i++){
            for(int j=0; j<x; j++){
                tableSecond[i][j]=tableFirst[x-j-1][i];
                System.out.print(""+tableSecond[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("----------");
        String[][] tableThird = new String[x][x];
        for(int i=0; i<x; i++){
            for(int j=0; j<x; j++){
                tableThird[i][j]=tableSecond[x-1-i][j];
                System.out.print(""+tableThird[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("----------");
        String[][] tableFourth = new String[x][x];
        
        for(int i=0; i<x; i++){
            for(int j=1; j<x; j+=2){
                tableFourth[i][j-1]=tableThird[i][j];                
            }
            for(int j=0; j<=x-2; j+=2){
                tableFourth[i][j+1]=tableThird[i][j];                
            }         
            if(x%2!=0){
                tableFourth[i][x-1]=tableThird[i][x-1];    
            }
        }
        for(int i=0; i<x; i++){
            for(int j=0; j<x; j++){
                System.out.print(""+tableFourth[i][j]+" ");
            }
            System.out.println();
        } 
        String output = "";
        System.out.println("----------");
       int i,r=x-1;
        while(r>0){
            for(i=x-1-r;i<=r;i++){
                output += tableFourth[x-1-r][i];
            }
            for(i=x-1-r+1;i<=r;i++){
                output += tableFourth[i][r];
            }
            for(i=r-1;i>=x-1-r && r>1;i--){
                output += tableFourth[r][i];
            }
            for(i=r-1;i>=x-1-r+1 && r>1;i--){
                output += tableFourth[i][x-1-r];
            }
            r--;
        }
        System.out.println("Result text: "+ output);
        
    }
    
}
