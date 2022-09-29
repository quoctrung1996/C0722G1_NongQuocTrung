package ss15_exception.practice;

public class Main {
    public static void main(String[] args) {
        String s="123d";
        char[]c=s.toCharArray();
        boolean isCheck=false;
        for (char ch:c){
            if(Character.isAlphabetic(ch)){
                isCheck=true;
                break;
            }
        }
        System.out.println(isCheck);
    }
}
