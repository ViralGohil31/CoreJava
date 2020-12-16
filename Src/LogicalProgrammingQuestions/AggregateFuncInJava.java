package LogicalProgrammingQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 
 * department wise maximum salary of employee
 *
 */

public class AggregateFuncInJava {
	public static void main(String[] args) {
		//Suppose we get the employee details from external sources like excel sheets etc
		List<Employee> e = new ArrayList<Employee>();
		Employee e1 = new Employee(10, "Viral", "PEG",20);
		Employee e2 = new Employee(10, "Brenden", "PEG",30);
		Employee e3 = new Employee(10, "Asif", "PSG",20);
		Employee e4 = new Employee(10, "Vikas", "PSG",40);
		Employee e5 = new Employee(10, "Nikhil", "PSG",20);
		Employee e6 = new Employee(80, "Vodafone", "GSS",30 );
		e.add(e1);
		e.add(e2);
		e.add(e3);
		e.add(e4);
		e.add(e5);
		e.add(e6);
		
		Map<String, Map<Integer,List<Employee>>> m = new HashMap<String, Map<Integer,List<Employee>>>();
		
		Iterator<Employee> itr = e.iterator();
		while(itr.hasNext()){
			Employee emp = itr.next();
			if(m.get(emp.getDept())==null){
					 Map<Integer,List<Employee>> salWise = new HashMap<Integer,List<Employee>>();
					 List<Employee> employee = new ArrayList<Employee>();
					 employee.add(emp);
					 salWise.put(emp.getSal(),employee);
					 m.put(emp.getDept(),salWise);
			}
			else if(m.get(emp.getDept()).get(emp.getSal())!=null){
				m.get(emp.getDept()).get(emp.getSal()).add(emp);
			}
			
		}
		
		Iterator<String> mapItr = m.keySet().iterator();

		while(mapItr.hasNext()){
			String dept = mapItr.next();
			System.out.print("\n"+dept);
			Map<Integer,List<Employee>>entry = m.get(dept);
			 Iterator<Entry<Integer, List<Employee>>>  ei = entry.entrySet().iterator();
			 while(ei.hasNext()){
				 Entry<Integer, List<Employee>> entrylocal =  ei.next();
				 System.out.print(" "+entrylocal.getValue().size());
				 
			 }
			//.keySet().iterator();
		/*	while(ii.hasNext()){
				System.out.println(ii.next());
			}*/
		}
	}
}



class Employee{
	private Integer id;
	private String name;
	private String dept;
	private Integer sal;
	
	public Employee(int id, String name, String dept,Integer salary) {
		super();
		this.id = id;
		this.name = name;
		this.dept = dept;
		this.sal = sal;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public Integer getSal() {
		return sal;
	}
	public void setSal(Integer sal) {
		this.sal = sal;
	}
	
}