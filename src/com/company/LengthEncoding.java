package com.company;

import java.util.Scanner;

public class LengthEncoding {
    public static String solution(String str) {
        String strToPrint = "";
        int strLength = str.length();
        for (int i = 0; i < strLength; i++) {
            int counter = 1;
            while (i < strLength - 1 && str.charAt(i) == str.charAt(i + 1)) {
                counter ++;
                i ++;
            }
            strToPrint = strToPrint + counter + str.charAt(i);
        }
        return strToPrint;
    }

    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str;
        System.out.print("Type your string here: ");
        str = scanner.nextLine();
        System.out.println(solution(str));
    }
}
