package lambdasandstreams.employee;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

// processing streams of Employees objetcs
public class ProcessingEmployees {
 public static void main(String[] args) {
     //initialize array of Employees
     Employee[] employees = {
             new Employee("Simon", "Maina",5000,"IT"),
             new Employee("Ashley", "Green", 7600, "IT"),
             new Employee("Matthew", "Indigo", 3587.5, "Sales"),
             new Employee("James", "Indigo", 4700.77, "Marketing"),
             new Employee("Luke", "Indigo", 6200, "IT"),
             new Employee("Jason", "Blue", 3200, "Sales"),
             new Employee("Wendy", "Brown", 4236.4, "Marketing")
     };

     //get List view of employees
     List<Employee> list = Arrays.asList(employees);
     System.out.println("Complete employee list:");
     list.stream().forEach(System.out::println);

     //Creating an immutable List<Employee> with List Method of
//     List<Employee> list = List.of(
//             new Employee("Jason", "Red", 5000, "IT"),
//             new Employee("Ashley", "Green", 7600, "IT"),
//             new Employee("Matthew", "Indigo", 3587.5, "Sales"),
//             new Employee("James", "Indigo", 4700.77, "Marketing"),
//             new Employee("Luke", "Indigo", 6200, "IT"),
//             new Employee("Jason", "Blue", 3200, "Sales"),
//             new Employee("Wendy", "Brown", 4236.4, "Marketing"));


     // Predicate that returns true for salaries in the range $4000 - $6000
     // declare variable of the functional interface type Predicate<T> and initialize it with a one-parameter
     // lambda that returns a boolean
     Predicate<Employee> fourToSixThousand = e -> (e.getSalary() >= 4000 && e.getSalary() <= 6000);

     // Dsiplay Employees with salaries in the rane $4000 - $6000
     // sorted into ascending order by salary
     System.out.printf("%nEmployees earning $4000 - $6000 per month sorted by salary:%n");
                        list.stream()
                             .filter(fourToSixThousand)
                             .sorted(Comparator.comparing(Employee::getSalary))
                             .forEach(System.out::println);

     System.out.printf("%nFirst employee who earns $4000-$6000:%n%s%n",
                                                        list.stream()
                                                        .filter(fourToSixThousand)
                                                        .findFirst()
                                                         .get());

     // Functions for getting first and last name from an employee
     // Functions receive and an Employee and return a String
     Function<Employee, String> byFirstName = Employee::getFirstName;
     Function<Employee, String> byLastName = Employee::getLastName;

     // Comparator for comparing Employees by first name then last name
     Comparator<Employee> lastThenFirst = Comparator.comparing(byLastName)
                                                    .thenComparing(byFirstName);


     // sort employees by last name, then first name
     System.out.printf("%nEmployees in ascending order by last name then first:%n");
                        list.stream()
                                .sorted(lastThenFirst)
                                .forEach(System.out::println);

      // sorting employees in descending order by last name, then first name
     System.out.printf("%nEmployees in descending order by last name then first:%n");
                        list.stream()
                                .sorted(lastThenFirst.reversed())
                                .forEach(System.out::println);

     System.out.printf("%nUnique employee last names:%n");
                        list.stream()
                                .map(Employee::getLastName)
                                .distinct()
                                .sorted(String.CASE_INSENSITIVE_ORDER.reversed())
                                .forEach(System.out::println);

        // group Employees by department
     System.out.printf("%nEmployees by department%n");
     Map<String, List<Employee>> groupedByDepartment =
                            list.stream()
                            .collect(Collectors.groupingBy(Employee::getDepartment));



     groupedByDepartment.forEach(
             (department, employeesInDepartment) -> {
                 System.out.printf("%n%s%n", department);
                 employeesInDepartment.forEach(
                         employee -> System.out.printf(" %s%n", employee)
                 );
             }
     );

     // count number of Employees in each department
     System.out.printf("%nCount of Employees by department:%n");
     Map<String, Long> employeeCountByDepartment =
                                list.stream()
                                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
     employeeCountByDepartment.forEach(
             (department, count) -> System.out.printf("%s has %d employee(s)%n", department,count)
     );

     // sum of Employee salaries with DoubleStream sum method
     System.out.printf("%nSum of Employees' salary (via sum method): %.2f%n",
                            list.stream()
                                    .mapToDouble(Employee::getSalary)
                                    .sum());

    // calculate sum of Employee salaries with Stream reduce method
     System.out.printf("Sum of Employees' salaries (via reduce method): %.2f%n",
                                list.stream()
                                            .mapToDouble(Employee::getSalary)
                                            .reduce(0, (value1,value2) -> value1 + value2));

     // average of Employee salaries with DoubleStream average method
     System.out.printf("Average of Employees' salaries: %.2f%n",
                                list.stream()
                                .mapToDouble(Employee::getSalary)
                                .average()
                                .getAsDouble()
                            );



 }
}
