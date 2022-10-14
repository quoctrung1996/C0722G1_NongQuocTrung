package quanlytaikhoan.util.checks;

public class CheckException {
    public static void checkNumber(int n)throws Check{
        if (n<0){
            throw new Check("Số phải lớn hơn 0");
        }
    }
    public static void checkNumber(double n)throws Check{
        if (n<0){
            throw new Check("Số phải lớn hơn 0");
        }
    }
}
