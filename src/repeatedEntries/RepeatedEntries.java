package repeatedEntries;

import java.util.Scanner;

public class RepeatedEntries {
  public static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    boolean isEnd = false;

    while (!isEnd) {
      System.out.println();
      byte option = menu();
      double[] dades = new double[10];

      switch (option) {
        case 1:
          dataEntry(dades);
          break;

        case 2:
          boolean areRepeatedEntries = areRepeatedEntries(dades);
          System.out.println(areRepeatedEntries ? "There are repeated entries" : "There are no repeated entries");
          break;

        case 3:
          double numberToSearch = dataEntryDouble("Number to search: ");
          System.out.println(numberToSearch + " apperars " + numberOfTimes(dades, numberToSearch) + " times");
          break;

        case 0:
          System.out.println("Bye!");
          isEnd = true;
          break;
      }
    }
  }

  public static boolean areRepeatedEntries(double[] x) {
    boolean res = false;

    for (int i = 0; i < x.length; i++) {
      for (int j = i + 1; j < x.length; j++) {
        if (x[i] == x[j])
          return true;
      }
    }

    return res;
  }

  public static int numberOfTimes(double[] x, double y) {
    int total = 0;

    for (int i = 0; i < x.length; i++) {
      if (x[i] == y)
        total++;
    }

    return total;
  }

  public static void dataEntry(double[] dades) {
    for (int i = 0; i < dades.length; i++) {
      dades[i] = dataEntryDouble("Enter number [" + i + "] = ");
    }
  }

  public static byte menu() {
    System.out.println("MENU");
    System.out.println("1. Enter data");
    System.out.println("2. Repeated entries?");
    System.out.println("3. Number  of times");
    System.out.println("0. Quit");
    return dataEntryByte("Choose menu option: ");
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

  public static double dataEntryDouble(String text) {
    double number = 0;
    System.out.print(text);
    boolean isValid = false;
    while (!isValid) {
      if (scanner.hasNextDouble()) {
        number = scanner.nextDouble();
        isValid = true;
      } else {
        scanner.next(); // Consume scanner
        System.err.print("Error! " + text);
      }
    }
    return number;
  }
}
