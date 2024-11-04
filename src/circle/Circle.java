package circle;

import java.util.Locale;
import java.util.Scanner;

public class Circle {
  public static void main(String args[]) {

		Scanner scanner = new Scanner(System.in);
		System.out.print("Choose your option: 1=perimeter, 2=area? ");

		int option = 0;
		if (scanner.hasNextInt()) {
			option = scanner.nextInt();
			scanner.useLocale(Locale.UK);
			if (option == 1 || option == 2) {
				System.out.print("Enter radius: ");
				float radius = 0;
				if (scanner.hasNextFloat()) {
					radius = scanner.nextFloat();

					System.out.println(option == 1 ? "Perimeter = " + round(perimeter(radius), 4)
							: "Area = " + round(area(radius), 4));
				} else {
					System.out.println("This is not a number");
				}
			} else {
				System.out.println("Option no valid!");
			}

		} else {

			System.out.println("This is not a number");
		}

		scanner.close();
	}

  public static double area(double radius){
    return Math.PI * Math.pow(radius, 2);
  }

  public static double perimeter(double radius){
    return (2 * Math.PI) * radius;
  }

  public static double round(double value, int decimals) {
    return Math.round(value * Math.pow(10, 2)) / Math.pow(10, 2);
  }
}
