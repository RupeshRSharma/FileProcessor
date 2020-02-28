package com.finra.fileProcessor.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * Test class to test file service.
 * 
 * @author Rupesh Sharma
 *
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class FilesServiceTest {
	
	@Autowired
	private FilesService filesService;
	
	@Test
	public void processFiles() {
		
		filesService.processFiles();
		
	}
	
}