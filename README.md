# FileProcessor<br>
Read all the files from the given directory path and process the files in
parallel by creating a separate thread for each file.
For each file, remove all the uppercase characters from the file.<br>
This is a basic application to show how multiples files can be processed using java.nio library.
There are a lot other ways this can done and improved.
<br><br>

#Spring boot version 2.2.5<br>
#Java 8<br>
#Maven<br><br>

#Build the application<br>
`mvn clean install`<br><br>

#Change the directory path in application.properties before running the application.<br><br>

#Run the application<br>
`mvn spring-boot:run` or Run as SpringBoot application using any IDE<br><br>

The application uses Files class from java.nio library to read and write the files. 
This is useful for small files as it loads all the file content in memory and then processes it.
For large and complex files, FileChannel from java.nio will be a better solution.<br><br>

Also, for processing files in parallel, it creates a new Thread for each file.
The same can be achieved with Executor service framework or any other concurrent processing framework.<br><br>

##Assumptions
 - Files are present in the specified directory