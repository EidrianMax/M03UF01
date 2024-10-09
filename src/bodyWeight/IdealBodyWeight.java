package bodyWeight;

import java.util.Scanner;

public class IdealBodyWeight {
  public static void main(String[] args) {
    final byte K_MEN = 4;
    final float K_WOMEN = 2.5f;

    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter your height in cm: ");
    short height = scanner.nextShort();

    System.out.print("Enter your age: ");
    byte age = scanner.nextByte();

    double lorentz = height - 100 - ((double) height - 150) / 4 + ((double) age - 20) / K_MEN;
    lorentz = Math.round(lorentz * 100) / 100.0;

    System.out.println("Ideal Body Weight for Men = " + lorentz + "kg");

    lorentz = height - 100 - ((double) height - 150) / 4 + (age - 20) / K_WOMEN;
    lorentz = Math.round(lorentz * 100) / 100.0;

    System.out.println("Ideal Body Weight for Women = " + lorentz + "kg");

    scanner.close();
  }
}
