public class Radix {
  public static int nth(int n, int col) {
    int place = (int)Math.pow(10, col + 1);
    return Math.abs((n % place) / (place / 10));
  }

  public static int length(int n) {
    n = Math.abs(n);
    if (n == 0) {
      return 1;
    }
    return (int)Math.floor(Math.log10(n)) + 1;
  }

  // public static void merge(MyLinkedList original, MyLinkedList[] buckets) {
  //
  // }
}
