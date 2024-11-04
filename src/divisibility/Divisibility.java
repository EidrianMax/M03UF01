package divisibility;

import java.util.Scanner;

public class Divisibility {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Enter number 1: ");
    int num1, num2;

    if (scanner.hasNextInt()) {
      num1 = scanner.nextInt();

      System.out.println("Enter number 2: ");

      if (scanner.hasNextInt()) {
        num2 = scanner.nextInt();

        System.out.println(areDivisible(num1, num2) ? "They are divisible" : "They are not divisible");
      } else {
        System.out.println("This is not an integer");
      }
    } else {
      System.out.println("This is not an integer");
    }

    scanner.close();
  }

  public static boolean areDivisible(int num1, int num2) {
    return num1 % num2 == 0 || num2 % num1 == 0;
  }
}
