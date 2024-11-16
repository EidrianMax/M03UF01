package graphics;

import java.util.Scanner;

public class Graphics2 {
  public static final Scanner scanner = new Scanner(System.in);
  public static final Graphics2 gp = new Graphics2();

  public static void main(String[] args) {
    byte lines;

    byte option = gp.menu();

    switch (option) {
      case 1:
        lines = dataEntryByte("Enter lines: ");
        System.out.println(gp.graphic1(lines));

        break;
      case 2:
        lines = dataEntryByte("Enter lines: ");
        System.out.println(gp.graphic2(lines));

        break;
      case 3:
        lines = dataEntryByte("Enter lines: ");
        System.out.println(gp.graphic3(lines));

        break;
      case 4:
        lines = dataEntryByte("Enter lines: ");
        System.out.println(gp.graphic4(lines));

        break;
      case 5:
        lines = dataEntryByte("Enter lines: ");
        System.out.println(gp.graphic5(lines));

        break;
      case 6:
        lines = dataEntryByte("Enter lines: ");
        System.out.println(gp.graphic6(lines));

        break;
    }
  }

  public String graphic1(byte lines) {
    String result = "";

    for (int i = 1; i <= lines; i++) {
      String numberPlusSpace = Integer.toString(i) + " ";

      result += " ".repeat(lines - i) + numberPlusSpace.repeat(i);

      if (i < lines) {
        result += "\n";
      }
    }

    return result;
  }

  public String graphic2(byte lines) {
    String result = "";

    int j = 1;

    for (int i = 1; i <= lines; i++) {
      String number = Integer.toString(i);

      result += " ".repeat(lines - i) + number.repeat(j);

      if (i < lines) {
        result += "\n";
      }

      j += 2;
    }

    return result;
  }

  public String graphic3(byte lines) {
    String result = "";

    int k = 1;
    int l = 0;

    for (int i = 1; i <= lines; i++) {
      result += " ".repeat(lines - i);

      for (int j = 1; j <= k; j++) {
        if (j > 9) {
          result += Integer.toString(l);

          l++;
          if (l > 9)
            l = 0;
        } else {
          result += Integer.toString(j);
        }
      }

      result += '\n';
      k += 2;
      l = 0;
    }

    return result;
  }

  public String graphic4(byte lines) {
    String result = "";

    int k = 1;
    int l = 1;
    for (int i = 1; i <= lines; i++) {
      result += " ".repeat(lines - i);

      for (int j = 1; j <= k; j++) {
        if (j == (int) Math.ceil((double) k / 2) + l) {
          result += Integer.toString(k - (j - 1));
          l++;
        } else {
          result += Integer.toString(j);
        }
      }

      result += '\n';
      k += 2;
      l = 1;
    }

    return result;
  }

  public String graphic5(byte lines) {
    String result = "";

    int k = 1;
    int l = 1;
    for (int i = 1; i <= lines; i++) {
      result += " ".repeat(((lines * 2) - (i * 2)));

      for (int j = 1; j <= k; j++) {
        if (j == (int) Math.ceil((double) k / 2) + l) {
          result += Integer.toString(k - (j - 1)) + " ";
          l++;
        } else {
          result += Integer.toString(j) + " ";
        }
      }

      result += '\n';
      k += 2;
      l = 1;
    }

    return result;
  }

  public String graphic6(byte lines) {
    String result = "";

    int k = 1;
    int l = 1;
    for (int i = 1; i <= lines; i++) {
      result += " ".repeat(((lines * 2) - (i * 2)));

      for (int j = 1; j <= k; j++) {
        int randomNumber = (int) Math.floor(Math.random() * 10);

        if (j == (int) Math.ceil((double) k / 2) + l) {
          result += Integer.toString(randomNumber) + " ";
          l++;
        } else {
          result += Integer.toString(randomNumber) + " ";
        }
      }

      result += '\n';
      k += 2;
      l = 1;
    }

    return result;
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
