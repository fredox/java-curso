package com.privalia.dao;

import java.io.IOException;

import org.apache.log4j.Logger;

import com.privalia.model.Student;
import com.privalia.util.FileManager;

public class StudentDao implements IStudentDao
{	
	static final Logger logger = Logger.getLogger(FileManager.class);
	
	@Override
	public int add(Student student) throws IOException {
		try{
			FileManager.write("Students.txt", student.toString());
			return 0;
		}catch(IOException e){
			logger.error(e.getMessage());
			throw e;
		}
	}
}
