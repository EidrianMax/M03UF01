package join;

import java.util.Arrays;

public class Join {
  public static void main(String[] args) {
    double[] arrayA = { 10.5, 7.4, 20.1, 35.32, 60.67, 9.21, 3.4, 53.6, 17.3, 87.8 };
    double[] arrayB = { 12.6, 4.7, 1.31, 32.54, 60.4, 9.31, 134.0, 55.2, 12.2, 43.6, 3.6 };

    System.out.println("array1 = " + Arrays.toString(arrayA));
    System.out.println("array2 = " + Arrays.toString(arrayB) + "\n");
    
    double[] res = join(arrayA, arrayB);

    String arraString = "";
    for (int i = 0; i < res.length; i++) {
      if (i == 0)
        arraString += "{" + res[i] + ", ";
      else if (i == res.length - 1)
        arraString += res[i] + "}";
      else
        arraString += res[i] + ", ";
    }

    System.out.println("Using loop for: ");
    System.out.println(arraString + "\n");

    System.out.println("Using toString: ");
    System.out.println(Arrays.toString(res));
  }

  public static double[] join(double[] a, double[] b) {
    double[] res = new double[a.length + b.length];

    int count = 0;

    for (int i = 0; i < a.length; i++) {
      res[count] = a[i];
      count++;
    }

    for (int i = 0; i < b.length; i++) {
      res[count] = b[i];
      count++;
    }
    ;

    return res;
  }
}
