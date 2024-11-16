/*
* SumFirstElements.java Nov 15, 2024
*
*
* ©Copyright 2024 Adrian Alvarado a243469aa@correu.escoladeltreball.org
*
* This is free software, licensed under the GNU General Public License v3.
* See http://www.gnu.org/licenses/gpl.html for more information.
*/
package sumFirstElements;

import java.util.Scanner;

public class SumFirstElements {
	public static final Scanner scanner = new Scanner(System.in);
	public static final SumFirstElements sfe = new SumFirstElements();
	public static void main(String[] args) {
		byte option = sfe.menu();
		
		switch (option) {
		case 1:
			byte numItems = dataEntryByte("Enter number of items: ");
			double[] dades = new double[numItems];
			
			sfe.dataEntry(dades);
			
			byte limit = dataEntryByte("The number of the first numbers to add: ");
			
			System.out.println("The sum of the " + limit + " first numbers = " + sfe.sumFirstElements(dades, limit));
			break;

		default:
			break;
		}
	}
	
	public double sumFirstElements(double[] dades, int limit) {
		double total = 0;
    int subLimit = limit > dades.length ? dades.length : limit; 
		
		for (int i = 0; i < subLimit; i++) {
			total += dades[i];
		}
		
		return total;
	}

	public byte menu() {
		System.out.println("MENU");
		System.out.println("1. Run Program");
		System.out.println("0. Quit");
		return dataEntryByte("Choose menu option: ");
	}

	public void dataEntry(double[] dades) {
		for (int i = 0; i < dades.length; i++) {
			dades[i] = dataEntryDouble("Enter numbers[" + i + "]: ");
		}
	}

	public double dataEntryDouble(String text) {
		double number = 0;
		System.out.print(text);
		boolean isValid = false;
		while (!isValid) {
			if (scanner.hasNextDouble()) {
				number = scanner.nextDouble();
				isValid = true;
			} else {
				scanner.next(); // Consume scanner
				System.err.println("Error! " + text);
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