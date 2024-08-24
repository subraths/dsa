import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ValidParanthesis {
  public boolean isValid(String s) {
    Map<Character, Character> map = new HashMap<>();
    map.put('(', ')');
    map.put('[', ']');
    map.put('{', '}');

    List<Character> stack = new ArrayList<>();

    for (char c : s.toCharArray()) {
      if (map.containsKey(c)) {
        stack.add(c);
      } else {
        int lastIndex = stack.size() - 1;
        char lastChar = stack.get(lastIndex);
        if (map.get(lastChar) == c) {
          stack.remove(lastIndex);
        } else {
          return false;
        }
      }
    }
    if (stack.size() > 0) return false;
    return true;
  }
}
