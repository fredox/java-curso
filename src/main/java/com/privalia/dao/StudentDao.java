package com.privalia.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.apache.log4j.Logger;
import com.privalia.model.Student;
import com.privalia.util.FileManager;

public class StudentDao implements IDao<Student>
{	
	static Properties prop = null;
	
	static final Logger logger = Logger.getLogger(FileManager.class);
	static FileInputStream input = null;
	
	static {
		prop = new Properties();
		try {
			input = new FileInputStream("src/main/resources/config.properties");
			prop.load(input);
		} catch (IOException e) {
			logger.error(e.getMessage());
			throw new ExceptionInInitializerError(e);
		}
	}
	
	@Override
	public int add(Student student) throws IOException {
		try{
			String filename = prop.getProperty("filename");
			FileManager.write(filename, student.toString());
			return 0;
		}catch(IOException e){
			logger.error(e.getMessage());
			throw e;
		}
	}
}
