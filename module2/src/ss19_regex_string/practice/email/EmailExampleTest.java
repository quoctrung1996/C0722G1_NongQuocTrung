package ss19_regex_string.practice.email;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailExampleTest {


    public static void main(String args[]) {
        String EMAIL_REGEX =   "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
        Pattern pattern=Pattern.compile(EMAIL_REGEX);
        Matcher matcher;
        String[] validEmail = new String[] { "a@gmail.com", "ab@yahoo.com", "abc@hotmail.com" };
        String[] invalidEmail = new String[] { "@gmail.com", "ab@gmail.", "@#abc@gmail.com" };
        for (String email : validEmail) {
            matcher= pattern.matcher(email);
            boolean isvalid = matcher.matches();
            System.out.println("Email is " + email +" is valid: "+ isvalid);
        }
        for (String email : invalidEmail) {
            matcher= pattern.matcher(email);
            boolean isvalid = matcher.matches();
            System.out.println("Email is " + email +" is valid: "+ isvalid);
        }
    }
}

