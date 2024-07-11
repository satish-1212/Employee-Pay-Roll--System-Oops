package Pay_Roll;
import java.util.*;

abstract class Employees
{
	
	private String name;
	private int id;
	
	public Employees(String name,int id)
	{
		this.name = name;
		this.id =id;
		
	}
	public String getName()
	{
		return name;
	}
	public int getId()
	{
		return id;
	}
	
	public abstract double calculateSalary();
	
	public String toString()
	{
		return "Employee[name="+name+",id="+id+" , salary="+calculateSalary()+"]";
	}
	
}
class FullTimeEmployee extends Employees
{
	private double monthlySalary;
	
	public FullTimeEmployee(String name,int id,double monthlySalary)
	{
		super(name,id);
		this.monthlySalary = monthlySalary;
	}
	
	public double calculateSalary()
	{
		return monthlySalary;
	}
}

class PartTimeEmployee extends Employees
{
	private int hoursWorked;
	private double hourlyRate;
	
	public PartTimeEmployee(String name,int id,int hoursWorked,double hourlyRate)
	{
		super(name,id);
		this.hoursWorked = hoursWorked;
		this.hourlyRate = hourlyRate;
	}
	public double calculateSalary()
	{
		return hoursWorked*hourlyRate;
	}
}


class PayrollSystem{
	
	private ArrayList<Employees> employeeList;
	
	public PayrollSystem()
	{
		employeeList = new ArrayList<>();
	}
	
	public void addEmployee(Employees employee) {
		employeeList.add(employee);
	}
	
	public void removeEmployee(int id)
	{
		Employees employeeToRemove = null;
		for(Employees employee : employeeList) {
			if(employee.getId()==id)
			{
				employeeToRemove  = employee;
				break;
			}
		}
		if(employeeToRemove != null) {
			employeeList.remove(employeeToRemove);
		}
	}
	
	public void displayEmployee()
	{
		for(Employees employee : employeeList) {
			System.out.println(employee);
		}
	}
}




public class Employee {

	public static void main(String[] args) {
		PayrollSystem payrollSystem = new PayrollSystem();
		FullTimeEmployee emp1 = new FullTimeEmployee("Satish",1,200000);
		PartTimeEmployee emp2 = new PartTimeEmployee("Sai",2,40,1000);
		
		payrollSystem.addEmployee(emp1);
		payrollSystem.addEmployee(emp2);
		System.out.println("Initial Employee Details: ");
		payrollSystem.displayEmployee();
		
		System.out.println("Removing Employee: ");
		payrollSystem.removeEmployee(2);
		
		System.out.println("Remaining Employees: ");
		payrollSystem.displayEmployee();

	}

}
