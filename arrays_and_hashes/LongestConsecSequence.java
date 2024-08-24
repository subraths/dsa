import java.util.HashSet;
import java.util.Set;

/** LongestConsecSequence */
public class LongestConsecSequence {

  public static void main(String[] args) {
    LongestConsecSequence sol = new LongestConsecSequence();
    System.out.println(sol.longestConsecSequence(new int[] {34, 3, 51, 2}));
    String name = "Subrath";
    for (char c : name.toCharArray()) {
      System.out.println(c);
    }
  }

  public int longestConsecSequence(int[] nums) {
    Set<Integer> set = new HashSet<>();
    int longest = 0;
    for (int num : nums) {
      set.add(num);
    }

    for (int i = 0; i < nums.length; i++) {
      if (!set.contains(nums[i] - 1)) {
        int length = 1;
        while (set.contains(nums[i] + length)) {
          length++;
        }
        longest = Math.max(longest, length);
      }
    }
    return longest;
  }
}
