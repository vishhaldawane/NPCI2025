import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;
interface Flower
{
	default void fun() {
		
	}
	default void foo() {
		
	}
	static Flower getInstance() {
		System.out.println("invoked from the Flower");
		return new Rose();
	}
	static Flower getInstance(String hint) {
		Flower f = null;
		System.out.println("of invoked from the Flower");
		if(hint.equals("diwali"))
			f = new Lotus();
		else if(hint.equals("valentine"))
			f = new Rose();
		if(hint.equals("dassera"))
			f = new Lily();
		return f;	
	}
	//void flowering();
}
class Rose implements Flower
{
	
}
class Lotus implements Flower
{
	
}
class Lily implements Flower
{
	
}

public class StreamTest2 {
	public static void moon(String[] args) {
		Flower flower = Flower.getInstance("valentine"); //hiding the implementation
			System.out.println("flower "+flower);
			
	}
	
	public static void main(String[] args) {
		
		//interface driven coding - 
		//Flower flower = Flower.getInstance(); //hiding the implementation
	//	System.out.println("flower "+flower);
		Employee staff[] =  {
				new Employee(7,"Julie",5000),
				new Employee(14,"Jane",6000),
				new Employee(28,"Amit",8000),
				new Employee(35,"Arif",9000),
				new Employee(42,"Amit",8000),
				new Employee(49,"Arif",9000),
				new Employee(56,"Robert",4000),
				new Employee(63,"Robert",4000),	
				new Employee(70,"Bharat",3000)	
		};
		//converted the array into the stream
		Stream<Employee> empStream = Stream.of(staff);
		//invoke the forEach of the stream 
		//and expect a callback to your lambda function
		Consumer<Employee> c =  (emp1)->
									{
										System.out.println("***"+emp1) ;
									}	;
		
		ArrayList<Employee> list = new ArrayList<Employee>();
		list.add(new Employee(222,"Jack",5000));
		list.add(new Employee(333,"Jackie",6000));
		list.add(new Employee(444,"Julie",7000));	
		Stream<Employee> streamOfEmps = list.stream();
		streamOfEmps.forEach(e->System.out.println(e));
		
		System.out.println("1------------------");
		
		//empStream.forEach(e->System.out.println(e));
		
		System.out.println("2--------");
		
		List<Employee> eList = empStream.
				 filter(e->e.empno>20 && e.name.startsWith("A")).
				 collect(Collectors.toList());
		
		eList.forEach(e->System.out.println("-->"+e));

		System.out.println("3--------");
		
		List<Employee> eList2 = Stream.of(staff)
				.filter(e->e.empno>40 && e.name.endsWith("t"))
				.collect(Collectors.toList());
		eList2.forEach(e->System.out.println("-->"+e));
		
		System.out.println("4--------");

		Stream.of(staff).
		filter(e->e.salary>5000).
		forEach(x->System.out.println(x));
	
		System.out.println("5-----------");
		Stream.of(staff).forEach(e->System.out.println("> "+e));
		System.out.println("-----------");
		float cost = Stream.of(staff).
				filter(e->e.empno>30).
				map(e->e.salary).
				reduce(0.0f,Float::sum); //single row function
		System.out.println("Total salary of empno more than 22 : "+cost);
		
		System.out.println("FIRST EMP with empno > 100 and name start with A ");
		Employee firstEmp = 
				Stream.of(staff).
				filter(e->e.empno>23 && e.name.startsWith("A"))
				.findFirst().orElse(null);
				

			System.out.println("emp "+firstEmp);
	System.out.println("6------sort on empno ascending -----");
	
			Stream.of(staff)
			.sorted(  (x,y) -> Integer.compare(x.empno, y.empno)  )		
			.forEach(x->System.out.println(x));
			
			System.out.println("7------sort on salary descending -----");
			
			Stream.of(staff)
			.sorted(  (x,y) -> Float.compare(y.salary, x.salary)  )		
			.forEach(x->System.out.println(x));
			
			System.out.println("8------min empno  -----");

			Employee emp1  = 
					Stream.of(staff).
					min( (e1,e2)->e1.empno-e2.empno).get();
				System.out.println("Emp with lowest empno : "+emp1);
				
				System.out.println("9------min empno  -----");

				Employee emp2  = 
						Stream.of(staff).
						max( (e1,e2)->e1.empno-e2.empno).get();
					System.out.println("Emp with max empno : "+emp2);
				
				System.out.println("10------min salary  -----");

				Employee emp3  = 
						Stream.of(staff).
						min( (x,y) -> Float.compare(x.salary, y.salary) ).get();
					System.out.println("Emp with lowest salary : "+emp3);
	
					System.out.println("11------min salary  -----");

					Employee emp4  = 
							Stream.of(staff).
							max( (x,y) -> Float.compare(x.salary, y.salary) ).get();
						System.out.println("Emp with max salary : "+emp4);
						
						System.out.println("12-------distinct emp-----");
						List<Employee> distEmp  = 
							Stream.of(staff).distinct().
							collect(Collectors.toList());
						
						distEmp.forEach((e)->System.out.println(e));
						
						long count1 =  
								Stream.of(staff).distinct().count();
						System.out.println("Count : "+count1);
						
				System.out.println("13=======");
				
				if(Stream.of(staff).allMatch(e->e.empno%7==0)) {
					System.out.println("All Emp's empno is divisible by 7");
				}
				else {
					System.out.println("not all Emp's empno is divisble by 2");
				}
				System.out.println("14-----------");
				if(Stream.of(staff).anyMatch(e->e.empno%5==0)) {
					System.out.println("Few Emp's empno is divisible by 5");
				}
				else {
					System.out.println("not all Emp's empno is divisble by 5");
				}
				System.out.println("15-----------");
				if(Stream.of(staff).noneMatch(e->e.empno%11==0)) {
					System.out.println("No Emp's empno is divisible by 11");
				}
				else {
					System.out.println("Few Emp's empno is divisble by 11");
				}
	}
}
class MyUtility
{
	static List<Employee> getEmployeesEarningSalaryInRange(Employee staff[], float lowSal, float hiSal) {
		
		List<Employee> tempAry = new ArrayList<Employee>();
		
		for(Employee emp : staff) {
			if(emp.getSalary() >= lowSal && emp.getSalary()<=hiSal) {
			//	System.out.println("emp "+emp);
				tempAry.add(emp);
			}
		}
		return tempAry;
	}
}

class Employee
{
	int empno;
	String name;
	float salary;
	
	
	
	
	@Override
	public int hashCode() {
		System.out.println("hashCode() invoked..........");

		final int prime = 31;
		int result = 1;
		result = prime * result + empno;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		System.out.println("equals() invoked..........");
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (empno != other.empno)
			return false;
		return true;
	}
	public Employee(int empno, String name, float salary) {
		super();
		this.empno = empno;
		this.name = name;
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [empno=" + empno + ", name=" + name + ", salary=" + salary + "]";
	}
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	
	
}


//- stream api is used to process the collections
//collection = container - to hold objects

/*
	The objects stored in the collection/container
	we need certain activities on it to perform
	
	select * from emp where empno > 5 order by empno
	
	1. filtering - (e)->e.empno>5
	
	select sum(sal) from emp;
	
	2. mapping of it - map((e)->e.salary).reduce(0.0,Double::sum)
	3. changes/reduction 
	4. rearrangement - sorting
	
			Talking (Human)
			 |
	Object talk(Object)
		|	      |
	Account     Running (Car)
(SavingsAccount)
	
	Features of Stream
	
			- it wont change the original data
			- it has all pipelined activities
			
			
		Operations in STREAM
		1. intermediate
			student.fun().play().card().showBalance();
						Game   Score  Account
		2. Terminate
			new Cow().milkACow().coagulate().churn(5);
				              Milk        Curd
				              
	  
*/
