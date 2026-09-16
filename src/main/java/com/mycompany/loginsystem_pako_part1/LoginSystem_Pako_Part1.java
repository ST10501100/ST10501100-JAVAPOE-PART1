/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.loginsystem_pako_part1;
import java.util.Scanner;
/**
 *
 * @author Student
 */
public class LoginSystem_Pako_Part1 {

    public static void main(String[] args) {
        
       //Declarations\
       String stName,surname,password,username,lenght,email;
        
       
         Scanner myInputs = new Scanner(System.in);
         //Prompt user for details
         System.out.print("Please enter name");
         stName = myInputs.next();
         System.out.print("Please enter surname");
         surname = myInputs.next();
         System.out.print("Please enter username");
         username = myInputs.next();
         
         while (true){
            
             if(checkUserName(username)){
                System.out.println("Username successfully captured");
                break;
                
            } else {
                System.out.println("Username is not correctly formated");
                System.out.println("Username must contain an underscore _");
            }

            
         }
      //Prompt for surname
      
      System.out.print("Please eneter surname:");
      surname= myInputs.next();
      
         while (true){
             
             System.out.print("Please enter your username address:");
             username= myInputs.next();
             
             if (checkUsername(username)){
                 System.out.println("username successfully captured:");
                 break;
                
             } else {
                 System.out.println("Username is invalid:");
                 System.out.println("");
             }
             
         }
 
         //Prompt user for email
         
         while (true){
             System.out.print("Enter your email address:");
             email=myInputs.next();
             
             if (checkEmail(email)){
                 System.out.print("Email successfully entered:");
                 break;
             }else{
                 System.out.print("Email is not in the correct format:");
             }
         }
         //Prompt user for password
         
         while (true){
             System.out.print("Enter password:");
             password = myInputs.next();
             
             if (checkPassword(password)){
                 System.out.println("Passwprd captured successfully:");
                 break;
                 
             } else {
                 System.out.println("Password is not correctly formatted.");
                 System.out.println("Your password must contain the following:");
                 System.out.println("-Password should be atleast 8 characters long.");
                 System.out.println("-Contain at least one capital letter.");
                 System.out.println("-Contain at least one number.");
                 System.out.println("-Password should contain atleasr 1 special character.");
             }
         }
     System.out.println();
     System.out.println("Registration Successful");
     System.out.println("Welcome"+ stName + "" + surname);
      
     input.close();
    }
    public state boolean checkPassword (String password){
        if (password.lenght() <8);{
        return false;
    
    }
    boolean hasCapital=false;
    boolean hasSpecial=false;
    boolean hasNumber=false;

    for(int i=0;1<password.lenght();i++);{
        char ch= password.chatAt(i);
        
    if(Character.isUpperCase(ch)){
        HasCapital=True
    }    
    public state boolean checkEmail (String email){
        return email.endsWith("@gmail.com");
    }
    while (true){
    System.out.println("Please enter username");
    Username= myInputs.nextln();
    if (CheckUserName(username)){
       System.out.println("Username successfully captured");
       break;
} else {
    System.out.println("Username is not correctly formatted");
    System.out.println("Username must contain an underscore");
}
    
    Public state boolean CheckUserName(string username){
    if (username.lenght()<4){
    return false;
}
    int count = 0;
    int sndCount=0;
    for (int i=0, i< username.lenght(); i++){
    char ch= username.CharAt(i);
}
}
}
    }    
    }
    
    
        
    }
