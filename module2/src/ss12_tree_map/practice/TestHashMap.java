package ss12_tree_map.practice;

import java.util.*;

public class TestHashMap {
    public static void main(String[] args) {
//        HashMap<String, Integer> hashMap = new HashMap<>();
//        hashMap.put("John", 30);
//        hashMap.put("Mike", 28);
//        hashMap.put("Bill", 32);
//        hashMap.put("Maria", 27);
//        Set<String> keys = hashMap.keySet();
//        for (String key : keys) {
//            System.out.println("Key: " + key + ": " + hashMap.get(key));
//        }
//        Map<String,Integer> map=new TreeMap<>();
//        map.put("John", 30);
//        map.put("Mike", 30);
//        map.put("Bill", 30);
//        System.out.println(map);
//        Set<String> keys = map.keySet();
//        for (String key : keys) {
//            System.out.println("Key: " + key + ": " + map.get(key));
//        }
//        for(Map.Entry<String, Integer> entry:map.entrySet()){
//            System.out.println(entry.getKey() +entry.getValue());}
//
//        Map<String, Integer> hashMap = new HashMap<>();
//        hashMap.put("Smith", 30);
//        hashMap.put("Anderson", 31);
//        hashMap.put("Lewis", 29);
//        hashMap.put("Cook", 29);
//        System.out.println("Display entries in HashMap");
//        System.out.println(hashMap + "\n");
//        Map<String, Integer> treeMap = new TreeMap<>(hashMap);
//        System.out.println("Display entries in ascending order of key");
//        System.out.println(treeMap);
        Map<String, Integer> linkedHashMap = new LinkedHashMap<>(16, 0.75f, true);
        linkedHashMap.put("Smith", 30);
        linkedHashMap.put("Anderson", 31);
        linkedHashMap.put("Lewis", 29);
        linkedHashMap.put("Cook", 29);
        System.out.println(linkedHashMap.get(29));
        System.out.println(linkedHashMap);

        System.out.println("\nThe age for " + "Lewis is " + linkedHashMap.get("Lewis"));
    }
}
