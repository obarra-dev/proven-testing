package com.obarra.proventesting.algorithm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * This class represent a Anagram. A anagram is a word or sentence that can be transformed into
 * another word or sentence. For example Elvis has all the same letters  as Lives.
 */
public class Anagram {

    /**
     * The time complexity of this algorithm is O(n). If we start at a value a of O and XOR
     * all the characters of both strings, we should return an end value of o if they are anagrams
     * @param word The first word to analise
     * @param otherWord The first word to analise
     * @return true if the two words are anagrams or false if they are not anagrams
     */
    public static Boolean areAnagramsMethodBitManipulation(final String word, final String otherWord){
        if(word.length() != otherWord.length()){
            return false;
        }

        int result = 0;

        for (int i = 0; i < word.length(); i++){
            result = result ^ word.charAt(i);
            result = result ^ otherWord.charAt(i);
        }

        return result == 0;
    }

    /**
     * The time complexity of this algorithm is maybe O(n) or O(log n).
     * This algorithm will have the same  order of magnitude as that of sorting method.
     * @param word The first word to analise
     * @param otherWord The first word to analise
     * @return true if the two words are anagrams or false if they are not anagrams
     */
    public static Boolean areAnagramsMethodSortAndCompare(final String word, final String otherWord){
        if(word.length() != otherWord.length()){
            return false;
        }

        char[] wordOrdered = word.toCharArray();
        Arrays.sort(wordOrdered);

        char[] otherWordOrdered = otherWord.toCharArray();
        Arrays.sort(otherWordOrdered);

        return Arrays.equals(wordOrdered, otherWordOrdered);
    }

    /**
     * The time complexity of this algorithm is O(log n). This algorithm sacrificed space in order to gain time.
     * @param word The first word to analise
     * @param otherWord The first word to analise
     * @return true if the two words are anagrams or false if they are not anagrams
     */
    public static Boolean areAnagramsMethodCountAndCompare(final String word, final String otherWord){
        if(word.length() != otherWord.length()){
            return false;
        }

        Map<Integer, Integer> counterLetters = new HashMap<>();

        for (int i = 0; i< word.length(); i++){
            counterLetters.merge((int)word.charAt(i), 1, (v1, v2) -> v1 + v2);
        }

        for (int i = 0; i< otherWord.length(); i++){
            int indexLetter = otherWord.charAt(i);
            Integer counter = counterLetters.get(indexLetter);

            if(counter == null || counter < 1){
                return false;
            }else{
                counterLetters.put(indexLetter, counter-1);
            }
        }

        return counterLetters.values().stream().noneMatch(v -> v !=0 );
    }

    /**
     * The time complexity of this algorithm is O(n^2).
     * @param word The first word to analise
     * @param otherWord The first word to analise
     * @return true if the two words are anagrams or false if they are not anagrams
     */
    public static Boolean areAnagramsMethodCheckingOff(final String word, final String otherWord){
        if(word.length() != otherWord.length()){
            return false;
        }

        char[] other = otherWord.toCharArray();
        boolean areAnagrams = false;
        for (int i = 0; i < word.length(); i++){
            for (int j = 0; j < other.length; j++){
                if(word.charAt(i) == other[j]){
                    other[j] = '\u0000';
                    areAnagrams = true;
                    break;
                }

                areAnagrams = false;
            }

            if(!areAnagrams){
                return areAnagrams;
            }
        }

        return areAnagrams;
    }
}
