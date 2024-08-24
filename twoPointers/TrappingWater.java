/** TrappingWater */
public class TrappingWater {

  public static void main(String[] args) {
    int[] height = new int[] {0, 2, 0, 3, 1, 0, 1, 3, 2, 1};
    TrappingWater sol = new TrappingWater();
    System.out.println(sol.trap(height));
  }

  public int trap(int[] height) {
    int total = 0;
    int l = 0;
    int r = height.length - 1;
    int leftMax = height[l];
    int rightMax = height[r];
    while (l < r) {
      if (leftMax < rightMax) {
        l++;
        leftMax = Math.max(leftMax, height[l]);
        total += leftMax - height[l];
      } else {
        r--;
        rightMax = Math.max(rightMax, height[r]);
        total += rightMax - height[r];
      }
    }
    return total;
  }
}
