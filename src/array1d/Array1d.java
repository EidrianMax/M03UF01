/*
* Array1d.java Nov 11, 2024
*
*
* ©Copyright 2024 Adrian Alvarado a243469aa@correu.escoladeltreball.org
*
* This is free software, licensed under the GNU General Public License v3.
* See http://www.gnu.org/licenses/gpl.html for more information.
*/
package array1d;

import java.util.Scanner;

public class Array1d {
	public static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		byte option = menu();
		
		switch (option) {
		case 1:
			int amount = dataEntryInt("Enter number of items: ");
			
			double[] dades = new double[amount];
			
			dataEntry(dades);
			
			System.out.println();
			
			for (int i = 0; i < dades.length; i++) {
				System.out.println("[" + i + "]" + " = " + dades[i]);
			}
			
			System.out.println();
			
			System.out.println("Total addition = " + sumArray(dades));
			System.out.println("Max value = " + arrayMaxValue(dades));
			System.out.println("Mean value = " + meanArray(dades));
			System.out.printf("Percentage greater than mean = %.2f", percentageGreaterThanMean(dades));
			break;

		case 0:
			System.out.println("Bye!");
			break;
		}
	}

	public static byte menu() {
		System.out.println("MENU");
		System.out.println("1. Run Program");
		System.out.println("0. Quit");
		return dataEntryByteMinMax("Choose menu option: ", (byte) 0, (byte) 1);
	}

	
	
	public static void dataEntry(double[] dades) {
		for(int i = 0; i < dades.length; i++) {
			dades[i] = dataEntryDouble("Enter numbers[" + i +"]: ");
		}
	}
	
	public static void printData(double[] data) {
		for(int i = 0; i < data.length; i++) {
			System.out.println("[" + i + "] = " + data[i]);
		}
	}
	
	public static double sumArray(double[] x) {
		double total = 0;
		
		for (int i = 0; i < x.length; i++) {
			total += x[i];
		}
		
		return total;
	}
	
	public static double arrayMaxValue(double[] dades) {
		double max = dades[0];
		
		for (int i = 0; i < dades.length; i++) {
			if(dades[i] > max) {
				max = dades[i];
			}
		}
		
		return max;
	}
	
	public static double meanArray(double[] x) {
		return sumArray(x) / x.length;
	}
	
	public static double percentageGreaterThanMean(double[] x) {
		double mean = meanArray(x);
		int count = 0;
		
		for (int i = 0; i < x.length; i++) {
			if(x[i] > mean) count++;
		}

		return (count * 100) / x.length;
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
	
	public static int dataEntryInt(String text) {
        int number = 0;
        System.out.print(text);
        boolean isValid = false;
        while (!isValid) {
            if (scanner.hasNextInt()) {
                number = scanner.nextInt();
                isValid = true;
            } else {
                scanner.next();  //Consume scanner 
                System.err.println("Error! " + text);
            }
        }
        return number;
    }
	
	public static double dataEntryDouble(String text) {
        double number = 0;
        System.out.print(text);
        boolean isValid = false;
        while (!isValid) {
            if (scanner.hasNextDouble()) {
                number = scanner.nextDouble();
                isValid = true;
            } else {
                scanner.next();  //Consume scanner 
                System.err.println("Error! " + text);
            }
        }
        return number;
    }
}