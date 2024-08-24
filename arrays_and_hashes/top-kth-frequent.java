import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

  public static void main(String[] args) {
    Solution sol = new Solution();
    int[] nums = {1, 1, 1, 1, 2, 2, 3, 3, 2, 4, 6};
    int k = 2;
    int[] values = sol.topKFrequent(nums, k);
    for (int x : values) {
      System.out.println(x);
    }
  }

  public int[] topKFrequent(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>();

    for (int i : nums) {
      map.put(i, map.getOrDefault(i, 0) + 1);
    }

    @SuppressWarnings("unchecked")
    List<Integer>[] bucket = new List[nums.length + 1];

    for (int key : map.keySet()) {
      int frequency = map.get(key);
      if (bucket[frequency] == null) {
        bucket[frequency] = new ArrayList<>();
      }
      bucket[frequency].add(key);
    }

    int[] topFrequentElements = new int[k];
    int counter = 0;

    for (int i = bucket.length - 1; i >= 0 && counter < k; i--) {
      if (bucket[i] != null) {
        for (int j : bucket[i]) {
          topFrequentElements[counter++] = j;
        }
      }
    }

    return topFrequentElements;
  }
}
