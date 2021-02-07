package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class PalindromeGenerator {

    public static void main(String[] args) {
        int n;
        int k;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter how many unique letters will be in the palindrome: ");
        n = scanner.nextInt();
        System.out.print("Enter how many characters the palindrome will consist of: ");
        k = scanner.nextInt();
        System.out.println(solution(n, k));

    }

    public static String solution(int n, int k) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        List<String> letters = new ArrayList<>();
        Random rnd = new Random();

        for (int i = 0; i < n; i ++) {
            char c = alphabet.charAt(rnd.nextInt(alphabet.length()));
            String cToString = String.valueOf(c);
            letters.add(cToString);
            alphabet = alphabet.replaceAll(cToString, "");
        }
        String[] palindrome = new String[k];
        int maxValue = -1;
        int lettersArrayIndex = 0;

        if (k % 2 == 0) {
            palindrome[k / 2] = letters.get(0);
            palindrome[(k / 2) - 1] = letters.get(0);
            letters.remove(0);
            maxValue = (k / 2) -1;
        } else {
            palindrome[k / 2] = letters.get(0);
            letters.remove(0);
            maxValue = k / 2;
        }

        List<String> lettersToReuse = new ArrayList<>();

        for (int j = 0; j <= maxValue - 1; j ++) {
            palindrome[j] = letters.get(lettersArrayIndex);
            lettersToReuse.add(letters.get(lettersArrayIndex));
            lettersArrayIndex ++;
            if (lettersArrayIndex == letters.size()) {
                lettersArrayIndex = 0;
            }
        }

        int w = k - 1;

        for (int j = 0; j < lettersToReuse.size(); j ++) {
            palindrome[w] = lettersToReuse.get(j);
            w --;
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < palindrome.length; i ++) {
            sb.append(palindrome[i]);
        }
        String string = sb.toString();
        return string;
    }
}
