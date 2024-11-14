package graphics;

import java.util.Scanner;

public class Graphics1 {
  public static final Scanner scanner = new Scanner(System.in);
  public static final Graphics1 gp = new Graphics1();

  public static void main(String[] args) {
    char character;
    byte lines;

    byte option = gp.menu();

    switch (option) {
      case 1:
        System.out.print("Enter char: ");
        character = scanner.next().charAt(0);
        lines = dataEntryByte("Enter lines: ");

        System.out.println(gp.graphic1((byte) lines, character));
        break;

      case 2:
        System.out.print("Enter char: ");
        character = scanner.next().charAt(0);
        lines = dataEntryByte("Enter lines: ");

        System.out.println(gp.graphic2((byte) lines, character));
        break;
      case 3:
        System.out.print("Enter char: ");
        character = scanner.next().charAt(0);
        lines = dataEntryByte("Enter lines: ");

        System.out.println(gp.graphic3((byte) lines, character));
        break;
      case 4:
        System.out.print("Enter char: ");
        character = scanner.next().charAt(0);
        lines = dataEntryByte("Enter lines: ");

        System.out.println(gp.graphic4((byte) lines, character));
        break;
      case 5:
        System.out.print("Enter char: ");
        character = scanner.next().charAt(0);
        lines = dataEntryByte("Enter lines: ");

        System.out.println(gp.graphic5((byte) lines, character));
        break;
      case 6:
        lines = dataEntryByte("Enter lines: ");

        System.out.println(gp.graphic6((byte) lines));
        break;
      case 0:
        System.out.println("BYE!");
        break;
    }
  }

  public String graphic1(byte lines, char c) {
    String total = "";

    for (int i = 1; i <= lines; i++) {
      for (int j = 1; j <= lines; j++) {
        total += Character.toString(c);
      }

      if (i < lines) {
        total += '\n';
      }
    }

    return total;
  }

  public String graphic2(byte lines, char c) {
    String total = "";

    for (int i = 1; i <= lines; i++) {
      total += Character.toString(c).repeat(i);

      if (i < lines) {
        total += '\n';
      }
    }

    return total;
  }

  public String graphic3(byte lines, char c) {
    String total = "";

    for (int i = 1; i <= lines; i++) {
      total += " ".repeat(lines - i) + Character.toString(c).repeat(i);

      if (i < lines) {
        total += '\n';
      }
    }

    return total;
  }

  public String graphic4(byte lines, char c) {
    String total = "";

    for (int i = 1; i <= lines; i++) {
      String charPlusSpace = Character.toString(c) + " ";

      total += " ".repeat(lines - i) + charPlusSpace.repeat(i);

      if (i < lines) {
        total += '\n';
      }
    }

    return total;
  }

  public String graphic5(byte lines, char c) {
    String total = "";

    int j = 1;

    for (int i = 1; i <= lines; i++) {
      String charPlusSpace = Character.toString(c).repeat(j);

      total += " ".repeat(lines - i) + charPlusSpace;

      if (i < lines) {
        total += '\n';
      }

      j += 2;
    }

    return total;
  }

  public String graphic6(byte lines) {
    String total = "";
    String c = "xo~*+";

    int j = 1;

    for (int i = 1; i <= lines; i++) {
      total += " ".repeat(lines - i);

      for (int k = 1; k <= j; k++) {
        int randomNumber = (int) Math.floor(Math.random() * 5);

        total += Character.toString(c.charAt(randomNumber));
      }

      if (i < lines) {
        total += '\n';
      }

      j += 2;
    }

    return total;
  }

  public byte menu() {
    System.out.println("1. Graphic 1");
    System.out.println("2. Graphic 2");
    System.out.println("3. Graphic 3");
    System.out.println("4. Graphic 4");
    System.out.println("5. Graphic 5");
    System.out.println("6. Graphic 6");
    System.out.println("0. Quit");
    return dataEntryByteMinMax("Choose menu option: ", (byte) 0, (byte) 6);
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
