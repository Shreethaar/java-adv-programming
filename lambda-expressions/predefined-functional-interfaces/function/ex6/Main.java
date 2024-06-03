import java.util.*;
import java.util.function.Function;

public class Main {
	public static List<Employee> increaseSalaries(List<Employee> employees, Function<Employee, Employee> salaryIncreaseFunction) {
		List<Employee> updatedEmployees = new ArrayList<>();
		for(Employee employee : employees ) {
			updatedEmployees.add(salaryIncreaseFunction.apply(employee));
		}
		return updatedEmployees;
	}
	public static List<String> convertToString(List<Employee> employees, Function<Employee, String> toStringFunction) {
		List<String> stringList = new ArrayList<>();
		for(Employee employee : employees) {
			stringList.add(toStringFunction.apply(employee));
		}
		return stringList;
	}
	public static void main(String[] args) {
		List<Employee> employees = Arrays.asList(
				new Employee("Alice", 50000),
				new Employee("Bob",60000),
				new Employee("Charlie", 700000)
				);
		Function<Employee,Employee> salaryIncreaseFunction=employee -> {employee.setSalary(employee.getSalary() * 1.1);
		return employee;
	};
		Function<Employee,String> toStringFunction = Employee::toString;
		List<Employee> updatedEmployees = increaseSalaries(employees, salaryIncreaseFunction);
		List<String> employeeStrings = convertToString(updatedEmployees,toStringFunction);
		System.out.println(employeeStrings);
	}
}
