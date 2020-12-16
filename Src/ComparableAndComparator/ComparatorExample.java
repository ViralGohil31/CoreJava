package ComparableAndComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorExample {
	public static void main(String[] args) {
		List<Student> studentList = new ArrayList<Student>();
		studentList.add(new Student(90));
		studentList.add(new Student(80));
		studentList.add(new Student(70));
		studentList.add(new Student(60));
		studentList.add(new Student(50));
		studentList.add(new Student(40));
		
		Collections.sort(studentList,new AgeComparator());
		for(Student s:studentList){
			System.out.println(s.age);
		}
	}
}


class AgeComparator implements Comparator<Object>{
	@Override
	public int compare(Object obj1,Object obj2){
		Student s1 = (Student)obj1;
		Student s2 = (Student)obj2;
		if(s1==s2){
			return 1;
		}else if(s1.age>s2.age){
			return 1;
		}else return -1;
	}

	
}
	
	
