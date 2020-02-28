package com.finra.fileProcessor.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Service to process files from input directory.
 * 
 * Read all the files from the given directory path and process the files in
 * parallel by creating a separate thread for each file.
 * 
 * For each file, remove all the uppercase characters from the file.
 * 
 * @author Rupesh Sharma
 *
 */
@Service
public class FilesService {

	// Directory path from application.properties, it will be used to read the files
	// from the directory on local system
	@Value("${directory.path}")
	private String directoryPath;

	// Process the files
	public void processFiles() {

		// Get the list files from directory
		String[] files = new File(directoryPath).list();

		// FOr each file, create a new thread and process the file
		for (String file : files) {
			new Thread(new FileList(directoryPath + "\\" + file)).start();
		}
	}

	//Class implementing the file processing logic for each file, implements Runnable interface so that each file can be processed in its own therad
	class FileList implements Runnable {

		// Location of the file directory
		String fileLoc;

		// Assign the file location
		FileList(String file) {
			this.fileLoc = file;
		}

		// Run the file thread
		public void run() {
			processFile(fileLoc);
		}

		// Process the file
		private void processFile(String fileLoc) {

			try {

				//Get the file path
				Path path = Paths.get(fileLoc);
				
				//Get the stream having all the file content
				Stream<String> lines = Files.lines(path);

				//Remove all the uppercase characters from all the lines of the file and get the updated content
				List<String> list2 = lines.map(str -> str.chars().filter((c) -> !Character.isUpperCase(c))
						.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString())
						.collect(Collectors.toList());

				//Write the updated content back to the file
				Files.write(path, list2);

				//Close the stream
				lines.close();

			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}

}