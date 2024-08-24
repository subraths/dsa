import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** ThreeSum */
public class ThreeSum {

  public static void main(String[] args) {
    ThreeSum sol = new ThreeSum();
    System.out.println(sol.threeSum(new int[] {-4, -2, -2, -2, 0, 1, 2, 2, 2, 3, 3, 4, 4, 6, 6}));
  }

  public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    Arrays.sort(nums);
    int target = 0;

    for (int i = 0; i < nums.length; i++) {
      if (i > 0 && nums[i] == nums[i - 1]) continue;

      int left = i + 1;
      int right = nums.length - 1;
      while (left < right) {
        int sum = nums[left] + nums[right] + nums[i];
        if (sum > target) right--;
        else if (sum < target) left++;
        else {
          res.add(Arrays.asList(nums[i], nums[right], nums[left]));
          left++;
          while (left < right && nums[left] == nums[left - 1]) left++;
        }
      }
    }

    return res;
  }
}
