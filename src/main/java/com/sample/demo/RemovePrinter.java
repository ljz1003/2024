package com.sample.demo;

public class RemovePrinter implements Printer{

    @Override
    public String doPrint(String src, String subStr) {
        src = src.replaceFirst(subStr, "");
        System.out.println("->" + src);
        return src;
    }
}
