package chat;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    
    public static void main(String args[]) throws Exception
	{
		Socket sk=new Socket("127.0.0.1",1234);
		BufferedReader sin=new BufferedReader(new InputStreamReader(sk.getInputStream()));
		PrintStream sout=new PrintStream(sk.getOutputStream());
		BufferedReader stdin=new BufferedReader(new InputStreamReader(System.in));
		Scanner input = new Scanner(System.in);
		String s;
		String name;
		System.out.println("Enter your name:");
		name = input.nextLine();
		while (  true )
		{
			
			
			
			System.out.print(name +": ");
			s=stdin.readLine();
			sout.println(s);
                        if ( s.equalsIgnoreCase("BYE") )
                        {
                           System.out.println("Connection ended by client");
 			   break;
                        }
			s=sin.readLine();
			System.out.print("Server : "+s+"\n");
  			
		}
		 sk.close();
		 sin.close();
		 sout.close();
 		stdin.close();
	}
    
}