package format;

public class FormatTable {
  public static void main(String[] args) {
    String article1 = "T-Shirt Red";
    String article2 = "Cap Green";
    String article3 = "Leather Wallet";
    String article4 = "Blue Jacket";
    String article5 = "Leather Jacket";

    float price1 = 33.54567f;
    float price2 = 22.2234f;
    float price3 = 15.3573f;
    float price4 = 67.1567f;
    float price5 = 129.321f;

    int quantity1 = 2;
    int quantity2 = 5;
    int quantity3 = 3;
    int quantity4 = 4;
    int quantity5 = 7;

    float total1 = price1 * quantity1;
		float total2 = price2 * quantity2;
		float total3 = price3 * quantity3;
		float total4 = price4 * quantity4;
		float total5 = price5 * quantity5;

    // Only in console
    // System.out.println("-".repeat(55));
    // System.out.printf("|%-20S|%-10S|%-10S|%-10S|%n", "article", "price", "quantity", "total");
    // System.out.println("-".repeat(55));
    // System.out.printf("|%-20S|%8.2f \u20AC|%10d|%8.2f \u20AC|%n", article1, price1, quantity1, total1);
    // System.out.printf("|%-20S|%8.2f \u20AC|%10d|%8.2f \u20AC|%n", article2, price2, quantity2, total2);
    // System.out.printf("|%-20S|%8.2f \u20AC|%10d|%8.2f \u20AC|%n", article3, price3, quantity3, total3);
    // System.out.printf("|%-20S|%8.2f \u20AC|%10d|%8.2f \u20AC|%n", article4, price4, quantity4, total4);
    // System.out.printf("|%-20S|%8.2f \u20AC|%10d|%8.2f \u20AC|%n", article5, price5, quantity5, total5);
    // System.out.println("-".repeat(55));
    // System.out.println("€");

    // Save in string and show in console
    String text = "-".repeat(55) + System.lineSeparator();
		text += String.format("|%-20S|%-10S|%-10S|%-10S|%n", "article", "price", "quantity", "total");

		text += "-".repeat(55) + "\n";

		text += String.format("|%-20S|%8.2f €|%10d|%8.2f €|%n", article1, price1, quantity1, total1);
		text += String.format("|%-20S|%8.2f €|%10d|%8.2f €|%n", article2, price2, quantity2, total2);
		text += String.format("|%-20S|%8.2f €|%10d|%8.2f €|%n", article3, price3, quantity3, total3);
		text += String.format("|%-20S|%8.2f €|%10d|%8.2f €|%n", article4, price4, quantity4, total4);
		text += String.format("|%-20S|%8.2f €|%10d|%8.2f €|%n", article5, price5, quantity5, total5);

		text += "-".repeat(55);
		
		System.out.println(text);
  }
}
