package streams;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ListEmployeeBasedOnTotalSalary {

    public static void main(String[] args) {

        List<Employee> employeeList = List.of(
                new Employee("Hari", "CS", 2000),
                new Employee("Ram", "EC", 4000),
                new Employee("Hari", "EC", 4000),
                new Employee("Ram", "CS", 2000),
                new Employee("Sita", "CS", 3000),
                new Employee("Ram", "CE", 3000),
                new Employee("Sita", "EE", 4000)

        );

        /*
         * Expected Output as below -
         * Ram : 9000.0
         * Sita : 7000.0
         * Hari : 6000.0
         * */

        Map<String, Double> employeeMap = employeeList.stream().collect(
                Collectors.groupingBy(Employee::getName, Collectors.summingDouble(Employee::getSalary))
        );

        employeeMap
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .forEach(
                        e -> System.out.println(e.getKey() + " : " + e.getValue())
                );
    }
}
