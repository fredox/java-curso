package com.privalia.util;

import java.io.FileWriter;
import java.io.IOException;

import org.apache.log4j.Logger;

public class FileManager {
	
	static final Logger logger = Logger.getLogger(FileManager.class);
	
	private FileManager()
	{
		
	}
	
	private static FileWriter createFile(String fileName) throws IOException
	{
		try{
			return new FileWriter(fileName, true);
		}catch(Exception e){
			logger.error(e.getMessage());
			throw e;
		}
	}
	
	public static synchronized void write(String filePath, String data) throws IOException
	{
		try (
				FileWriter fileWriter = createFile(filePath);
		){
			fileWriter.append(data + "\n");
		}catch(IOException e){
			logger.error(e.getMessage());
			throw e;
		}
	}
}
