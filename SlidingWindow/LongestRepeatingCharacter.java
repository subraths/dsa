import java.util.HashMap;
import java.util.Map;

/** longestRepeatingCharacter */
class LongestRepeatingCharacter {
  public static void main(String[] args) {
    LongestRepeatingCharacter lc = new LongestRepeatingCharacter();
    int res = lc.repeated("AABABBA", 1);
    System.out.println(res);
  }

  /**
   * The idea is to check if a window is valid if it is not valid move left pointer one step and
   * remove the corresponding char at left pointer then max of local window length and global res
   *
   * <p>check a window is valid windowLength - mostFreq <= k ==> valid; windowLength - mostFreq > k
   * ==> invalid;
   */
  public int repeated(String s, int k) {
    Map<Character, Integer> map = new HashMap<>();
    int res = 0;
    int mostFreq = 0;
    int i = 0, j = 0;
    while (i <= j && j < s.length()) {
      map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
      mostFreq = Math.max(mostFreq, map.get(s.charAt(j)));

      if ((j - i + 1) - mostFreq > k) {
        map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
        i++;
      }
      res = Math.max(res, j - i + 1);
      j++;
    }
    return res;
  }
}
