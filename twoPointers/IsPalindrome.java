/** IsPalindrome */
public class IsPalindrome {

  public static void main(String[] args) {
    IsPalindrome sol = new IsPalindrome();
    System.out.println(sol.isPalindrome("Was it a car or a cat I saw?"));
  }

  public boolean isPalindrome(String s) {
    int i = 0;
    int j = s.length() - 1;

    while (i < j) {
      while (i < j && !Character.isLetter(s.charAt(i))) {
        i++;
      }
      while (i < j && !Character.isLetter(s.charAt(j))) {
        j--;
      }
      if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
        return false;
      }

      i++;
      j--;
    }

    return true;
  }
}
