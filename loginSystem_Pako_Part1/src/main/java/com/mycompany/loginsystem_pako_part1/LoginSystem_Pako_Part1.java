 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
 package com.mycompany.loginsystem_pako_part1;
import java.util.Scanner;

public class LoginSystem_Pako_Part1 {

    public static void main(String[] args) {
        //Declarations
       String stName, surname, password, username, cellphone;
        
         Scanner myInputs = new Scanner(System.in);
         //Prompt user for details
         System.out.print("Please enter name: ");
         stName = myInputs.next();
         
         System.out.print("Please enter surname: ");
         surname = myInputs.next();
         
         System.out.print("Please enter username: ");
         username = myInputs.next();
         
         //While loop to check username
         while (true){
             if(CheckUserName(username)){
                System.out.println("Username successfully captured");
                break;
            } else {
                System.out.println("Username is not correctly formated");
                System.out.println("Username must contain an underscore _ and be no more than 5 characters long");
                System.out.print("Please enter username: ");
                username = myInputs.next();
            }
         }

         //  Prompt and check cell number
         while (true){
             System.out.print("Enter your cellphone number (cell number should contain +27): ");
             cellphone = myInputs.next();
             
             if (checkCellphoneNumber(cellphone)){
                 System.out.println("Cellphone number successfully captured");
                 break;
             } else{
                 System.out.println("Cellphone number is not in the correct format");
                 System.out.println("Must start with +27 and be 12 characters long ");
             }
         }
         //while loop to check password
         while (true){
             System.out.print("Enter password: ");
             password = myInputs.next();
             
             if (checkPassword(password)){
                 System.out.println("Password captured successfully");
                 break;
             } else {
                 System.out.println("Password is not correctly formatted.");
                 System.out.println("*At least 8 characters long.");
                 System.out.println("*At least one capital letter.");
                 System.out.println("*At least one number.");
                 System.out.println("*At least 1 special character.");
             }
         }
         
     System.out.println();
     System.out.println("Registration Successful");
     System.out.println("Welcome " + stName + " " + surname);
      
     myInputs.close();
    }
    
    public static boolean checkPassword (String password){
        if (password.length() < 8){
            return false;
        }
        boolean hasCapital = false;
        boolean hasSpecial = false;
        boolean hasNumber = false;

        for(int i=0; i < password.length(); i++){
            char     ch = password.charAt(i);
            if(Character.isUpperCase(ch)){
                hasCapital = true;
            } else if(Character.isDigit(ch)){
                hasNumber = true;
            } else if(!Character.isLetterOrDigit(ch)){
                hasSpecial = true;
            }
        }
        return hasCapital && hasNumber && hasSpecial;
    }
    
    //  check cellphone
    public static boolean checkCellphoneNumber(String cellphone){
        // Must start with +27, be 12 chars long, and rest must be numbers
        if(cellphone.length() != 12){
            return false;
        }
        if(!cellphone.startsWith("+27")){
            return false;
        }
        // Check if characters after +27 are digits
        for(int i=3; i < cellphone.length(); i++){
            if(!Character.isDigit(cellphone.charAt(i))){
                return false;
            }
        }
        return true;
    }
    
    public static boolean CheckUserName(String username){
         
        int count = 0;
        for (int i=0; i < username.length(); i++){
            char ch = username.charAt(i);
            if(ch == '_'){
                count++;
            }
        }
        return count >= 1 && username.length() <= 5;
    }
    
    
    }