package W4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern; 

public class W4_class {
	private int rank;
	public String gender;
	public String name;
	public int year;
	
	
	public int genderIdentifier(String gender) {
		int status = 1;
		if (gender.contains("m") || gender.contains("M")) {status = 1;}
		else if (gender.contains("f") || gender.contains("F"))  {status = 0;}
		return status;
	}
	
	
	public static void main(String[] args) {
		W4_class W4 = new W4_class();
		Scanner sc=new Scanner(System.in); 
		char inq = 'Y';
		System.out.println("");
		while (inq != 'N' ) {
			   System.out.println("Enter the year: ");
			   W4.year = sc.nextInt();
			   System.out.println("Enter the gender: ");
			   W4.gender = sc.next();
			   System.out.println("Enter the name: ");
			   W4.name = sc.next();
			   
			   //open file
				  String filename="babynamesranking" + W4.year + ".txt";
				  //System.out.println(filename);
	
			   try
			   {
			     BufferedReader reader = new BufferedReader(new FileReader(filename));
			     String line;
			     int linenum=0;
			     while ((line = reader.readLine()) != null)
			     {
	//		    	 String line2 = sc.nextLine() ;s
			    	 linenum++;
			    	 
			    	 String patternString = W4.name;
			    	 Pattern pattern = Pattern.compile("\\b"+patternString+"\\b");
			    	 Matcher matcher = pattern.matcher(line);
			    	 
			    	 if(matcher.find()) {
			    		 if (W4.genderIdentifier(W4.gender)==1) {
			    		 System.out.println("Boy name " + W4.name + " is ranked #" + linenum + " in the year: " + W4.year);
				    	 }else {
				    		 System.out.println("Girl name " + W4.name + " is ranked #" + linenum + " in the year: " + W4.year);
	
				    	 }
			    		 System.out.println("Enter another inquiry? (Y/N) :: ");
			    		 inq = sc.next().charAt(0);
			    	 }
			    	 
			     }
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
	   
}
