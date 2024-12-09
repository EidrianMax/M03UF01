package sales;

public class Sales {
  public static void main(String[] args) {
    // Sales
    double[] sales = {
        // Week 0
        120.55, 255.12, 250.55, 150.55, 350.25, 2567.44, 2124.32,
        // Week 1
        245.10, 353.22, 340.45, 167.24, 376.34, 2665.25, 1253.32,
        // Week 2
        250.50, 432.12, 356.28, 176.87, 378.58, 2487.22, 1789.64,
        // Week 3
        235.75, 389.54, 309.52, 143.95, 366.76, 2764.55, 1250.22,
        // Week 4
        265.87, 443.33, 250.30, 220.10, 335.23, 1256.78, 2126.34,
        // Week 5
        244.54, 462.77, 445.15, 122.50, 337.76, 2157.31, 1524.15,
        // Week 6
        300.45, 125.65, 400.20, 150.75, 340.10, 2367.45, 1894.22,
        // Week 7
        220.35, 410.20, 200.80, 175.90, 370.50, 2754.12, 1956.30,
        // Week 8
        310.15, 190.25, 330.40, 160.70, 350.65, 2456.80, 2231.55,
        // Week 9
        285.90, 495.35, 150.25, 200.40, 300.25, 2956.25, 1754.20,
        // Week 10
        410.75, 125.90, 380.40, 155.60, 310.30, 2654.10, 1854.85,
        // Week 11
        295.55, 140.45, 290.60, 145.90, 365.25, 2356.45, 2178.40,
        // Week 12
        430.50, 150.80, 470.10, 170.90, 325.30, 2487.60, 1985.45,
        // Week 13
        250.75, 440.90, 240.85, 130.45, 375.20, 2654.75, 2054.35,
        // Week 14
        320.90, 180.50, 390.15, 155.30, 310.80, 2763.30, 2174.90,
        // Week 15
        435.25, 125.70, 450.40, 140.90, 350.60, 2500.55, 2956.25,
        // Week 16
        150.60, 350.80, 110.60, 190.75, 320.20, 2450.15, 1899.50,
        // Week 17
        210.90, 405.25, 250.35, 130.80, 340.70, 2750.30, 2154.80,
        // Week 18
        270.40, 185.50, 315.90, 145.25, 330.85, 2655.10, 1799.40,
        // Week 29
        300.75, 490.90, 250.80, 110.60, 380.95, 2250.45, 2001.85,
        // Week 20
        350.90, 190.20, 390.10, 170.50, 375.30, 2750.55, 1956.30,
        // Week 21
        320.10, 130.45, 295.75, 165.90, 355.80, 2450.70, 2175.90,
        // Week 22
        280.65, 175.35, 315.45, 110.60, 345.95, 2654.20, 1994.10,
        // Week 23
        430.55, 125.75, 445.35, 155.10, 320.40, 2356.85, 2178.25,
        // Week 24
        295.45, 400.15, 290.85, 135.90, 365.50, 2500.65, 1989.40,
        // Week 25
        240.70, 450.25, 250.30, 125.85, 300.25, 2950.10, 1765.30,
        // Week 26
        315.85, 185.45, 375.25, 165.30, 340.75, 2956.25, 2250.65,
        // Week 27
        275.90, 135.60, 300.40, 120.50, 345.10, 2750.40, 1956.20,
        // Week 28
        250.45, 480.60, 250.70, 140.90, 365.55, 2254.30, 2156.40,
        // Week 29
        325.40, 150.25, 330.60, 125.40, 360.95, 2550.65, 1998.70,
        // Week 30
        300.75, 405.40, 260.15, 110.60, 370.85, 2854.20, 1765.30,
        // Week 31
        340.55, 185.50, 395.75, 130.40, 350.10, 2650.85, 2254.75,
        // Week 32
        310.45, 195.85, 290.65, 145.60, 320.40, 2450.30, 2156.90,
        // Week 33
        295.65, 125.75, 445.30, 150.40, 310.85, 2950.10, 1800.25,
        // Week 34
        275.50, 350.80, 360.75, 125.10, 300.40, 2760.65, 1956.90,
        // Week 35
        315.90, 125.50, 310.45, 155.75, 375.65, 2500.50, 1998.75,
        // Week 36
        325.75, 450.60, 260.10, 130.45, 355.25, 2754.30, 2156.50,
        // Week 37
        345.55, 195.25, 310.75, 140.85, 380.95, 2650.85, 1899.40,
        // Week 38
        295.10, 185.75, 360.55, 125.40, 345.10, 2850.10, 2005.30,
        // Week 39
        320.75, 405.40, 290.50, 135.70, 355.85, 2765.40, 1854.20,
        // Week 40
        250.80, 125.60, 280.45, 145.80, 310.50, 2554.10, 2199.65,
        // Week 41
        315.10, 175.50, 330.75, 130.60, 340.40, 2500.40, 1954.40,
        // Week 42
        280.55, 490.80, 295.65, 155.40, 350.90, 2754.50, 1765.10,
        // Week 43
        305.30, 150.70, 370.85, 165.90, 360.40, 2654.30, 2178.45,
        // Week 44
        255.85, 195.45, 350.25, 125.40, 315.90, 2954.10, 1994.75,
        // Week 45
        280.65, 180.25, 300.50, 140.90, 365.25, 2956.25, 2178.20,
        // Week 46
        295.10, 150.60, 390.10, 110.75, 345.95, 2250.45, 2001.60,
        // Week 47
        325.30, 405.20, 340.85, 130.50, 375.25, 2650.85, 2154.20,
        // Week 48
        275.85, 140.75, 310.40, 155.10, 310.90, 2754.10, 2178.60,
        // Week 49
        300.60, 150.25, 380.55, 120.45, 340.40, 2850.25, 2956.25,
        // Week 50
        310.25, 175.85, 345.60, 135.70, 355.85, 2954.20, 2005.10,
        // Week 51
        295.75, 125.60, 290.85, 145.30, 310.90, 2125.55, 2019.25 };

    String str = String.format("%19s%10s%10s%10s%10s%10s%10s %n", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun");
    str += "-".repeat(79) + "\n";
    int week = 0;

    for (int i = 0; i < sales.length; i++) {
      if(i % 7 == 0) {
        String weekFormat = String.format("%02d", week);
        str += "Week " + weekFormat + ": ";
        week++;
      }

      str+= String.format("%10.2f", sales[i]);

      if(i == (week * 7) - 1){
        str += "\n";
      }
    }

    System.out.println(str);
  }
}
