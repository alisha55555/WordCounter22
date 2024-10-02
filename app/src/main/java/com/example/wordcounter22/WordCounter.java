package com.example.wordcounter22;

public class WordCounter {

    // Метод для подсчета слов
    public int countWords(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }
        // Разделение текста на слова по пробелам, точкам и запятым
        String[] words = text.split("[\\s,.]+");
        return words.length;
    }

    // Метод для подсчета символов
    public int countChars(String text) {
        return text.length();
    }
}
