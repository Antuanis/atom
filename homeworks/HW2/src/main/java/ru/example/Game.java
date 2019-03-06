package ru.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Random;

public class Game {

    public static void main(String[] args) {

        play("dictionary.txt");

    }

    public static boolean play(String FileName) {

        String word = getWord(FileName);
        //System.out.println(word);
        char[] myword = word.toCharArray();
        int count = myword.length;
        System.out.println("Welcome to Bulls and Cows game!");
        System.out.println("I offered a " + count + "-letter word, your guess?");
        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < 10; i++) { //10 попыток

            String mm = scan.nextLine();
            char[] inword = mm.toCharArray();
            if (word.equals(mm)) { //Сравнение 2х строк
                System.out.println("You Won!!!");
                return true;

            }

            int bul = bulls(inword, myword);
            int cow = cows(inword, word);
            System.out.println("Bulls: " + bul);
            System.out.println("Cows: " + cow);

        }

        System.out.println("You Lose: " + word);
        return false;

    } //Игра Быки и Коровы

    public static int bulls(char[] inword, char[] myword) {

        int count = Math.min(myword.length, inword.length);//Берем длинну более короткого слова
        int bul = 0;
        for (int j = 0; j < count; j++)  //Считаем "Быков"
            if (myword[j] == inword[j])
                bul++;
        return bul;

    } //Вычисление "быков"

    public static int cows(char[] inword, String word) {

        int cow = 0;
        for (int j = 0; j < inword.length; j++) //Счтаем"Коров"
            if (word.indexOf(inword[j]) > -1)
                cow++;
        return cow;
    } //Вычисление "коров"

    public static String getWord(String FileName) {

        try {

            Scanner scan = new Scanner(new File(FileName));
            int count = 0;
            while (scan.hasNext()) { //Считаем количество строк(слов) в файле
                scan.nextLine();
                count++;

            }

            Random rnd = new Random(System.currentTimeMillis());
            int number = rnd.nextInt(count);//Выбираем случайное слово
            scan = new Scanner(new File(FileName));
            for (int i = 0; i < number - 1; i++)
                scan.nextLine();
            return (scan.nextLine());//Выводим полученное слово

        } catch (FileNotFoundException ex) { //Если файл не найден выводит ошибку

            System.err.println("File not found: " + ex.getMessage());
            return null;

        }

    } // Выбор случайного слова из файла

}
