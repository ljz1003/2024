package com.sample.demo;

public class ReplacePrinter implements Printer{


    @Override
    public String doPrint(String str, String subStr) {

        char c = subStr.charAt(0);
        if (c == 'A' || c == 'a') {
            str = str.replaceFirst(subStr,  "");
            System.out.println("->> " + str);
        } else {

            char charBefore = (char)(c - 1);
            str = str.replaceFirst(subStr, charBefore + "");
            System.out.println(String.format("->> %s, %s is replaced by %c", str, subStr, c));

        }
        return str;
    }
}
