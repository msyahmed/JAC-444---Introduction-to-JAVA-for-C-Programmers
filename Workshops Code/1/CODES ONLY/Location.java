package location;
/**********************************************

Workshop # 1.1 (Finding location in array)

Course:JAC444> - WINTER 2018

Last Name:<Ahmed>

First Name:<Muhammad>

ID:12633016
Section: D

This assignment represents my own work in accordance with Seneca Academic Policy.

Signature M.A

Date:<submission date>

**********************************************/
import java.util.Scanner;

public class Location{
    int row , col;
    double maxValue;
    public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    Location l = new Location();
    //entering array values
    System.out.println("Enter the number of rows and columns in the array: ");
    l.row = input.nextInt();
    l.col = input.nextInt();
    double[][] array = new double[l.row][l.col];
    System.out.println("Enter the array: ");
    for (int i = 0; i < array.length; i++)
      for (int j = 0; j < array[i].length; j++)
        array[i][j] = input.nextDouble();

    // Display result
    System.out.println("\nLocation of the largest element is " + locateLargest(array) + " at (" + findMaxI(array) + ", " + findMaxJ(array) + ")" );
    //System.out.println(" at location (" + (l.rowLoc)"," + (l.colLoc)")" );
  }
  
  public static double locateLargest(double[][] a){
    Location l = new Location();
    l.maxValue = 0;
    int maxIndex = 0;
    for (int i = 0; i < a.length; i++) {
        for (int j = 0; j < a[i].length; j++) {
            if (a[i][j] > l.maxValue) {
            l.maxValue = a[i][j];
            maxIndex = i;
            }
        }
    }
    return l.maxValue;
  }
  
  public static double findMaxI(double[][] a){
    Location l = new Location();
    double maxValue = 0;
    int maxIndex = 0;
    for (int i = 0; i < a.length; i++) {
        for (int j = 0; j < a[i].length; j++) {
            if (a[i][j] > maxValue) {
            maxIndex = i;
            }
        }
    }
    return maxIndex;
  }
  
    public static double findMaxJ(double[][] a){
    Location l = new Location();
    double maxValue = 0;
    int maxIndex = 0;
    for (int i = 0; i < a.length; i++) {
        for (int j = 0; j < a[i].length; j++) {
            if (a[i][j] > maxValue) {
            maxIndex = j-1;
            }
        }
    }
    return maxIndex;
  }
}
  

  
  