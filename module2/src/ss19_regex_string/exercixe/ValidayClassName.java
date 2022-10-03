package ss19_regex_string.exercixe;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidayClassName {
    public static void validayClassName(String[] strings){
        String classNameRegex="^[CAP][0-9]{4}[GHIKLM]$";
        Pattern pattern=Pattern.compile(classNameRegex);
        for (String className:strings){
            Matcher matcher= pattern.matcher(className);
            boolean match= matcher.matches();
            System.out.println("Class is "+className+" is valid: "+match);
        }
    }

    public static void main(String[] args) {
        String[] valiNameClass={"C0318G","C0722H"};
        String[] invaliNameClass={"M0318G","P0323A"};
        ValidayClassName.validayClassName(valiNameClass);
        ValidayClassName.validayClassName(invaliNameClass);
    }
//    public static void checkClass(String[] strings){
//        String regexClass="^[CAP][0-9]{4}[GHIKLM]$";
//        Pattern pattern=Pattern.compile(regexClass);
//       for (String s:strings){
//           Matcher matcher= pattern.matcher(s);
//           boolean match= matcher.matches();
//           System.out.println(s+" is "+match);
//       }
//    }
//public static void main(String[] args) {
//    checkClass(new String[]{"C0318G","C0722H"});
//    checkClass(new String[]{"M0318G","P0323A"});
//}
}
