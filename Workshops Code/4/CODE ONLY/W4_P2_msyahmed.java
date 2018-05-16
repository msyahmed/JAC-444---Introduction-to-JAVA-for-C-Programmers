/**********************************************

Workshop # 4 - Part 2

Course:<JAC 444> - Semester Winter 2018

Last Name:<Ahmed>

First Name:<Muhammad Shaher Yar>

ID:<126330166>

Section:<D>

This assignment represents my own work in accordance with Seneca Academic Policy.

Signature M.A

Date:<March 28, 2018>

**********************************************/
package W4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern; 
import java.io.FileNotFoundException;

public class W4_class {
	//member variables
	public String name;
	public String gender;
	public int year;
	Scanner sc=new Scanner(System.in);
	
	
	//Either male or female
	public int genderIdentifier(String gender) {
		int status = 1;
		if (gender.charAt(0) == 'm' || gender.charAt(0) == 'M' ) {status = 1;}
		else if (gender.charAt(0) == 'f'  || gender.charAt(0) == 'F' )  {status = 0;}
		return status;
	}
	
	
	//validate gender Input
	public boolean genderValidator(String gender) {
		boolean flag = true;
		while(flag == true) {
			if (gender.matches("m") || gender.matches("M") || gender.matches("f") || gender.matches("F") ) {
				this.gender = gender;
				flag = false;
			}else {	
				wrongInputMessage();
				System.out.println(" 'M/m' for MALE & 'F/f' for FEMALE" );
				gender = sc.next();
				flag = true;				
			}
		}
		return true;
	}
	
	
	//Invalid input message
	public void wrongInputMessage() {
		System.out.println("<*error>: Please input in right format");
	}
	
	public boolean yearValidator(int x) {
		W4_class W4 = new W4_class();
		boolean flag = true;
		while (flag == true) {
			if(x < 2001 || x > 2010) {
				W4.wrongInputMessage();
				System.out.println("Enter year b/w 2001 & 2010");
				x = W4.sc.nextInt();
				flag = true;
			}else { flag = false;
			this.year = x;
			}
		}
		return true;
	}
	
	public static void rankIdentifier() {
		W4_class W4 = new W4_class();
		Scanner sc=new Scanner(System.in);
		char inq = 'Y';
		System.out.println("\n");
		
		while (inq != 'N' ) {
			//USER INPUT
			System.out.println("Enter the year: ");
			W4.year = sc.nextInt();
			if (W4.yearValidator(W4.year) == true) {
				System.out.println("Enter the gender: ");
				W4.gender = sc.next();
				if (W4.genderValidator(W4.gender) == true) {
					System.out.println("Enter the name: ");
					W4.name = sc.next();
				}
			} 
			//open file
			String filename="babynamesranking" + W4.year + ".txt";	
			try
			   {
			     BufferedReader reader = new BufferedReader(new FileReader(filename));
			     String line;
			     int linenum=0;
			     boolean flag = false;
			     while ((line = reader.readLine()) != null)
			     {
			    	 linenum++;
			    	 
			    	 String patternString = W4.name;
			    	 Pattern pattern = Pattern.compile("\\b"+patternString+"\\b");
			    	 Matcher matcher = pattern.matcher(line);
			    	 if(matcher.find()) {
			    		 if (W4.genderIdentifier(W4.gender) == 1) {
			    			 System.out.println("Boy name " + W4.name + " is ranked #" + linenum + " in the year: " + W4.year);
			    			 flag = true;
			    		 }else if (W4.genderIdentifier(W4.gender) == 0) {
				    		 System.out.println("Girl name " + W4.name + " is ranked #" + linenum + " in the year: " + W4.year);
				    		 flag = true;
			    		 }else {W4.wrongInputMessage();}
			    		 System.out.println("Enter another inquiry? (Y/N) :: ");
			    		 inq = sc.next().charAt(0);
			    		 if(inq == 'n') {
			 				inq = 'N';
			 			}
			    	 }
			     }
			     
			     //if name not found			     
			     if(flag == false){
		    		 System.out.println("Name " + W4.name + " does not exist in " + W4.year + " file");
		    		 System.out.println("\n");
		    		 System.out.println("Enter another inquiry? (Y/N) :: ");
		    		 inq = sc.next().charAt(0);
		    		 if(inq == 'n') {
		 				inq = 'N';
		 			}
		    	 }
			     
			     //close the file
			     reader.close();	
			   }
			   catch (Exception e)
			   {
			     System.err.format("Exception occurred trying to read '%s'.", filename);
			     e.printStackTrace();
			   }
	   }
	   System.out.println("Program closed!");
	   sc.close();
	}

	public static void main(String[] args) {
		rankIdentifier();
	}
	   
}
