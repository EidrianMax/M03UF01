/*
* Covid.java Nov 22, 2024
*
*
* ©Copyright 2024 Adrian Alvarado a243469aa@correu.escoladeltreball.org
*
* This is free software, licensed under the GNU General Public License v3.
* See http://www.gnu.org/licenses/gpl.html for more information.
*/
package covid;

import java.util.Arrays;
import java.util.Scanner;

public class Covid {
  public static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    int[][] covidCases = { { 54, 57, 71, 191, 225, 323, 433 }, { 764, 982, 1146, 1472, 1720, 2126, 1729 },
        { 2488, 3698, 4040, 5184, 4877, 7646, 8544 }, { 8945, 9195, 8263, 6140, 5642, 8146, 6041 },
        { 5802, 7654, 6765, 5654, 3467, 5277, 7647 }, { 5675, 4345, 3234, 4532, 3567, 3756, 3243 },
        { 2578, 3089, 2987, 2867, 2433, 3222, 3433 }, { 2133, 2111, 1567, 1322, 1211, 1089, 899 },
        { 677, 566, 454, 454, 478, 686, 544 } };

    byte option = menu();
    int week = 0;
    int dayOfWeek = 0;

    switch (option) {
      case 1:
        week = dataEntryByte("Enter week: ");
        dayOfWeek = dataEntryByte("Enter day of week: ");

        System.out.println("1. Number of cases a day of a week: " + numberfCases(covidCases, dayOfWeek, week));
        break;

      case 2:
        week = dataEntryByteMinMax("Cases per week. Enter week 1...9: ", (byte) 1, (byte) 9);

        System.out.println("2. Number of cases per week: " + casesPerWeek(covidCases, week));
        break;

      case 3:
        System.out.println("3. Total cases: " + totalCases(covidCases));

        break;

      case 4:
        System.out.println("4. Total average: " + totalAverage(covidCases));

        break;

      case 5:
        System.out.println("5. Array total weeks: " + Arrays.toString(arrayTotalPerWeek(covidCases)));

        break;

      case 6:
        System.out.println("6. Average per week: " + Arrays.toString(arrayAveragePerWeek(covidCases)));

        break;

      case 7:
        System.out.println("7. Max value every week: " + Arrays.toString(arrayMaxValueaxValuePerWeek(covidCases)));

        break;
      
      case 0:
        System.out.println("Bye!");

      default:
        System.out.println("Wrong entry");

        break;
    }
  }

  public static int numberfCases(int[][] m, int dayOfWeek, int week) {
    int total = 0;

    for (int i = 0; i < m.length; i++) {
      for (int j = 0; j < m[i].length; j++) {
        if (dayOfWeek == j && week == i)
          total = m[i][j];
      }
    }

    return total;
  }

  public static int casesPerWeek(int[][] m, int week) {
    int totalByWeek = 0;

    for (int i = 0; i < m[week].length; i++) {
      totalByWeek += m[week][i];
    }

    return totalByWeek;
  }

  public static int totalCases(int[][] m) {
    int total = 0;

    for (int i = 0; i < m.length; i++) {
      for (int j = 0; j < m[i].length; j++) {
        total += m[i][j];
      }
    }

    return total;
  }

  public static double totalAverage(int[][] m) {
    int totalCases = totalCases(m);
    int totalDays = 0;

    for (int i = 0; i < m.length; i++) {
      totalDays += m[i].length;
    }

    return totalCases / totalDays;
  }

  public static int[] arrayTotalPerWeek(int[][] m) {
    int[] arrayTotalByWeek = new int[m.length];

    for (int i = 0; i < m.length; i++) {
      int totalByWeek = 0;

      for (int j = 0; j < m[i].length; j++) {
        totalByWeek += m[i][j];
      }

      arrayTotalByWeek[i] = totalByWeek;
    }

    return arrayTotalByWeek;
  }

  public static int[] arrayAveragePerWeek(int[][] m) {
    int[] arr = new int[m.length];

    for (int i = 0; i < arr.length; i++) {
      arr[i] = casesPerWeek(m, i) / m[i].length;
    }

    return arr;
  }

  public static int[] arrayMaxValueaxValuePerWeek(int[][] m) {
    int arr[] = new int[m.length];

    for (int i = 0; i < m.length; i++) {
      int maxByWeek = Integer.MIN_VALUE;

      for (int j = 0; j < m[i].length; j++) {
        if (m[i][j] > maxByWeek)
          maxByWeek = m[i][j];
      }

      arr[i] = maxByWeek;
    }

    return arr;
  }

  public static byte menu() {
    System.out.println("MENU:\n" + "1. Consult a day\n" + "2. Number Of cases per week\n" + "3. Total cases\n"
        + "4. Total average\n" + "5. Get total for every week\n" + "6. Get average for every week\n"
        + "7. Get max value for every week\n" + "0. Quit");
    return dataEntryByteMinMax("Enter your option: ", (byte) 0, (byte) 7);
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