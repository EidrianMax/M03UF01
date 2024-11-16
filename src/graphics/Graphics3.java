package graphics;

import java.util.Scanner;

public class Graphics3 {
  public static final Scanner scanner = new Scanner(System.in);
  public static final Graphics3 gp = new Graphics3();

  public static void main(String[] args) {
    byte option = gp.menu();
    int leaves, trunk;

    switch (option) {
      case 1:
        leaves = dataEntryInt("Height of leaves? ");
        trunk = dataEntryInt("Height of trunk? ");

        System.out.println(gp.graphic1(leaves, trunk));
        break;

      case 0:
        System.out.println("Bye!");
        break;
    }
  }

  public String graphic1(int leaves, int trunk) {
    String result = "";
    int k = 1;

    for (int i = 1; i <= leaves; i++) {
      if (i == 1) {
        result += " ".repeat(leaves - i) + "+" + "\n";
      } else {
        result += " ".repeat(leaves - i);
      }

      int l = 1;
      int m = 1;

      for (int j = 1; j <= k; j++) {
        if (i == 1)
          continue;

        boolean isHalf = j == (int) Math.ceil((double) k / 2);
        boolean isLast = j == k;
        boolean isLessThanHalf = j > 1 && j < (int) Math.ceil((double) k / 2);
        boolean isMoreThanHalf = j > (int) Math.ceil((double) k / 2) && j < k;

        if (isLessThanHalf) {
          result += "/";
          l++;
        } else if (isHalf) {
          result += "|";
        } else if (isMoreThanHalf) {
          result += "\\";
          m++;
        } else if (isLast) {
          result += "*" + "\n";
        } else {
          result += "*";
        }

      }

      k += 2;
    }

    for (int i = 1; i <= trunk; i++) {
      int totalButtonLeaves = (leaves * 2) - 1;
      int halfButtonLeaves = totalButtonLeaves / 2;
      int positionTruck = halfButtonLeaves - 1;

      result += " ".repeat(positionTruck) + "|".repeat(3) + " ".repeat(positionTruck) + "\n";
    }

    return result;
  }

  public byte menu() {
    System.out.println("1. Graphic 1");
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
