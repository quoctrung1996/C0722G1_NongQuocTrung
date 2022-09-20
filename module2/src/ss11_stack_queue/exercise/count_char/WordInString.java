package ss11_stack_queue.exercise.count_char;

import java.util.Locale;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

import static jdk.nashorn.internal.objects.NativeDebug.map;

public class WordInString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeMap<String, Integer> map = new TreeMap<>();
        System.out.println("nhập đoạn văn bản");
        String string = sc.nextLine();
        //string = string.toLowerCase();
        String[] stringArray = string.toLowerCase().split(" ");
        for (String key:stringArray){
            if (!map.containsKey(key)){
                map.put(key,1);
            }else {
                Integer value=map.get(key);
                value++;
                map.replace(key,value);
            }
        }
        System.out.println(map);
    }
}

