package slotMachine;

import java.util.Scanner;

public class SlotMachine {
  public static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    float moneyMachine = 1000.00f;
    float bet = 25.00f;
    byte turns = 0;
    boolean isEndGame = false;

    float moneyUser = dataEntryFloat("Enter money of the user: ");

    while (!isEndGame) {
      System.out.println();
      byte option = menu();

      switch (option) {
        case 1:
          turns++;
          byte randomFruit1 = randomFruit();
          byte randomFruit2 = randomFruit();
          byte randomFruit3 = randomFruit();
          String fruit1 = figure(randomFruit1);
          String fruit2 = figure(randomFruit2);
          String fruit3 = figure(randomFruit3);
          String resultFruits = result(randomFruit1, randomFruit2, randomFruit3);

          System.out.println("Result" + "[" + turns + "]: " + fruit1 + "\t" + fruit2 + "\t" + fruit3);
          System.out.println(resultFruits + " -> " + prize(bet, resultFruits));

          if (resultFruits.equals("YOU HAVE LOST!!")) {
            moneyUser -= bet;
            moneyMachine += bet;
          } else {
            moneyUser += bet;
            moneyMachine -= bet;
          }

          System.out.println("Money User: " + moneyUser);
          System.out.println("Money machine: " + moneyMachine);

          if(bet > moneyUser){
            System.out.println();
            System.out.println("SORRY!");
            System.out.println("YOU DON'T HAVE ENOUGH MONEY TO BET!!");
            System.out.println("BYE!!");
            isEndGame = true;
          }

          if(moneyMachine <= 0){
            System.out.println();
            System.out.println("THE MACHINE IS EMPTY, TRY IN ANOTHER MACHINE");
            System.out.println("BYE!!");
            isEndGame = true;
          }

          break;

        default:
          System.out.println("BYE!!");
          isEndGame = true;
          break;
      }

    }

  }

  public static byte menu() {
    return dataEntryByteMinMax("MENU: 1. Play / 0. Quit. Choose option: ", (byte) 0, (byte) 1);
  }

  public static byte randomFruit() {
    byte randomNumber = (byte) Math.floor(Math.random() * 6 + 1);

    if (randomNumber >= 6) {
      randomNumber = (byte) Math.floor(Math.random() * 6);
    }

    return randomNumber;
  }

  public static String figure(byte randomFruit) {
    if (randomFruit == 1)
      return "STRAWBERRY";
    else if (randomFruit == 2)
      return "BANANA";
    else if (randomFruit == 3)
      return "APPLE";
    else if (randomFruit == 4)
      return "LEMON";
    else if (randomFruit == 5)
      return "WATERMELON";
    else if (randomFruit == 6)
      return "STAR";
    else
      return "ERROR";
  }

  public static boolean isTwoFruits(byte fruit1, byte fruit2, byte fruit3) {
    if (fruit1 >= 1 && fruit1 <= 5 && fruit2 >= 1 && fruit2 <= 5 && fruit1 == fruit2 && fruit3 <= 5)
      return true;
    else if (fruit2 >= 1 && fruit2 <= 5 && fruit3 >= 1 && fruit3 <= 5 && fruit2 == fruit3 && fruit1 <= 5)
      return true;
    else if (fruit3 >= 1 && fruit3 <= 5 && fruit1 >= 1 && fruit1 <= 5 && fruit3 == fruit1 && fruit2 <= 5)
      return true;
    else
      return false;
  }

  public static boolean isTwoFruitsOneStar(byte fruit1, byte fruit2, byte fruit3) {
    if (fruit1 >= 1 && fruit1 <= 5 && fruit2 >= 1 && fruit2 <= 5 && fruit1 == fruit2 && fruit3 > 5)
      return true;
    else if (fruit2 >= 1 && fruit2 <= 5 && fruit3 >= 1 && fruit3 <= 5 && fruit2 == fruit3 && fruit1 > 5)
      return true;
    else if (fruit3 >= 1 && fruit3 <= 5 && fruit1 >= 1 && fruit1 <= 5 && fruit3 == fruit1 && fruit2 > 5)
      return true;
    else
      return false;
  }

  public static boolean isThreeFruits(byte fruit1, byte fruit2, byte fruit3) {
    return (fruit1 >= 1 && fruit1 <= 5) && (fruit2 >= 1 && fruit2 <= 5) && (fruit3 >= 1 && fruit3 <= 5)
        && (fruit1 == fruit2 && fruit2 == fruit3);
  }

  public static boolean isTwoStars(byte fruit1, byte fruit2, byte fruit3) {
    return (fruit1 == 6 && fruit2 == 6 && fruit3 < 6) || (fruit2 == 6 && fruit3 == 6 && fruit1 < 6)
        || (fruit1 == 6 && fruit3 == 6 && fruit2 < 6);
  }

  public static boolean isThreeStars(byte fruit1, byte fruit2, byte fruit3) {
    return fruit1 == 6 && fruit2 == 6 && fruit3 == 6;
  }

  public static String result(byte fruit1, byte fruit2, byte fruit3) {
    if (isTwoFruits(fruit1, fruit2, fruit3))
      return "TWO FRUITS";
    else if (isThreeFruits(fruit1, fruit2, fruit3))
      return "THREE FRUITS";
    else if (isTwoFruitsOneStar(fruit1, fruit2, fruit3))
      return "TWO FRUITS ONE STAR";
    else if (isTwoStars(fruit1, fruit2, fruit3))
      return "TWO STARS";
    else if (isThreeStars(fruit1, fruit2, fruit3))
      return "THREE STARS";
    else
      return "YOU HAVE LOST!!";
  }

  public static float prize(float bet, String result) {
    switch (result) {
      case "TWO FRUITS":
        return bet;

      case "TWO FRUITS ONE STAR":
        return bet * 3;

      case "TWO STARS":

        return bet * 4;

      case "THREE FRUITS":

        return bet * 5;

      case "THREE STARS":

        return bet * 11;

      default:
        return 0;
    }
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

  public static float dataEntryFloat(String text) {
    float number = 0;
    System.out.print(text);
    boolean isValid = false;
    while (!isValid) {
      if (scanner.hasNextFloat()) {
        number = scanner.nextFloat();
        isValid = true;
      } else {
        scanner.next(); // Consume scanner
        System.err.print("Error! " + text);
      }
    }
    return number;
  }
}
