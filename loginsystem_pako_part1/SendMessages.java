 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Student
 */

import java.util.Scanner;
import java.io.FileWriter;
import java.util.ArrayList;  //Variables for messages
import java.util.Random;
import java.io.IOException;
public class Messages {
    
    private String msgID,message, recipient, msgHash, status;
    private int msgNum;
    
    //
    private static ArrayList<Messages> sentMessages = new ArrayList<>();
    
    //
    private static ArrayList<Messages> disregardedMessages = new ArrayList<>();
    
    //
    private static  ArrayList<Messages> storedMessages = new ArrayList<>();
    
    public Message(
           int msgNumber,
           String messageID,recipient, message)
             {
    
    this.messageID= messageID;
    this.messageNumber = messageNumber; 
    this.recipient = recipient;
    this.message = message;
    this.messageHash = createMessageHash();
}
 
           
   //QuickChat
           
    public static void startQuickChat(Scanner input){
        
        Sytem.out.prinln("Welcome to quickchat");
        
        //
        System.out.print("How many messages would you like to enter?");
        
        int numOfMessages= input.nextInt();
        input.nextLine();
        
        //
        
        boolean running = true;
        
        while (running){
            
            System.out.println("==========================");
            System.out.println("           QUICKCHAT");
            System.out.println("============================");
            System.out.println("1. Send Messages");
            System.out.println("2. Show recently sent messages");
            System.out.println("3. Quit");
            System.out.print("Choose an option:");
            
            String option = input.nextLine();
            
            switch (option) {
                case "1":
                    
                    sendMessages(input, numOfMessages);
                    
                    break;
                    
                case "2":
                    
                    System.out.println(" COMING SOON:");
                    
                    break;
                    
                case "3":
                    
                    running = false;
                    
                    System.out.println("Thanks for using QuickChat:");
                    
                    break;
                    
                default:
                    
                    System.out.println("Invalid option");
                  
            }
        }
    }
    
    //Send messages
    
    public static void sendMessages(
             Scanner input,
            int numOfMessages) {
        
        //
        
        for (int i = 1; i <= numOfMessages; i++){
            System.out.println("=================");
            System.out.println("MESSAGE"+ i);
            System.out.println("==================");
            
            //Message ID
            
            String messageID = generateMessageID();
            
            System.out.println("Message ID generated:"+ messageID);
            
            //RECIPIENT
            
            String recipient;
            
            while (true) {
                //Prompt
                Sytem.out.print("Enter recipient's cellphone number:");
                recipient = input.nextLine();
                Message temporaryMessage = new Message(messageID,
                i, recipient , "");
                
            if (temporaryMesage.checkRecipientCell()){
                
                Sysyem.out.println("Cellphone number succesfully Captured:");
                
                break;
                
            } else {
                System.out.println("Cellphone number is incorrectly formatted"+"does not contain an internationsl code"+"Correct format and try again");
                
                 
            }
            }
            
            //
            
            String msgText;
            
            while (true) {
                
                Sytem.out.print("Enter your message:");
                msgText = input.nextLine();
                
                if (msgText.lenght()<= 250){
                    
                    break;
                    
                   
                } else {
                     
                    System.out.println("Enter message with less than 250"+ "characters.");
                    
                  
                }
            }
            
        }
    }
            
            
            
            }
    
