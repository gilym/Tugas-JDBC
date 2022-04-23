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

public class Login extends JFrame implements ActionListener {
           JFrame window = new JFrame("Login");
    Connecctor con = new Connecctor ();
       JLabel loutuser = new JLabel("Username");
        JTextField tfoutuser  = new JTextField();
    JLabel loutpass = new JLabel("Password");
        JTextField tfoutpass = new JTextField();
    JButton btnLogin = new JButton("Login");
    JButton btnDaftar = new JButton("Daftar");

    public Login (){
         window.setLayout(null);
        window.setSize(550,350);
      //  window.setDefaultCloseOperation(3);
        window.setVisible(true);
        window.setLocationRelativeTo(null);
        
        window.add(loutuser);
        window.add(tfoutuser);
        window.add(loutpass);
        window.add(tfoutpass);
        window.add(btnLogin);
        window.add(btnDaftar);
      
        loutuser.setBounds(230,35,120,20);
        loutpass.setBounds(230,80,120,20);

//TEXTFIELD
        tfoutuser.setBounds(200, 60, 120, 20);
        tfoutpass.setBounds(200, 100, 120, 20);
       

       btnLogin.setBounds(215, 135, 90, 20);
btnDaftar.setBounds(215,170,90,20);
      
        setDefaultCloseOperation(window.EXIT_ON_CLOSE);
          btnLogin.addActionListener(this);
          btnDaftar.addActionListener(this);
        
}

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()== btnLogin){
            try{
                if(tfoutuser.getText().equals("") || tfoutpass.getText().equals("") ){
                    JOptionPane.showMessageDialog(null,"Inputan Harus Berisi Karakter");  
               }else{
                    String user=getlUser();
                 String pass=getlPass();
                 String query = "Select * from users WHERE username= '"+user+"' AND `password` = '"+pass+"'";
                 con.statement = con.koneksi.createStatement();
                ResultSet cek = con.statement.executeQuery(query);
                if(cek.next()){
                     JOptionPane.showMessageDialog(null,"       Selamat Datang "+ user+" \n             Berhasil Login");  
                }
                else{
                    JOptionPane.showMessageDialog(null,"              Login Gagal \n Username atau Password salah");  
                }
                }
                
            }
            
            catch(Exception ex){
                System.out.println(ex.getMessage());
            }
        }
         if (e.getSource()== btnDaftar){
           Daftar daftar = new Daftar ();
       }
        
    }
    
      public String getlUser(){
         return tfoutuser.getText();
     }
      public String getlPass(){
         return tfoutpass.getText();
     }
     public void inputDB(){
         
    }
}
