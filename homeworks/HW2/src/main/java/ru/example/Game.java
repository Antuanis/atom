package ru.example;

import java.io.*;
import java.util.Scanner;
import java.util.Random;

public class Game {

    public static void main(String[] args) {
        // System.out.print("Hallow World!");
        String word = GetWord();
        System.out.println(word);
    }

    static String GetWord() {
        try {
            Scanner scan = new Scanner(new File("dictionary.txt"));
            int count = 0;
            while (scan.hasNext()) {//Считаем количество строк(слов) в файле
                scan.nextLine();
                count++;
            }
            Random rnd = new Random(System.currentTimeMillis());
            int number = rnd.nextInt(count);//Выбираем случайное слово
            scan = new Scanner(new File("dictionary.txt"));
            for (int i = 0; i < number - 1; i++)
                scan.nextLine();
            return (scan.nextLine());//Выводим полученное слово
        } catch (FileNotFoundException ex) {//Если файл не найден выводит ошибку
            System.err.println("File not found: " + ex.getMessage());
            return null;
        }
    }// Выбор случайного слова из файла
}
