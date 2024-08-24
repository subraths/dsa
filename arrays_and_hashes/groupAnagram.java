import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

  public static void main(String[] args) {
    Solution sol = new Solution();

    String[] str = {"eat", "tea", "tan", "ate", "nat", "bat"};

    List<List<String>> groupedAnagrams = sol.groupAnagrams(str);

    System.out.println(groupedAnagrams);
  }

  public List<List<String>> groupAnagrams(String[] strs) {

    if (strs == null || strs.length == 0) {
      return new ArrayList<>();
    }

    Map<String, List<String>> map = new HashMap<>();

    for (String str : strs) {
      String frequencyString = getFrequencyString(str);

      if (map.containsKey(frequencyString)) {
        map.get(frequencyString).add(str);
      } else {
        List<String> strList = new ArrayList<>();
        strList.add(str);
        map.put(frequencyString, strList);
      }
    }
    return new ArrayList<>(map.values());
  }

  private String getFrequencyString(String str) {

    int[] freq = new int[26];

    for (char c : str.toCharArray()) {
      freq[c - 'a']++;
    }

    StringBuilder frequencyString = new StringBuilder("");
    char c = 'a';

    for (int i : freq) {
      frequencyString.append(c);
      frequencyString.append(i);
      c++;
    }

    return frequencyString.toString();
  }
}
