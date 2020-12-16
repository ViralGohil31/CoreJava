package LambdaExpression;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class Java8LambdaExample2 {
	public static void main(String[] args) {
		
		List<Person> persons = Arrays.asList(
				new Person("Viral", "Gohil", 24),
				new Person("Virat","Patidar",30),
				new Person("Akash","Kumar",25)
				);
		
		//Sort the list by FirstName
		
		Collections.sort(persons,(p1,p2)-> p1.getFirstName().compareTo(p2.getFirstName()));
		
		
		//print all the element in the list
		System.out.println("***********Print all the element in the list **********");
		
		printConditionally(persons,p->true);
		//printAll(persons);
		
		//print Conditionally
		
		
		System.out.println("************ Print Conditionally ************");
		
		

		printConditionally(persons, p->{
			if(p.getFirstName().startsWith("A")) return true;
			 return false;
		});
		
		/*
		printConditionally(persons, new Condition() {
			@Override
			public boolean test(Person p) {
				if(p.getFirstName().startsWith("A")) return true;
				return false;
			}
		});*/
	}
	
	
	private static void printAll(List<Person> persons) {
		for(Person person : persons) {
			System.out.println(person);
		}
	}
	
	private static void printConditionally(List<Person> persons,Condition condition) {
		for(Person person: persons) {
			if(condition.test(person)) {
				System.out.println(person);
			}
		}
	}
}
