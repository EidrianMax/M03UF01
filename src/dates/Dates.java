package dates;

import java.util.Scanner;

public class Dates {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Dates dates = new Dates();

    System.out.print("***********************************************************\r\n" + //
        "* Date                                 © Adrian Alvarado  *\r\n" + //
        "*                                                         *\r\n" + //
        "* Program to check if the date is a valid date, the days  *\r\n" + //
        "* of a specific month or if the year is a leap year.      *\r\n" + //
        "***********************************************************\r\n" + //
        "\r\n" + //
        "MENU:\r\n" + //
        "1: Valid Date\r\n" + //
        "2: Days of Month\r\n" + //
        "3: Is Leap Year\r\n" + //
        "Choose your option: ");

    byte option = scanner.nextByte();

    byte d, m;
    short y;

    switch (option) {
      case 1:
        System.out.print("Enter the day: ");
        d = scanner.nextByte();

        System.out.print("Enter the month: ");
        m = scanner.nextByte();

        System.out.print("Enter the year: ");
        y = scanner.nextShort();

        String stringIsValidDate = dates.isValidDate(d, m, y) ? "is a valid date" : "is not a valid date";

        System.out.println(d + "/" + m + "/" + y + "/" + " " + stringIsValidDate);

        break;

      case 2:
        System.out.print("Enter the month: ");
        m = scanner.nextByte();

        System.out.print("Enter the year: ");
        y = scanner.nextShort();

        System.out.println("The number of days are: " + dates.daysOfMonth(m, y));

        break;

      case 3:
        System.out.print("Enter the year: ");
        y = scanner.nextShort();

        String stringIsLeapYear = dates.isLeapYear(y) ? "is a leap year" : "is not a leap year";
        System.out.println("Year " + y + stringIsLeapYear);

        break;

      default:
        System.out.println("This is not an option! Enter 1 or 3: ");

        break;
    }

    scanner.close();
  }

  public boolean isLeapYear(short y) {
    return y % 4 == 0 && y % 100 != 0 || y % 400 == 0;
  }

  public byte daysOfMonth(byte m, short y) {
    if (m < 1 || m > 12 || y < 1000 || y > 9999)
      return -1;
    if (m == 1 || m == 3 || m == 5 || m == 7 || m == 8 || m == 10 || m == 12)
      return 31;
    else if (m == 4 || m == 6 || m == 9 || m == 11)
      return 30;
    else if (m == 2 && !isLeapYear(y))
      return 28;
    else if (m == 2 && isLeapYear(y))
      return 29;
    else
      return -1;
  }

  public boolean isValidDate(byte d, byte m, short y) {
    return 1 <= d && d <= daysOfMonth(m, y);
  }
}
