package studentdb2;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class StudentList {
	
	 static FileOutputStream fos = null;
     static ObjectOutputStream oos = null;
     static FileInputStream fis = null;
     static ObjectInputStream ois = null;

	
	public static void main(String[] args) {
		List<Student> registeredStudents = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		
		try{
			File fin = new File("savedData");
	        
	        fis = new FileInputStream(fin);
	        ois = new ObjectInputStream(fis);
	        
	        registeredStudents = (List<Student>) ois.readObject();
			
		} catch(FileNotFoundException e){
			e.printStackTrace();
		} catch(IOException ce){
			ce.printStackTrace();
		} catch(ClassNotFoundException c){
			c.printStackTrace();
		
		}finally {

            // make sure to close the files!
            try {
                
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
		}
		
		
		
		int select;
		String studentNumber;
		String fn;
		char mi;
		String ln;
		String dp;
		int level;
		String crush;
		String favSubjectCode;
		String favSubjectDescription;
		do{
			System.out.println("STUDENT DATABASE");
			System.out.println("Key in the corresponding number of the procedure you wanted: ");
			System.out.println("\t(1) Register\n\t(2) View Student Directory\n\t(3) Deregister\n\t(4) Edit Student Info\n\t(5) Student List View\n\t(6) *SAVE* \n\t(7) Exit");
			select = sc.nextInt();
			
			if(select == 1) {
				System.out.println("Register");
				System.out.print("Enter student number(YYYYxxxxx format): ");
				studentNumber = sc.next();
				System.out.println("Enter the following: ");
				System.out.print("* First Name: ");
				fn = sc.next();
				System.out.print("* Middle Initial: ");
				mi = sc.next().charAt(0);
				System.out.print("* Last Name: ");
				ln = sc.next();
				System.out.print("* Degree Program: ");
				dp = sc.next();
				System.out.print("* Year Level: ");
				level = sc.nextInt();
				System.out.print("* Crush Name: ");
				crush = sc.next();
				System.out.print("* Favorite Subject: ");
				favSubjectCode = sc.next();
				System.out.print("* Favorite Subject Description: ");
				favSubjectDescription = sc.next();
				
				Student student = new Student(studentNumber, fn, mi, ln, dp, level, crush, new Course(favSubjectCode, favSubjectDescription));
				registeredStudents.add(student);
				System.out.println("NEW STUDENT");
				System.out.println(student);
				System.out.println();
				System.out.println();
			}
			
			if(select == 2) {
				System.out.println("Enter student number(YYYYxxxxx format): ");
	            String sn = sc.nextLine();
	            boolean exists = false;
	            for (int i = 0; i < registeredStudents.size(); i++) {
	                if (registeredStudents.get(i).getStudentNumber().equals(sn)) {
	                    System.out.print(registeredStudents.get(i) +"\n\n");
	                    exists = true;
	                    break;
	                }
	            }
	            if (exists == false) {
	            	System.out.print("Student not found.");
	            }
			}
			
			if(select == 3) {
				System.out.println("Enter student number(YYYYxxxxx format): ");
	            String stn = sc.next();
	            boolean existing = false;
	            for (int i = 0; i < registeredStudents.size(); i++) {
	                if (registeredStudents.get(i).getStudentNumber().equals(stn)) {
	                    registeredStudents.remove(i);
	                    existing = true;
	                    System.out.println("SUCCESS!");
	                    break;
	                }
	            }  
	            if (existing == false) {
	            	System.out.println("Student not found.\n");
	            }
			}
			
			if(select == 4) {
				System.out.print("Enter student number: ");
				String stno = sc.nextLine();
				boolean uneditable = true;
				for (int i = 0; i < registeredStudents.size(); i++) {
	                if (registeredStudents.get(i).getStudentNumber().equals(stno)) {
	                    System.out.println("STUDENT PROFILE\n" + registeredStudents.get(i));
	                    System.out.println("UPDATE FIELDS:\n");
	                    System.out.println("STUDENT NUMBER: " + registeredStudents.get(i).getStudentNumber());
	                    System.out.print("Edit First Name: ");
	                    registeredStudents.get(i).setFirstName(sc.nextLine());
	                    System.out.print("Edit Middle Initial: ");
	                    registeredStudents.get(i).setMiddleInitial(sc.nextLine().charAt(0));
	                    System.out.print("Edit Last Name: ");
	                    registeredStudents.get(i).setLastName(sc.nextLine());
	                    System.out.print("Edit Degree Program: ");
	                    registeredStudents.get(i).setCourse(sc.nextLine());
	                    System.out.print("Update Year Level: ");
	                    registeredStudents.get(i).setYearLevel(sc.nextInt());
	                    System.out.print("Update Crush Name: ");
	                    registeredStudents.get(i).setCrushName(sc.next());
	                    System.out.println("INFORMATION UPDATED!\nSTUDENT PROFILE\n" + registeredStudents.get(i));
	                    uneditable = false;
	                    break;
	                }
	            }
	            if (uneditable == true)
	                System.out.println("Student not found");
			}
			
			if (select == 5) {
				System.out.println("STUDENT DIRECTORY");
				for (int i = 0; i < registeredStudents.size(); i++) {
					System.out.print(registeredStudents.get(i));
					System.out.println("-");
				}
			}
			
			if(select == 6) {
				try{
					File fout = new File("savedData");
					fos = new FileOutputStream(fout);
					oos = new ObjectOutputStream(fos);

					oos.writeObject(registeredStudents);
		           
					oos.close();
				}
				catch( FileNotFoundException e){ 
					e.printStackTrace();
				}
				catch( IOException ce){
					ce.printStackTrace();
				}finally {

		            // make sure to close the files!
		            try {
		                
		                fos.close();
		            } catch (IOException e) {
		                e.printStackTrace();
		            }
				}
			}
			
		} while (select != 7);
		
		sc.close();
		System.out.println("Thank you! Program terminated.");
	}
}
