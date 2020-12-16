package LogicalProgrammingQuestions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeSet;



/**
 * 
 * Maximum salary of Employees Group by Department and also display the count of each department
 * using one way by sorting List and another way by using TreeSet because always store the element in sorted order.
 *
 */

public class AggregateFunctionInJava {
	public static void main(String[] args) {
		Map<String,List<Employees>> map = new HashMap<String,List<Employees>>();
		
		List<Employees> empl = new ArrayList<Employees>();
		Employees emp = new Employees("Viral", "PEG", 20);
		Employees emp1 = new Employees("Heena", "PEG", 20);
		Employees emp2 = new Employees("Brenden", "PEG", 30);
		
		Employees emp3 = new Employees("Asif", "PSG", 20);
		Employees emp4 = new Employees("Vikas", "PSG", 40);
		Employees emp5 = new Employees("Arif", "PSG", 20);
		

		Employees emp6 = new Employees("Vaibhav", "GSS", 35);
		Employees emp7 = new Employees("Anand", "GSS", 65);
		
		empl.add(emp);
		empl.add(emp1);
		empl.add(emp2);
		empl.add(emp3);
		empl.add(emp4);
		empl.add(emp5);
		empl.add(emp6);
		empl.add(emp7);
		
		for(Employees e:empl){
			if(map.get(e.getDept())!=null){
				List<Employees> l = map.get(e.getDept());
				l.add(e);
			}else if(map.get(e.getDept())==null){
				List<Employees> l1 = new ArrayList<Employees>();
				l1.add(e);
				map.put(e.getDept(),l1);
			}
		}
		System.out.println("Department wise Maximum Salary and number of employee:-\n".toUpperCase());
		System.out.println("Dept \t Max(Salary)\t Name\t Count");
		System.out.println("---------------------------------");
		Iterator<Entry<String, List<Employees>>> itr= map.entrySet().iterator();
		 while(itr.hasNext()){
			 Entry<String, List<Employees>> entry = itr.next();
			 System.out.print(entry.getKey()+"\t");
			 List<Employees> e = entry.getValue();
			 Collections.sort(e,new SalaryComparator());
			 for(Employees a:e){
				 System.out.print(" "+a.getSalary()+"\t\t"+a.getName()+"\t");
				 break;
			 }
			 System.out.println("  "+e.size());
		 }
		
		 
		 //Another Way
		 
		 System.out.println("\nAnother Way Using TreeSet \n");
			Map<String,TreeSet<Employees>> map1 = new HashMap<String,TreeSet<Employees>>();
			TreeSet<Employees> s = new TreeSet<Employees>(new SalaryComparator());
			Employees empl1 = new Employees("Viral", "PEG", 20);
			Employees empl2 = new Employees("Heena", "PEG", 20);
			Employees empl3 = new Employees("Brenden", "PEG", 30);
			
			Employees empl4 = new Employees("Asif", "PSG", 20);
			Employees empl5 = new Employees("Vikas", "PSG", 40);
			Employees empl6 = new Employees("Arif", "PSG", 20);
			

			Employees empl7 = new Employees("Vaibhav", "GSS", 35);
			Employees empl8 = new Employees("Anand", "GSS", 65);
			s.add(empl1);
			s.add(empl2);
			s.add(empl3);
			s.add(empl4);
			s.add(empl5);
			s.add(empl6);
			s.add(empl7);
			s.add(empl8);
			
			for(Employees e:s){
				if(map1.get(e.getDept())!=null){
					TreeSet<Employees> l = map1.get(e.getDept());
					l.add(e);
				}else if(map1.get(e.getDept())==null){
					TreeSet<Employees> l1 = new TreeSet<Employees>(new SalaryComparator());
					l1.add(e);
					map1.put(e.getDept(),l1);
				}
			}
			
			Iterator<Entry<String, TreeSet<Employees>>> itrator= map1.entrySet().iterator();
			 while(itrator.hasNext()){
				 Entry<String, TreeSet<Employees>> entry = itrator.next();
				 System.out.print(entry.getKey()+"\t");
				 TreeSet<Employees> e = entry.getValue();
				 for(Employees a:e){
					 System.out.print(" "+a.getSalary()+"\t\t"+a.getName()+"\t");
					 break;
				 }
				 System.out.println("  "+e.size());
			 }
			
			
	}
}




class Employees{
	private String name;
	private String dept;
	private Integer salary;
	
	
	public Employees(String name, String dept, Integer salary) {
		super();
		this.name = name;
		this.dept = dept;
		this.salary = salary;
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
	public Integer getSalary() {
		return salary;
	}
	public void setSalary(Integer salary) {
		this.salary = salary;
	}
	
}

class SalaryComparator implements Comparator<Object>{
	@Override
	public int compare(Object obj1,Object obj2){
		Employees s1 = (Employees)obj1;
		Employees s2 = (Employees)obj2;
		if(s1==s2){
			return 1;
		}else if(s1.getSalary()>s2.getSalary()){
			return -1;
		}else return 1;
	}

}


/*class Employeeees implements Comparable<Employeeees>{
	private String name;
	private String dept;
	private Integer sal;
	
	public Employeeees(String name, String dept,Integer salary) {
		super();
		this.name = name;
		this.dept = dept;
		this.sal = salary;
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

	@Override
	public int compareTo(Employeeees o) {
		if(this==o) return 0;
		else if(this.sal>sal) return -1;
		else return 1;
				
	}
	
	
}



class SalaryComparatorr implements Comparator<Object>{
	@Override
	public int compare(Object obj1,Object obj2){
		Employeeees s1 = (Employeeees)obj1;
		Employeeees s2 = (Employeeees)obj2;
		if(s1==s2){
			return 1;
		}else if(s1.getSal()>s2.getSal()){
			return -1;
		}else return 1;
	}
}*/
