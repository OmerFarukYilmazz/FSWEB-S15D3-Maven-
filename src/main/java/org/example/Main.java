package org.example;


import org.example.entity.Employee;

import java.util.*;

public class Main {
    private static Map<Integer,Employee> employeeMap;
    private static List<Employee> duplicatedEmployees;


    public static void main(String[] args) {
        LinkedList<Employee> employees = new LinkedList<>();
        /*
        employees.add(new Employee(2,"Joan","Craig"));
        employees.add(new Employee(4,"Emerson","Long"));
        employees.add(new Employee(5,"Dudley","Wood"));
        employees.add(new Employee(5,"Dudley","Wood"));
        System.out.println(removeDuplicates(employees)); */

        employees.add(new Employee(1, "Dogancan", "Kinik"));
        employees.add(new Employee(1, "Dogancan", "Kinik"));
        employees.add(new Employee(2, "Seyyit Battal", "Arvas"));
        employees.add(new Employee(2, "Seyyit Battal", "Arvas"));
        employees.add(new Employee(3, "Anil", "Ensari"));
        employees.add(new Employee(3, "Anil", "Ensari"));
        employees.add(new Employee(4, "Burak", "Cevizli"));

        List<Employee> list = Main.removeDuplicates(employees);
        System.out.println(list);
        Map<Integer, Employee> map = Main.findUniques(employees);
        System.out.println(map);
        List<Employee> list1= Main.findDuplicates(employees);
        System.out.println(list1);


    }

    public static List<Employee> findDuplicates (List<Employee> employees) {
        // First Method using global variables(employeeMap,duplicatedEmployees) and Iterator
        employeeMap = new HashMap<>();
        duplicatedEmployees = new LinkedList<>();

        Iterator<Employee> iterator = employees.iterator();
        while(iterator.hasNext()){
            Employee employee = iterator.next();
            if(employee == null){
                System.out.println("null");
                continue;
            }
            if(employeeMap.containsKey(employee.getId())){
                duplicatedEmployees.add(employee);
            }
            else{
                employeeMap.put(employee.getId(),employee);
            }
        }
        return duplicatedEmployees;
        /*
        // Second Method using local variable and for loop,Set.
        Set<Employee> set = new HashSet<>();
        List<Employee> duplicates = new LinkedList<>();

        for (Employee employee : employees) {
            if (!set.add(employee)) {
                duplicates.add(employee);
            }
        }
        return duplicates;
         */
    }

    public static Map<Integer,Employee> findUniques(List<Employee> employees){
        employeeMap = new HashMap<>();

        Iterator<Employee> iterator = employees.iterator();
        while(iterator.hasNext()){
            Employee employee = iterator.next();
            if(employee == null){
                System.out.println("null");
                continue;
            }
            if(!employeeMap.containsKey(employee.getId())){
                employeeMap.put(employee.getId(),employee);
            }

        }
        return employeeMap;
    }

    public static List<Employee> removeDuplicates(List<Employee> employees){
        List<Employee> dublicates = findDuplicates(employees);
        Map<Integer,Employee> uniques = findUniques(employees);

        List <Employee> onlyUnique = new LinkedList<>(uniques.values());
        onlyUnique.removeAll(dublicates);
        return onlyUnique;
    }
}