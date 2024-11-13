package guessNumber;

import java.util.Scanner;

public class GuessNumber {
  public static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    byte maxNumber = dataEntryByteMinMax("Enter the maximum number (10..100): ", (byte) 10, (byte) 100);
    byte attemps = dataEntryByteMinMax("Enter the number of attempts (2 .. 10): ", (byte) 2, (byte) 10);
    byte count = 1;
    boolean end = false;
    byte rand = randomNumber(maxNumber);

    while (count <= attemps && !end) {
      byte num = dataEntryByteMinMax("ATTEMP " + count + " . " + "Enter 1 to " + maxNumber + ": ", (byte) 1, (byte) maxNumber);
      byte guess = guessNumber(num, rand);

      if (guess == 1) {
        System.out.println("Too high! ATTEMPT " + count + " . " + "Enter 1 to " + maxNumber + ": ");
        count++;
      } else if (guess == -1) {
        System.out.println("Too low! ATTEMPT " + count + " . " + "Enter 1 to " + maxNumber + ": ");
        count++;
      } else {
        System.out.println("YOU HAVE WON!!! THE END.");
        end = true;
        count++;
      }
    }

    if (!end) {
      System.out.println("YOU HAVE LOST! BYE!");
    }
  }

  public static byte randomNumber(byte max) {
    return (byte) (Math.random() * max + 1);
  }

  public static byte guessNumber(byte num, byte randomNum) {
    if (num > randomNum)
      return 1;
    else if (num < randomNum)
      return -1;
    else
      return 0;
  }

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
