/**
 * 
 */
package src;

import java.io.IOException;
/**
 * @author Pankush
 *
 */
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class NameComparator implements Comparator<Student> {

	@Override
	public int compare(Student stu1, Student stu2) {
		return stu1.getName().compareToIgnoreCase(stu2.getName());
	}

}

class CityComparator implements Comparator<Student> {

	@Override
	public int compare(Student stu1, Student stu2) {
		// TODO Auto-generated method stub
		return stu1.getCity().compareToIgnoreCase(stu2.getCity());
	}

}

public class BusinessClass {
	private List<Student> students;
	private Scanner sc;
	public BusinessClass() {
		this.students = new ArrayList<>();
		this.sc = new Scanner(System.in);
	}
	public static void main(String[] args) throws IOException, StudentNotFoundException{
		BusinessClass bo = new BusinessClass();
		bo.addStudent();
		bo.addStudent();
		bo.addStudent();
		bo.displayStudents();
		System.out.println("---------------------------------------------");
		bo.displayStudents("Gurgaon");
		System.out.println("---------------------------------------------");
		bo.sortByCity();
		System.out.println("---------------------------------------------");
		bo.sortByName();
		System.out.println("---------------------------------------------");
		bo.displayStudent(101);
		System.out.println("---------------------------------------------");
		bo.displayStudent(10);
	}

	private Student readStudent() {

		Student newStudent = new Student();
		System.out.println("--------------Enter Student details---------------- ");
		System.out.println("Enter id: ");
		int id = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter Name: ");
		String name = sc.nextLine();
		System.out.println("Enter city: ");
		String city = sc.nextLine();
		newStudent.setId(id);
		newStudent.setName(name);
		newStudent.setCity(city);
		return newStudent;
	}

	public void addStudent() {
		Student newStudent = readStudent();
		students.add(newStudent);
	}

	public void displayStudents() {
		System.out.println("Displaying all Students Details-");
		students.stream().forEach(System.out::println);
	}

	public void displayStudents(String city) {
		System.out.println("Displaying students for " + city+" City");
		students.stream().filter(student -> student.getCity().equalsIgnoreCase(city)).forEach(System.out::println);
	}

	public void sortByName() {
		System.out.println("Displaying students sorted by name: ");
		students.stream().sorted(new NameComparator()).forEach(System.out::println);
	}

	public void sortByCity() {
		System.out.println("Displaying students sorted by city: ");
		students.stream().sorted(new CityComparator()).forEach(System.out::println);

	}

	public void displayStudent(int id) throws RuntimeException {
		System.out.println("Displaying student for " + id +" ID");
		boolean flag = false;
		for (Student stud : students) {
			if (stud.getId() == id) {
				flag = true;
				System.out.println(stud);
				break;
			}
		}
		if (!flag) {
			throw new RuntimeException("Entered ID not found");
		}
	}

	@Override
	public void finalize() {
		sc.close();
	}

}