import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class EncodeDecode {
  public static void main(String[] args) {
    List<String> input = new ArrayList<>(Arrays.asList("neet", "code", "love", "you"));
    EncodeDecode sol = new EncodeDecode();
    String encodedData = sol.encode(input);
    List<String> decodedData = sol.decode(encodedData);
    System.out.println(encodedData);
    System.out.println(decodedData);
  }

  public String encode(List<String> strs) {
    StringBuilder sb = new StringBuilder("");
    for (String str : strs) {
      sb.append(str.length()).append('#').append(str);
    }
    return sb.toString();
  }

  public List<String> decode(String str) {
    List<String> finalList = new ArrayList<>();
    int i = 0;
    while (i < str.length()) {
      int j = i;
      while (str.charAt(j) != '#') {
        j++;
      }
      int length = Integer.parseInt(str.substring(i, j));
      i = j + 1 + length;
      finalList.add(str.substring(j + 1, i));
    }
    return finalList;
  }
}
