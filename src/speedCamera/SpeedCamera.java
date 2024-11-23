package speedCamera;

import java.util.Scanner;

public class SpeedCamera {
  public static final Scanner scanner = new Scanner(System.in); 
  public static void main(String[] args) {
    byte option = menu();

    switch (option) {
      case 1:
        
        break;
    
      default:
        break;
    }
  }

  public int speed(int distanceMeters, int durationSeconds){
    double distanceKm = distanceMeters * 1000.0;
    double durationHours = durationSeconds * 3600.0;

    return (int) (distanceKm / durationHours);
  }

  public boolean isFine(int distanceMeters, int durationSeconds, byte maxSpeed){
    int speed = speed(distanceMeters, durationSeconds);

    if(speed > maxSpeed)
      return true;
    else
      return false;
  }

  public int fine(int distanceMeters, int durationSeconds, byte maxSpeed){
    int speed = speed(distanceMeters, durationSeconds);

    if(speed > maxSpeed && speed < maxSpeed + 30)
      return 100;
    else if(speed > maxSpeed + 30)
      return 300;
    else if(speed > maxSpeed + 50)
      return 400;
    else if(speed > maxSpeed + 60 && speed < maxSpeed + 70)
      return 500;
    else
      return 600;
  }

  public byte points(int distanceMeters, int durationSeconds, byte maxSpeed){
    int speed = speed(distanceMeters, durationSeconds);

    if(speed > maxSpeed && speed < maxSpeed + 30)
      return 0;
    else if(speed > maxSpeed + 30)
      return 2;
    else if(speed > maxSpeed + 50)
      return 4;
    else if(speed > maxSpeed + 60 && speed < maxSpeed + 70)
      return 6;
    else
      return 6;
  }

  public static byte menu() {
    System.out.println("Menu");
    return dataEntryByte("1: Speed\r\n" + //
            "2: IsFine\r\n" + //
            "3: Fine\r\n" + //
            "4: Points\r\n" + //
            "Choose menu option: ");
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
