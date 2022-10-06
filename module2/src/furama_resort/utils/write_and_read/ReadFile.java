package furama_resort.utils.write_and_read;

import furama_resort.model.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ReadFile {
    public static List<Employee> readFileEmployee(String filePath) {
        List<Employee> employeeList = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            String[] info;
            Employee employee = new Employee();
            while ((line = bufferedReader.readLine()) != null) {
                if (!line.equals("")) {
                    info = line.split(",");
                    employee.setId(Integer.parseInt(info[0]));
                    employee.setName(info[1]);
                    employee.setBirthday(LocalDate.parse(info[2], DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                    employee.setGender(info[3]);
                    employee.setIdentityCard(info[4]);
                    employee.setPhoneNumber(info[5]);
                    employee.setEmail(info[6]);
                    employee.setLevel(info[7]);
                    employee.setPosition(info[8]);
                    employee.setWage(Double.parseDouble(info[9]));
                    employeeList.add(employee);
                }
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return employeeList;
    }

    public static List<Customer> readFileCustomer(String filePath) {
        List<Customer> customerList = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            String[] info;
            Customer customer = new Customer();
            while ((line = bufferedReader.readLine()) != null) {
                if (!line.equals("")) {
                    info = line.split(",");
                    customer.setId(Integer.parseInt(info[0]));
                    customer.setName(info[1]);
                    customer.setBirthday(LocalDate.parse(info[2], DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                    customer.setGender(info[3]);
                    customer.setIdentityCard(info[4]);
                    customer.setPhoneNumber(info[5]);
                    customer.setEmail(info[6]);
                    customer.setCustomerType(info[7]);
                    customer.setAddress(info[8]);
                    customerList.add(customer);
                }
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return customerList;
    }

    public static Map<Facility, Integer> readFileFacility(String filePath) {
        Map<Facility, Integer> map = new LinkedHashMap<>();
        try {
            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            String[] info;
            House house;
            Villa villa;
            Room room;
            while ((line = bufferedReader.readLine()) != null) {
                if (!line.equals("")) {
                    info = line.split(",");
                    if (info[0].contains("VL")) {
                        villa = new Villa(info[0], info[1], Double.parseDouble(info[2]), Double.parseDouble(info[3]), Integer.parseInt(info[4]), info[5], info[6], Double.parseDouble(info[7]), Integer.parseInt(info[8]));
                        map.put(villa, Integer.parseInt(info[9]));
                    } else if (info[0].contains("HO")) {
                        house = new House(info[0], info[1], Double.parseDouble(info[2]), Double.parseDouble(info[3]), Integer.parseInt(info[4]), info[5], info[6], Integer.parseInt(info[7]));
                        map.put(house, Integer.parseInt(info[8]));
                    } else {
                        room = new Room(info[0], info[1], Double.parseDouble(info[2]), Double.parseDouble(info[3]), Integer.parseInt(info[4]), info[5], info[6]);
                        map.put(room, Integer.parseInt(info[7]));
                    }
                }
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }

    public static Map<Facility, Integer> readFileFacilityMaintenance(String filePath) {
        Map<Facility, Integer> map = new LinkedHashMap<>();
        try {
            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            String[] info;
            House house;
            Villa villa;
            Room room;
            while ((line = bufferedReader.readLine()) != null) {
                if (!line.equals("")) {
                    info = line.split(",");
                    if (info[0].contains("VL")) {
                        villa = new Villa(info[0], info[1], Double.parseDouble(info[2]), Double.parseDouble(info[3]), Integer.parseInt(info[4]), info[5], info[6], Double.parseDouble(info[7]), Integer.parseInt(info[8]));
                        if (Integer.parseInt(info[9]) >= 5) {
                            map.put(villa, Integer.parseInt(info[9]));
                        }
                    } else if (info[0].contains("HO")) {
                        house = new House(info[0], info[1], Double.parseDouble(info[2]), Double.parseDouble(info[3]), Integer.parseInt(info[4]), info[5], info[6], Integer.parseInt(info[7]));
                        if (Integer.parseInt(info[8]) >= 5) {
                            map.put(house, Integer.parseInt(info[8]));
                        }
                    } else {
                        room = new Room(info[0], info[1], Double.parseDouble(info[2]), Double.parseDouble(info[3]), Integer.parseInt(info[4]), info[5], info[6]);
                        if (Integer.parseInt(info[7]) >= 5) {
                            map.put(room, Integer.parseInt(info[7]));
                        }
                    }
                }
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }
}
