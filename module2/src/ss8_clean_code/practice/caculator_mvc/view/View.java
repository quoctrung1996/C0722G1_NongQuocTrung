package ss8_clean_code.practice.caculator_mvc.view;

import ss8_clean_code.practice.caculator_mvc.service.CaculatorService;

public class View {
    public static void main(String[] args) {
        System.out.println(CaculatorService.calculate(4,5,'*'));
    }
}
