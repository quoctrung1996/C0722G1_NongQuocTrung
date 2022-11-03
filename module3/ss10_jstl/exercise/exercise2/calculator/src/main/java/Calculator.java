public class Calculator {
    public static double calculate(double number1, double number2, char calculator) throws Exception{
        double result = 0;
        switch (calculator) {
            case '+':
                return result=number1 + number2;
            case '-':
                return result=number1 - number2;
            case '*':
                return result=number1 * number2;
            case '/':
                if (number2 != 0) {
                    return result=number1 / number2;
                } else {
                    throw new Exception("lỗi");
                }
            default:
                System.out.println("không chính xác");
        }
        return result;
    }
}
