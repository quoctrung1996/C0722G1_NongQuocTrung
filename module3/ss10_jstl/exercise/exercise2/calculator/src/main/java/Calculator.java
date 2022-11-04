public class Calculator {
    public static double calculate(double numberFirst, double numberSecond, char calculator) throws Exception{
        double result = 0;
        switch (calculator) {
            case '+':
                return result=numberFirst + numberSecond;
            case '-':
                return result=numberFirst - numberSecond;
            case '*':
                return result=numberFirst * numberSecond;
            case '/':
                if (numberSecond != 0) {
                    return result=numberFirst / numberSecond;
                } else {
                    throw new Exception("lỗi");
                }
            default:
                System.out.println("không chính xác");
        }
        return result;
    }
}
