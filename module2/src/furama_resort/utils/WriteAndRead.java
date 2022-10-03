package furama_resort.utils;

import furama_resort.model.Employee;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class WriteAndRead {
    public static List<Employee> readFile(String filePath) {
        List<Employee> employeeList = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            String[] info;
            Employee employee = new Employee();
            while ((line = bufferedReader.readLine()) != null) {
                info = line.split(",");
                employee.setId(Integer.parseInt(info[0]));
                employee.setName(info[1]);
                employee.setBirthday(info[2]);
                employee.setGender(info[3]);
                employee.setIdentityCard(info[4]);
                employee.setPhoneNumber(info[5]);
                employee.setEmail(info[6]);
                employee.setLevel(info[7]);
                employee.setPosition(info[8]);
                employee.setWage(Double.parseDouble(info[9]));
                employeeList.add(employee);
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return employeeList;
    }

    public static void writeFile(List<Employee> employeeList, String filePath) {
        try {
            FileWriter fileWriter = new FileWriter(filePath);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Employee employee : employeeList) {
                bufferedWriter.write(employee.getInfo());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
