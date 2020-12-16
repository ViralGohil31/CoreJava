package ComparableAndComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparableExample {
	public static void main(String[] args) {
		List<Student> studentList = new ArrayList<Student>();
		studentList.add(new Student(90));
		studentList.add(new Student(80));
		studentList.add(new Student(70));
		studentList.add(new Student(60));
		studentList.add(new Student(50));
		studentList.add(new Student(40));
		
		Collections.sort(studentList);
		for(Student s:studentList){
			System.out.println(s.age);
		}
	}
}


class Student implements Comparable<Student>{
	int age;
	Student(int age){
		this.age = age;
	}
	
	
	@Override
	public int compareTo(Student o) {
		if(o==null) return -1;
		if(this == o) return 0;
		else if (age > o.age){
			return 1;
		}else{
			return -1;
		}
	}
	
}