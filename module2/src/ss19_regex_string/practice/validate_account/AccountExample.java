package ss19_regex_string.practice.validate_account;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AccountExample {
    public static void main(String[] args) {
        String accountRegex="^[_a-z0-9]{6,}$";
        Pattern pattern=Pattern.compile(accountRegex);
        String[] valiAccount={ "123abc_", "_abc123", "______", "123456","abcdefgh"};
        String[] invaliAccount={ ".@", "12345", "1234_", "abcde"};
        Matcher matcher;
        for (String account:valiAccount){
            matcher= pattern.matcher(account);
            boolean match= matcher.matches();
            System.out.println(account+" is "+match);
        }
        for (String account:invaliAccount){
            matcher= pattern.matcher(account);
            boolean match= matcher.matches();
            System.out.println(account+" is "+match);
        }
    }
}
