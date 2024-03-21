package com.sample.demo;

public class ReplacePrinter implements Printer{


    @Override
    public String doPrint(String str, String subStr) {
        char c = subStr.charAt(0);
        String replacement = 'a' == c ? "" : (char) (c - 1) + "";
        String dest = str.replaceFirst(subStr, replacement);
        System.out.println(dest);
        return dest;
    }
}
