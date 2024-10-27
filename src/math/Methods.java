package math;

public class Methods {
	public static void main(String[] args) {
		// 1.a Math.round
		double d1 = 4.3;
		double d2 = 4.6;
		double d3 = 157.9;
		System.out.println("Round 4.3: " + Math.round(d1));
		System.out.println("Round 4.6: " + Math.round(d2));
		System.out.println("Round 157.9: " + Math.round(d3) + "\n");

		// 1.b Math.ceil
		// Redondeo hacia arriba
		d1 = 1024.7;
		d2 = 10.3;
		d3 = -129.10;
		double d4 = -25.92;

		System.out.println("Round up 1024.7: " + (int) Math.ceil(d1));
		System.out.println("Round up 10.3: " + (int) Math.ceil(d2));
		System.out.println("Round up -129.10: " + (int) Math.ceil(d3));
		System.out.println("Round up -25.92: " + (int) Math.ceil(d4) + "\n");

		// 1.c Math.floor
		// Redondea hacia abajo
		d1 = 1024.7;
		d2 = 10.3;
		d3 = -129.10;
		d4 = -25.92;
		System.out.println("Round down 1024.7: " + (int) Math.floor(d1));
		System.out.println("Round down 10.3: " + (int) Math.floor(d2));
		System.out.println("Round down -129.10: " + (int) Math.floor(d3));
		System.out.println("Round down -25.92: " + (int) Math.floor(d4) + "\n");

		// 1.d 1.e Math.max i Math.min
		// Devuelve el máximo o el mínimo entre dos números
		d1 = 24.26;
		d2 = 24.75;
		System.out.println("Max: " + Math.max(d1, d2));
		System.out.println("Min: " + Math.min(d1, d2) + "\n");

		// 1.f Math.sqrt
		// Calcula la raiz cuadrada
		d1 = 1936;
		d2 = 16384;
		System.out.println("Square root 1936: " + Math.sqrt(d1));
		System.out.println("Square root 16384: " + Math.sqrt(d2) + "\n");

		// 1.g Math.log10
		// Devuelve el logaritmo en base 10
		d1 = 10.0;
		d2 = 100.0;
		d3 = 10000.25;
		System.out.println("Log10 10: " + Math.log10(d1));
		System.out.println("Log10 100: " + Math.log10(d2));
		System.out.println("Log10 10000.25: " + Math.log10(d3) + "\n");

		// 1.i Math.abs
		// Devuelve el valor absoluto de un número, es decir, convierte cualquier número
		// negativo en positivo y deja sin cambios los números positivos
		d1 = 35.26;
		d2 = -12.75;
		System.out.println("Abs 35.26: " + Math.abs(d1));
		System.out.println("Abs: -12.75 " + Math.abs(d2) + "\n");

		// 1.j Elije un número aleatorio entre el 1 y el 10
		// Opción 1
		int i1 = (int) (Math.random() * 10) + 1;
		System.out.println("Math.random 1 .. 10: " + i1);

		// Opción 2
		int d = (int) Math.ceil(Math.random() * 10 + 1);
		System.out.println("Math.random 1 .. 10: " + d);
	}
}
