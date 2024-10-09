package power;

public class Power {
  public static void main(String[] args){
    byte force = 125;
		byte distance = 37;
		byte time = 12;
		
    // No decimals
		int powerInt = force * distance / time;
		System.out.println("P (no decimals) = " + powerInt);

		// With decimals
		double timeWithDecimals = time;
		double powerDouble = force * distance / timeWithDecimals;
		System.out.println("P (with decimals) = " + powerDouble);
		
    // With two decimals
    // Para redondear a dos decimales utilizamos el metodo round
    // Multiplicamos el valor en decimales por 100 (si queremos más decimales agregamos más zeros al 100 como decimales queramos)
    // Y lo dividimos para 100
		double powerTwoDecimals = Math.round(powerDouble * 100) / 100.0;
		System.out.println("P (with 2 decimals) = " + powerTwoDecimals);
  }
}
