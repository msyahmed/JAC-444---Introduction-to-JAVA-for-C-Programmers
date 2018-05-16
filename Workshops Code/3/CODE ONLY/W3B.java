/**********************************************

Workshop # 3 -  part b

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

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.lang.*;
import java.io.*;
import java.util.*;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class W3B extends JFrame {
    JFrame f;
    JLabel jl;
    JLabel jl2;
    JLabel jl3;
    JLabel jl4;
    JLabel jl5;
    JPanel panel;
    JTextField tf;
    JTextField tf2;
    JTextField tf3;
    JTextField tf4;
    JTextField tf5;
    
    JButton b;
    JButton b2;
    JButton b3;
    JButton b4;
    JButton b5;
    JButton b6;
      
    int NAME = 32; 
    int STREET = 32;
    int CITY = 20; 
    int STATE = 2; 
    int ZIP = 5; 
    
    
    
 public W3B(){
     
    super ("Address Book");
    setLayout(new FlowLayout());
    f = new JFrame();//creating instance of JFrame
    
    f.setSize(600,500);
    f.setLocationRelativeTo(null);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setVisible(true);//making the frame visible
    f.setTitle("Address Book");
    f.setBackground(Color.red);
    
    panel = new JPanel(new GridBagLayout());
    panel.setBackground(Color.WHITE);
    
    GridBagConstraints gbl = new GridBagConstraints();
    gbl.insets = new Insets(1,1,1,1);
    gbl.gridx = 0;
    gbl.gridy = 0;
    
    //LINE 1
    jl = new JLabel("Name");
    panel.add(jl, gbl);
    
    gbl.gridx = 1;
    gbl.gridy = 0;
    
    tf = new JTextField();
    tf.setPreferredSize(new Dimension(200, 15));
    
    panel.add(tf, gbl);
    
    //LINE 2
    gbl.gridx = 0;
    gbl.gridy = 1;
    
    jl2 = new JLabel("Street");
    
    panel.add(jl2,gbl);
    
    
    gbl.gridx = 1;
    gbl.gridy = 1;
    
    tf2 = new JTextField();
    tf2.setPreferredSize(new Dimension(200, 15));
    
    panel.add(tf2, gbl);
    
    
    //LINE 3
    
    gbl.gridx = 0;
    gbl.gridy = 2;
    
    jl3 = new JLabel("City");
    panel.add(jl3, gbl);
    
    gbl.gridx = 1;
    gbl.gridy = 2;
    
    tf3 = new JTextField();
    tf3.setPreferredSize(new Dimension(50, 15));
    panel.add(tf3, gbl);
    
    //LINE 3 2nd (STATE) element
    gbl.gridx = 2;
    gbl.gridy = 2;
    
    jl4 = new JLabel("State");
    panel.add(jl4, gbl);
    
    gbl.gridx = 3;
    gbl.gridy = 2;
    
    tf4 = new JTextField();
    tf4.setPreferredSize(new Dimension(30, 15));
    panel.add(tf4, gbl);
    
    //LINE 3 3rd (ZIP) element
    gbl.gridx = 4;
    gbl.gridy = 2;
    
    jl5 = new JLabel("Zip");
    panel.add(jl5, gbl);
    
    gbl.gridx = 5;
    gbl.gridy = 2;
    
    tf5 = new JTextField();
    tf5.setPreferredSize(new Dimension(50, 15));
    panel.add(tf5, gbl);
    
    
    //BUTTONS
    gbl.gridx = 1;
    gbl.gridy = 4;
    
    b = new JButton("Add");
    b.setBackground(Color.yellow);
    panel.add(b, gbl);//adding button in PANEL.
    
    gbl.gridx = 2;
    gbl.gridy = 4;
    b2 = new JButton("First");
    b2.setBackground(Color.yellow);
    panel.add(b2,gbl);//adding button in PANEL.
    
    gbl.gridx = 3;
    gbl.gridy = 4;
    b3 = new JButton("Next");
    b3.setBackground(Color.yellow);
    panel.add(b3,gbl);//adding button in PANEL.
    
    gbl.gridx = 4;
    gbl.gridy = 4;
    b4 = new JButton("Previous");
    b4.setBackground(Color.yellow);
    panel.add(b4,gbl);//adding button in PANEL.
    
    gbl.gridx = 5;
    gbl.gridy = 4;
    b5 = new JButton("Last");
    b5.setBackground(Color.yellow);
    panel.add(b5,gbl);//adding button in PANEL.
    
    gbl.gridx = 6;
    gbl.gridy = 4;
    b6 = new JButton("Update");
    b6.setBackground(Color.yellow);
    panel.add(b6,gbl);//adding button in PANEL.
    
//    b2 = new JButton("Press");
//    panel.add(b2);

    f.add(panel, BorderLayout.WEST);
    
    
    //ActionListeners
    thehandler handler = new thehandler();
    
//    //For JLabel
//    jl.addActionListener(handler);
//    jl2.addActionListener(handler);
//    jl3.addActionListener(handler);
//    jl4.addActionListener(handler);
//    jl5.addActionListener(handler);
    
    //Action Listener For TextField
    tf.addActionListener(handler);
    tf2.addActionListener(handler);
    tf3.addActionListener(handler);
    tf4.addActionListener(handler);
    tf5.addActionListener(handler);
    
    //Action Listener For JButton
    b.addActionListener(handler);
    b2.addActionListener(handler);
    b3.addActionListener(handler);
    b4.addActionListener(handler);
    b5.addActionListener(handler);
    b6.addActionListener(handler);
    
    
 }  
 
    private class thehandler implements ActionListener{
        FileWriter fw;
        @Override
        public void actionPerformed (ActionEvent event){
            Files f =  new Files();
            String string ="";
            //Writing Details
            if(event.getActionCommand() == b.getActionCommand()){
                try{
                    fw = new FileWriter("Address.dat");
                    fw.write(jl.getText() + " : " +tf.getText()+ ", ");
                    fw.write(jl2.getText() + " : " +tf2.getText()+ ", ");
                    fw.write(jl3.getText() + " : " +tf3.getText()+ ", ");
                    fw.write(jl4.getText() + " : " +tf4.getText()+ ", ");
                    fw.write(jl5.getText() + " : " +tf5.getText()+ "\n");
                    fw.close();
                    
                    JOptionPane.showMessageDialog(null, "Details added to file successfully!");
                
                }
                catch(Exception e){JOptionPane.showMessageDialog(null, e+"");}
            }
            
            else if(event.getSource()==b){
                string = String.format("button : %s", event.getActionCommand());
                
            }
            else if(event.getSource()==b2){
                string = String.format("button 2: %s", event.getActionCommand());
            }
            else if(event.getSource()==b3){
                string = String.format("button 3: %s", event.getActionCommand());
            }
            else if(event.getSource()==b4){
                string = String.format("button 4: %s", event.getActionCommand());
            }
            else if(event.getSource()==b5){
                string = String.format("button 5: %s", event.getActionCommand());
            }
            else if(event.getSource()==b6){
                string = String.format("button 6: %s", event.getActionCommand());
            }
            
            JOptionPane.showMessageDialog(null, string);
        }


    }
    
    public static void main(String[] args) {
        
        Files f = new Files();
        W3B file = new W3B();
        f.openFile();
        W3B gui = new W3B();
        f.closeFile();
        
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}