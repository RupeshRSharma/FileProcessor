package com.finra.fileProcessor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.finra.fileProcessor.service.FilesService;

/**
 * Main application to run the Spring boot app
 * 
 * @author Rupesh Sharma
 *
 */
@SpringBootApplication
public class FileProcessorApplication implements CommandLineRunner {

	//Service to process the file
	@Autowired
	private FilesService filesService;
	
	//Execute the file processor and log the time taken to process the file.
	@Override
    public void run(String...args) throws Exception {
		
		//Start time
		long start = System.currentTimeMillis();
		
		//Process the files
		filesService.processFiles();
		
		//TIme taken to process the files
		long timeTaken = System.currentTimeMillis() - start;
	
		System.out.println("Time taken to process the files: "+ timeTaken+"ms");

    }
	
	public static void main(String[] args) {
		SpringApplication.run(FileProcessorApplication.class, args);
	}

}
