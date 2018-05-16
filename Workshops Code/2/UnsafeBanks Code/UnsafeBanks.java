package unsafebanks;


import java.lang.ArrayIndexOutOfBoundsException;
import java.util.*;

/**********************************************

Workshop # 2.2 (Unsafe Banks)

Course:JAC444> - WINTER 2018

Last Name:<Ahmed>

First Name:<Muhammad>

ID:12633016
Section: D

This assignment represents my own work in accordance with Seneca Academic Policy.

Signature M.A

Date:<submission date>

**********************************************/
public class UnsafeBanks {
    static int id = 0;
    static int loan = 0;
    
    static double[][] banksInfo;
    public static void main(String[] args) throws ArrayIndexOutOfBoundsException {
        System.out.print("Number of banks: ");
        Scanner scan = new Scanner (System.in);
        int n =  scan.nextInt();
        
        double balances[] = new double[n];
        double borrowerId[] = new double[n];
        
        System.out.print("Minimum asset Limit: ");
        Scanner scan2 = new Scanner (System.in);
        int limit =  scan2.nextInt();
        
        banksInfo = new double[n][limit];
        int[] borrowers = new int[n];
        double [] borrowerAmounts = new double[n];
//        boolean [] unsafe;
        ArrayList listS = new ArrayList();
        listS = new ArrayList(n);
//        UnsafeBanks U = new UnsafeBanks();
        /*Inputs */
        double assets[] = new double[n];
        
        for (int i = 0; i < banksInfo.length; i++){
            double sum = 0;
            System.out.print("Bank # " + i);
            System.out.print(" -> Balance: ");
            
            balances[i] = scan.nextDouble();
            System.out.print(" -> Number of banks Loaned by Bank#  " + i + ":" );
            int numberofBanksLoaned = scan.nextInt();
           
            for(int x = 0; x < numberofBanksLoaned; x++){
//                System.out.println("val of x her is :  "+x);
                System.out.print(" -> Bank ID: ");
                    int id = scan.nextInt();
                    borrowerId[x] = id;
                    System.out.print(" -> Amount: ");
                    borrowerAmounts[x]= scan.nextDouble();
//                    System.out.println("Bank " +x+ " lends " + borrowerAmounts[x] + " to bank " + borrowerId[x]);
                    sum = sum + borrowerAmounts[x];
            }
            assets[i] = balances[i] + sum;
            System.out.println("Assets of bank " + i + " is " + assets[i]);
            if((assets[i]) < limit){
                       listS.add(i); 
                       for (int a = 0; a < 5; a++){
                            if(borrowerId[a] == i){
                                     assets[i] = balances[i] - sum;
                                     //System.out.println("I reached assets[a]) < limit module");
                                     listS.add(a);
                                     //System.out.println("val of i here in assets is :  "+ i);
                            }
                       } 
            }
            System.out.println();
            }
            System.out.println("Final list of unsafe banks: " + listS);
        } 
}
        