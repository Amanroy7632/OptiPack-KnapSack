import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
  String str;

  Validation() {
  }

  Validation(String s) {
    this.str = s;
  }

  public boolean CheckSepcialChars(String s) {
    String exp = "[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>/?]";
    Pattern pattern = Pattern.compile(exp);
    Matcher matcher = pattern.matcher(s);
    return matcher.find();
  }

  public boolean containsDigit(String s) {
    return s.matches(".*\\d.*");
  }

  public boolean checkPhoneNumber(String s) {
    if(s.length() !=10 || Integer.parseInt(s.substring(0, 1)) <6){
     return true;
    }
    return false;
    // return s.length() != 10 ? true : false;
  }

  public boolean checkBlankField(String s[]) {
    for (int i = 0; i < s.length; i++) {
      if (s[i].isBlank()) {
        return true;
      }
    }
    return false;
  }
  public boolean checkForWeight(String s[]) {
    for (int i = 0; i < s.length; i++) {
      if(!containsDigit(s[i]) || CheckSepcialChars(s[i])){
      return true;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    new Validation();
  }
}
