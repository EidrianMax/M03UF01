package dataEntry;

import java.util.Scanner;

public class DataEntry {
  public static final Scanner scanner = new Scanner(System.in);

  public static byte dataEntryByteMinMax(String text, byte min, byte max) {
    byte number = 0;
    System.out.print(text);
    boolean isValid = false;
    while (!isValid) {
      if (scanner.hasNextInt()) {
        number = scanner.nextByte();
        if (number <= max && number >= min) {
          isValid = true;
        } else {
          System.err.println("Error! Insert a number between " + min + " and " + max);
          System.out.print(text);
        }
      } else {
        scanner.next(); // Consume scanner
        System.err.println("Error! Insert a number");
        System.out.print(text);
      }
    }
    return number;
  }

  public static byte dataEntryByte(String text) {
    byte number = 0;
    System.out.print(text);
    boolean isValid = false;
    while (!isValid) {
      if (scanner.hasNextByte()) {
        number = scanner.nextByte();
        isValid = true;
      } else {
        scanner.next(); // Consume scanner
        System.err.print("Error! " + text);
      }
    }
    return number;
  }
}