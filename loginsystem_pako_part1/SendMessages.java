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
           String messageID,recipient, message
           int messageNumber) {
    
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
        
        int numOfMessages= input.nectInt();
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
            }
        }
    }
}
