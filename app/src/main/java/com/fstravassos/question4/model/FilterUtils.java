package com.fstravassos.question4.model;

public class FilterUtils {

    public static boolean checkTypos(String firstWord, String secondWord) {
        char[] word1 = firstWord.toCharArray();
        char[] word2 = secondWord.toCharArray();
        int difCount = 0;

        for (int i = 0, j = 0; i < word1.length && j < word2.length && difCount < 2; i++, j++) {
            if (word1[i] != word2[j]) {
                ++difCount;

                if (word1.length < word2.length) --i;
                if (word2.length < word1.length) --j;
            }
        }

        return difCount < 2;
    }

    public static boolean isPartialPermutation(String pattern, String permutation) {
        boolean result = pattern.length() == permutation.length() && permutation.length() >= 3;

        char[] patternArray = pattern.toCharArray();
        char[] permutationArray = permutation.toCharArray();

        if (result = result && checkFirstCharacter(patternArray, permutationArray)) {
            char[] swapped = getPermutation(patternArray, permutationArray);

            if (result = checkTotalChangedLetters(swapped, pattern.length())) {
                result = checkLetters(patternArray, permutationArray);
            }
        }

        return result;
    }

    private static boolean checkLetters(char[] swapped, char[] patternArray) {
        boolean result = true;
        sort(swapped, 0, swapped.length - 1);
        sort(patternArray, 0, patternArray.length - 1);

        for (int i = 0; i < swapped.length && result; i++) {
            result = swapped[i] == patternArray[i];
        }

        return result;
    }

    private static boolean checkFirstCharacter(char[] patternArray, char[] permutationArray) {
        return patternArray[0] == permutationArray[0];
    }

    private static char[] getPermutation(char[] patternArray, char[] permutationArray) {
        StringBuilder swapped = new StringBuilder();

        for (int i = 1; i < patternArray.length; i++) {
            if (patternArray[i] != permutationArray[i]) {
                swapped.append(permutationArray[i]);
            }
        }

        return swapped.toString().toCharArray();
    }

    private static boolean checkTotalChangedLetters(char[] swapped, int patternSize) {
        return swapped.length <= ((patternSize * 2) / 3);
    }

    private static void sort(char[] array, int start, int end) {
        if (start < end) {
            int indexPivot = split(array, start, end);
            sort(array, start, indexPivot - 1);
            sort(array, indexPivot + 1, end);
        }
    }

    private static int split(char[] array, int first, int last) {
        char pivot = array[first];
        int start = first + 1;
        int end = last;

        while (start <= end) {
            if (array[start] <= pivot) {
                start++;
            } else if (pivot < array[end]) {
                end--;
            } else {
                char swap = array[start];
                array[start++] = array[end];
                array[end--] = swap;
            }
        }
        array[first] = array[end];
        array[end] = pivot;
        return end;
    }
}
