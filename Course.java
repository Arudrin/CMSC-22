package studentdb2;
import java.io.*;

public class Course implements Serializable{
	
	String courseCode;
	String courseDescription;

	
	Course( String code, String description ){
		courseCode = code;
		courseDescription = description;
	}
}
