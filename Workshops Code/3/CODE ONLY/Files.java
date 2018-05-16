/**********************************************

Workshop # 3 - files for part b

Course:<JAC444> - Semester WInter 2018

Last Name:<Ahmed>

First Name:<Muhammad Shaher Yar>

ID:<126330166>

Section:<D>

This assignment represents my own work in accordance with Seneca Academic Policy.

Signature

Date:<21 Mar, 2018>

**********************************************/

package w3b;

import java.util.Formatter;

public class Files {
    //Create a file
    private Formatter x;
    
    //File Opener
    public void openFile(){
        try{
            x = new Formatter("Address.txt");
        }
        catch (Exception e) {
            System.out.println("File opening error");
        }
    }
    
    //Adding records 
    public void addRecords(String name, String street, String city, String state, String zip){
        x.format("%s%s%s%s%s", name, street, city, state, zip);
    }
    
    public void closeFile(){
        x.close();
    }
}
