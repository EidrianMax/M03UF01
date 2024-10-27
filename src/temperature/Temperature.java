package temperature;

import java.util.Scanner;

public class Temperature {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Temperature tp = new Temperature();

    System.out.print("Enter the degrees in Celsius: ");
    float celsius = scanner.nextFloat();
    System.out.println("The degrees in Fahrenheits is: " + tp.c2f(celsius) + "ºF");

    System.out.print("Enter the degrees in Fahrenheit: ");
    float fahrenheit = scanner.nextFloat();
    System.out.println("The degrees in Celsius is: " + tp.f2c(fahrenheit) + "ºC");

    scanner.close();
  }

  public float c2f(float c){
    return 9 * c / 5 + 32;
  }

  public float f2c(float f){
    return  (f - 32) * 5 / 9;
  }

  public static double round(double num, byte dec) {
		return Math.round(num * Math.pow(10, dec)) / Math.pow(10, dec);
	}
}
