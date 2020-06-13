package com.java8;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Employee {
    public String empName;
    public Integer salary;

    public Employee() {

    }

    public Employee(String empName, Integer salary) {
        this.empName = empName;
        this.salary = salary;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }
}

public class Singleton implements SingletonInterface {
//    static {
//        int testStaticVar = 0;
//    }
//
//    public Test() {
//        System.out.println();
//    }
//
//    public int sum(Integer a, Integer b) {
//        System.out.println("Integer sum meth");
//        return 1;
//    }
//
//    public int sum(int a, int b) {
//        System.out.println("int sum meth");
//        return 1;
//    }
//
//    public static void main(String[] args) {
//        Test obj = new Test();
//        System.out.println(obj.sum(new Integer(1), new Integer(2)));
//    }

    private static Singleton single_instance = null;
    int i;

    private Singleton () {
        i = 90;
    }

    public static Singleton getInstance() {
        if(single_instance == null) {
            single_instance = new Singleton();
        }
        return single_instance;
    }

    @Override
    public void heyBud() {
        //System.out.println("Yo this is fancy...");
    }

    public void check(String name) {
        System.out.println(name);
    }

    public void check(Integer num, String name) {
        System.out.println(num + name);
    }

    public static void main (String args[]) {

        Singleton singleton = new Singleton();
        singleton.check(null, "Anand");
        singleton.check("Anand");


        //System.out.println(Objects.equals(new Integer(1), new Integer(2)));
        Singleton first = Singleton.getInstance();
        //System.out.println("First instance integer value:"+first.i);
        first.i = first.i + 90;
        Singleton second = Singleton.getInstance();
        //System.out.println("Second instance integer value:"+second.i);

        second.i = second.i + 90;
        Singleton third = Singleton.getInstance();
        //System.out.println("Third : " + third.i);

        //SingletonInterface singleton = new Singleton();
//        singleton.hey();
//        singleton.heyBud();

//        Map<String, List<String>> people = new HashMap<>();
//        people.put("John", Arrays.asList("555-1123", "555-3389"));
//        people.put("Mary", Arrays.asList("555-2243", "555-5264"));
//        people.put("Steve", Arrays.asList("555-6654", "555-3242"));
//        people.put("Steve", Arrays.asList("555-5555", "555-5556"));

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("John",250000));
        employees.add(new Employee("Rosy",600000));
        employees.add(new Employee("Max",200000));
        employees.add(new Employee("Stephen",300000));

//        employees.stream()
//                .map(Employee::getEmpName)
//                .forEach(System.out::println);

        String top3HighestPaidEmployees = employees.stream()
                .sorted(Comparator.comparingInt(Employee::getSalary).reversed())
                .distinct()
                .limit(3)
                .map(Employee::getEmpName)
                .collect(Collectors.joining(", "));

        System.out.println("Top 3 highest paid employees are - " +top3HighestPaidEmployees);

        System.out.println(Arrays.asList(1, 2, 3, 4, 5, 6)
                .stream()
                .filter(i -> i < 4)
                .map(i -> i * 2)
                .max(Integer::compare).get());

        int[] intArr = new int[]{2,5, 4, 4, 1, 1,2,2,2,3,3,5,5,5};

        IntStream.of(intArr)
                .distinct()
                .sorted()
                .limit(3)
                .forEach(System.out::print);

        //IntStream.of(intArr).min().ifPresent(System.out::println);
        Stream<Integer> stream = Arrays.asList(1, 2, 3, 4, 5, 6).stream();

        //stream.forEach(System.out::println);
//        people.values().stream()
//                .flatMap(Collection::stream)
//                .collect(Collectors.toList())
//                .forEach(System.out::println);
//

    }
}
