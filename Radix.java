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

  public static void merge(SortableLinkedList original, SortableLinkedList[] buckets) {
    for (int i = 0; i < buckets.length; i++) {
      if (buckets[i] != null) {
        original.extend(buckets[i]);
      }
    }
  }

  public static void radixSortSimple(SortableLinkedList data) {
    int maxLength = 1;
    SortableLinkedList[] buckets = new SortableLinkedList[10];
    for (int j = 0; j < maxLength; j++) {
      for (int i = 0; i < data.size(); i++) {
        int curr = data.get(i);
        if (j == 0 && length(curr) > maxLength) {
          maxLength = length(curr);
        }
        int nPlace = nth(curr, j);
        if (buckets[nPlace] == null) {
          buckets[nPlace] = new SortableLinkedList();
        }
        buckets[nPlace].add(curr);
        data.remove(i);
        i--;
      }
      merge(data, buckets);
    }
  }

  public static void radixSort(SortableLinkedList data) {
    int maxLength = 1;
    SortableLinkedList[] buckets = new SortableLinkedList[20];
    for (int j = 0; j < maxLength; j++) {
      for (int i = 0; i < data.size(); i++) {
        int curr = data.get(i);
        if (j == 0 && length(curr) > maxLength) {
          maxLength = length(curr);
        }

        int nPlace = nth(curr, j);
        if (curr < 0 && nPlace != 0) {
          nPlace = 9 + (-1 * nPlace);
        } else {
          nPlace = 10 + nth(curr, j);
        }
        if (buckets[nPlace] == null) {
          buckets[nPlace] = new SortableLinkedList();
        }
        buckets[nPlace].add(curr);
        data.remove(i);
        i--;
      }
      merge(data, buckets);
    }
  }
}
