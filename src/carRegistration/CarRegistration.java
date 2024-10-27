package carRegistration;

import java.util.Scanner;

public class CarRegistration {
  public static void main(String[] args){
    CarRegistration cr = new CarRegistration();
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter Spanish car registration: ");
    String carRegistration = scanner.next();

    System.out.println("Number = " + cr.getNumber(carRegistration));
    System.out.println("Letters = " + cr.getLetters(carRegistration));

    System.out.print("Enter Spanish car registration 1: ");
    String carRegistration1 = scanner.next();

    System.out.print("Enter Spanish car registration 2: ");
    String carRegistration2 = scanner.next();

    System.out.println("Are the same? " + cr.compare(carRegistration1, carRegistration2));

    scanner.close();
  }
  
  public int getNumber(String str){
    String numbers = str.substring(0, 4);
    return Integer.parseInt(numbers);
  }

  public String getLetters(String str){
    return str.substring(4, 7).toUpperCase();
  }

  public boolean compare(String str1, String str2){
    return str1.equalsIgnoreCase(str2);
  }
}
