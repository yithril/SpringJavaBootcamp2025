package org.example;

public class StringSplit {
    public static void main(String[] args) {
        String example = "10|Dana Wyatt|52.5|12.50";

        String[] employeeArray = example.split("\\|");

        System.out.println(employeeArray[1]);

        //index 0 will id, index 1 will be name, index 2 will hours worked and 3 will be pay rate
        //converting the data to the proper format
        int id = Integer.parseInt(employeeArray[0]);
        String name = employeeArray[1];
        double hoursWorked = Double.parseDouble(employeeArray[2]);
        double payRate = Double.parseDouble(employeeArray[3]);

        Employee newEmployee = new Employee(id, name, hoursWorked, payRate);
    }
}
