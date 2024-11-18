package splitEvenOdd;

public class Split {
  public static void main(String[] args) {
    splitArray(null, false);
  }

  public static int[] splitArray(int[] data, boolean isEven){
    int countEven = 0;
    int countOdd = 0;
    int evenOrOdd = isEven ? 2 : 1;

    for (int i = 0; i < data.length; i++) {
      if(data[i] % evenOrOdd == 0){
        countEven++;
      } else {
        countOdd++;
      }
    }

    int[] res = new int[isEven ? countEven : countOdd];

    int resCount = 0;
    for (int i = 0; i < data.length; i++) {
      if(data[i] % evenOrOdd == 0){
        res[resCount] = data[i];
        resCount++;
      } else {
        res[resCount] = data[i];
        resCount++;
      }
    }

    return res;
  }
}
