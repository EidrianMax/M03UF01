package triangles;

import java.util.Scanner;

public class Triangles {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Triangles triangles = new Triangles();

    System.out.print("Enter side a: ");
    double a = scanner.nextDouble();

    System.out.print("Enter side b: ");
    double b = scanner.nextDouble();

    System.out.print("Enter side c: ");
    double c = scanner.nextDouble();

    System.out.println("Type: " + triangles.typeOfTriangle(a, b, c));
    System.out.println("Area: " + triangles.round(triangles.area(a, b, c), 4));
    System.out.println("Perimetre: " + triangles.perimeter(a, b, c));
    System.out.println("Angle A = " + triangles.round(triangles.angleA(a, b, c), 4));
    System.out.println("Angle B = " + triangles.round(triangles.angleB(a, b, c), 4));
    System.out.println("Angle C = " + triangles.round(triangles.angleC(a, b, c), 4));
    System.out.println("Height A = " + triangles.round(triangles.heightA(a, b, c), 4));
    System.out.println("Height B = " + triangles.round(triangles.heightB(a, b, c), 4));
    System.out.println("Height C = " + triangles.round(triangles.heightC(a, b, c), 4));
    System.out.println("Type by angle = " + triangles.typeOfTriangleByAngles(a, b, c));
    System.out.println("Median A = " + triangles.round(triangles.medianA(a, b, c), 4));
    System.out.println("Median B = " + triangles.round(triangles.medianB(a, b, c), 4));
    System.out.println("Median C = " + triangles.round(triangles.medianC(a, b, c), 4));
    System.out.println("Inradius = " + triangles.round(triangles.inradius(a, b, c), 4));
    System.out.println("Circumradius = " + triangles.round(triangles.circumradius(a, b, c), 4));

    scanner.close();
  }

  public boolean isTriangle(double a, double b, double c) {
    return a + b > c && a + c > b && b + c > a;
  }

  public String typeOfTriangle(double a, double b, double c) {
    if (!isTriangle(a, b, c))
      return "ERROR";
    else if (a == b && c == a)
      return "EQUILATER";
    else if (a == b || b == c || c == a)
      return "ISOSCELES";
    else if (a != b && c != a)
      return "ESCALEN";
    else
      return "ERROR";
  }

  public double perimeter(double a, double b, double c) {
    return a + b + c;
  }

  public double semiperimeter(double a, double b, double c) {
    return perimeter(a, b, c) / 2;
  }

  public double area(double a, double b, double c) {
    String typeOfTriangle = typeOfTriangle(a, b, c);
    double semiperimeter = semiperimeter(a, b, c);

    if (typeOfTriangle == "EQUILATER")
      return Math.sqrt(3) * Math.pow(a, 2) / 4;

    else if (typeOfTriangle == "ISOSCELES")
      if (a == b)
        return c * Math.sqrt(Math.pow(a, 2) - Math.pow(c, 2) / 4) / 2;
      else if (a == c)
        return b * Math.sqrt(Math.pow(a, 2) - Math.pow(b, 2) / 4) / 2;
      else
        return a * Math.sqrt(Math.pow(b, 2) - Math.pow(a, 2) / 4) / 2;

    else if (typeOfTriangle == "ESCALEN")
      return Math.sqrt(semiperimeter * (semiperimeter - a) * (semiperimeter - b) * (semiperimeter - c));

    else
      return -1;
  }

  public double angleA(double a, double b, double c) {
    return Math.acos((Math.pow(b, 2) + Math.pow(c, 2) - Math.pow(a, 2)) / (2 * b * c)) * 180 / Math.PI;
  }

  public double angleB(double a, double b, double c) {
    return Math.acos((Math.pow(a, 2) + Math.pow(c, 2) - Math.pow(b, 2)) / (2 * a * c)) * 180 / Math.PI;
  }

  public double angleC(double a, double b, double c) {
    return Math.acos((Math.pow(a, 2) + Math.pow(b, 2) - Math.pow(c, 2)) / (2 * a * b)) * 180 / Math.PI;
  }

  public String typeOfTriangleByAngles(double a, double b, double c) {
    double angleA = angleA(a, b, c);
    double angleB = angleB(a, b, c);
    double angleC = angleC(a, b, c);

    if (angleA < 90 && angleB < 90 && angleC < 90)
      return "ACUTE";
    else if (angleA == 90 || angleB == 90 || angleC == 90)
      return "RIGHT";
    else
      return "OBTUSE";
  }

  public double heightA(double a, double b, double c) {
    return 2 * area(a, b, c) / a;
  }

  public double heightB(double a, double b, double c) {
    return 2 * area(a, b, c) / b;
  }

  public double heightC(double a, double b, double c) {
    return 2 * area(a, b, c) / c;
  }

  public double medianA(double a, double b, double c) {
    return Math.sqrt(2 * Math.pow(b, 2) + 2 * Math.pow(c, 2) - Math.pow(a, 2)) / 2;
  }

  public double medianB(double a, double b, double c) {
    return Math.sqrt(2 * Math.pow(a, 2) + 2 * Math.pow(c, 2) - Math.pow(b, 2)) / 2;
  }

  public double medianC(double a, double b, double c) {
    return Math.sqrt(2 * Math.pow(a, 2) + 2 * Math.pow(b, 2) - Math.pow(c, 2)) / 2;
  }

  public double inradius(double a, double b, double c) {
    return area(a, b, c) / semiperimeter(a, b, c);
  }

  public double circumradius(double a, double b, double c) {
    return a * b * c / (4 * inradius(a, b, c) * semiperimeter(a, b, c));
  }

  public double round(double num, int dec) {
		return Math.round(num * Math.pow(10, dec)) / Math.pow(10, dec);
	}
}
