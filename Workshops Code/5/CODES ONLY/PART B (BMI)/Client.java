import java.net.*;
import java.io.*;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class Client {

    private static InetAddress host;
    private static final int PORT = 1234;

    public static void main(String[] args) {
        try {
            host = InetAddress.getLocalHost();
        } catch (UnknownHostException uhEx) {
            System.out.println("Host ID not found!");
            System.exit(1);
        }
        accessServer();
    }

    private static void accessServer() {
        Socket link = null;    
        try {
            link = new Socket(host, PORT);
            
            Scanner input = new Scanner(link.getInputStream());
            PrintWriter output = new PrintWriter(link.getOutputStream(), true);

            //Set up stream for keyboard entry
            Scanner userEntry = new Scanner(System.in);

            double ht, wt;
            String bmi;
            
                System.out.print("Write your height in meters (ex 1.80): ");
                ht = userEntry.nextDouble();
                System.out.print("Write your weight in kilograms (ex: 70.5): ");
                wt = userEntry.nextDouble();
                System.out.println("Waiting for BMI Server to connect...");
                
                //send the INPUTS
                output.println(ht);
                output.println(wt);
                
                //getting the answer from the server
                bmi = input.nextLine();
                System.out.println("Your BMI is :  " + bmi);
           
        } catch (IOException e) {
            e.printStackTrace();
        }
        catch (NoSuchElementException ne){   // when the server closes connection
            System.out.println("Connection closed");
        }
        finally {
            try {
                System.out.println("\n* Closing connection… *");
                link.close(); 
            } catch (IOException ioEx) {
                System.out.println("Unable to disconnect!");
                System.exit(1);
            }
        }
    }
}