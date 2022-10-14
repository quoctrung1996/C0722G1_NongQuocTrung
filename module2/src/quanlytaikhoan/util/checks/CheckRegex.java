package quanlytaikhoan.util.checks;

public class CheckRegex {
    public static boolean checkTen(String ten){
        String regex="^([A-Z][a-z]+ )+([A-Z][a-z]+)$";
        return ten.matches(regex);
    }
}
