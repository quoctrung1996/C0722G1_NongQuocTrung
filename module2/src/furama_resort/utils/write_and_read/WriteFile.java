package furama_resort.utils.write_and_read;

import furama_resort.model.Customer;
import furama_resort.model.Employee;
import furama_resort.model.Facility;

import java.io.*;
import java.util.List;
import java.util.Map;

public class WriteFile {

    public static void writeFileEmployee(List<Employee> employeeList, String filePath) {
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

    public static void writeFileCustomer(List<Customer> customerList, String filePath) {
        try {
            FileWriter fileWriter = new FileWriter(filePath);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Customer customer : customerList) {
                bufferedWriter.write(customer.getInfo());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void writeFileFacility(Map<Facility, Integer> map, String filePath) {
        try {
            FileWriter fileWriter = new FileWriter(filePath);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Map.Entry<Facility, Integer> display : map.entrySet()) {
                bufferedWriter.write(display.getKey().getInfor()+","+display.getValue());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
