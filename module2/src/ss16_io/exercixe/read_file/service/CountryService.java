package ss16_io.exercixe.read_file.service;

import ss16_io.exercixe.read_file.model.Country;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CountryService {
    //    public static List<Country> readFile(String filePath) {
//        List<Country> countryList = new ArrayList<>();
//        File file = new File(filePath);
//        String[] info;
//        Country country;
//        try {
//            if (!file.exists()) {
//                throw new FileNotFoundException();
//            }
//            FileReader fileReader = new FileReader(file);
//            BufferedReader bufferedReader = new BufferedReader(fileReader);
//            String line = "";
//            while ((line = bufferedReader.readLine()) != null) {
//               info=line.split(",");
//               country=new Country(Integer.parseInt(info[0]),info[1],info[2]);
//               countryList.add(country);
//            }
//            bufferedReader.close();
//        } catch (Exception e) {
//            System.out.println("file không tồn tại");
//        }
//        return countryList;
//    }
//    public static void getInfoCounttry(List<Country>countryList){
//        for(Country country:countryList){
//            System.out.println(country.getInfo());
//        }
//    }
    public static List<Country> readFile(String filePath) {
        List<Country> countryList = new ArrayList<>();
        Country country;
        try {
            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            String[] info;
            while ((line = bufferedReader.readLine()) != null) {
                info = line.split(",");
                country = new Country(Integer.parseInt(info[0]), info[1], info[2]);
                countryList.add(country);
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return countryList;
    }
    public static void getInfoCounttry(List<Country> countryList){
        for (Country country:countryList){
            System.out.printf("%s,%s,%s",country.getId(),country.getCode(),country.getName()+"\n");
        }
    }
}
