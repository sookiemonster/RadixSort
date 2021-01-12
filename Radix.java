public class Radix {
  public static int nth(int n, int col) {
    int place = (int)Math.pow(10, col + 1);
    return Math.abs((n % place) / (place / 10));
  }
}
