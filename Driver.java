import java.util.*;

public class Driver {
  public static void main(String[] args) {
    // System.out.println("Nth Tests");
    // System.out.println(Radix.nth(123,1));
    // System.out.println(Radix.nth(-123,1));
    // System.out.println(Radix.nth(123,2));
    // System.out.println(Radix.nth(-123,2));
    // System.out.println(Radix.nth(123,3));
    // System.out.println(Radix.nth(-123,4));
    // System.out.println(Radix.nth(-123,0));
    //
    //
    // System.out.println();
    // System.out.println("Length Tests");
    // // lengthTest(10, 10000);
    // System.out.println();
    // System.out.println("Merge Tests");
    // // mergeTest(4, 100);
    // System.out.println();
    // System.out.println("Radix Simple Tests");
    // radixSimpleTest(1000000, 10000);
    System.out.println("Radix Tests");
    SortableLinkedList a = randomNegativeList(20, 100);
    System.out.println(a);
    Radix.radixSort(a);
    System.out.println(a);
  }

  public static int randomNumber(int maxNum) {
    return (int)(Math.random()*maxNum);
  }

  public static void lengthTest(int tests, int maxNum) {
    for (int i = 0; i < tests; i++) {
      int temp = randomNumber(maxNum);
      System.out.println(temp + ": " + Radix.length(temp));
    }

    for (int i = 0; i < tests; i++) {
      int temp = (-1 * randomNumber(maxNum));
      System.out.println(temp + ": " + Radix.length(temp));
    }
  }

  public static SortableLinkedList randomList(int size, int maxNum) {
    SortableLinkedList result = new SortableLinkedList();
    for (int i = 0; i < size; i++) {
      result.add(randomNumber(maxNum));
    }
    return result;
  }

  public static SortableLinkedList randomNegativeList(int size, int maxNum) {
    SortableLinkedList result = new SortableLinkedList();
    for (int i = 0; i < size; i++) {
      int temp = (int)(Math.random()* maxNum * 2) - maxNum;
      result.add(temp);
    }
    return result;
  }

  public static void mergeTest(int size, int maxLength) {
    SortableLinkedList a = randomList(size, maxLength);
    SortableLinkedList[] arr = new SortableLinkedList[4];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = (randomList(size, maxLength));
    }
    // System.out.println("Original: ");
    // System.out.println(a);
    // System.out.println("Buckets: ");
    // for (int i = 0; i < arr.length; i++) {
    //   System.out.println(arr[i]);
    // }
    Radix.merge(a, arr);
    System.out.println(a);
  }

  public static int[] randArray(int size, int maxNum) {
    int[] result = new int[size];
    for (int i = 0; i < size; i++) {
      result[i] = randomNumber(maxNum);
    }
    return result;
  }

  public static SortableLinkedList toLinkedList(int[] arr) {
    SortableLinkedList result = new SortableLinkedList();
    for (int i = 0; i < arr.length; i++) {
      result.add(arr[i]);
    }
    return result;
  }

  public static int[] linkedToArray(SortableLinkedList list) {
    int[] result = new int[list.size()];
    for (int i = 0; i < list.size(); i++) {
      result[i] = list.get(i);
    }
    return result;
  }

  public static void radixSimpleTest(int size, int maxLength) {
    // int[] arr = randArray(size, maxLength);
    // SortableLinkedList test = toLinkedList(arr);
    SortableLinkedList a = randomList(size, maxLength);
    Radix.radixSortSimple(a);
    // Arrays.sort(arr);
    // if (Arrays.equals(linkedToArray(test), arr)) {
    //   System.out.println("Correct!");
    // } else {
    //   System.out.println("NONONONONO!");
    // }
  }

}
