/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jdbc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import javax.swing.*;
import java.sql.*;


public class Daftar extends JFrame implements ActionListener{
       JFrame window = new JFrame("Daftar");
    Connecctor con = new Connecctor ();
    JLabel linuser = new JLabel("Username");
        JTextField tfinuser  = new JTextField();
    JLabel linpass = new JLabel("Password");
        JTextField tfinpass = new JTextField();
    

   
    JButton btnDaftar = new JButton("Daftar");
    
    
    public Daftar(){
         window.setLayout(null);
        window.setSize(550,350);
      //  window.setDefaultCloseOperation(3);
        window.setVisible(true);
        window.setLocationRelativeTo(null);
      
        
        
        window.add(linuser);
        window.add(tfinuser);
        window.add(linpass);
        window.add(tfinpass);
      
       
        window.add(btnDaftar);
        
        //LABELl
        
        linuser.setBounds(230, 35, 120, 20);
        linpass.setBounds(230, 80, 120, 20);
        

//TEXTFIELD
       
        tfinuser.setBounds(200, 60, 120, 20);
        tfinpass.setBounds(200, 100, 120, 20);


//BUTTON PANEL
        
        btnDaftar.setBounds(215,135,90,20);
      
        setDefaultCloseOperation(window.EXIT_ON_CLOSE);
      
        btnDaftar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if (e.getSource()== btnDaftar){
           try{
               if(tfinuser.getText().equals("") || tfinpass.getText().equals("") ){
                    JOptionPane.showMessageDialog(null,"Inputan Harus Berisi Karakter");  
               }
               
               else{
             String query = "INSERT INTO `users`(`username`, `password`) VALUES ('"+getUser()+"','"+getPass()+"')";
            
            con.statement = con.koneksi.createStatement();
            con.statement.executeUpdate(query);

           
            JOptionPane.showMessageDialog(null,"Daftar Berhasil !!");   
               }
              
           }
           catch(Exception ex){
              System.out.println(ex.getMessage());
           }
       }
       
      
      
    }

    public String getUser(){
        return tfinuser.getText();
    }
     public String getPass(){
        return tfinpass.getText();
    }
     public void inputDB(){
         
    }
}