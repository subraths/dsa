import java.util.HashSet;

public class ContainsDuplicate {
  public static void main(String[] args) {
    int[] nums = {1, 2, 3, 3};

    System.out.println(contains(nums));
  }

  public static boolean contains(int[] arr) {
    HashSet<Integer> set = new HashSet<Integer>();

    for (int i = 0; i < arr.length; i++) {
      if (set.contains(arr[i])) {
        return true;
      } else {
        set.add(arr[i]);
      }
    }

    return false;
  }
}
