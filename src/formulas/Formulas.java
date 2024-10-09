package formulas;

public class Formulas {
  public static void main(String[] args) {
    double a = 25.5;
    double b = 50.67;
    double c = 2;
    double d = 10.5;
    double e = -2.5;
    double f = 13.6;
    double g = 2.2;
    double h = Math.PI;
    double i = 33.3;
    double t = 90;
    double z = 45;

    // Formula 1
    double result = (Math.sqrt(a) + b / c) / (d - e / Math.pow(f, 2));
    System.out.println("Formula 1 = " + result);

    // Formula 2
    result = Math.pow(a, 2) / (b - c) + (d - e) / (f - g * h / i);
    System.out.println("Formula 2 = " + result);

    // Formula 3
    result = (Math.pow(a, 2) - Math.pow(b, 3) - 4) / (3 * c)
        * Math.sin(Math.toRadians(t))
        * Math.cos(Math.toRadians(z));

    System.out.println("Formula 3 = " + result);

    // Formula 4
    result = Math.pow(a + b, 2) / c - 3 * d / (e + f) -  Math.log10(7* g);
    System.out.println("Formula 4 = " + result);	
  }
}
