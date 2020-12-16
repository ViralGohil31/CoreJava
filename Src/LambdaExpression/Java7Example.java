package LambdaExpression;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


interface Condition{
	boolean test(Person p);
}

public class Java7Example {
	public static void main(String[] args) {
		
		List<Person> persons = Arrays.asList(
				new Person("Viral", "Gohil", 24),
				new Person("Virat","Patidar",30),
				new Person("Akash","Kumar",25)
				);
		
		//Sort the list by FirstName
		
		Collections.sort(persons, new Comparator<Person>() {
			@Override
			public int compare(Person o1, Person o2) {
				return o1.getFirstName().compareTo(o2.getFirstName());
			}
		});
		
		//print all the element in the list
		System.out.println("***********Print all the element in the list **********");
		printAll(persons);
		
		
		//print Conditionally
		
		
		System.out.println("************ Print Conditionally ************");
		printConditionally(persons, new Condition() {
			@Override
			public boolean test(Person p) {
				if(p.getFirstName().startsWith("A")) return true;
				return false;
			}
		});
		
		
		
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
