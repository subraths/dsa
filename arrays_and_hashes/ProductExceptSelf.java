import java.util.Arrays;

/** ProductExceptSelf */
public class ProductExceptSelf {

  public static void main(String[] args) {
    int[] nums = new int[] {1, 2, 4, 6};
    ProductExceptSelf sol = new ProductExceptSelf();
    System.out.println(Arrays.toString(sol.productExceptSelf(nums)));
  }

  public int[] productExceptSelf(int[] nums) {
    int[] result = new int[nums.length];

    // fill result with prefix result
    int prefix = 1;
    for (int i = 0; i < nums.length; i++) {
      result[i] = prefix;
      prefix *= nums[i];
    }

    int postfix = 1;
    for (int i = nums.length - 1; i >= 0; i--) {
      result[i] *= postfix;
      postfix *= nums[i];
    }

    return result;
  }
}
