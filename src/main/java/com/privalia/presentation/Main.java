package com.privalia.presentation;

import java.util.Scanner;
import org.apache.log4j.Logger;

import com.privalia.dao.IStudentDao;
import com.privalia.dao.StudentDao;
import com.privalia.model.Student;
import com.privalia.util.MethodInfo;

public class Main {
	static final Logger logger = Logger.getLogger(Main.class);

	@MethodInfo(author="Alfredo",
			revision=4,
			comments="My first Comment",
			date="22/09/2017")
	public static void main(String[] args) {
		boolean exit = false;
		Scanner sc = new Scanner(System.in);
		
		while (!exit) {
			logger.info("+--------------------+");
			logger.info("|  1. New Student    |");
			logger.info("|  2. Salir          |");
			logger.info("+--------------------+");
			int option = sc.nextInt();
			switch (option) {
				case 1: 
					logger.info("Student Id:");
					int id = sc.nextInt();
					logger.info("Student name:");
					String name = sc.next();
					logger.info("Student surname:");
					String surname = sc.next();
					logger.info("Age:");
					int age = sc.nextInt();
					
					Student student = new Student(id, name, surname, age); 
					IStudentDao studentDao = new StudentDao();
					try{
						studentDao.add(student);
					}catch(Exception e){
						logger.info("error:" + e.getMessage());
					}
					logger.info("Student Saved:");
					
					logger.info("-----------------------------------");
					logger.info("id:" + student.getIdStudent());
					logger.info("name: " + student.getName());
					logger.info("surname: " + student.getSurname());
					logger.info("Age:" + student.getAge());
					logger.info("-----------------------------------");
					break;
				case 2:
					exit = true;
					sc.close();
					break;
				default:
					logger.info("Error: Yo must enter option 1 or 2");
					break;
			}
		}
	}
}
