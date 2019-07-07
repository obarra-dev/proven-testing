package com.obarra.littletaste.algorithm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * This class represent a Anagram. A anagram is a word or sentence that can be transformed into
 * another word or sentence. For example Elvis has all the same letters  as Lives.
 */
public class Anagram {

    /**
     * The time complexity of this algorithm is maybe O(n) or O(log n).
     * This algorithm will have the same  order of magnitude as that of sorting method.
     * @param word
     * @param otherWord
     * @return
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
     * @param word
     * @param otherWord
     * @return
     */
    public static Boolean areAnagramsMethodCountAndCompare(final String word, final String otherWord){
        if(word.length() != otherWord.length()){
            return false;
        }

        Map<Integer, Integer> counterLetters = new HashMap<>();
        for (int i = 0; i< word.length(); i++){
            int indexLetter = word.charAt(i);
            Integer counter = counterLetters.get(indexLetter);

            if(counter == null){
                counterLetters.put(indexLetter, 1);
            }else{
                counterLetters.put(indexLetter, counter+1);
            }
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

        for (Map.Entry<Integer, Integer> entry: counterLetters.entrySet()){
            if(entry.getValue()!= 0){
                return false;
            }
        }

        return true;
    }
}
