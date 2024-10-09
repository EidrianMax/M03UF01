package relationals;

public class Relationals {
  public static void main(String[] args) {
    int x = 3;
    int y = 2;
    boolean b1 = false;
    boolean b2 = true;

    // Apartado 1
    int z = (x + 4 * y) % 3;

    // Explicación
    // 1. 4 * 2 = 8
    // 3 + 8 = 11
    // 11 % 3 = 2
    System.out.println("1. z = " + z);

    // Apartado 2
    boolean bool = ( x > y && !b1 ) || (x == y);

    // Explicación
    // (3 > 2 && !false) || (3 == 2)
    // (true && true) || (false)
    // true || false = true
    System.out.println("2. bool = " + bool);

    // Apartado 3
    int q = (( y + x / 2) % 2 ) * 5;

    // Explicación
    // ((2 + 3 / 2) % 2) * 5
    // ((2 + 1.5) % 2) * 5
    // (3.5 % 2) * 5
    // 1 * 5 = 5
    System.out.println("3. q = " + q);

    // Apartado 4
    boolean bool2 = b1 && ( x > 0 || !( y < 5 ));

    // Explicación
    // false && (3 > 0 || !(2 < 5))
    // false && (3 > 0 || !true)
    // false && (true || false)
    // false && true
    // false
    System.out.println("4. bool2 = " + bool2);

    // Apartado 5
    boolean bool3 = !(b1 && !b2);

    // Explicación
    // !(false && !true)
    // !(false && false)
    // !false
    // true
    System.out.println("5. bool3 = " + bool3);

    // Apartado 6
    boolean bool4 = b1 && b2 || x > y / 2;

    // Explicación
    // false && true || 3 > 2 / 2
    // false && true || 3 > 1
    // false || true
    // true
    System.out.println("6. bool4 = " + bool4);

    // Apartado 7
    int amount = 20;
    System.out.println(amount >= 15 && amount < 100);

    amount = 10;
		// El resultado es FALSE
		System.out.println("15" + (amount >= 10 && amount < 100));
		
		amount = 15;
		// El resultado es TRUE		
		System.out.println("15" + (amount >= 15 && amount < 100));
		
		
		amount = 100;
		// El resultado es FALSE
		System.out.println(amount >= 15 && amount < 100);
		
		amount = 500;
		// El resultado es FALSE
		System.out.println(amount >= 15 && amount < 100);
  }
}
