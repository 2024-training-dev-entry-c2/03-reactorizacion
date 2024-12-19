package org.example;

import java.time.LocalDate;

import static org.example.Main.input;
/**
 * @author Manuel Aguilera / @aguileradev
 */
public class InputCaptureUtil {

    public static String captureString(String message) {
        System.out.println(message);
        return input.nextLine();
    }

    public static LocalDate captureDate(String message) {
        System.out.println(message);
        return LocalDate.parse(input.nextLine());
    }

    public static Byte captureByte(String message) {
        System.out.println(message);
        return input.nextByte();
    }

    public static Integer captureInteger(String message) {
        System.out.println(message);
        return input.nextInt();
    }

    public static String captureStringWithNextLineClear(String message) {
        System.out.println(message);
        input.nextLine();
        return input.nextLine();
    }
}
