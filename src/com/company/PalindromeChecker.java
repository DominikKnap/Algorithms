package com.company;

import java.util.Scanner;

public class PalindromeChecker {
    public static String solution(String str) {
        int lowIndex = 0;
        int highIndex = str.length() - 1;

        while (lowIndex < highIndex) {
            if (str.charAt(lowIndex) == str.charAt(highIndex)) {
                lowIndex ++;
                highIndex --;
            }
            else {
                if (isStringPalindrome(str, lowIndex + 1, highIndex) && str.length() > 3) {
                    return str.substring(lowIndex, lowIndex + 1);
                }
                if (isStringPalindrome(str, lowIndex + 2, highIndex) && str.length() > 4) {
                    return str.substring(lowIndex, lowIndex + 2);
                }
                if (isStringPalindrome(str, lowIndex, highIndex - 1) && str.length() > 3) {
                    return str.substring(highIndex - 1, highIndex);
                }
                if (isStringPalindrome(str, lowIndex, highIndex - 2) && str.length() > 4) {
                    return str.substring(highIndex - 2, highIndex);
                }
                return "not possible";
            }
        }

        return "palindrome";
    }

    public static boolean isStringPalindrome(String str, int lowIndex, int highIndex) {
        while (lowIndex < highIndex) {
            if (str.charAt(lowIndex) != str.charAt(highIndex)) {
                return false;
            }
            lowIndex ++;
            highIndex --;
        }
        return true;
    }

    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str;
        System.out.print("Type palindrome: ");
        str = scanner.nextLine();
        System.out.println(solution(str));
    }
}
