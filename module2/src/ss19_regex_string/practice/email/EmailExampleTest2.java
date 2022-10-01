package ss19_regex_string.practice.email;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailExampleTest2 {
    public static void main(String[] args) {
        String email="^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
        Pattern pattern=Pattern.compile(email);
        Matcher matcher;
        String[] valiEmail={ "a@gmail.com", "ab@yahoo.com", "abc@hotmail.com" };
        String[] invaliEmail={"@gmail.com", "ab@gmail.", "@#abc@gmail.com"};
        for (String e:valiEmail){
            matcher= pattern.matcher(e);
            boolean match= matcher.matches();
            System.out.println(e+" is "+match);
        }
        for (String e:invaliEmail){
            matcher= pattern.matcher(e);
            boolean match= matcher.matches();
            System.out.println(e+" is "+match);
        }
    }

}