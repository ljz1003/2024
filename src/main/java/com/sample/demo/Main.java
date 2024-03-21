package com.sample.demo;


import java.util.Objects;
import java.util.Optional;
import java.util.Scanner;

/*
A command line application to demo the functionality
 */
public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please select function, Press 'A' to remove, 'B' to replace, 'C' to exit.");

        while(true) {
            System.out.print("Your option is:");
            String option = Optional.ofNullable(scanner.nextLine()).orElse("");
            // Press C to exit
            if ("C".equalsIgnoreCase(option)) {
                System.exit(0);
            } else {

                if ("A".equalsIgnoreCase(option) || "B".equalsIgnoreCase(option)) {
                    System.out.print("Input:");
                    String src = scanner.nextLine();
                    String result = getString(option, src);
                    if (Objects.equals(src, result)) {
                        System.out.println(String.format("No need to remove or replace in string: %s", result));
                    }
                } else {
                    System.out.println("Invalid option");
                }
            }
        }

    }

    private static String getString(String option, String src) {

        String result = null;
        try {
            StringWorker worker = StringWorker.getInstance();
            if ("A".equalsIgnoreCase(option)) {
                //Press A to remove 3 or more consecutive characters are identical
                result= worker.remove(src);

            } else if ("B".equalsIgnoreCase(option)) {
                //Press B to replace 3 or more consecutive characters are identical
                result = worker.replace(src);

            }

        } catch (IllegalFormatStringException e) {
            System.out.println("The string should only contain alphabet characters a-z");
        }

        return result;
    }
}
