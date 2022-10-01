package ss19_regex_string.exercixe;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidayPhoneNumber {
    public static boolean validayPhone(String s) {
        String phoneRegex = "^[0-9]{2}-[0][0-9]{9}$";
        Pattern pattern = Pattern.compile(phoneRegex);
        Matcher matcher = pattern.matcher(s);
        return matcher.matches();
    }

    public static void main(String[] args) {
        System.out.println("(84)-(0978489648) is valid "+validayPhone("84-0978489648"));
        System.out.println("(a8)-(22222222) is valid "+validayPhone("a8-22222222"));
    }
}
