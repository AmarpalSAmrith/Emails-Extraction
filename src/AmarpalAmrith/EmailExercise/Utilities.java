package AmarpalAmrith.EmailExercise;

import java.util.Scanner;

public class Utilities {

    public static void msgPrompt(String msg) {
        System.out.println(msg);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i <= msg.length(); i++) {

            stringBuilder.append("=");
        }
        System.out.println(stringBuilder);
        System.out.print(">");
    }
    public static int requestInt(String msg, int lowerVal){
        while (true) {
            String requestNumber = requestString(msg);
            int convertedNumber = 0;
            try {
                convertedNumber = Integer.valueOf(requestNumber);
                return convertedNumber;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number!");
            }
            if (convertedNumber > lowerVal) {
                return convertedNumber;
            } else {
                System.out.println("Please enter a number greater than " + lowerVal);
            }
        }
    }

    public static String requestString(String msg){
        Scanner scanner = new Scanner(System.in);
        System.out.println(msg);
        System.out.print(">");
        return scanner.next();
    }

}