package dev.lpa;


import dev.lpa.Anonymous.Employee;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Employee e1 = new Employee("Jonathan", "Joester", "5/1/1880");
        Employee e2 = new Employee("Joseph", "Joester", "5/1/1926");
        Employee e3 = new Employee("Jotharo", "Kujo", "5/1/1983");
        Employee e4 = new Employee("Josuke", "Higashikata", "5/1/2001");
        Employee e5 = new Employee("Giorno", "Giovana", "5/1/2005");
        Employee e6 = new Employee("Joylene", "Kujo", "5/1/2015");
        List<Employee> list = new ArrayList<>(Arrays.asList(e1, e2, e3, e4, e5, e6));
printOrderList(list,"name");
        System.out.println();
        printOrderList(list,"year");
    }

    public static void printOrderList(List<Employee> eList, String sortField) {

        int currentYear = LocalDate.now().getYear();

        class Employees {

            private Employee containedEmployee;
            int workExperience;
            String fullName;

            public Employees(Employee containedEmployee) {
                containedEmployee = containedEmployee;
                workExperience = currentYear - Integer.parseInt(containedEmployee.hireDate().split("/")[2]);

                fullName = String.join(" ", containedEmployee.firstName(),
                        containedEmployee.lastName());
            }


            @Override
            public String toString() {
                return "%s has been an employee for %d years".formatted(fullName, workExperience);
            }

            public Employee getContainedEmployee() {
                return containedEmployee;
            }

            public void setContainedEmployee(Employee containedEmployee) {
                this.containedEmployee = containedEmployee;
            }
        }

        List<Employees> list = new ArrayList<>();
        for (Employee employee : eList) {
            list.add(new Employees(employee));
        }

        var comparator = new Comparator<Employees>() {

            @Override
            public int compare(Employees o1, Employees o2) {

                if (sortField.equals("name")) {
                    return o1.fullName.compareTo(o2.fullName);
                }


                return o1.workExperience - o2.workExperience;
            }
        };
        list.sort(comparator);

        for(Employees employees : list) {
            System.out.println(employees);
        }
    }
}