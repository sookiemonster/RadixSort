public class Driver {
  public static void main(String[] args) {
    System.out.println("Nth Tests");
    System.out.println(Radix.nth(123,1));
    System.out.println(Radix.nth(-123,1));
    System.out.println(Radix.nth(123,2));
    System.out.println(Radix.nth(-123,2));

    System.out.println();
    System.out.println("Length Tests");
    lengthTest(10, 10000);
    System.out.println();
    System.out.println("Merge Tests");
    mergeTest(4, 100);
  }

  public static String randomNumber(int maxNum) {
    String randNum = "" + (int)(Math.random()*maxNum);
    return randNum;
  }

  public static void lengthTest(int tests, int maxNum) {
    for (int i = 0; i < tests; i++) {
      String temp = randomNumber(maxNum);
      System.out.println(temp + ": " + Radix.length(Integer.parseInt(temp)));
    }

    for (int i = 0; i < tests; i++) {
      String temp = "" + (-1 * Integer.parseInt(randomNumber(maxNum)));
      System.out.println(temp + ": " + Radix.length(Integer.parseInt(temp)));
    }
  }

  public static MyLinkedList randomList(int size, int maxNum) {
    MyLinkedList result = new MyLinkedList();
    for (int i = 0; i < size; i++) {
      result.add(randomNumber(maxNum));
    }
    return result;
  }

  public static void mergeTest(int size, int maxLength) {
    MyLinkedList a = randomList(size, maxLength);
    MyLinkedList[] arr = new MyLinkedList[4];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = (randomList(size, maxLength));
    }
    System.out.println("Original: ");
    System.out.println(a);
    System.out.println("Buckets: ");
    for (int i = 0; i < arr.length; i++) {
      System.out.println(arr[i]);
    }
    Radix.merge(a, arr);
    System.out.println(a);
  }
}
