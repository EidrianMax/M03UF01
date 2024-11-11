/*
* SevenHalfGame.java Nov 8, 2024
*
*
* ©Copyright 2024 Adrian Alvarado a243469aa@correu.escoladeltreball.org
*
* This is free software, licensed under the GNU General Public License v3.
* See http://www.gnu.org/licenses/gpl.html for more information.
*/
package sevenHalfGame;

import java.util.Scanner;

public class SevenHalfGame {

  public static Scanner scanner = new Scanner(System.in);
  public static boolean isChangeBet = false;
  public static int valueToBet = 0;

  public static void main(String[] args) {
    SevenHalfGame game = new SevenHalfGame();

    // player
    int moneyPlayer = 0;
    byte currentPlayerCard = 0;
    float currentPlayerPoints = 0;
    float totalPlayerPoints = 0;

    // bank
    int moneyBank = 0;
    byte currentBankCard = 0;
    float currentBankPoints = 0;
    float totalBankPoints = 0;

    // player and bank
    byte turns = 0;

    boolean isEndGame = false;
    boolean isStand = false;

    System.out.println("************************************************************************\r\n" + //
        "* 7 1/2  Seven Half Game                           © Adrian Alvarado   *\r\n" + //
        "*                                                                      *\r\n" + //
        "* The player competes against the BANK.                                *\r\n" + //
        "* The goal of this game is to score seven and a half or a close number *\r\n" + //
        "* without exceeding.                                                   *\r\n" + //
        "* If the player gets more than 7 and 1/2, the BANK automatically wins. *\r\n" + //
        "* If the player gets less than 7 and 1/2, the BANK plays.              *\r\n" + //
        "* The BANK will always try to get more or equal than the player.       *\r\n" + //
        "* If the BANK gets the same, then the BANK wins.                       *\r\n" + //
        "* The value of cards from 1 through 7 are their actual value.          *\r\n" + //
        "* and the value of cards from 8 through 12 are 1/2.                    *\r\n" + //
        "************************************************************************");

    System.out.print("Enter money Player: ");
    moneyPlayer = scanner.nextInt();

    System.out.print("Enter money Bank: ");
    moneyBank = scanner.nextInt();

    System.err.print("Enter bet: ");
    valueToBet = scanner.nextInt();

    while (!isEndGame) {
      System.out.println();
      byte option = menu1();

      switch (option) {
        case 1:
          totalPlayerPoints = 0;
          totalBankPoints = 0;
          turns = 0;
          isStand = false;

          currentPlayerCard = game.randomCard();
          currentPlayerPoints = game.value(currentPlayerCard);
          totalPlayerPoints += currentPlayerPoints;
          currentBankCard = game.randomCard();
          currentBankPoints = game.value(currentBankCard);
          totalBankPoints += currentBankPoints;
          turns += 1;

          System.out.println("PLAYER: card " + turns + ": " + currentPlayerCard + " - Points: " + currentPlayerPoints);

          while (!isStand) {
            System.out.println();
            byte option2 = menu2();

            switch (option2) {
              case 1:
                currentPlayerCard = game.randomCard();
                currentPlayerPoints = game.value(currentPlayerCard);
                totalPlayerPoints += currentPlayerPoints;
                currentBankCard = game.randomCard();
                currentBankPoints = game.value(currentBankCard);
                totalBankPoints += currentBankPoints;
                turns += 1;

                System.out
                    .println("PLAYER: card " + turns + ": " + currentPlayerCard + " - Points: " + currentPlayerPoints);
                System.out.println("Total: " + totalPlayerPoints);

                break;
              case 2:
                System.out.println("BANK: card " + turns + ": " + currentBankCard + " - Points: " + currentBankPoints
                    + " - Totals: " + totalBankPoints);
                System.out.println();

                String winner = game.winner(totalPlayerPoints, totalBankPoints);

                if (winner.equals("Player")) {
                  moneyPlayer += valueToBet;
                  moneyBank -= valueToBet;
                } else {
                  moneyBank += valueToBet;
                  moneyPlayer -= valueToBet;
                }

                System.out.println("THE WINNER IS: " + winner);
                System.out.println("MONEY PLAYER: " + moneyPlayer);
                System.out.println("MONEY BANK: " + moneyBank);
                isStand = true;
                isChangeBet = true;
            }
          }

          break;

        case 0:
          System.out.println();
          System.out.println("BYE!");
          System.out.println("THE END");
          isEndGame = true;
          break;
      }
    }
  }

  public static byte menu1() {
    System.out.println("MENU 1");
    if (isChangeBet) {
      byte betOption = dataEntryByteMinMax("Do you want to change the bet: 1. YES, 2. NO: ", (byte) 1, (byte) 2);

      if (betOption == 1) {
        System.out.print("Enter bet: ");
        valueToBet = scanner.nextInt();
      }
    }
    System.out.println();
    System.out.println("1. PLAY, 0. QUIT");
    return dataEntryByteMinMax("CHOOSE MENU OPTION: ", (byte) 0, (byte) 1);
  }

  public static byte menu2() {
    System.out.println("MENU 2");
    System.out.println("1. ONE CARD MORE, 2. STAND");
    return dataEntryByteMinMax("CHOOSE MENU OPTION: ", (byte) 1, (byte) 2);
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

  public byte randomCard() {
    return (byte) Math.floor(Math.random() * 48);
  }

  public float value(byte randomCard) {
    byte number = (byte) (randomCard % 12);

    return number > 7 || number == 0 ? 0.5f : number;
  }

  public String winner(float player, float bank) {
    if (player > 7.5f || bank == player || bank > player)
      return "Bank";
    else
      return "Player";
  }
}
