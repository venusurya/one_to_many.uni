package one_to_many.uni.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import one_to_many.uni.dao.SchoolDao;
import one_to_many.uni.dao.StudentDao;
import one_to_many.uni1dto.School;
import one_to_many.uni1dto.Student;

 

public class SchoolMain {

	public static void main(String[] args) {

		StudentDao dao = new StudentDao();
		SchoolDao daos = new SchoolDao();
		

		 List<Student>list=new ArrayList();


		Scanner sc = new Scanner(System.in);
		boolean check = true;
		System.out.println("======welcome======");

		do {
			System.out.println("Enter your choice \n 1.Register School   \n 2.Save Student"
					+ "\n 3.update student \n 4.delete student "
					+ "\n 5.details of student \n 6.details of all students"
					+ "\n 7.update school \n 8.Delete school"
					+ "\n 9.Details of school \n 10.All school details  \n 11.Exit");
			int choice = sc.nextInt();
			switch (choice) {
			case 1: {
				System.out.println("To Register school pls provide the given criteria");
				System.out.println("give your school name");
				String name = sc.next();
				System.out.println("pls provide your school code");
				int code = sc.nextInt();

				School s1 = new School();
				s1.setCode(code);
				s1.setName(name);

				daos.saveSchool(s1);

			}
				break;
			case 2: {
				boolean back=true;
				System.out.println("pls provide school id to join the student");
				int id = sc.nextInt();
				do {
					System.out.println("Choose your option \n 1.Save student \n 2.Exit");
					int choose=sc.nextInt();
					switch (choose) {
					case 1:
					{
						
					
						System.out.println("Enter Student name");
						String name = sc.next();
						System.out.println("Enter fathers name");
						String fname = sc.next();
						System.out.println("Enter mother name");
						String mname = sc.next();
						System.out.println("Enter phone number");
						long phone = sc.nextLong();
						System.out.println("Enter address");
						String address = sc.next();

						Student s = new Student();

						s.setName(name);
						s.setFathersname(fname);
						s.setMothersname(mname);
						s.setPhone(phone);
						s.setAddress(address);
						list.add(s);
						
						
					}break;
					

					case 2:back=false;
						
					}
			
					
					
				}while(back);
				School s2=new School()	;
				s2.setList(list);	
				daos.saveStudents(s2,id);
						
				
			
				

			}break;
			case 3:
			{
				System.out.println("pls provide student id to update the student");
				int id = sc.nextInt();
				System.out.println("Enter Student name");
				String name = sc.next();
				System.out.println("Enter fathers name");
				String fname = sc.next();
				System.out.println("Enter mother name");
				String mname = sc.next();
				System.out.println("Enter phone number");
				long phone = sc.nextLong();
				System.out.println("Enter address");
				String address = sc.next();

				Student s = new Student();

				s.setName(name);
				s.setFathersname(fname);
				s.setMothersname(mname);
				s.setPhone(phone);
				s.setAddress(address);
				dao.updateStudent(id, s);
				
				
			}break;
			case 4:
			{
				System.out.println("pls provide student id to delete the student");
				int id = sc.nextInt();
				try {
					dao.deleteStudent(id);
				} catch (Exception e) {
					System.out.println("Sorry you cant remove student from school ");
				}
			}break;
			case 5:{
				System.out.println("pls provide student id to get details of the student");
				int id = sc.nextInt();
				dao.displayStudent(id);
				
			}break;
			case 6:{
				dao.displayAllStudent();
			}break;
			case 7:{
				System.out.println("pls provide school id to update the school");
				int id = sc.nextInt();
				System.out.println("give your school name");
				String name = sc.next();
				System.out.println("pls provide your school code");
				int code = sc.nextInt();

				School s1 = new School();
				s1.setCode(code);
				s1.setName(name);
				daos.updateSchool(id, s1);
			}break;
			case 8:{
				System.out.println("pls provide school id to delete the school");
				int id = sc.nextInt();
				daos.deleteSchool(id);
			}break;
			case 9:{
				System.out.println("pls provide school id to get details of the school");
				int id = sc.nextInt();
				daos.getdetails(id);
			}break;
			case 10:{
				daos.getDetailsAllSchool();
			}break;
			case 11:check=false;
				
			
			
			
	

			
			}
		} while (check);
		System.out.println("=======Thank you======");

	}

}
