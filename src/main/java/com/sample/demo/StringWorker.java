package com.sample.demo;

import java.util.Optional;

public class StringWorker {

    private static volatile StringWorker worker;

    private StringWorker() {
        if (worker != null) {
            throw new AssertionError("StringWorker constructor can't be called explicitly");
        }
    }

    public static StringWorker getInstance() {

        if(worker == null) {
            synchronized (StringWorker.class) {
                if (worker == null) {
                    worker = new StringWorker();
                }
            }
        }
        return worker;
    }

    /*
    For a given string that only contains alphabet characters a-z,
    if 3 or more consecutive characters are identical, remove them from the string.
    Repeat this process until there is no more than 3 identical characters sitting besides each other.
    Example:
    Input: aabcccbbad
    Output:
           -> aabbbad
           -> aaad
           -> d
     */
    public String remove(String srcStr) throws IllegalFormatStringException {
        return doRemoveOrReplace(srcStr, new RemovePrinter());
    }

    /*
     #Stage 2 - advanced requirement
     Instead of removing the consecutively identical characters,
     replace them with a single character that comes before it alphabetically.
     Example:
          Input: aabcccbbad
          Output:
                -> aabbbad
                -> aaad
                -> d
     */
    public String replace(String srcStr) throws IllegalFormatStringException {
        return doRemoveOrReplace(srcStr, new ReplacePrinter());
    }

    //common function to do remove or replace operation.
    private String doRemoveOrReplace(String srcStr, Printer printer) throws IllegalFormatStringException {

        srcStr = preCheck(srcStr);

        int i = 0;
        while (i < srcStr.length()) {
            int endIndex = i + 1;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(srcStr.charAt(i));
            while (endIndex < srcStr.length()) {
                //only the char code value is equal, we think that the character is the same character,
                //for instance 'A' == 'A' only and 'A' !='a'
                if (srcStr.charAt(i) != srcStr.charAt(endIndex)) {
                    break;
                }
                stringBuilder.append(srcStr.charAt(endIndex));
                endIndex++;

            }

            String subStr = stringBuilder.toString();
            if (subStr.length() >= 3) {
                //print with remove format or replace format
                srcStr = printer.doPrint(srcStr, subStr);
                //backward the index so that we can start it over again.
                i = backwardIndex(srcStr, i);
            } else {
                i = endIndex;
            }
        }

        return srcStr;
    }

    //backward the index
    private int backwardIndex(String srcStr, int currentIndex) {
        int backwardIndex = currentIndex - 1;
        while(backwardIndex >= 0 && currentIndex < srcStr.length()) {
            if (srcStr.charAt(currentIndex) != srcStr.charAt(backwardIndex)) {
                break;
            }
            backwardIndex--;
        }
        return (backwardIndex < 0 ? 0 : backwardIndex + 1);
    }


    private String preCheck(String src) throws IllegalFormatStringException {
        //System.out.println("source: " + srcStr);
        src = Optional.ofNullable(src).orElse("").trim();
        if ("".equals(src) || !src.matches("[a-z]+")) {
            throw new IllegalFormatStringException("The string should only contain alphabet characters a-z");
        }
        return src;
    }
}
