import java.io.*;
import java.net.*;
import java.util.*;

public class Server {

    private static ServerSocket serverSocket;
    private static final int PORT = 1234;
    public String result = "unknown";
    public int bmi = 0;
    public static void main(String[] args)
    {
        System.out.println("Opening port...\n");
        try {
            serverSocket = new ServerSocket(PORT);
        }
        catch (IOException ioex){
            System.out.println("Unable to attach to port!");
            System.exit(1);
        }
          handleClient();

  }

    private static void handleClient()
    {
        Socket socket = null;
        try {
            socket = serverSocket.accept(); 
            Scanner input = new Scanner(socket.getInputStream());// input stream from client
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);// output stream for client
            double ht = input.nextDouble();
            double wt = input.nextDouble();
            double bmi = 0;
            String result = "Unknown";
            double heightInMeters = (ht * ht);
            bmi = wt/heightInMeters;
            
            //print messages
            System.out.println("Waiting for height and weight from client:");
            System.out.println("Height : " + ht);
            System.out.println("Weight : "+ wt );
            System.out.println("Calculating BMI....");
            
            //checks
        	if (bmi < 18.5 ) {
        	result = "Underweight";
        	}else if (bmi >= 18.5 && bmi < 25) {
        	result = "Normal";
        	}else if (bmi >= 25 && bmi < 30) {
        	result = "Overweight";
        	}else if (bmi >= 30 ) {
        	result = "Obese"; 
        	}else result = result;
            output.println(result); //Server returns the bmi results            
            

        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                System.out.println("Closing connection...");
                socket.close();
            }
            catch (IOException ie)
            {
                System.out.println("Unable to close connection");
                System.exit(1);
            }
        }
    }
}