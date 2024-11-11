package factorial;

import java.util.Scanner;

public class Factorial {
  public static final Scanner scanner = new Scanner(System.in);
  public static Factorial fc = new Factorial();

  public static void main(String[] args) {
    byte option = menu();

    switch (option) {
      case 1:
        int number = dataEntryInt("Enter number: ");

        System.out.println(number + "!: " + fc.factorial(number));

        break;

      default:
        break;
    }
  }

  public double factorial(int n) {
    double total = n;

    if (n == 0)
      return 1;

    if (n < 0)
      return -1;

    for (int i = n - 1; i >= 1; i--) {
      total *= i;
    }

    return total;
  }

  public static byte menu() {
    System.out.println("MENU");
    System.out.println("1. Calculate Factorial");
    System.out.println("0. Quit");
    return dataEntryByteMinMax("Choose menu option: ", (byte) 0, (byte) 1);
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

  public static int dataEntryInt(String text) {
    int number = 0;
    System.out.print(text);
    boolean isValid = false;
    while (!isValid) {
      if (scanner.hasNextInt()) {
        number = scanner.nextInt();
        isValid = true;
      } else {
        scanner.next(); // Consume scanner
        System.err.print("Error! " + text);
      }
    }
    return number;
  }
}
